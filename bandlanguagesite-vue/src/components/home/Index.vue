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
          <span style="float: left;font-size: 1.5rem">词汇</span>
          <el-button icon="iconfont iconadd" circle size="mini" @click="registerWord" style="margin-left: 1vw;"></el-button>
          <v-word-register
              :registerFormVisible="registerWordDlg"
              @closeRegisterWordDialog="closeRegisterWordDialog"></v-word-register>
        </div>
        <el-table
            :data="words.slice(wordStartPage, wordEndPage)"
        >
          <el-table-column type="index" label="序号" width="60" align="center">
          </el-table-column>
          <el-table-column prop="name" label="词汇名" min-width="30" align="center">
          </el-table-column>
          <el-table-column
              prop="typeString"
              label="类型"
              min-width="30"
              align="center"
          >
          </el-table-column>
          <el-table-column prop="sceneName" label="词汇所在的场景区" min-width="30" align="center">
          </el-table-column>
        </el-table>
        <el-pagination
            :current-page.sync="wordCurrentPage"
            :page-size="wordPageSize"
            layout="prev, pager, next,total"
            :total="words.length"
            class="a-pagination"
            hide-on-single-page
        >
        </el-pagination>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span style="float: left;font-size: 1.5rem">句型</span>
          <el-button icon="iconfont iconadd" circle size="mini" @click="registerSentence" style="margin-left: 1vw;"></el-button>
          <v-sentence-register
              :registerFormVisible="registerSentenceDlg"
              @closeRegisterSentenceDialog="closeRegisterSentenceDialog"></v-sentence-register>
        </div>
        <el-table
            :data="sentences.slice(sentenceStartPage, sentenceEndPage)"
        >
          <el-table-column type="index" label="序号" width="60" align="center">
          </el-table-column>
          <el-table-column prop="name" label="句型名" min-width="30" align="center">
          </el-table-column>
          <el-table-column prop="description" label="句型描述" min-width="30" align="center">
          </el-table-column>
          <el-table-column prop="sceneName" label="句型所在的场景区" min-width="30" align="center">
          </el-table-column>
        </el-table>
        <el-pagination
            :current-page.sync="sentenceCurrentPage"
            :page-size="sentencePageSize"
            layout="prev, pager, next,total"
            :total="sentences.length"
            class="a-pagination"
            hide-on-single-page
        >
        </el-pagination>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span style="float: left;font-size: 1.5rem">常用剧本</span>
          <el-button style="float: right; padding: 3px 0" type="text">全部</el-button>
        </div>
        <el-table
            :data="hotScripts"
        >
          <el-table-column type="index" label="序号" width="60" align="center">
          </el-table-column>
          <el-table-column prop="name" label="剧本名" min-width="30" align="center">
          </el-table-column>
          <el-table-column prop="description" label="剧本描述" min-width="30" align="center">
          </el-table-column>
          <el-table-column prop="content" label="剧本内容" min-width="30" align="center">
          </el-table-column>
          <el-table-column prop="sceneName" label="剧本所在的场景区" min-width="30" align="center">
          </el-table-column>
        </el-table>
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
import WordRegister from "@/components/word/WordRegister";
import SentenceRegister from "@/components/sentence/SentenceRegister";
export default {
  data() {
    return {
      activePath: "/",
      activeIndex2: '1',

      default_avatar: defaultAvatar,
      hot_scenes:[],
      //注册新词汇的对话框
      registerWordDlg: false,

      words: [],
      wordCurrentPage: 1,
      wordPageSize: 10,

      //注册新句型的对话框
      registerSentenceDlg: false,
      sentences: [],
      sentenceCurrentPage: 1,
      sentencePageSize: 10,

      // 常用的剧本
      hotScripts: [],
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
    registerWord() {
      this.registerWordDlg = true
    },
    closeRegisterWordDialog(flag){
      this.registerWordDlg = flag
    },
    reloadWords(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/word/all/`
      }).then(res => {
        let words = res.data.data
        words.forEach( (element) => {
          // 词汇类型 1：名词 2：动词 3：形容词 4：副词 5：数词 6：量词 7：代词 8：叹词  9：拟声词 10：介词 11：连词 12：助词
          if(element.type === 1){
            element["typeString"] = "名词"
          }else if(element.type === 2){
            element["typeString"] = "动词"
          }else if(element.type === 3){
            element["typeString"] = "形容词"
          }else if(element.type === 4){
            element["typeString"] = "副词"
          }else if(element.type === 5){
            element["typeString"] = "数词"
          }else if(element.type === 6){
            element["typeString"] = "量词"
          }else if(element.type === 7){
            element["typeString"] = "代词"
          }else if(element.type === 8){
            element["typeString"] = "叹词"
          }else if(element.type === 9){
            element["typeString"] = "拟声词"
          }else if(element.type === 10){
            element["typeString"] = "介词"
          }else if(element.type === 11){
            element["typeString"] = "连词"
          }else if(element.type === 12){
            element["typeString"] = "助词"
          }
        })
        _this.words = words
      }).catch( error => {
        console.log(error)
      })
    },
    reloadSentences(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/sentence/all/`
      }).then(res => {
        _this.sentences = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    reloadScenes(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/scene/scenes/`
      }).then(res => {
        let scenes = res.data.data
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
    reloadHotScripts(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/script/hotScripts/`,
        params: {
          limitCount: 5,
        }
      }).then(res => {
        _this.hotScripts = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    registerSentence() {
      this.registerSentenceDlg = true
    },
    closeRegisterSentenceDialog(flag){
      this.registerSentenceDlg = flag
    },
  },
  mounted() {

  },
  created() {
    // sceneId = this.$route.params.id
    this.reloadScenes()
    this.reloadWords()
    this.reloadSentences()
    this.reloadHotScripts()
  },
  computed: {
    wordStartPage: function () {
      return (this.wordCurrentPage - 1) * this.wordPageSize;
    },
    wordEndPage: function () {
      return this.wordCurrentPage * this.wordPageSize;
    },
    sentenceStartPage: function () {
      return (this.sentenceCurrentPage - 1) * this.sentencePageSize;
    },
    sentenceEndPage: function () {
      return this.sentenceCurrentPage * this.sentencePageSize;
    },
  },
  components:{
    "v-header":Header,
    "v-word-register": WordRegister,
    "v-sentence-register": SentenceRegister,
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