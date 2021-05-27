<template>
  <div>
    <el-form :model="user" label-position="top">
      <el-form-item label="用户名 *" :label-width="formLabelWidth">
        <el-input placeholder="Michael" v-model="user.username" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="昵称 *" :label-width="formLabelWidth">
        <el-input placeholder="麦克" v-model="user.nickname" maxlength="100" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input placeholder="请输入密码(100字符以内)" v-model="user.password" show-password maxlength="100" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="手机号" :label-width="formLabelWidth">
        <el-input placeholder="请输入手机号" v-model="user.mobile" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="邮箱" :label-width="formLabelWidth">
        <el-input placeholder="example@qq.com" v-model="user.email" maxlength="100" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="头像链接" :label-width="formLabelWidth">
        <el-input
            v-model="user.head"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="500"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" style="text-align: center;">
      <el-button @click="cancelRegister">取消</el-button>
      <el-button type="primary" @click="confirmRegister">注册</el-button>
    </div>
  </div>
</template>

<script>
import md5 from 'js-md5';
export default {
  name: "Register",
  data(){
    return {
      user: {
        username: "",
        nickname: "",
        password: "",
        mobile: "",
        email: "",
        head: "",
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancelRegister() {
      this.user.username = ""
      this.user.nickname = ""
      this.user.password = ""
      this.user.mobile = ""
      this.user.email = ""
      this.user.head = ""
      this.$emit('closeRegisterDialog',false)
    },
    confirmRegister() {
      const _this = this
      let registerUser = {}
      registerUser["username"] = _this.user.username
      registerUser["nickname"] = _this.user.nickname
      registerUser["mobile"] = _this.user.mobile
      registerUser["email"] = _this.user.email
      registerUser["head"] = _this.user.head
      let salt = this.global.salt
      registerUser["password"] = md5(salt.charAt(2)+salt.charAt(0)+_this.user.password+salt.charAt(1)+salt.charAt(9))
      // console.log(registerUser["password"])
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/doRegister`,
        data: registerUser
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册用户成功",
            type: 'success'
          });
          this.cancelRegister()
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
          message: "注册用户失败",
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