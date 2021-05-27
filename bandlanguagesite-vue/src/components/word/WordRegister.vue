<template>
  <el-dialog title="注册新词汇" :visible="registerFormVisible" :show-close="false">
    <el-form :model="newWord" label-position="top">
      <el-form-item label="词汇名称" :label-width="formLabelWidth">
        <el-input v-model="newWord.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="词汇描述" :label-width="formLabelWidth">
        <el-input
          v-model="newWord.description"
          type="textarea"
          :autosize="{ minRows: 2 }"
          maxlength="250"
          show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇例子" :label-width="formLabelWidth">
        <el-input
            v-model="newWord.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇类型" :label-width="formLabelWidth">
        <el-radio-group v-model="newWord.type">
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
            v-model="newWord.synonym"
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
      newWord: {
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
    registerFormVisible:Boolean,
  },
  methods: {
    clearInput(){
      this.newWord.name = ""
      this.newWord.description = ""
      this.newWord.example = ""
      this.newWord.type = 1
      this.newWord.synonym = ""
    },
    cancelRegister() {
      this.clearInput()
      this.$emit('closeRegisterWordDialog',false)
    },
    confirmRegister() {
      const _this = this
      let registerWord = _this.newWord
      registerWord["userId"] = _this.$store.getters.getUser.userId
      registerWord["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/word/insert/`,
        data: registerWord
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册词汇成功",
            type: 'success'
          });
          _this.clearInput()
        }
        else {
          _this.$message({
            showClose: true,
            message: "注册词汇失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "注册词汇失败",
          type: 'error'
        });
      })
      // console.log("newWord:")
      // console.log(this.newWord)
      this.$emit('closeRegisterWordDialog',false)
    },
  },
  created() {},
  computed: {

  },
};
</script>

<style scoped></style>
