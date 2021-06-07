<template>
  <div class="code-mirror-div">
    <div class="codeMenu">
      <el-button size="small" @click="runCommand()">执行 </el-button>
      <el-button size="small">保存</el-button>
      <el-button size="small">语法树</el-button>
      <el-button size="small">默认剧本 </el-button>
    </div>


<!-- 
    <code-mirror-editor
        ref="cmEditor"
        :cmTheme="cmTheme"
        :cmMode="cmMode"
        :autoFormatJson="autoFormatJson"
        :jsonIndentation="jsonIndentation"
    ></code-mirror-editor> -->


      <!--codemirror-->
    <div class="center">
      <textarea class="form-control" id="code" name="code"></textarea>
    </div>

  </div>
</template>
<script>
//import CodeMirrorEditor from "@/components/common/CodeMirrorEditor";
//import CodeHint from '../../assets/codeHint/codeHint'

import "codemirror/addon/hint/show-hint.css"
require("codemirror/addon/hint/show-hint")
let CodeMirror = require("codemirror/lib/codemirror")

export default {
  name: 'Command',
  components: {
    //CodeMirrorEditor
  },

  data() {
    return {
      // cmTheme: "idea", // codeMirror主题
      // cmEditorMode: "sql", // 编辑模式
      // cmMode: "application/json", //codeMirror模式
      // jsonIndentation: 2, // json编辑模式下，json格式化缩进 支持字符或数字，最大不超过10，默认缩进2个空格
      // autoFormatJson: true ,// json编辑模式下，输入框失去焦点时是否自动格式化，true 开启， false 关闭
      CodeMirrorEditor: null,
      codeValue: '',
      toolBar: { isLint: false },
      codeHints: [],
      selection: { from: {}, to: {} },
      
    };
  },
  computed: {
    hintCode () {
      //return [].concat(this.codeHints, this.hintColumnCode)
      return this.codeHints
    }
  },
  methods: {
    //初始化codeMirror
    initCodeMirror () {
      //获取代码区
      console.log("初始化代码区")
      let myTextarea = document.getElementById('code');
      this.CodeMirrorEditor = CodeMirror.fromTextArea(myTextarea, {
        value: '',
        mode:'javascript',//编辑器语言
        // theme:'base16-light', //不设置主题, 使用默认主题
        lineNumbers: true,//显示行号
        smartIndent: true,
        autofocus: true,
        autoRefresh: true,
        historyEventDelay: 500,
        indentWithTabs: true,
        tabSize: 4,
        indentUnit: 4,
        line: true,
        matchBrackets: true,
        autoCloseBrackets: true,
        styleActiveLine: true,
        foldGutter: true,
        lint: this.toolBar.isLint, 
        gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter", "CodeMirror-lint-markers"],
        extraKeys: {"Ctrl-Space": "autocomplete"},//自定义快捷键
        // extraKeys: {"Ctrl": "autocomplete"},//ctrl可以弹出选择项 
        hintOptions: {
          completeSingle: false,
          alignWithWord: false,
          hint: this.getHints
        }
      })
      // 当输入框内容发生变化 更新 codeValue 值
      this.CodeMirrorEditor.on('change', (cm) => {
        this.codeValue = cm.getValue()
        console.log(JSON.stringify(this.codeValue))
      })
      
      this.CodeMirrorEditor.on('cursorActivity', (cm) => {
        // this.CodeMirrorEditor.showHint()
         this.selection.to = cm.getCursor()
        if (this.CodeMirrorEditor.getSelection().length === 0) {
          this.selection.from = cm.getCursor()
        }
        //获取所选的词汇
        var A1 = this.CodeMirrorEditor.getCursor().line;
        var A2 = this.CodeMirrorEditor.getCursor().ch;
        var B1 = this.CodeMirrorEditor.findWordAt({line: A1, ch: A2}).anchor.ch;
        var B2 = this.CodeMirrorEditor.findWordAt({line: A1, ch: A2}).head.ch;
        let selectWord=this.CodeMirrorEditor.getRange({line: A1,ch: B1}, {line: A1,ch: B2})
        //console.log(selectWord)
        // SET_SCRIPT_SELECTED:(state,selectionInfo)=>{
        //     state.scriptSelected.isSelected=selectionInfo.isSelected;
        //     state.scriptSelected.text=selectionInfo.text;
        // },
        let selectionInfo={
          isSelected:true,
          text:selectWord
        }
        this.$store.commit("SET_SCRIPT_SELECTED", selectionInfo);
        console.log(this.$store.getters.getScriptSelected.text)

      })
    //当鼠标点击
    this.CodeMirrorEditor.on('mousedown', (cm) => {
        this.selection.from = cm.getCursor()
      })
      // //当鼠标松开
      // this.CodeMirrorEditor.on('mouseup',(cm)=>{

      // })
    
    },

    //name为data中的属性名
    // initCodeHintByJS(data, type, name){

    //   console.log("data")
    //     // 读取提示库，并把参数data的值加载到this.data的属性
    //   console.log(data)
    //   for (let i = 0; i < data.length; i++) {

    //     let nativeItem = {
    //       text: data[i].code,
    //       displayText: data[i].name,
    //       className: '',
    //       render: (elt, self, data) => {
    //         let compEle = document.createElement('div')
    //         compEle.innerHTML = `<span class="iconfont icon-${type}" style='color: red;'></span>  ${data.displayText}`
    //         elt.appendChild(compEle)
    //       }
    //     }
    //     this[name].push(nativeItem)
    //   }
    // },
   
    //获取提示
    getHints (cm, option) {
      
      return new Promise((accept) => {
        console.log(option)
        console.log("开始获取提示！")
        setTimeout(() => {
          //识别中文
          let WORD = /^[\u4E00-\u9FA5]{1,5}$/
          //当没有使用ESLINT时，需要加\
          //let WORD = /[\w\[\]\"\.$]+/
          let cursor = cm.getCursor(), curLine = cm.getLine(cursor.line)
          let start = cursor.ch, end = cursor.ch
          while (start && WORD.test(curLine.charAt(start - 1))) {
            --start
          }
          let curWord = start != end && curLine.slice(start, end)
          let list = [], isDefinedObj = false
          if (curWord) {
            if (list.length === 0) {
              var dotIndex = curWord.lastIndexOf('.'),
                  memberStr = curWord.slice(dotIndex + 1),
                  comList = []
              comList = this.hintCode
        
              for (let j = 0; j < comList.length; j++) {
            
                  if (comList[j].displayText.toLowerCase().lastIndexOf(memberStr.toLowerCase(), 0) === 0) {
                   
                    list.push(comList[j])
                  }
                }
              isDefinedObj = true
            }
          }
          if (isDefinedObj) {
              return accept({list: list,
                from: CodeMirror.Pos(cursor.line, start),
                to: CodeMirror.Pos(cursor.line, end)})
            } else {
              return accept({list: list,
                from: CodeMirror.Pos(cursor.line, start  + 1),
                to: CodeMirror.Pos(cursor.line, end)})
              }
          }, 100) 
        
      })
    },

    initCodeHint(){
      const _this = this
      console.log("sceneId")
      console.log(_this.$route.params.id)
      console.log(_this.$store.getters.getUser.userId)
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/word/allWords/`,
        params: {
          "sceneId": _this.$route.params.id,
        }
      }).then(res => {
        let words = res.data.data
        console.log("words")
        console.log(words)

        let type ="function"
        for (let i = 0; i < words.length; i++) {
          let nativeItem = {
            text: words[i].name+" ",
            displayText: words[i].name,
            className: '',
            render: (elt, self, data) => {
              let compEle = document.createElement('div')
              compEle.innerHTML = `<span class="iconfont icon-${type}" style='color: red;'></span>  ${data.displayText}`
              elt.appendChild(compEle)
            }
          }
          this["codeHints"].push(nativeItem)
          }
        console.log("codeHints")
        console.log(this.codeHints)
        //_this.words = words
      }).catch( error => {
        console.log(error)
      })
 
      
    }


  },
   mounted(){
    this.initCodeMirror()
    this.initCodeHint()
    //this.initCodeHintByJS(CodeHint, 'function', 'codeHints')
    console.log("codeHints")
    console.log(this.codeHints)
    console.log(CodeMirror.resolveMode('javascript'))
  },
};
</script>
<style>
.CodeMirror {
  margin-top: 2vh;
  padding: 2px;
  height: auto;
  overflow-y: auto;
}
</style>
<style lang="scss" scoped>
.code-mirror-div {
  background-color: #f5fdfd;
  .tool-bar {
    top: 2vh;
    margin: 2vh 2vw 0 2vw;
  }
}

</style>