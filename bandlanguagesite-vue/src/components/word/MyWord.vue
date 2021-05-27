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
        prop="type"
        label="类型"
        min-width="30"
        align="center"
      >
      </el-table-column>
      <el-table-column prop="description" label="描述" header-align="center">
      </el-table-column>
      <el-table-column prop="example" label="例子" header-align="center">
      </el-table-column>
      <el-table-column prop="statusString" label="状态" min-width="30" align="center">
      </el-table-column>
      <el-table-column label="操作" min-width="30" align="center">
        <template v-slot:default="scope">
          <el-button @click="viewDetail(scope.row.id)"> 查看 </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="a-pagination-wrapper">
      <span
        ><el-pagination
          :current-page.sync="currentPage"
          :page-size="pageSize"
          layout="prev, pager, next,total"
          :total="words.length"
          class="a-pagination"
          hide-on-single-page
        >
        </el-pagination>
      </span>
    </div>
    <v-user-word-details
        :wordDetailsVisible="wordDetailsVisible"
        :wordId="wordDetailId"
        @closeWordDetailDialog="closeWordDetailDialog"></v-user-word-details>
  </div>
</template>

<script>
import UserWordDetails from "./UserWordDetails";
export default {
  components: {
    "v-user-word-details": UserWordDetails,
  },
  data() {
    return {
      words: [
        {
          id: 22,
          name: "如果",
          description: "表示‘假如’的意思，一般用于 如果句型",
          example: "如果 陈聪颖的年龄大于20",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 1,
        },
        {
          id: 23,
          name: "则",
          description: "介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作",
          example: "如果 陈聪颖的年龄大于20 ，则 输出 对 ，否则 输出 错",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          type: "介词",
          status: 0,
        },
      ],
      wordDetailsVisible:false,
      wordDetailId:0,
      currentPage: 1,
      pageSize: 20,
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
      if (row.status === 0) {
        return "warning-row";
      } else {
        return "success-row";
      }
    },
    viewDetail(id) {
      // console.log(id);
      this.wordDetailsVisible = true
      this.wordDetailId = id
    },
    closeWordDetailDialog(flag){
      this.wordDetailsVisible = flag
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
  created() {},
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
