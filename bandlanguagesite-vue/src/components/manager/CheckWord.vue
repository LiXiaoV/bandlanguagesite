<template>
<div class="">
    <el-table
    :data="tableData.slice(startPage, endPage)"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="词汇id">
            <span>{{ props.row.id }}</span>
          </el-form-item>
          <el-form-item label="词本身">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="词汇描述">
            <span>{{ props.row.desc }}</span>
          </el-form-item>
          <el-form-item label="词汇举例">
            <span>{{ props.row.example }}</span>
          </el-form-item>
          <el-form-item label="词汇类别">
            <span>{{ props.row.type }}</span>
          </el-form-item>
          <el-form-item label="同义词">
            <span>{{ props.row.synonym }}</span>
          </el-form-item>
          <el-form-item label="状态">
            <span>{{ props.row.status }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="词汇 ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="词本身"
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
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '2',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '3',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '4',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '5',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '6',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '7',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '8',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '9',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '10',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '11',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '12',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '13',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '14',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '15',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '16',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '17',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '18',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
          status: '待审核'
        },{
          id: '19',
          name: "如果",
          desc: '表示‘假如’的意思，一般用于 如果句型',
          example: '如果 陈聪颖的年龄大于20',
          type: '介词',
          synonym: '假如,如',
          status: '待审核'
        },{
          id: '20',
          name: '则',
          desc: '介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作',
          example: '如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错',
          type: '介词',
          synonym: '即',
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