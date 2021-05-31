<template>
  <div>
    <el-form :model="nodeObj" label-position="top">
      <el-form-item label="节点类名 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="nodeObj.rule" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="节点类包名 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="nodeObj.chineseName" maxlength="250" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="节点类代码 *" :label-width="formLabelWidth">
        <el-input
            v-model="nodeObj.express"
            type="textarea"
            :autosize="{ minRows: 10 }"
            maxlength="100000"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" style="text-align: center;">
      <el-button @click="cancelRegisterNode">取消</el-button>
      <el-button type="primary" @click="confirmRegister">新增</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "NodeAdd",
  data(){
    return {
      nodeObj: {
        name: "",
        package: "",
        content: "",
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancelRegisterNode() {
      this.nodeObj.name = ""
      this.nodeObj.package = ""
      this.nodeObj.content = ""
      this.$emit('closeRegisterNodeDialog',false)
    },
    confirmRegister() {
      const _this = this
      let registerNodeObj = {}
      registerNodeObj["name"] = _this.nodeObj.name
      registerNodeObj["package"] = _this.nodeObj.package
      registerNodeObj["content"] = _this.nodeObj.content
      registerNodeObj["userId"] = _this.$store.getters.getUser.userId
      registerNodeObj["sceneId"] = _this.$route.params.id
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

<style scoped>

</style>