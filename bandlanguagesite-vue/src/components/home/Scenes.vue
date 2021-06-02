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
        </div>
        <el-row>
          <el-col class="scene-area-item" :span="3" v-for="(item, index) in scenes" :key="index" :offset="1">
            <div @click="enterSceneDetail(item.deptId)">
              <img class="scene-area" :src="item.avatar" :alt="item.name">
              <div>{{item.name}}</div>
            </div>
          </el-col>
        </el-row>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="totalCount"
            :page-size="pageSize"
            :current-page="currentPage"
            @current-change="handleCurrentChange">
        </el-pagination>
      </el-card>

    </div>
  </div>
</template>

<script>
import imageLibrary from '../../assets/images/image-library.png';
import Header from "@/components/common/Header";
export default {
  data() {
    return {
      activePath: "/scenes",
      scenes:[
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
        //   id:5,
        //   name:'应急',
        //   src:imageLibrary
        // },
        // {
        //   id:6,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:7,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:8,
        //   name:'应急',
        //   src:imageLibrary
        // },
        // {
        //   id:9,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:10,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:11,
        //   name:'应急',
        //   src:imageLibrary
        // },
        // {
        //   id:12,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:13,
        //   name:'影像库',
        //   src:imageLibrary
        // },
        // {
        //   id:14,
        //   name:'应急',
        //   src:imageLibrary
        // },
        // {
        //   id:15,
        //   name:'影像库',
        //   src:imageLibrary
        // },
      ],
      currentPage:1,
      pageSize:15,
      totalCount:16,
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
    }
  },
  mounted() {

  },
  created() {
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
  components:{
    "v-header":Header
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
  text-align: center;
}

.scene-area{
  margin-bottom: 1vh;
  height: 4vw;
}
.scene-area-item{
  margin:0 2vw 4vh 2vw;
  background-color: #E9EEF3;
}



</style>