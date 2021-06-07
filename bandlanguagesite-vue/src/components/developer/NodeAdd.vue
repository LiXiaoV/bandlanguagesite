<template>
  <el-card>
    <el-row type="flex">
      <el-col :span="12" :offset="11">
        <span style="font-size: 14px;">新增节点</span>
      </el-col>
      <el-col :span="1">
        <i class="custom-close-icon el-icon el-icon-close" @click="cancelRegisterNode"></i>
      </el-col>
    </el-row>

    <el-form :model="nodeObj" label-position="top">
      <el-form-item label="节点类名 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="nodeObj.name" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="节点类包名 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="nodeObj.packageName" maxlength="250" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="节点类代码 *" :label-width="formLabelWidth">
        <el-input
            v-model="nodeObj.content"
            type="textarea"
            :autosize="{ minRows: 10 }"
            maxlength="100000"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center;">
      <el-button @click="cancelRegisterNode">取消</el-button>
      <el-button type="primary" @click="confirmRegisterNode">新增</el-button>
    </div>
  </el-card>
</template>

<script>

export default {
  name: "NodeAdd",
  props:{
    sceneId: Number,
  },
  data(){
    return {
      nodeObj: {
        name: "",
        packageName: "",
        content: "",
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancelRegisterNode() {
      this.nodeObj.name = ""
      this.nodeObj.packageName = ""
      this.nodeObj.content = ""
      this.$emit('closeRegisterNodeCard',false)
    },
    confirmRegisterNode() {
      // 检查输入
      if(this.nodeObj.name === '' || this.nodeObj.name === undefined || this.nodeObj.name === null){
        this.$message({
          showClose: true,
          message: "节点名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.nodeObj.packageName === '' || this.nodeObj.packageName === undefined || this.nodeObj.packageName === null){
        this.$message({
          showClose: true,
          message: "节点包名不能为空",
          type: 'error'
        });
        return;
      }
      if(this.nodeObj.content === '' || this.nodeObj.content === undefined || this.nodeObj.content === null){
        this.$message({
          showClose: true,
          message: "节点代码不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerNodeObj = {}
      registerNodeObj["name"] = _this.nodeObj.name
      registerNodeObj["packageName"] = _this.nodeObj.packageName
      registerNodeObj["content"] = _this.nodeObj.content
      registerNodeObj["userId"] = _this.$store.getters.getUser.userId
      registerNodeObj["sceneId"] = _this.sceneId
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/node/insert`,
        data: registerNodeObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "新增节点成功",
            type: 'success'
          });
          _this.$emit("updateNodeOptionsEvent")
          this.cancelRegisterNode()
        }
        else {
          _this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "新增节点失败",
          type: 'error'
        });
      })
    },
  },
  created() {
  }
}
</script>

<style>
.custom-close-icon{
  color: #909399;
  cursor:pointer;
}
.custom-close-icon:hover{
  color: #409eff;
}
</style>