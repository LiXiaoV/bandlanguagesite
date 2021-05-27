<template>
  <div class="v-global">
    <div class="v-header">
      <keep-alive>
        <v-header></v-header>
      </keep-alive>
    </div>
    <div class="v-content">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span style="float: left;font-size: 1.5rem">火热的场景区</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="enterScenes">全部</el-button>
        </div>
        <el-row>
          <el-col class="scene-area-item" :span="3" v-for="(item, index) in hot_scenes" :key="index" :offset="1">
            <div @click="enterSceneDetail(item.deptId)">
              <img class="scene-area" :src="item.avatar" :alt="item.name">
              <div>{{item.name}}</div>
            </div>

          </el-col>

        </el-row>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span style="float: left;font-size: 1.5rem">常用剧本</span>
          <el-button style="float: right; padding: 3px 0" type="text">全部</el-button>
        </div>
        <div v-for="o in 5" :key="o" class="text item">
          {{'剧本 ' + o }}
        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span style="float: left;font-size: 1.5rem">火热的帖子</span>
        </div>
        <div v-for="o in 3" :key="o" class="hot-invitation">
          <div class="invitation-item">
            <el-avatar class="invitation-avatar" :size="50" src="https://empty" @error="errorHandler">
              <img :src="default_avatar" alt="我的头像"/>
            </el-avatar>

            <div class="invitation-content">
              <el-row type="flex">
                <el-col><span style="color: #58a8c1">发帖者</span></el-col>
                <el-col :span="6"><span>发帖时间</span></el-col>
              </el-row>
              <el-row type="flex" style="padding-top: 1vh;font-weight: bold;font-size: 1.2rem;">
                <el-col><span>帖子标题</span></el-col>
              </el-row>
              <div style="max-height: 10vh;">
                <p>帖子内容</p>
              </div>
              <el-row type="flex" justify="space-between" class="invitation-operation">
                <el-col class="dianzan">
                  <span class="iconfont icondianzan"></span>
                  <span>100</span>
                </el-col>
                <el-col class="pinglun">
                  <span class="iconfont iconpinglun"></span>
                  <span>50</span>
                </el-col>
                <el-col class="fenxiang">
                  <span class="iconfont iconfenxiang"></span>
                  <span>3</span>
                </el-col>
              </el-row>
            </div>

          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import defaultAvatar from '../../assets/images/default-avatar.png';
import imageLibrary from '../../assets/images/image-library.png';
import Header from "@/components/common/Header";
export default {
  data() {
    return {
      activePath: "/",
      activeIndex2: '1',

      default_avatar: defaultAvatar,
      hot_scenes:[
        // {
        //   id:1,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:2,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:3,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:4,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:6,
        //   name:'应急',
        //   src:imageLibrary
        // },
        // {
        //   id:7,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:8,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:9,
        //   name:'应急',
        //   src:imageLibrary
        // },
      ]
    };
  },
  methods: {
    errorHandler() {
      return true
    },
    enterScenes(){
      this.global.setActivePath("/scenes");
      this.$router.push({ path: "/scenes" })
    },
    enterSceneDetail(sceneId){
      console.log("sceneId:"+sceneId)
      if(sceneId){
        // sessionStorage.setItem("activePath","scenes")
        this.global.setActivePath("/scenes");
        this.$router.push({ path: `/sceneDetail/${sceneId}` })
      }
    },

  },
  mounted() {

  },
  created() {
    // sceneId = this.$route.params.id

    const _this = this
    this.$axios({
      method: 'get',
      url: `${this.global.serverUrl}/scene/scenes/`
    }).then(res => {
      const scenes = res.data
      if(scenes){
        scenes.forEach((element) =>{
          element.avatar = imageLibrary
        })
      }
      _this.hot_scenes = scenes
    }).catch( error => {
      console.log(error)
    })
  },
  components:{
    "v-header":Header
  }
}
</script>
<style lang="scss">
body{
  background-color: #edf5f5;
}
.v-global{
  //background-color: #E9EEF3;
  margin: 0 10vw;
  .v-header{
    //height: 10vh;
  }
  .v-content{
    margin-top: 4vh;
  }
}
</style>

<style lang="scss" scoped>

@import "../../assets/style/iconfont/iconfont.css";
//body{
//  background-color: #edf5f5;
//}
//.a-global{
//  //background-color: #E9EEF3;
//  margin: 0 10vw;
//  .a-header{
//    height: 10vh;
//  }
//  //.a-content{
//  //  height: 50vh;
//  //
//  //}
//}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
  text-align: left;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 65vw;
  margin-left: 7vw;
  margin-top: 2vh;
}

.scene-area{
  margin-bottom: 1vh;
  height: 4vw;
}
.scene-area-item{
  margin:0 2vw 4vh 2vw;
  background-color: #E9EEF3;
  text-align: center;
}

.invitation-item{
  //text-align: left;
  margin-bottom: 2vh;
  //border-bottom: 1px solid #7e7c7c;
  background-color: #f5fdfd;
  .invitation-avatar{
    float: left;
    margin: 0;
    padding: 0;
  }
  .invitation-content{
    margin-left: 5vw;
  }
  .invitation-operation{
    text-align: center;
  }
}

</style>