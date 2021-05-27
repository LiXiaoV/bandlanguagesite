<template>
  <div class="v-global">
    <div class="v-header">
      <keep-alive>
        <v-header></v-header>
      </keep-alive>
    </div>
    <div class="v-content">
      <el-row>
        <el-col :span="3" style="margin-left:2vw;margin-top: 10vh;">
          <el-menu
              :default-active="navIndex"
              class="el-menu-vertical-demo"
              @select="changeNavContent"
          >
            <el-menu-item index="1">
              <i style="margin-right: 0.5vw;" class="iconfont iconcihui"></i>
              <span>词汇</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i style="margin-right: 0.5vw;" class="iconfont iconjuxing"></i>
              <span slot="title">句型</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i style="margin-right: 0.5vw;" class="iconfont iconjuben"></i>
              <span slot="title">剧本</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i style="margin-right: 0.5vw;" class="iconfont iconDebug"></i>
              <span slot="title">调试器</span>
            </el-menu-item>
            <el-menu-item index="5">
              <i style="margin-right: 0.5vw;" class="iconfont iconkaifa"></i>
              <span slot="title">帮语开发</span>
            </el-menu-item>
            <el-menu-item index="6">
              <i style="margin-right: 0.5vw;" class="iconfont iconsetting"></i>
              <span slot="title">帮语管理</span>
            </el-menu-item>
            <el-menu-item index="7">
              <i style="margin-right: 0.5vw;" class="iconfont icontaolun"></i>
              <span slot="title">场景区讨论</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="18">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span style="float: left;font-size: 1.5rem">{{sceneTitle}}</span>
            </div>
            <keep-alive>
              <el-row v-if="navIndex === '1'">
                <word-index></word-index>
              </el-row>
              <el-row v-if="navIndex === '2'">
                <sentence-index></sentence-index>
              </el-row>
              <el-row v-if="navIndex === '3'">
                <script-index></script-index>
              </el-row>
              <el-row v-if="navIndex === '4'">
                <debug-index></debug-index>
              </el-row>
              <el-row v-if="navIndex === '5'">
                <developer-index></developer-index>
              </el-row>
              <el-row v-if="navIndex === '6'">
                <manager-index></manager-index>
              </el-row>
              <el-row v-if="navIndex === '7'">
                <span>场景区讨论</span>
              </el-row>
            </keep-alive>
          </el-card>
        </el-col>

      </el-row>

    </div>
  </div>
</template>

<script>
import Header from "@/components/common/Header";
import defaultAvatar from '../../assets/images/default-avatar.png';
import WordIndex from "@/components/word/WordIndex";
import SentenceIndex from "@/components/sentence/SentenceIndex";
import ScriptIndex from "@/components/script/ScriptIndex";
import DeveloperIndex from "@/components/developer/DeveloperIndex";
import ManagerIndex from "@/components/manager/ManagerIndex";
import DebuggerIndex from "@/components/debugger/DebuggerIndex";
// import imageLibrary from "@/assets/images/image-library.png";

export default {
  data() {
    return {
      activeIndex: '1',
      input: '',
      sceneTitle: '',
      default_avatar: defaultAvatar,
      navIndex: '1',
      currentPage: 1,
      pageSize: 15,
      totalCount: 16,
    };
  },
  methods: {
    errorHandler() {
      return true
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    changeNavContent(key) {
      if (key) {
        this.navIndex = key;
      }
    }
  },
  created() {
    const sceneId = this.$route.params.id
    // console.log("sceneId:"+sceneId)
    const _this = this
    this.$axios({
      method: 'get',
      url: `${this.global.serverUrl}/scene/${sceneId}`
    }).then(res => {
      const detailScene = res.data
      if(detailScene){
        _this.sceneTitle = detailScene.name + "场景区"
      }
    }).catch( error => {
      console.log(error)
    })
  },
  components: {
    "v-header": Header,
    "word-index": WordIndex,
    "sentence-index": SentenceIndex,
    "script-index": ScriptIndex,
    "developer-index": DeveloperIndex,
    "manager-index": ManagerIndex,
    "debug-index": DebuggerIndex,
  }
}
</script>

<style lang="scss" scoped>

@import "../../assets/style/iconfont/iconfont.css";

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 64vw;
  margin-left: 1vw;
}

.scene-area {
  margin-bottom: 1vh;
  height: 4vw;
}

.scene-area-item {
  margin: 0 2vw 4vh 2vw;
  background-color: #E9EEF3;
}


</style>