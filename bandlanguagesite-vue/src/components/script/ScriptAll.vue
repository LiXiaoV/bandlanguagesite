<template>
  <div>
    <div class="">
      <el-table
          :data="scriptTableData.slice(startPage, endPage)"
          style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="剧本id">
                <span>{{ props.row.scriptId }}</span>
              </el-form-item>
              <el-form-item label="剧本名称">
                <span>{{ props.row.name }}</span>
              </el-form-item>
              <el-form-item label="剧本内容">
                <span>{{ props.row.content }}</span>
              </el-form-item>
              <el-form-item label="剧本描述">
                <span>{{ props.row.description }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column type="index" label="序号" width="60" align="center">
        </el-table-column>
        <el-table-column label="剧本名称" min-width="30" prop="name" align="center">
        </el-table-column>
        <el-table-column label="剧本描述" min-width="30" prop="description" align="center">
        </el-table-column>
        <el-table-column label="操作" min-width="30" align="center">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">运行</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
          :current-page.sync="currentPage"
          :page-size="pageSize"
          layout="prev, pager, next,total"
          :total="scriptTableData.length"
          class="a-pagination"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScriptAll",
  data() {
    return {
      scriptTableData: [],
      //分页：页面控制
      currentPage: 1,
      pageSize: 10,
    }
  },
  created() {
    const _this = this
    this.$axios({
      method: 'get',
      url: `${this.global.serverUrl}/script/allScripts/`,
      params: {
        "sceneId": _this.$route.params.id
      }
    }).then(res => {
      _this.scriptTableData = res.data.data
    }).catch( error => {
      console.log(error)
    })

  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
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
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 100%;
}
.a-pagination{
  align-items: center;
}
</style>