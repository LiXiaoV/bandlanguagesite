<template>
  <el-table :data="newWordsList" border style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="a-table-expand">
          <el-form-item label="词汇名">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="类型">
            <span>{{ props.row.type }}</span>
          </el-form-item>
          <el-form-item label="描述">
            <span>{{props.row.description}}</span>
          </el-form-item>
          <el-form-item label="状态">
            <span>{{ props.row.statusString }}</span>
          </el-form-item>
          <el-form-item>
            <div v-if="props.row.status === 0">
              <el-button type="primary" @click="acceptTask(props.$index)"
                >领取任务</el-button
              >
            </div>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column type="index" label="序号" width="60" align="center"> </el-table-column>
    <el-table-column prop="name" label="词汇名" min-width="30" align="center"> </el-table-column>
    <el-table-column prop="type" label="类型" align="center" min-width="45"> </el-table-column>
    <el-table-column prop="description" label="描述" align="center"> </el-table-column>
    <el-table-column prop="statusString" label="状态" align="center" min-width="40"> </el-table-column>
  </el-table>
</template>

<script>
export default {
  data() {
    return {
      newWordsList: [
        {
          editDesc: true,
          name: "如果",
          type: "关系介词",
          description: "表示‘假如’的意思，一般用于 如果句型",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          conclusion:"",
          status: 0,
          statusString:""
        },
        {
          editDesc: true,
          name: "则",
          type: "关系介词",
          description: "介词，无实际意思，常用于表示当前面的条件成立将进行后面的操作",
          editor: "ccy",
          updateTime: "2020-03-09 16:13:58",
          conclusion:"",
          status: 1,
          statusString:""
        },
      ],
    };
  },
  methods: {
    deleteWord(index) {
      console.log(index);
    },
    acceptTask(index) {
      this.newWordsList[index].status=1;
      this.newWordsList[index].statusString="待开发";
      console.log(index);
    },

    initiateStatus() {
      this.newWordsList.forEach((element) => {
        switch (element.status) {
          case 0: {
            element.statusString = "待领取";
            break;
          }
          case 1: {
            element.statusString = "待开发";
            break;
          }
          case 2:{element.statusString = "开发中";
            break;
          }
          case 3:{
            element.statusString="待审核";
            break;
          }
          default: {
            element.statusString = "处理完成";
          }
        }
      });
    },
  },
  computed: {},
  mounted() {
    this.initiateStatus();
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
