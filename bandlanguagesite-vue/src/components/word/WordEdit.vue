<template>
  <el-dialog title="编辑词汇" :visible="editFormVisible" :show-close="false">
    <el-form :model="existWord" label-position="top">
      <el-form-item label="词汇名称 *" :label-width="formLabelWidth">
        <el-input v-model="existWord.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="词汇描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="existWord.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇例子" :label-width="formLabelWidth">
        <el-input
            v-model="existWord.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇类型" :label-width="formLabelWidth">
        <el-radio-group v-model="existWord.type">
          <el-radio :label="1">名词</el-radio>
          <el-radio :label="2">动词</el-radio>
          <el-radio :label="3">形容词</el-radio>
          <el-radio :label="4">副词</el-radio>
          <el-radio :label="5">数词</el-radio>
          <el-radio :label="6">量词</el-radio>
          <el-radio :label="7">代词</el-radio>
          <el-radio :label="8">叹词</el-radio>
          <el-radio :label="9">拟声词</el-radio>
          <el-radio :label="10">介词</el-radio>
          <el-radio :label="11">连词</el-radio>
          <el-radio :label="12">助词</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="同义词" :label-width="formLabelWidth">
        <el-input
            v-model="existWord.synonym"
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
  name: "WordEdit",
  data() {
    return {
      existWord: {
        name: "",
        description: "",
        example: "",
        type: 1,
        synonym: ""
      },

      formLabelWidth: "120px",
    };
  },
  props:{
    editFormVisible:Boolean,
    wordId:Number
  },
  methods: {
    clearInput(){
      this.existWord = {}
    },
    cancelEdit() {
      this.clearInput()
      this.$emit('closeEditWordDialog',false)
    },
    confirmEdit() {
      // 检查输入
      if(this.existWord.name === '' || this.existWord.name === undefined || this.existWord.name === null){
        this.$message({
          showClose: true,
          message: "词汇名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.existWord.description === '' || this.existWord.description === undefined || this.existWord.description === null){
        this.$message({
          showClose: true,
          message: "词汇描述不能为空",
          type: 'error'
        });
        return;
      }
      const _this = this
      let updateWord = _this.existWord
      updateWord["userId"] = _this.$store.getters.getUser.userId
      updateWord["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/word/`,
        data: updateWord
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改词汇成功",
            type: 'success'
          });
          _this.cancelEdit()
        }
        else {
          _this.$message({
            showClose: true,
            message: "修改词汇失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "修改词汇失败",
          type: 'error'
        });
      })
      // console.log("existWord:")
      // console.log(this.existWord)
      this.$emit('closeEditWordDialog',false)
    },
  },
  watch: {
    editFormVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        const _this = this
        let wordId = this.$props.wordId
        this.$axios({
          method: 'get',
          url: `${this.global.serverUrl}/word/${wordId}`
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
            detailWord["isTypeInString"] = "未录入"
          }else if(detailWord.isTypeIn === 1){
            detailWord["isTypeInString"] = "已录入"
          }else {
            detailWord["isTypeInString"] = "其它"
          }
          _this.existWord = detailWord
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