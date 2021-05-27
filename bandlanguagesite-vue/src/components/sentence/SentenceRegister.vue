<template>
  <el-dialog title="注册新句型" :visible="registerFormVisible" :show-close="false">
    <el-form :model="newSentence" label-position="top">
      <el-form-item label="句型名称" :label-width="formLabelWidth">
        <el-input v-model="newSentence.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="句型描述" :label-width="formLabelWidth">
        <el-input
            v-model="newSentence.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="句型的巴克斯范式表示" :label-width="formLabelWidth">
        <el-input
            v-model="newSentence.paradigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelRegister">取消</el-button>
      <el-button type="primary" @click="confirmRegister">注册</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  data() {
    return {
      newSentence: {
        name: "",
        description: "",
        paradigm: "",
      },
      userId: 3,
      formLabelWidth: "120px",
    };
  },
  props:{
    registerFormVisible:Boolean,
  },
  methods: {
    clearInput(){
      this.newSentence.name = ""
      this.newSentence.description = ""
      this.newSentence.paradigm = ""
    },
    cancelRegister() {
      this.clearInput()
      this.$emit('closeRegisterSentenceDialog',false)
    },
    confirmRegister() {
      const _this = this
      let registerSentence = _this.newSentence
      registerSentence["userId"] = _this.$store.getters.getUser.userId
      registerSentence["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/sentence/insert/`,
        data: registerSentence
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册句型成功",
            type: 'success'
          });
          _this.clearInput()
        }
        else {
          _this.$message({
            showClose: true,
            message: "注册句型失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "注册句型失败",
          type: 'error'
        });
      })
      this.$emit('closeRegisterSentenceDialog',false)
    },
  },
  created() {},
  computed: {

  },
};
</script>

<style scoped></style>
