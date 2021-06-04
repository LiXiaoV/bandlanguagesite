<template>
  <div>
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
    <div slot="footer" style="text-align: center;">
      <el-button @click="cancelEdit">取消</el-button>
      <el-button type="primary" @click="confirmEdit">确认修改</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "NodeEdit",
  props:{
    sceneId: Number,
    nodeObjId: Number,
  },
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
      this.updateNodeObj()
    },
    confirmEdit() {
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
      let EditNodeObj = {}
      EditNodeObj["nodeId"] = _this.nodeObj.nodeId
      EditNodeObj["name"] = _this.nodeObj.name
      EditNodeObj["package"] = _this.nodeObj.package
      EditNodeObj["content"] = _this.nodeObj.content
      EditNodeObj["userId"] = _this.$store.getters.getUser.userId
      EditNodeObj["sceneId"] = _this.sceneId
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/node/update`,
        data: EditNodeObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改节点成功",
            type: 'success'
          });
          _this.$emit("updateNodeOptionsEvent")
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
    updateNodeObj(){
      const _this = this
      let nodeId = _this.nodeObjId
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/node/${nodeId}/`,
      }).then(res => {
        _this.nodeObj = res.data.data
      }).catch( error => {
        console.log(error)
      })
    }
  },
  created() {
    this.updateNodeObj()
  },
  watch:{
    nodeObjId(newValue,oldValue){
      // console.log("nodeObjId",newValue,oldValue)
      if(newValue !== oldValue){
        this.updateNodeObj()
      }
    }
  }
}
</script>

<style scoped>

</style>