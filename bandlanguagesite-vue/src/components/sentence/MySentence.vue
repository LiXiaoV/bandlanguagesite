<template>
  <div>
    <el-table
        :data="sentences.slice(startPage, endPage)"
        :row-class-name="tableRowClassName"
    >
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="句型名" min-width="30" align="center">
      </el-table-column>
      <el-table-column prop="description" label="描述" min-width="30" header-align="center">
      </el-table-column>
      <el-table-column prop="isTypeInString" label="状态" min-width="20" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="30" align="center">
        <template v-slot:default="scope">
          <el-button size="mini" @click="viewDetail(scope.row.sentenceId)"> 查看 </el-button>
          <el-button size="mini" @click="editDetail(scope.row.sentenceId)"> 编辑 </el-button>
          <el-popconfirm
              title="确定删除吗？"
              @confirm="deleteSentence(scope.row.sentenceId)"
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
        :total="sentences.length"
        class="a-pagination"
        hide-on-single-page
    >
    </el-pagination>
    <v-user-sentence-detail
        :sentenceDetailsVisible="sentenceDetailsVisible"
        :sentenceId="sentenceDetailId"
        @closeSentenceDetailDialog="closeSentenceDetailDialog"></v-user-sentence-detail>
    <v-sentence-edit
        :editFormVisible="editFormVisible"
        :sentenceId="editSentenceId"
        @closeEditSentenceDialog="closeEditSentenceDialog"></v-sentence-edit>
  </div>
</template>

<script>
import UserSentenceDetail from "@/components/sentence/UserSentenceDetail";
import SentenceEdit from "@/components/sentence/SentenceEdit";
export default {
  name: "MySentence",
  data(){
    return {
      sentences: [],
      sentenceDetailsVisible:false,
      // 是否展开编辑页面标识
      editFormVisible: false,

      sentenceDeleteDlgVisible: false,
      sentenceDetailId:0,
      editSentenceId: 0,
      currentPage: 1,
      pageSize: 10,
    }
  },
  methods:{
    tableRowClassName({ row }) {
      if (row.isTypeInString === "未实现") {
        return "warning-row";
      } else {
        return "success-row";
      }
    },
    viewDetail(id) {
      this.sentenceDetailsVisible = true
      this.sentenceDetailId = id
    },
    closeSentenceDetailDialog(flag){
      this.sentenceDetailsVisible = flag
    },
    editDetail(id){
      this.editFormVisible = true
      this.editSentenceId = id
    },
    closeEditSentenceDialog(flag){
      this.editFormVisible = flag
      this.reloadSentence()
    },
    deleteSentence(id){
      const _this = this
      let deleteSentence = {}
      deleteSentence["sentenceId"] = Number(id)
      deleteSentence["userId"] = _this.$store.getters.getUser.userId
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/sentence/`,
        data: deleteSentence,
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除句型成功",
            type: 'success'
          });
          _this.reloadSentence()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除句型失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除句型失败",
          type: 'error'
        });
      })
    },
    reloadSentence(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/sentence/mySentences/`,
        params: {
          "sceneId": _this.$route.params.id,
          "userId": _this.$store.getters.getUser.userId
        }
      }).then(res => {
        let sentences = res.data.data
        sentences.forEach( (element) => {
          // 句型状态
          if(element.isTypeIn === 0){
            element["isTypeInString"] = "未实现"
          }else if(element.isTypeIn === 1){
            element["isTypeInString"] = "已实现"
          }else {
            element["isTypeInString"] = "其它"
          }
        })
        _this.sentences = sentences
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
    this.reloadSentence()
  },
  components:{
    "v-user-sentence-detail": UserSentenceDetail,
    "v-sentence-edit": SentenceEdit,
  }
}
</script>

<style scoped>

</style>