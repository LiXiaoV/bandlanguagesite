<template>
  <el-card>
    <el-row type="flex">
      <el-col :span="12" :offset="11">
        <span style="font-size: 14px;">添加中间范式</span>
      </el-col>
      <el-col :span="1">
        <i class="custom-close-icon el-icon el-icon-close" @click="cancelAddParadigm"></i>
      </el-col>
    </el-row>

    <el-form :model="paradigmObj" label-position="top">
      <el-form-item label="中间范式表示 *" :label-width="formLabelWidth">
        <el-input
            v-model="paradigmObj.easyParadigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="举例 *" :label-width="formLabelWidth">
        <el-input
            v-model="paradigmObj.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center;margin-top: 1vh;">
      <el-button @click="cancelAddParadigm">取消</el-button>
      <el-button type="primary" @click="confirmAddParadigm">添加</el-button>
    </div>
  </el-card>
</template>

<script>
export default {
  name: "ParadigmAddInRegSentence",
  props:{
    sceneId: Number,
    itemId: Number,
    itemType: Number,
  },
  data(){
    return {
      paradigmObj: {
        easyParadigm: '',
        example: '',
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    clearInput(){
      this.paradigmObj.easyParadigm = ""
      this.paradigmObj.example = ""
    },
    cancelAddParadigm() {
      this.clearInput()
      this.$emit('closeAddParadigmCard')
    },
    confirmAddParadigm() {
      // 检查输入
      if(this.paradigmObj.easyParadigm === '' || this.paradigmObj.easyParadigm === undefined || this.paradigmObj.easyParadigm === null){
        this.$message({
          showClose: true,
          message: "中间范式表示不能为空",
          type: 'error'
        });
        return;
      }
      if(this.paradigmObj.example === '' || this.paradigmObj.example === undefined || this.paradigmObj.example === null){
        this.$message({
          showClose: true,
          message: "中间范式的举例不能为空",
          type: 'error'
        });
        return;
      }
      let addParadigm = {}
      addParadigm["easyParadigm"] = this.paradigmObj.easyParadigm
      addParadigm["example"] = this.paradigmObj.example
      this.$emit('addParadigmObj',addParadigm)
      this.clearInput()
    },
  },
  created() {
  }
}
</script>

<style scoped>

</style>