<template>
<div class="">
    <el-table
    :data="tableData.slice(startPage, endPage)"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="句型id">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="句子本身">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="句子描述">
            <span>{{ props.row.desc }}</span>
          </el-form-item>
          <el-form-item label="巴科斯范式">
            <span>{{ props.row.paradigm }}</span>
          </el-form-item>
          <el-form-item label="场景id">
            <span>{{ props.row.sceneid }}</span>
          </el-form-item>
          <el-form-item label="状态">
            <span>{{ props.row.status }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="句子 ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="句子本身"
      prop="name">
    </el-table-column>
    <el-table-column
      label="状态"
      prop="status">
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">通过</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">不通过</el-button>
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
  
  
</template>

<style>
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

<script>
  export default {
    data() {
      return {
        tableData: [{
          id: '1',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '2',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '3',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '4',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '5',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '6',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '7',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '8',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '9',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '10',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '11',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },{
          id: '12',
          name: "显示 张三",
          desc: '显示张三的信息',
          paradigm: '“显示 张三”的巴科斯范式',
          sceneid: '1',
          status: '待审核'
        },],
        //分页：页面控制
        currentPage: 1,
        pageSize: 8,
      }
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