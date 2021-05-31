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
      <el-button @click="cancelEdit">撤销修改</el-button>
      <el-button type="primary" @click="confirmEdit">确认修改</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "NodeEdit",
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
    cancelEdit() {
      this.nodeObj.name = ""
      this.nodeObj.package = ""
      this.nodeObj.content = ""
      this.$emit('closeEditNodeDialog',false)
    },
    confirmEdit() {
      const _this = this
      let EditNodeObj = {}
      EditNodeObj["name"] = _this.nodeObj.name
      EditNodeObj["package"] = _this.nodeObj.package
      EditNodeObj["content"] = _this.nodeObj.content
      EditNodeObj["userId"] = _this.$store.getters.getUser.userId
      EditNodeObj["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/developer/updateNode`,
        data: EditNodeObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改节点成功",
            type: 'success'
          });
          this.cancelEdit()
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
          message: "修改节点失败",
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