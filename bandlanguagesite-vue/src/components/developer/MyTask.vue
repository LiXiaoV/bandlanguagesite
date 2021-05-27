<template>
  <div>
    <el-table :data="wordTaskList" height="600" id="wordTable" border>
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
              <el-input
                type="textarea"
                v-model="props.row.description"
                :disabled="props.row.editDesc"
                maxlength="50"
                show-word-limit
                autosize="true"
              >
              </el-input>
              <el-button icon="el-icon-edit" @click="editDesc(props.$index)"></el-button>
            </el-form-item>
            <el-form-item label="例子">
              <el-input
                v-model="props.row.description"
                :disabled="props.row.editExample"
                maxlength="50"
                show-word-limit
                autosize="true"
              >
              <el-button slot="append" icon="el-icon-edit" @click="editExample(props.$index)"></el-button>
              </el-input>
            </el-form-item>
            <el-form-item label="状态">
              <span>{{ props.row.statusString }}</span>
            </el-form-item>
            <el-form-item>
              <div v-if="props.row.status == 1">
                <el-button type="primary" @click="changeDevelopmentStatus('word',props.$index,2,'开发中')"
                  >开始处理</el-button
                >
              </div>
              <div v-else-if="props.row.status == 2">
                <el-button type="primary" @click="changeDevelopmentStatus('word',props.$index,3,'开发完成')">开发完成</el-button>
                <el-button type="primary" @click="changeDevelopmentStatus('word',props.$index,4,'拒绝开发')">拒绝开发</el-button>
              </div>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="词汇名" min-width="20" align="center">
      </el-table-column>
      <el-table-column prop="type" label="类型" align="center" min-width="30">
      </el-table-column>
      <el-table-column prop="description" label="描述" align="center"> </el-table-column>
      <el-table-column prop="description" label="例子" align="center"> </el-table-column>
      <el-table-column prop="statusString" label="状态" align="center" min-width="30">
      </el-table-column>
    </el-table>

    <!-- '我的'句型开发任务 -->
    <el-table :data="sentenceTaskList" id="sentenceTable"></el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      wordTaskList: [
          {
          editDesc: true,
          editExample:true,
          name: "如果",
          type: "关系介词",
          description: "表示‘假如’的意思，一般用于 如果句型",
          updateTime: "2020-03-09 16:13:58",
          conclusion:"",
          status: 1,
          statusString:"待开发"
        },
      ],
      sentenceTaskList: [],
    };
  },
  methods:{
    //编辑
    editDesc(index) {
      this.wordTaskList[index].editDesc = !this.wordTaskList[index].editDesc;
      console.log(this.wordTaskList[index].editDesc);
    },

    editExample(index){
        this.wordTaskList[index].editExample = !this.wordTaskList[index].editExample;
    },

    //开发状态变迁
    changeDevelopmentStatus(type,index,newStatus,newStatusString){
        switch(type){
            case 'word':{
                this.wordTaskList[index].status=newStatus;
                this.wordTaskList[index].statusString=newStatusString;
                break;
            }
            case 'sentence':{
                this.sentenceTaskList[index].status=newStatus;
                this.sentenceTaskList[index].statusString=newStatusString;
                break;
            }
        }
    }
  }
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
</style>
