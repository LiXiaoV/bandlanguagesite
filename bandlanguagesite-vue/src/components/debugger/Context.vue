<template>
  <div class="context">
    <!-- <el-card style="border-radius: 8px; height: 82vh" :body-style="cardBodyStyle"> -->
    <div class="tabBox">
      <el-tabs
        :tab-position="tabPosition"
        style="height: 200px; background-color: white"
        type="card"
        v-model="activeTab"
        @tab-click="tooglePanel"
      >
        <el-tab-pane name="visibility">
          <template slot="label">
            <i
              :class="isPanelHidden ? 'el-icon-d-arrow-left' : 'el-icon-d-arrow-right'"
              style="text-align: middle"
              @click="clickPanel"
            ></i>
          </template>
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
                  <template slot="title"> 场景区语境 </template>
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
                  <template slot="title"> 剧本当前语境 </template>
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
            <div style="height: 30vh; overflow-y: auto">
              <ul>
                <li v-for="(item, index) in scriptLibrary" :key="index">{{ item }}</li>
              </ul>
            </div>
          </div></el-tab-pane
        >

        <el-tab-pane label="词汇句型手册" name="menu">
          <div style="margin-top: 10px">
            <el-input placeholder="请输入词汇/句型关键字" v-model="searchText">
              <el-button slot="append" icon="el-icon-search" size="mini"></el-button>
            </el-input>
            <el-table>
              <el-table-column label="名称"></el-table-column>
              <el-table-column></el-table-column>
            </el-table>
          </div>
        </el-tab-pane>
        <el-tab-pane label="选中信息" v-if="isScriptedSelect"
          >{{ selectedText }}
          <p class="titleFont">场景区信息</p>
        </el-tab-pane>
      </el-tabs>
    </div>

    <!-- <el-divider style="border-top: 2px dashed #e8eaec;font-size:13px;font-weight:normal"></el-divider> -->
    <!-- </el-card> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      //搜索
      searchText: "",
      searchList:[],

      tabPosition: "right",
      isPanelHidden: false,
      activeTab:"context",

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

      scriptLibrary: ["剧本1"],

      status: 1,
    };
  },
  methods: {
    //搜索内容
    searchContent() {
      console.log("enter +1");
    },

    //
    tooglePanel(activeName) {
      if(activeName=="visibility"){
        this.isPanelHidden = !this.isPanelHidden;
        this.$store.commit("SET_CONTEXT_PANEL_VISIBLE", this.isPanelHidden);
        if(!this.isPanelHidden){
          this.activeTab="context";
        }
      }
    },

    clickPanel(){
      this.isPanelHidden = !this.isPanelHidden;
      this.$store.commit("SET_CONTEXT_PANEL_VISIBLE", this.isPanelHidden);
    },

  },
  created() {
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
  computed: {
    isScriptedSelect: function () {
      return this.$store.getters.getScriptSelected.isSelected;
    },
    selectedText: function () {
      return this.$store.getters.getScriptSelected.text;
    },
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
</style>

<style lang="scss">
.tabBox {
  border-style: outset;
  margin-top: 20px;
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
</style>
