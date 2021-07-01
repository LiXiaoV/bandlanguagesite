<template>
  <div>
    <el-row type="flex" align="center" style="background-color: white;">
      <el-col :sm="2" :md="2" :lg="1"><span class="iconfont iconluntan" style="font-size: 3rem;"></span></el-col>
      <el-col :sm="4" :md="3" :lg="2"><div style="margin-top: 1.5vh;font-size: 1.1rem;"><span>帮语网站</span></div></el-col>
      <el-col :sm="10" :md="10" :lg="13">
        <el-menu :default-active="global.activePath" class="el-menu-demo" mode="horizontal"
                 :router="true" @select="handleSelect" style="border-bottom:none">
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
      <el-col :sm="1" :md="1" :lg="1"><div style="margin-left: 1vw;margin-top: 1.5vh;"><span style="font-size: 2rem;" class="iconfont iconyouxiang"></span></div></el-col>
      <el-col :sm="2" :md="2" :lg="2">
        <el-popover
            width="250"
            placement="bottom-end"
            trigger="hover">
          <div>
            <div slot="header">
              <span>{{userInfo.userName}}</span>
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
          <el-avatar slot="reference" :size="40" :src="userInfo.head" @error="errorHandler" style="margin-top: 1vh;margin-left: 0.5vw;">
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
      <v-login @closeLoginDialog="closeLoginDialog"
                @loginStatusUpdate="loginStatusUpdate"></v-login>
    </el-dialog>
  </div>

</template>

<script>
import defaultAvatar from '../../assets/images/default-avatar.png';
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
    }
  },
  methods:{
    handleSelect(key) {
      if(key){
        console.log(key);
        // sessionStorage.setItem("activePath",key)
        this.$store.commit("SET_CURRENT_SCENE_ID",0);
        this.global.setActivePath(key)
      }
    },
    errorHandler() {
      return true
    },
    register(){
      window.open("https://www.wetoband.com/tre//runSystemTool?toolID=2920378&gid=145", '_blank');
    },
    login(){
      this.loginDialogVisible = true
    },
    settingAccount(){

    },
    logout(){
      // 1. 先后端发送logout请求,先登出，再做游客登陆
      const _this = this
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/logout/`,
      }).then(res => {
        if(res.data.code === 0){
          _this.$store.commit("SET_IS_LOGIN",false)
          _this.isLogin = _this.$store.getters.getIsLogin
        }
        else {
          _this.$message({
            showClose: true,
            message: "用户注销失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "用户注销失败",
          type: 'error'
        });
      })

      // 2. 重新请求用户信息，把userInfo设为游客,并更新userInfo
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/user/info/`,
      }).then(res => {
        if(res.data.code === 0){
          let me = res.data.data
          _this.$store.commit("SET_USERINFO",me)
          _this.userInfo = _this.$store.getters.getUser
          if(_this.userInfo != null && Number(_this.userInfo.userID) > 0 && Number(_this.userInfo.userID) !== 28){
            _this.$store.commit("SET_IS_LOGIN",true)
            _this.isLogin = _this.$store.getters.getIsLogin
          }
          _this.$message({
            showClose: true,
            message: "注销成功",
            type: 'success'
          });
        }
      }).catch( error => {
        console.log(error)
      })
    },
    closeLoginDialog(){
      this.loginDialogVisible = false
    },
    loginStatusUpdate(){
      // 检查用户登录状态，和用户信息
      this.isLogin = this.$store.getters.getIsLogin
      this.userInfo = this.$store.getters.getUser

    },

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
    let userInfo = this.$store.getters.getUser
    if(userInfo == null || Object.keys(userInfo).length === 0){
      // 去后端查用户
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/user/info/`,
      }).then(res => {
        if(res.data.code === 0){
          let me = res.data.data
          _this.$store.commit("SET_USERINFO",me)
          _this.userInfo = _this.$store.getters.getUser
          // console.log(_this.userInfo)
          if(_this.userInfo != null && Number(_this.userInfo.userID) > 0 && Number(_this.userInfo.userID) !== 28){
            _this.$store.commit("SET_IS_LOGIN",true)
          }else {
            _this.$store.commit("SET_IS_LOGIN",false)
          }
          _this.isLogin = _this.$store.getters.getIsLogin
        }
      }).catch( error => {
        console.log(error)
      })
    }else {
      // 确保及时有值，刷新时也能拿到userInfo
      this.userInfo = this.$store.getters.getUser
      this.isLogin = this.$store.getters.getIsLogin
      // console.log(this.isLogin)
    }
  },
  components:{
    "v-login": LoginByUsername,
  }
}
</script>

<style scoped>
@import "../../assets/style/iconfont/iconfont.css";
</style>