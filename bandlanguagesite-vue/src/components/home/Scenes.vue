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
          <span style="float: left;font-size: 1.5rem">所有场景区</span>
          <el-button icon="iconfont iconadd" circle size="mini" @click="registerScene" style="margin-left: 1vw;"></el-button>
          <v-scene-register
              :registerFormVisible="registerSceneDlg"
              @closeRegisterSceneDialog="closeRegisterSceneDialog"></v-scene-register>
        </div>
        <el-row>
          <el-col class="scene-area-item" :span="3" v-for="(item, index) in scenes.slice(startPage, endPage)" :key="index" :offset="1">
            <div @click="enterSceneDetail(item.deptId)">
              <img class="scene-area" :src="item.avatar" :alt="item.name">
              <div>{{item.name}}</div>
            </div>
          </el-col>
        </el-row>
        <el-pagination
            :current-page.sync="currentPage"
            :page-size="pageSize"
            layout="prev, pager, next,total"
            :total="scenes.length"
            class="a-pagination"
            hide-on-single-page
        >
        </el-pagination>
      </el-card>

    </div>
  </div>
</template>

<script>
import imageLibrary from '../../assets/images/image-library.png';
import Header from "@/components/common/Header";
import SceneRegister from "@/components/home/SceneRegister";
export default {
  data() {
    return {
      activePath: "/scenes",
      scenes:[],
      currentPage:1,
      pageSize:15,

      // 注册场景区
      registerSceneDlg: false,

    };
  },
  methods: {
    errorHandler() {
      return true
    },
    handleCurrentChange(val){
      console.log(`当前页: ${val}`);
    },
    enterSceneDetail(sceneId){
      console.log("sceneId:"+sceneId)
      if(sceneId){
        // sessionStorage.setItem("activePath","scenes")
        this.global.setActivePath("/scenes");
        this.$router.push({ path: `/sceneDetail/${sceneId}` })
      }
    },
    reloadScenes(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/scene/scenes/`
      }).then(res => {
        const scenes = res.data.data
        if(scenes){
          scenes.forEach((element) =>{
            element.avatar = imageLibrary
          })
        }
        _this.scenes = scenes
        _this.totalCount = scenes.length
      }).catch( error => {
        console.log(error)
      })
    },
    registerScene(){
      this.registerSceneDlg = true
    },
    closeRegisterSceneDialog(){
      this.reloadScenes()
      this.registerSceneDlg = false
    }
  },
  mounted() {

  },
  created() {
    this.reloadScenes()
  },
  components:{
    "v-header":Header,
    "v-scene-register": SceneRegister,
  },
  computed:{
    startPage:function(){
      return (this.currentPage-1)*this.pageSize;
    },
    endPage:function(){
      return this.currentPage*this.pageSize;
    }
  }
}
</script>

<style lang="scss" scoped>

//body{
//  background-color: #edf5f5;
//}
//.v-global{
//  //background-color: #E9EEF3;
//  margin: 0 10vw;
//  .v-header{
//    //height: 10vh;
//  }
//  .v-content{
//    margin-top: 5vh;
//  }
//}

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



</style>