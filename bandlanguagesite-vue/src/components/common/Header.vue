<template>
  <div>
    <el-row type="flex" justify="center" style="background-color: white;">
      <el-col :sm="2" :md="2" :lg="1"><span class="iconfont iconluntan" style="font-size: 3rem;"></span></el-col>
      <el-col :sm="3" :md="2" :lg="2"><div style="margin-top: 1.5vh;font-size: 1.1rem;">帮语网站</div></el-col>
      <el-col :sm="11" :md="10" :lg="13">
        <el-menu :default-active="global.activePath" class="el-menu-head" mode="horizontal" :router="true" @select="handleSelect">
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/scenes">场景区</el-menu-item>
          <el-menu-item index="/discuss">公共讨论</el-menu-item>
        </el-menu>
      </el-col>
      <el-col :sm="4" :md="6" :lg="5">
        <el-input
            placeholder="搜索场景区、剧本、帖子"
            prefix-icon="el-icon-search"
            v-model="input"
            clearable
            style="margin-top: 1vh;"
        >
        </el-input>
      </el-col >
      <el-col :sm="2" :md="1" :lg="1"><span style="float: right;font-size: 2rem;margin-top:1.5vh;margin-left: 1vw;" class="iconfont iconyouxiang"></span></el-col>
      <el-col :sm="2" :md="2" :lg="1">
        <el-popover
            width="250"
            placement="bottom-end"
            trigger="hover">
          <div>
            <div slot="header">
              <span>{{userInfo.nickname}}</span>
            </div>
            <el-divider></el-divider>
            <div v-if="isLogin === true">
              <div v-for="o in 4" :key="o" class="text item">
                {{'列表内容 ' + o }}
              </div>
              <el-divider></el-divider>
            </div>
            <el-row type="flex" justify="center" v-if="isLogin === true">
              <el-col :span="11" :offset="1">
                <el-button round size="medium" @click="settingAccount" style="width: 100px;">账号设置</el-button>
              </el-col>
              <el-col :span="11" :offset="1">
                <el-button round size="medium" @click="logout" style="width: 100px;">注销</el-button>
              </el-col>
            </el-row>
            <el-row justify="center" v-else>
              <el-col :span="11" :offset="1">
                <el-button type="success" round size="medium" @click="login" style="width: 100px;">登陆</el-button>
              </el-col>
              <el-col :span="11" :offset="1">
                <el-button round size="medium" @click="register" style="width: 100px;">注册</el-button>
              </el-col>
            </el-row>
          </div>
          <el-avatar slot="reference" :size="40" :src="userInfo.head" @error="errorHandler" style="margin-top: 1vh;margin-left: 1vw;">
            <img :src="default_avatar" alt="我的头像"/>
          </el-avatar>
        </el-popover>
      </el-col>
    </el-row>
    <el-dialog
        title="登陆"
        :visible.sync="loginDialogVisible"
        width="30%"
        center>
      <v-login @closeLoginDialog="closeLoginDialog"></v-login>
    </el-dialog>
    <el-dialog
        title="注册"
        :visible.sync="registerDialogVisible"
        width="30%"
        center>
      <v-register @closeRegisterDialog="closeRegisterDialog"></v-register>
    </el-dialog>
  </div>

</template>

<script>
import defaultAvatar from '../../assets/images/default-avatar.png';
import Register from "@/components/account/Register";
import LoginByUsername from "@/components/account/LoginByUsername";
export default {
  name: "Header",
  data(){
    return {
      default_avatar: defaultAvatar,
      input: '',
      userInfo: {},
      isLogin: false,
      loginDialogVisible: false,
      registerDialogVisible: false,
    }
  },
  methods:{
    handleSelect(key) {
      if(key){
        console.log(key);
        // sessionStorage.setItem("activePath",key)
        this.global.setActivePath(key)
      }
    },
    errorHandler() {
      return true
    },
    register(){
      this.registerDialogVisible = true
    },
    login(){
      this.loginDialogVisible = true
    },
    settingAccount(){

    },
    logout(){
      // 先后端发送logout请求
      // 把userInfo设为游客,并更新userInfo
      this.$store.commit("SET_USERINFO",this.global.defaultUser)
      this.userInfo = this.global.defaultUser
      // 把登陆状态改为false
      this.isLogin = false
    },
    closeLoginDialog(flag){
      this.loginDialogVisible = flag
      // 更新userInfo和登陆标志
      this.userInfo = this.$store.getters.getUser
      this.isLogin = this.userInfo.userId > 1
    },
    closeRegisterDialog(flag){
      this.registerDialogVisible = flag
    }
  },
  mounted() {
    // this.activePath = sessionStorage.getItem("activePath")
    // console.log("activePath:"+this.activePath)
    // if(!this.activePath){
    //   this.activePath = "/"
    // }
    // sessionStorage.removeItem("activePath")
    console.log("header mounted")
  },
  watch:{
    // activePath(newValue,oldValue){
    //   console.log("activePath:",newValue,oldValue);
    // }
  },
  created() {
    if(this.$store.getters.getUser == null){
      // console.log("设置默认用户：")
      // console.log(this.global.defaultUser)
      this.$store.commit("SET_USERINFO",this.global.defaultUser)
      this.isLogin = false
    }else if(this.$store.getters.getUser.userId > 1){
      this.isLogin = true
    }

    this.userInfo = this.$store.getters.getUser
    // console.log("userInfo:")
    // console.log(this.userInfo)
  },
  components:{
    "v-register": Register,
    "v-login": LoginByUsername,
  }
}
</script>

<style scoped>
@import "../../assets/style/iconfont/iconfont.css";
</style>