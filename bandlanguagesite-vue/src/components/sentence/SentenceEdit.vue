<template>
  <el-dialog title="编辑句型" :visible="editFormVisible" :show-close="false">
    <el-form :model="existSentence" label-position="top">
      <el-form-item label="句型名称 *" :label-width="formLabelWidth">
        <el-input v-model="existSentence.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="句型描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="existSentence.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="句型的巴克斯范式表示" :label-width="formLabelWidth">
        <el-input
            v-model="existSentence.paradigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelEdit">取消</el-button>
      <el-button type="primary" @click="confirmEdit">更新</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "SentenceEdit",
  data() {
    return {
      existSentence: {
        name: "",
        description: "",
        paradigm: "",
      },

      formLabelWidth: "120px",
    };
  },
  props:{
    editFormVisible:Boolean,
    sentenceId:Number
  },
  methods: {
    clearInput(){
      this.existSentence = {}
    },
    cancelEdit() {
      this.clearInput()
      this.$emit('closeEditSentenceDialog',false)
    },
    confirmEdit() {
      const _this = this
      let updateSentence = _this.existSentence
      updateSentence["userId"] = _this.$store.getters.getUser.userId
      updateSentence["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/sentence/update/`,
        data: updateSentence
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改句型成功",
            type: 'success'
          });
          _this.cancelEdit()
        }
        else {
          _this.$message({
            showClose: true,
            message: "修改句型失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "修改句型失败",
          type: 'error'
        });
      })
      // console.log("existSentence:")
      // console.log(this.existSentence)
      this.$emit('closeEditSentenceDialog',false)
    },
  },
  watch: {
    editFormVisible(newVal, oldVal) {
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
            detailSentence["isTypeInString"] = "未录入"
          }else if(detailSentence.isTypeIn === 1){
            detailSentence["isTypeInString"] = "已录入"
          }else {
            detailSentence["isTypeInString"] = "其它"
          }
          _this.existSentence = detailSentence
        }).catch( error => {
          console.log(error)
        })
      }
    },
  },
  created() {},
  computed: {

  },
}
</script>

<style scoped>

</style>