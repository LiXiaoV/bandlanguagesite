<template>
  <el-dialog
      :visible="sentenceDetailsVisible"
      width="30%"
      label-width="50px"
      label-position="right"
      :show-close="false"
  >
    <el-form :form="detailSentence">
      <el-form-item label="句型名：">
        <span>{{ detailSentence.name }}</span>
      </el-form-item>
      <el-form-item label="描述：">
        <span>{{ detailSentence.description }}</span>
      </el-form-item>
      <el-form-item label="句型的巴克斯范式表示：">
        <span>{{ detailSentence.paradigm }}</span>
      </el-form-item>
      <el-form-item label="创建者：">
        <span>{{ detailSentence.creatorNickname }}</span>
      </el-form-item>
      <el-form-item label="最近的修改者：">
        <span>{{ detailSentence.editorNickname }}</span>
      </el-form-item>
      <el-form-item label="最近的修改时间：">
        <span>{{ detailSentence.updateTime }}</span>
      </el-form-item>
      <el-form-item label="录入状态：">
        <span>{{ detailSentence.isTypeInString }}</span>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button type="primary" @click="closeDlg">关闭</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "UserSentenceDetail",
  props:{
    sentenceDetailsVisible:Boolean,
    sentenceId:Number
  },
  data() {
    return {
      detailSentence: {},
    };
  },
  methods: {
    closeDlg() {
      this.$emit('closeSentenceDetailDialog',false)
    },
  },
  computed: {
  },
  watch: {
    sentenceDetailsVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        const _this = this
        let sentenceId = this.$props.sentenceId
        this.$axios({
          method: 'get',
          url: `${this.global.serverUrl}/sentence/${sentenceId}`
        }).then(res => {
          let detailSentence = res.data.data
          // 句型状态
          if(detailSentence.isTypeIn === 0){
            detailSentence["isTypeInString"] = "未实现"
          }else if(detailSentence.isTypeIn === 1){
            detailSentence["isTypeInString"] = "已实现"
          }else {
            detailSentence["isTypeInString"] = "其它"
          }
          _this.detailSentence = detailSentence
        }).catch( error => {
          console.log(error)
        })
      }
    },
  },
  created() {

  }
}
</script>

<style scoped>

</style>