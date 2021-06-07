<template>
  <div>
    <el-table
      :data="words.slice(startPage, endPage)"
      :row-class-name="tableRowClassName"
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
      <el-table-column prop="isTypeInString" label="状态" min-width="30" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="30" align="center">
        <template v-slot:default="scope">
          <el-button size="mini" @click="viewDetail(scope.row.wordId)"> 查看 </el-button>
          <el-button size="mini" @click="editDetail(scope.row.wordId)"> 编辑 </el-button>
          <el-popconfirm
              title="确定删除吗？"
              @confirm="deleteWord(scope.row.wordId)"
          >
            <el-button type="danger" size="mini" slot="reference" style="margin-left: 10px;"> 删除 </el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
          :current-page.sync="currentPage"
          :page-size="pageSize"
          layout="prev, pager, next,total"
          :total="words.length"
          class="a-pagination"
          hide-on-single-page
        >
    </el-pagination>

    <v-user-word-details
        :wordDetailsVisible="wordDetailsVisible"
        :wordId="wordDetailId"
        @closeWordDetailDialog="closeWordDetailDialog"></v-user-word-details>
    <v-word_edit
        :editFormVisible="editFormVisible"
        :wordId="editWordId"
        @closeEditWordDialog="closeEditWordDialog"></v-word_edit>
  </div>
</template>

<script>
import UserWordDetails from "./UserWordDetails";
import WordEdit from "@/components/word/WordEdit";

export default {
  components: {
    "v-user-word-details": UserWordDetails,
    "v-word_edit": WordEdit,
  },
  data() {
    return {
      words: [],
      wordDetailsVisible:false,
      editFormVisible: false,
      wordDeleteDlgVisible: false,
      wordDetailId:0,
      editWordId: 0,
      currentPage: 1,
      pageSize: 10,
    };
  },
  methods: {
    tableRowClassName({ row }) {
      // console.log("rowIndex:"+rowIndex);
      //   if (rowIndex % 2 == 0) {
      //     return "warning-row";
      //   } else {
      //     return "success-row";
      //   }
      if (row.isTypeInString === "未实现") {
        return "warning-row";
      } else {
        return "success-row";
      }
    },
    viewDetail(id) {
      this.wordDetailsVisible = true
      this.wordDetailId = id
    },
    closeWordDetailDialog(flag){
      this.wordDetailsVisible = flag
    },
    editDetail(id){
      this.editFormVisible = true
      this.editWordId = id
    },
    closeEditWordDialog(flag){
      this.editFormVisible = flag
      this.reloadWord()
    },
    deleteWord(id){
      const _this = this
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/word/${id}`,
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除词汇成功",
            type: 'success'
          });
          _this.reloadWord()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除词汇失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除词汇失败",
          type: 'error'
        });
      })
    },
    reloadWord(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/word/myWords/`,
        params: {
          "sceneId": _this.$route.params.id,
          "userId": _this.$store.getters.getUser.userId
        }
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

          // 词汇状态
          if(element.isTypeIn === 0){
            element["isTypeInString"] = "未实现"
          }else if(element.isTypeIn === 1){
            element["isTypeInString"] = "已实现"
          }else {
            element["isTypeInString"] = "其它"
          }
        })
        _this.words = words
      }).catch( error => {
        console.log(error)
      })
    }
  },
  computed: {
    startPage: function () {
      return (this.currentPage - 1) * this.pageSize;
    },
    endPage: function () {
      return this.currentPage * this.pageSize;
    },
  },
  created() {
    this.reloadWord()
  },
};
</script>

<style>
.el-table .warning-row {
  /*background-color: oldlace;*/
}

.el-table .success-row {
  background: #f0f9eb;
}

.a-pagination-wrapper {
  width: 100%;
  height: fit-content;
  position: fixed;
  bottom: 1rem;
}

.a-pagination {
  margin: auto;
  width: fit-content;
}
</style>
