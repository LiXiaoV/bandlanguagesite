<template>
  <div>
    <el-form :model="user" label-position="top">
      <el-form-item label="用户名 *" :label-width="formLabelWidth">
        <el-input placeholder="Michael" v-model="user.username" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input placeholder="请输入密码(100字符以内)" v-model="user.password" show-password maxlength="100" show-word-limit></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" style="text-align: center;">
      <el-button @click="cancelLogin">取消</el-button>
      <el-button type="primary" @click="confirmLogin">登陆</el-button>
    </div>
  </div>
</template>

<script>
import md5 from "js-md5";

export default {
  name: "LoginByUsername",
  data(){
    return {
      user: {
        username: "",
        password: "",
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancelLogin() {
      this.user.username = ""
      this.user.password = ""
      this.$emit('closeLoginDialog',false)
    },
    confirmLogin() {
      const _this = this
      let loginUser = {}
      loginUser["username"] = _this.user.username
      let salt = this.global.salt
      loginUser["password"] = md5(salt.charAt(2)+salt.charAt(0)+_this.user.password+salt.charAt(1)+salt.charAt(9))
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/doLoginByUsername`,
        data: loginUser
      }).then(res => {
        if(res.data.code === 0){

          _this.$message({
            showClose: true,
            message: "登陆成功",
            type: 'success'
          });
          const userInfo = res.data.data
          _this.$store.commit("SET_USERINFO",userInfo)
          this.cancelLogin()
        }
        else {
          _this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "登陆失败",
          type: 'error'
        });
      })
    },
  },
  created() {
  }
}
</script>

<style scoped>

</style>