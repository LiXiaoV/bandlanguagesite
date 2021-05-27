<template>
  <div class="code-mirror-div">
    <div class="codeMenu">
      <el-button size="small" @click="runCommand()">执行 </el-button>
      <el-button size="small">保存</el-button>
      <el-button size="small">语法树</el-button>
      <el-button size="small">默认剧本 </el-button>
    </div>
<!--    <div class="tool-bar">-->
<!--      <el-button size="small" style="margin-left:1vw;" @click="getValue">获取内容</el-button>-->
<!--      <el-button size="small" style="margin-left:1vw;" @click="setValue">修改内容</el-button>-->
<!--    </div>-->
    <code-mirror-editor
        ref="cmEditor"
        :cmTheme="cmTheme"
        :cmMode="cmMode"
        :autoFormatJson="autoFormatJson"
        :jsonIndentation="jsonIndentation"
    ></code-mirror-editor>
  </div>
</template>
<script>
import CodeMirrorEditor from "@/components/common/CodeMirrorEditor";

export default {
  name: 'Command',
  components: {
    CodeMirrorEditor
  },
  data() {
    return {
      cmTheme: "idea", // codeMirror主题
      cmEditorMode: "sql", // 编辑模式
      cmMode: "application/json", //codeMirror模式
      jsonIndentation: 2, // json编辑模式下，json格式化缩进 支持字符或数字，最大不超过10，默认缩进2个空格
      autoFormatJson: true // json编辑模式下，输入框失去焦点时是否自动格式化，true 开启， false 关闭
    };
  },
  methods: {
    //获取内容
    getValue() {
      let content = this.$refs.cmEditor.getValue();
      console.log(content);
    },
    //修改内容
    setValue() {
      let value = "显示 ccy";
      this.$refs.cmEditor.setValue(JSON.stringify(value));
    }
  }
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