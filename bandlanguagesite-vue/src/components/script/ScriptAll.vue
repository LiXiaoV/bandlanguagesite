<template>
  <div>
    <div class="">
      <el-table
          :data="tableData.slice(startPage, endPage)"
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
              <el-form-item label="剧本编辑者">
                <span>{{ props.row.editorId }}</span>
              </el-form-item>
              <el-form-item label="更新时间">
                <span>{{ props.row.updateTime }}</span>
              </el-form-item>
              <el-form-item label="状态">
                <span>{{ props.row.statusString }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
            label="剧本 ID"
            prop="scriptId">
        </el-table-column>
        <el-table-column
            label="剧本名称"
            prop="name">
        </el-table-column>
        <el-table-column
            label="状态"
            prop="statusString">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">运行</el-button>
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="a-pagination">
        <el-pagination
            :current-page.sync="currentPage"
            :page-size="pageSize"
            layout="prev, pager, next,total"
            :total="tableData.length"
        >
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScriptAll",
  data() {
    return {
      tableData: [{
        id: '1',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '2',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '3',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '4',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '5',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '6',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '7',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '8',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '9',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '10',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '11',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '12',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },{
        id: '13',
        name: "如果",
        content: "如果 陈聪颖的年龄大于20",
        desc: '表示‘假如’的意思，一般用于 如果句型',
        environment: '剧本环境',
        editor: 'xiaov',
        updateTime: '2021-1-5',
        status: '待审核',
        bandId: "123",
      },],
      //分页：页面控制
      currentPage: 1,
      pageSize: 8,
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
      let scripts = res.data.data
      scripts.forEach( (element) => {

        // 句型状态
        if(element.status === 1){
          element["statusString"] = "待开发"
        }else if(element.status === 2){
          element["statusString"] = "开发中"
        }else if(element.status === 3){
          element["statusString"] = "待审核"
        }else if(element.status === 4){
          element["statusString"] = "待发布"
        }else if(element.status === 5){
          element["statusString"] = "已发布"
        }
      })
      _this.tableData = scripts
    }).catch( error => {
      console.log(error)
    })
    this.initScriptTableData();
  },
  methods: {
    initScriptTableData(){

    },
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
  width: 50%;
}
.a-pagination{
  align-items: center;
}
</style>