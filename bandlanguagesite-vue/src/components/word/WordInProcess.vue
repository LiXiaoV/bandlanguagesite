<template>
  <div>
    <el-button @click="registerWord" icon="el-icon-plus">注册新词汇</el-button>
    <v-word-register
        :registerFormVisible="registerWordDlg"
        @closeRegisterWordDialog="closeRegisterWordDialog"></v-word-register>
    <div>
      <el-row type="flex" class="row-bg" justify="center" style="margin: 2vh 0;">
        <el-col :span="20">
          <el-steps>
            <el-step title="待开发" icon="el-icon-edit"></el-step>
            <el-step title="开发中" icon="el-icon-upload"></el-step>
            <el-step title="待审核" icon="el-icon-picture"></el-step>
            <el-step title="待发布" icon="el-icon-picture"></el-step>
          </el-steps>
        </el-col>
      </el-row>

      <el-row type="flex" :gutter="2">
        <el-col :span="6">
          <el-card v-show="isCardShown[0]">
            <el-table
              :data="toDevelopTask.slice(toDevelopTaskStartPage, toDevelopTaskEndPage)"
              :header-cell-style="toDevelopTableStyle"
              empty-text="无待开发词汇"
              ref="toDevelopTable"
              :max-height="screenHeight*0.5"
              :height="screenHeight*0.5"
            >
              <el-table-column
                type="index"
                label="序号"
                header-align="center"
                style="height: 100%"
                min-width="20"
              ></el-table-column>
              <el-table-column
                prop="name"
                label="词汇名"
                min-width="30"
                align="center"
              ></el-table-column>
              <el-table-column label="操作" align="center" min-width="40">
                <template slot-scope="scope">
                  <el-button @click="viewDetails(0, scope.row)">查看</el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="b-pagination-wrapper">
              <el-pagination
                :current-page.sync="toDevelopTablePage"
                :page-size="pageSize"
                layout="prev, pager, next"
                :total="toDevelopTask.length"
                class="b-pagination"
              >
              </el-pagination>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6"
          ><el-card v-show="isCardShown[1] === true">
          <el-table
              :data="
                developingTask.slice(DevelopingTableStartPage, DevelopingTableEndPage)
              "
              :header-cell-style="DevelopingTableStyle"
              empty-text="无开发中词汇"
              ref="developingTable"
              :max-height="screenHeight*0.5"
              :height="screenHeight*0.5"
            >
              <el-table-column
                type="index"
                label="序号"
                header-align="center"
                fixed="left"
              ></el-table-column>
              <el-table-column
                prop="name"
                label="词汇名"
                min-width="30"
                align="center"
              ></el-table-column>
              <el-table-column label="操作" min-width="40" align="center">
                <template slot-scope="scope">
                  <el-button @click="viewDetails(1, scope.row)">查看</el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="b-pagination-wrapper">
              <el-pagination
                :current-page.sync="DevelopingTablePage"
                :page-size="pageSize"
                layout="prev, pager, next"
                :total="developingTask.length"
                class="b-pagination"
              >
              </el-pagination>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6"
          ><el-card v-show="isCardShown[2] === true"
            ><el-table
              :data="toAuditTask.slice(toAuditTableStartPage, toAuditTableEndPage)"
              empty-text="无待审核词汇"
              :header-cell-style="toAuditTableStyle"
              ref="toAuditTable"
              :max-height="screenHeight*0.5"
              :height="screenHeight*0.5"
            >
              <el-table-column
                type="index"
                label="序号"
                header-align="center"
                fixed="left"
              ></el-table-column>
              <el-table-column
                prop="name"
                label="词汇名"
                min-width="30"
                align="center"
              ></el-table-column>
              <el-table-column label="操作" min-width="40" align="center">
                <template slot-scope="scope">
                  <el-button @click="viewDetails(2, scope.row)">查看</el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="b-pagination-wrapper">
              <el-pagination
                :current-page.sync="toAuditTablePage"
                :page-size="pageSize"
                layout="prev, pager, next"
                :total="toAuditTask.length"
                class="b-pagination"
              >
              </el-pagination>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card v-show="isCardShown[3] === true">
            <el-table
              :data="toReleaseTask.slice(toReleaseTableStartPage, toReleaseTableEndPage)"
              empty-text="无待发布词汇"
              :header-cell-style="toReleaseTableStyle"
              ref="toReleaseTable"
              :max-height="screenHeight*0.5"
              :height="screenHeight*0.5"
            >
              <el-table-column
                type="index"
                label="序号"
                header-align="center"
                fixed="left"
              ></el-table-column>
              <el-table-column
                prop="name"
                label="词汇名"
                min-width="30"
                align="center"
              ></el-table-column>
              <el-table-column label="操作" min-width="40" align="center">
                <template slot-scope="scope">
                  <el-button @click="viewDetails(3, scope.row)">查看</el-button>
                </template>
              </el-table-column>
            </el-table>
            <div class="b-pagination-wrapper">
              <el-pagination
                :current-page.sync="toReleaseTablePage"
                :page-size="pageSize"
                layout="prev, pager, next"
                :total="toReleaseTask.length"
                class="b-pagination"
              ></el-pagination>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import WordRegister from "./WordRegister";
export default {
  components: {
    "v-word-register": WordRegister,
  },
  data() {
    return {
      //注册新词汇的对话框
      registerWordDlg: false,

      //不同过程中的列表
      toDevelopTask: [
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
      ],
      developingTask: [],
      toAuditTask: [],
      toReleaseTask: [],

      isCardShown: [true, true, true, true],

      //表头颜色
      toDevelopTableStyle: {
        "background-color": "#909399",
        "color": "aliceblue",
        "font-weight": "bold",
      },

      DevelopingTableStyle: {
        "background-color": "#67C23A",
        "color": "aliceblue",
        "font-weight": "bold",
      },
      toAuditTableStyle: {
        "background-color": "#409EFF",
        "color": "aliceblue",
        "font-weight": "bold",
      },

      toReleaseTableStyle: {
        "background-color": "#E6A23C",
        "color": "aliceblue",
        "font-weight": "bold",
      },

      //页面控制
      toDevelopTablePage: 1,
      DevelopingTablePage: 1,
      toAuditTablePage: 1,
      toReleaseTablePage: 1,
      pageSize: 8,

      screenHeight:document.documentElement.clientHeight, // 屏幕高度
      wordTableHeight:this.screenHeight*0.3,
    };
  },
  methods: {
    registerWord() {
      this.registerWordDlg = true
    },
    closeRegisterWordDialog(flag){
      this.registerWordDlg = flag
    },
    toggleCard(itemIndex) {
      this.isCardShown[itemIndex] = !this.isCardShown[itemIndex];
      this.$forceUpdate();
    },
    DevelopingTableTablePage(){
      console.log("DevelopingTableTablePage执行")
    },
    viewDetails(state, row) {
      console.log(row);
    },
  },
  mounted() {
    const _this = this;
    window.onresize = function () { // 定义窗口大小变更通知事件
      _this.screenHeight = document.documentElement.clientHeight // 窗口高度
    }
  },
  computed: {
    toDevelopTaskStartPage: function () {
      return (this.toDevelopTablePage - 1) * this.pageSize;
    },
    toDevelopTaskEndPage: function () {
      return this.toDevelopTablePage * this.pageSize;
    },
    DevelopingTableStartPage: function () {
      return (this.DevelopingTablePage - 1) * this.pageSize;
    },
    DevelopingTableEndPage: function () {
      return this.DevelopingTablePage * this.pageSize;
    },
    toAuditTableStartPage: function () {
      return (this.toAuditTablePage - 1) * this.pageSize;
    },
    toAuditTableEndPage: function () {
      return this.toAuditTablePage * this.pageSize;
    },
    toReleaseTableStartPage: function () {
      return (this.toReleaseTablePage - 1) * this.pageSize;
    },
    toReleaseTableEndPage: function () {
      return this.toReleaseTablePage * this.pageSize;
    },
  },

};
</script>

<style lang="scss" scoped>

.b-pagination-wrapper {
  width: 100%;
  height: fit-content;
  position: relative;
  padding-top: 0.2rem;
}

.b-pagination {
  margin: auto;
  width: fit-content;
}
</style>
