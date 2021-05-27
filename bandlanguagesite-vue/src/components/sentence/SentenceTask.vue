<template>
  <div>
    <el-backtop target=".el-table__body-wrapper.is-scrolling-none"></el-backtop>
    <el-table
      :data="newSentencesList.slice(startPage, endPage)"
      border
      style="width: 100%"
      :height="tableHeight"
    >
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="a-table-expand">
            <el-form-item label="句型名">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="描述">
              <span>{{ props.row.description }}</span>
            </el-form-item>
            <el-form-item label="状态">
              <span>{{ props.row.statusString }}</span>
            </el-form-item>
            <el-form-item>
              <div v-if="props.row.status == 0">
                <el-button type="primary" @click="acceptTask(props.$index)"
                  >领取任务</el-button
                >
              </div>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="句型名" min-width="30" align="center">
      </el-table-column>
      <el-table-column prop="description" label="描述" align="center"> </el-table-column>
      <el-table-column prop="statusString" label="状态" align="center" min-width="40">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newSentencesList: [
        {
          editDesc: true,
          name: "如果...那么",
          description: "表示‘假如’的意思，一般用于 如果句型",
          updateTime: "2020-03-09 16:13:58",
          conclusion: "",
          status: 0,
          statusString: "待开发",
          sceneNames: "",
        },
      ],

      //页数控制
      pageSize: 20,
      currentPage: 1,
    };
  },
  methods: {
    acceptTask(index) {
      console.log("index",index)
    },
  },
  computed: {
    startPage: function () {
      return (this.currentPage - 1) * this.pageSize;
    },
    endPage: function () {
      return this.currentPage * this.pageSize;
    },
    tableHeight: function () {
      return this.$store.state.MAIN.height - 140;
    },
  },
};
</script>

<style scoped>
.a-table-expand {
  font-size: 0;
}
.a-table-expand label {
  width: 100%;
  color: #99a9bf;
}
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  padding-top: 0.5rem;
  width: 100%;
  height: fit-content;
}

.a-input-desc {
  width: 30rem;
}
</style>
