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
          <span style="float: left;font-size: 1.5rem">所有剧本</span>
        </div>
        <el-table
            :data="scriptTableData.slice(startPage, endPage)"
            style="width: 100%;">
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left" inline class="a-table-expand">
                <el-form-item label="剧本id：">
                  <span>{{ props.row.scriptId }}</span>
                </el-form-item>
                <el-form-item label="剧本名称：">
                  <span>{{ props.row.name }}</span>
                </el-form-item>
                <el-form-item label="剧本内容：">
                  <span>{{ props.row.content }}</span>
                </el-form-item>
                <el-form-item label="剧本描述：">
                  <span>{{ props.row.description }}</span>
                </el-form-item>
                <el-form-item label="剧本所在的场景区id：">
                  <span>{{ props.row.sceneId }}</span>
                </el-form-item>
                <el-form-item label="剧本所在的场景区名称：">
                  <span>{{ props.row.sceneName }}</span>
                </el-form-item>
                <el-form-item label="剧本运行次数：">
                  <span>{{ props.row.runTimes }}</span>
                </el-form-item>
                <el-form-item label="剧本更新时间：">
                  <span>{{ props.row.updateTime }}</span>
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
          <el-table-column prop="sceneName" label="剧本所在的场景区" min-width="30" align="center">
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
      </el-card>

    </div>
  </div>
</template>

<script>
import Header from "@/components/common/Header";
export default {
  name: "AllScripts",
  data() {
    return {
      activePath: "/",
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
      url: `${this.global.serverUrl}/script/all/`,
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
  },
  components:{
    "v-header": Header,
  }
}
</script>

<style lang="scss" scoped>
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
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  width: 100%;
  height: fit-content;
}
.a-pagination{
  align-items: center;
}
</style>