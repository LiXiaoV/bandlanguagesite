<template>
  <div>
    <el-dialog
      :visible="wordDetailsVisible"
      width="30%"
      label-width="50px"
      label-position="right"
      :show-close="false"
    >
      <el-form :form="detailWord">
        <el-form-item label="词汇名：">
          <span>{{ detailWord.name }}</span>
        </el-form-item>
        <el-form-item label="类型：">
          <span>{{ detailWord.typeString }}</span>
        </el-form-item>
        <el-form-item label="描述：">
          <span>{{ detailWord.description }}</span>
        </el-form-item>
        <el-form-item label="例子：">
          <span>{{ detailWord.example }}</span>
        </el-form-item>
        <el-form-item label="同义词：">
          <span>{{ detailWord.synonym }}</span>
        </el-form-item>
        <el-form-item label="创建者：">
          <span>{{ detailWord.creatorNickname }}</span>
        </el-form-item>
        <el-form-item label="最近的修改者：">
          <span>{{ detailWord.editorNickname }}</span>
        </el-form-item>
        <el-form-item label="最近的修改时间：">
          <span>{{ detailWord.updateTime }}</span>
        </el-form-item>
        <el-form-item label="状态：">
          <span>{{ detailWord.isTypeInString }}</span>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="primary" @click="closeDlg">关闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      detailWord: {},
    };
  },
  methods: {
    closeDlg() {
      this.$emit('closeWordDetailDialog',false)
    },
  },
  props:{
    wordDetailsVisible:Boolean,
    wordId:Number
  },
  computed: {
  },
  watch: {
    wordDetailsVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        const _this = this
        let wordId = this.$props.wordId
        this.$axios({
          method: 'get',
          url: `${this.global.serverUrl}/word/wordDetail/${wordId}`
        }).then(res => {
          let detailWord = res.data.data
          // 词汇类型 1：名词 2：动词 3：形容词 4：副词 5：数词 6：量词 7：代词 8：叹词  9：拟声词 10：介词 11：连词 12：助词
          if(detailWord.type === 1){
            detailWord["typeString"] = "名词"
          }else if(detailWord.type === 2){
            detailWord["typeString"] = "动词"
          }else if(detailWord.type === 3){
            detailWord["typeString"] = "形容词"
          }else if(detailWord.type === 4){
            detailWord["typeString"] = "副词"
          }else if(detailWord.type === 5){
            detailWord["typeString"] = "数词"
          }else if(detailWord.type === 6){
            detailWord["typeString"] = "量词"
          }else if(detailWord.type === 7){
            detailWord["typeString"] = "代词"
          }else if(detailWord.type === 8){
            detailWord["typeString"] = "叹词"
          }else if(detailWord.type === 9){
            detailWord["typeString"] = "拟声词"
          }else if(detailWord.type === 10){
            detailWord["typeString"] = "介词"
          }else if(detailWord.type === 11){
            detailWord["typeString"] = "连词"
          }else if(detailWord.type === 12){
            detailWord["typeString"] = "助词"
          }

          // 词汇状态
          if(detailWord.isTypeIn === 0){
            detailWord["isTypeInString"] = "未实现"
          }else if(detailWord.isTypeIn === 1){
            detailWord["isTypeInString"] = "已实现"
          }else {
            detailWord["isTypeInString"] = "其它"
          }
          _this.detailWord = detailWord
        }).catch( error => {
          console.log(error)
        })
      }
    },
  },
  created() {

  }
};
</script>
