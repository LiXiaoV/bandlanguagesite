<template>
  <div>
    <el-table :data="scripts.slice(startPage, endPage)">
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="剧本名" min-width="30" align="center">
      </el-table-column>
      <el-table-column prop="description" label="剧本描述" min-width="30" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="30" align="center">
        <template v-slot:default="scope">
          <el-button size="mini" @click="viewDetail(scope.row.scriptId)"> 查看 </el-button>
          <el-button size="mini" @click="editDetail(scope.row.scriptId)"> 编辑 </el-button>
          <el-popconfirm
              title="确定删除吗？"
              @confirm="deleteScript(scope.row.scriptId)"
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
        :total="scripts.length"
        class="a-pagination"
        hide-on-single-page
    >
    </el-pagination>
    <v-user-script-detail
        :scriptDetailsVisible="scriptDetailsVisible"
        :scriptId="scriptDetailId"
        @closeScriptDetailDialog="closeScriptDetailDialog"></v-user-script-detail>
    <v-script-edit
        :editFormVisible="editFormVisible"
        :scriptId="editScriptId"
        @closeEditScriptDialog="closeEditScriptDialog"></v-script-edit>
  </div>
</template>

<script>
import UserScriptDetail from "@/components/script/UserScriptDetail";
import ScriptEdit from "@/components/script/ScriptEdit";

export default {
  name: "MyScript",
  data(){
    return {
      scripts: [],
      scriptDetailsVisible:false,
      // 是否展开编辑页面标识
      editFormVisible: false,
      
      scriptDetailId:0,
      editScriptId: 0,
      currentPage: 1,
      pageSize: 10,
    }
  },
  methods:{
    viewDetail(id) {
      this.scriptDetailsVisible = true
      this.scriptDetailId = id
    },
    closeScriptDetailDialog(flag){
      this.scriptDetailsVisible = flag
    },
    editDetail(id){
      this.editFormVisible = true
      this.editScriptId = id
    },
    closeEditScriptDialog(flag){
      this.editFormVisible = flag
      this.reloadScript()
    },
    deleteScript(id){
      const _this = this
      let deleteScript = {}
      deleteScript["scriptId"] = Number(id)
      deleteScript["userId"] = _this.$store.getters.getUser.userID
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/script/`,
        data: deleteScript,
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除剧本成功",
            type: 'success'
          });
          _this.reloadScript()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除剧本失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除剧本失败",
          type: 'error'
        });
      })
    },
    reloadScript(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/script/myScripts/`,
        params: {
          "sceneId": _this.$route.params.id,
          "userId": _this.$store.getters.getUser.userID
        }
      }).then(res => {
        _this.scripts = res.data.data
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
    this.reloadScript()
  },
  components:{
    "v-user-script-detail": UserScriptDetail,
    "v-script-edit": ScriptEdit,
  }
}
</script>

<style scoped>

</style>