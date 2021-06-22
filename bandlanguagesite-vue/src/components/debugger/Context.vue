<template>
  <div class="context">
    <!-- <el-card style="border-radius: 8px; height: 82vh" :body-style="cardBodyStyle"> -->
    <div class="tabBox">
      <el-tabs
        :tab-position="tabPosition"
        style="height: 200px; background-color: white"
        type="card"
        v-model="activeTab"
        :before-leave="tooglePanel"
        @tab-click="tabClick"
      >
        <el-tab-pane name="visibility" style="margin-bottom: 5px">
          <template slot="label">
            <i
              :class="isPanelHidden ? 'el-icon-d-arrow-left' : 'el-icon-d-arrow-right'"
              style="text-align: middle; width: 100%; height: 100%"
              @click="clickPanel"
            ></i>
          </template>
          <p style="font-style: italic; margin: auto; width: 100%">请选择查看的窗格</p>
        </el-tab-pane>

        <el-tab-pane label="语境" name="context">
          <div>
            <div class="titleFont">语境</div>
            <div style="height: 75vh; overflow-y: auto" class="contextStyle">
              <el-collapse style="border: none" :value="activePanel">
                <el-collapse-item name="organization">
                  <template slot="title"> 机构语境 </template>
                  <div style="width: 100%">
                    <div
                      v-for="(item, index) in contextList.organizationContext"
                      :key="index"
                    >
                      <div v-if="item.value.length > 1">
                        <dt>{{ item.name }}:</dt>
                        <dd v-for="valueItem in item.value" :key="valueItem">
                          <span class="valueFont">{{ valueItem }}</span>
                        </dd>
                      </div>
                      <div v-else>
                        {{ item.name }}:<span class="valueFont">{{ item.value[0] }}</span>
                      </div>
                    </div>
                  </div>
                </el-collapse-item>
                <el-collapse-item name="band">
                  <template slot="title"> 帮区语境 </template>
                  <div style="width: 100%">
                    <div v-for="(item, index) in contextList.bandContext" :key="index">
                      <div v-if="item.value.length > 1">
                        <dt>{{ item.name }}:</dt>
                        <dd v-for="valueItem in item.value" :key="valueItem">
                          <span class="valueFont">{{ valueItem }}</span>
                        </dd>
                      </div>
                      <div v-else>
                        {{ item.name }}:<span class="valueFont">{{ item.value[0] }}</span>
                      </div>
                    </div>
                  </div>
                </el-collapse-item>
                <el-collapse-item name="script">
                  <template slot="title"> 剧本语境 </template>
                  <div style="height:width: 100%">
                    <div v-for="(item, index) in contextList.scriptContext" :key="index">
                      <div v-if="item.value.length > 1">
                        <dt>{{ item.name }}:</dt>
                        <dd v-for="valueItem in item.value" :key="valueItem">
                          <span class="valueFont">{{ valueItem }}</span>
                        </dd>
                      </div>
                      <div v-else>
                        {{ item.name }}:<span class="valueFont">{{ item.value[0] }}</span>
                      </div>
                    </div>
                  </div>
                </el-collapse-item>
              </el-collapse>
            </div>
          </div>
        </el-tab-pane>

        <el-tab-pane label="剧本库" name="scripts"
          ><div>
            <div class="titleFont">剧本库</div>
            <div style="height: 75vh; overflow-y: auto">
              <el-table :data="scriptLibrary" empty-text="暂无剧本" height="68vh">
                <el-table-column type="expand">
                  <template slot-scope="props" style="padding: 5px">
                    <el-form label-position="left">
                      <el-form-item label="剧本描述:" label-width="80px">
                        <el-input
                          :value="props.row.description"
                          type="textarea"
                          :readonly="true"
                          :rows="2"
                        ></el-input>
                      </el-form-item>
                      <el-form-item label="剧本内容:" label-width="80px">
                        <el-input
                          :value="props.row.content"
                          type="textarea"
                          :readonly="true"
                          :rows="4"
                        ></el-input>
                      </el-form-item>
                      <el-form-item label="更新时间:" label-width="80px">
                        <el-input
                          v-model="props.row.updateTime"
                          :readonly="true"
                        ></el-input>
                      </el-form-item>
                    </el-form>
                  </template>
                </el-table-column>
                <el-table-column
                  label="剧本名"
                  prop="name"
                  align="center"
                ></el-table-column>
                <el-table-column
                  label="剧本描述"
                  prop="description"
                  show-overflow-tooltip
                  align="center"
                ></el-table-column>
              </el-table>
              <el-pagination
                :total="scriptLibraryTotal"
                :current-page="scriptPageNum"
                :page-size="scriptPageSize"
                @current-change="handleScriptCurrentChange"
                style="bottom: 5px; margin: auto; text-align: center"
                small
                layout="prev, pager, next"
              ></el-pagination>
            </div></div
        ></el-tab-pane>

        <el-tab-pane label="词汇句型手册" name="menu">
          <div style="margin-top: 10px;padding-left:4px">
            <el-input
              placeholder="请输入词汇/句型关键字"
              v-model="searchText"
              @keyup.native="pressToConfirm($event)"
            >
              <el-button
                slot="append"
                icon="el-icon-search"
                size="mini"
                @click.native="searchContent(1)"
              ></el-button>
            </el-input>
            <el-radio-group v-model="searchType" @change="searchTypeChange" style="padding-left:4px;padding-right:4px;text-align:center">
              <el-radio :label="1">词汇</el-radio>
              <el-radio :label="2">句型</el-radio>
              <el-radio :label="3">词句</el-radio>
            </el-radio-group>
            <el-table :data="searchList" height="62vh" stripe>
              <el-table-column type="expand" width="25px">
                <template slot-scope="props">
                  <el-form label-position="left" label-width="45px">
                    <el-form-item label="描述:">
                      <el-input
                        :value="props.row.description"
                        type="textarea"
                        :readonly="true"
                        :rows="4"
                      ></el-input>
                    </el-form-item>
                    <el-form-item label="示例:">
                      <el-input
                        :value="props.row.example"
                        type="textarea"
                        :readonly="true"
                        :rows="2"
                      ></el-input>
                    </el-form-item>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column label="名称" prop="name" align="center"></el-table-column>
              <el-table-column
                label="场景区"
                prop="sceneName"
                align="center"
              ></el-table-column>
            </el-table>
            <el-pagination
              small
              hide-on-single-page
              :current-page.sync="searchPageNum"
              :page-size="searchPageSize"
              :total="searchTotal"
              layout="prev, pager, next"
              @current-change="searchContent(searchPageNum)"
              style="text-align:center;width:100%"
            ></el-pagination>
          </div>
        </el-tab-pane>
        <el-tab-pane label="预览" v-if="isScriptedSelect"
          ><h2>{{ selectedText }}</h2>
          <p class="titleFont">场景区信息</p>

          <p>存在{{ selectedText }}所有场景区</p>
          <ul>
            <li v-for="item in possibleSceneList" :key="item">
              <el-link :underline="false">{{item.name}}</el-link>
            </li>
          </ul>
        </el-tab-pane>
      </el-tabs>
    </div>

    <!-- </el-card> -->
  </div>
</template>

<script>
import { trimSpaceLR, getYMD } from "../../store/common";

export default {
  data() {
    return {
      //搜索
      searchText: "",
      searchList: [],
      searchTotal: 0,
      searchWordsList: [],
      searchSentencesList: [],
      searchPageNum: 1,
      searchPageSize: 10,
      searchType: 1,

      tabPosition: "right",
      isPanelHidden: false,
      activeTab: "context",

      //剧本库分页控制
      // currentPage: 1,
      // pageSize: 6,

      //cardBody
      cardBodyStyle: {
        height: "inherit",
        "padding-left": "5px",
        "padding-right": "5px",
        "padding-top": "10px",
      },

      //当前激活的面板
      activePanel: [],

      contextList: {
        //机构语境
        organizationContext: [
          { name: "机构名称", value: ["B8实验室", "飞元工厂"] },
          { name: "机构人数", value: ["30"] },
        ],

        //帮区语境
        bandContext: [{ name: "场景区名", value: ["物流场景"] }],

        //剧本语境
        scriptContext: [],
      },

      scriptLibrary: [],
      scriptLibraryTotal: 0,
      scriptPageNum: 1,
      scriptPageSize: 10,

      //
      possibleSceneList:[],
      selectedSceneInfo:{},
    };
  },
  methods: {
    //搜索内容
    searchContent(pageNum) {
      console.log(pageNum);
      switch (this.searchType) {
        case 1: {
          //词汇
          let url = `${this.global.serverUrl}/word/getWordsByKeywordInPage`;
          this.search(url, pageNum);
          break;
        }
        case 2: {
          //句型
          let url = `${this.global.serverUrl}/sentence/getSentencesByKeywordInPage`;
          this.search(url, pageNum);
          break;
        }
        case 3: {
          //两者
          let url = `${this.global.serverUrl}/script/getWordsAndSentencesByKeyword`;
          this.search(url, pageNum);
          break;
        }
      }
    },

    search(url, pageNum) {
      if (trimSpaceLR(this.searchText) != "") {
        this.$axios({
          methods: "get",
          url: url,
          params: {
            keyword: trimSpaceLR(this.searchText),
            pageNum: pageNum,
            pageSize: this.searchPageSize,
          },
        }).then((res) => {
          this.searchList = res.data.data.result;
          this.searchTotal = res.data.data.total;
          let typeName="";
          if(this.searchTotal==0){
            switch(this.searchType){
              case 1:{
                typeName="词汇";
                break;
              }
              case 2:{
                typeName="句型";
                break;
              }
              case 3:{
                typeName="词汇和句型";
                break;
              }
            }
            this.$message.info({message:"没有相关词汇"+typeName});
            console.log("没有相关词汇"+typeName);
          }
          console.log(res.data.data);
          if (res.data.data.type == 1) {
            this.searchList.forEach((item) => {
              item.isWord = true;
            });
          } else if (res.data.data.type == 2) {
            this.searchList.forEach((item) => {
              item.isWord = false;
            });
          }
        });
      }
    },

    pressToConfirm(e) {
      if (e.keyCode == 13) {
        this.searchContent(1);
      }else if(trimSpaceLR(this.searchText)==""){
        this.searchList=[];
        this.searchTotal=0;
      }
    },

    searchTypeChange() {
      this.searchContent(1);
    },

    //
    tooglePanel() {
      if (this.isPanelHidden) {
        return false;
      } else {
        return true;
      }
    },

    tabClick(e) {
      if (e.paneName == "0") {
        this.isPanelHidden = !this.isPanelHidden;
        if (!this.isPanelHidden) {
          this.activeTab = "context";
        }
        this.$store.commit("SET_CONTEXT_PANEL_VISIBLE", this.isPanelHidden);
      }
    },

    clickPanel() {
      this.isPanelHidden = !this.isPanelHidden;
      this.$store.commit("SET_CONTEXT_PANEL_VISIBLE", this.isPanelHidden);
    },

    //
    getScripts(pageNum, pageSize) {
      this.$axios({
        methods: "get",
        url: `${this.global.serverUrl}/script/getScriptsInPage`,
        params: {
          pageNum: pageNum,
          pageSize: pageSize,
        },
      }).then((res) => {
        this.scriptLibrary = res.data.data.scripts;
        this.scriptLibrary.forEach((item) => {
          item.updateTime = getYMD(item.updateTime);
        });
        this.scriptLibraryTotal = res.data.data.scriptsTotal;
      });
    },

    handleScriptCurrentChange(val) {
      this.getScripts(val, this.scriptPageSize);
    },

    /**
     * 
     */
    getSceneInfo(sceneId){
      this.$axios({
        methods:'get',
        url:`${this.global.serverUrl}/scene/${sceneId}`
      }).then((res)=>{
        this.selectedSceneInfo=res.data.data;
      })
    },

    getScenesByKeyword(keyword){
      this.$axios({
        methods:'get',
        url:`${this.global.serverUrl}/scene/getScenesByKeyword`,
        params:{
          keyword:keyword
        }
      }).then((res)=>{
        this.possibleSceneList=res.data.data;
      })
    },

  },
  created() {
    this.$store.commit("SET_CONTEXT_PANEL_VISIBLE", false);
    if (this.contextList.organizationContext.length > 0) {
      this.activePanel.push("organization");
    }
    if (this.contextList.bandContext.length > 0) {
      this.activePanel.push("band");
    }
    if (this.contextList.scriptContext.length > 0) {
      this.activePanel.push("script");
    }
  },
  mounted() {
    this.getScripts(this.scriptPageNum, this.scriptPageSize);
  },
  computed: {
    isScriptedSelect: function () {
      return this.$store.getters.getScriptSelected.isSelected;
    },
    selectedText: function () {
      return this.$store.getters.getScriptSelected.text;
    },
    currentSceneId:function(){
      return this.$store.getters.getCurrentSceneId;
    },
  },
  watch: {
    isScriptedSelect(newVal,oldVal){
      if(oldVal==false&&newVal==true){
        if(trimSpaceLR(this.selectedText)!=""){
          this.getScenesByKeyword(trimSpaceLR(this.selectedText));
        }else{
          this.possibleSceneList=[];
        }
        if(this.$store.getters.getScriptSelected.isSceneSelected){
          this.getSceneInfo(this.$store.getters.getScriptSelected.sceneId);
        }else{
          this.selectedSceneInfo={};
        }
      }
    },
    currentSceneId(){
      
    }                                    
  },
};
</script>

<style lang="scss" scoped>
.text {
  font-size: 14px;
}

.box-card {
  margin-bottom: 1vh;
}
.context {
  // background-color: #f5fdfd;
  overflow-y: hidden;
  height: inherit;
}

.contextStyle {
  border-radius: 4px;
}

.titleFont {
  font-size: 16px;
  font-weight: 600;
}

.valueFont {
  font-family: "EnviromentValueFont";
  font-size: 16px;
  font-weight: normal;
}

.formItemStyle {
  margin: 5px;
  padding: 5px;
}
</style>

<style lang="scss">
.tabBox {
  border-style: outset;
  margin-top: 10px;
  .el-tabs--right {
    height: 75vh !important;
    .el-tabs__item {
      width: 45px;
      line-height: 24px;
      height: auto;
      word-wrap: break-word;
      white-space: pre-line;
      margin-bottom: 20px;
    }
  }
}

#tab-visibility {
  padding-bottom: 0 !important;
}

.el-table__expanded-cell[class*="cell"] {
  padding-left: 10px !important;
  padding-right: 10px !important;
  padding-bottom: 10px !important;
}

// .el-tabs--right.el-tabs--card .el-tabs__item.is-right.is-active:first-child{
//   margin-bottom: 0px;
// }
</style>
