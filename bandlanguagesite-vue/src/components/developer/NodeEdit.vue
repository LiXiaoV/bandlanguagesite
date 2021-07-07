<template>
  <el-card>
    <el-row type="flex">
      <el-col :span="12" :offset="11">
        <span style="font-size: 14px;">修改节点</span>
      </el-col>
      <el-col :span="1">
        <i class="custom-close-icon el-icon el-icon-close" @click="closeEditNodeCard"></i>
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
      <el-popconfirm
          title="确定删除此节点吗？"
          @confirm="deleteNode(nodeObj.nodeId)"
          placement="top-start"
      >
        <el-button type="danger" slot="reference" style="margin-right: 10px;">删除</el-button>
      </el-popconfirm>
      <el-button @click="cancelEdit">重置修改</el-button>
      <el-button type="primary" @click="confirmEdit">确认修改</el-button>
    </div>
  </el-card>
</template>

<script>

export default {
  name: "NodeEdit",
  props:{
    sceneId: Number,
    nodeObjId: Number,
    itemId: Number,
    itemType: Number,
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
      let editNodeObj = {}
      editNodeObj["nodeId"] = _this.nodeObj.nodeId
      editNodeObj["name"] = _this.nodeObj.name
      editNodeObj["package"] = _this.nodeObj.package
      editNodeObj["content"] = _this.nodeObj.content
      editNodeObj["userId"] = _this.$store.getters.getUser.userID
      editNodeObj["sceneId"] = _this.sceneId

      if(_this.itemId > 0 && _this.itemType > 0){
        editNodeObj["type"] = _this.itemType
        editNodeObj["itemId"] = _this.itemId
      }
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/node/`,
        data: editNodeObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改节点成功",
            type: 'success'
          });
          _this.$emit("updateNodeOptionsEvent")
          _this.$emit("updateAssociatedNodesEvent")
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
    },
    closeEditNodeCard(){
      // console.log("关闭编辑节点卡片")
      this.nodeObj.name = ''
      this.nodeObj.package = ''
      this.nodeObj.content = ''
      this.$emit("closeEditNodeCard")
    },
    deleteNode(id){
      const _this = this
      let deleteNode = {}
      deleteNode["nodeId"] = id
      deleteNode["userId"] = _this.$store.getters.getUser.userID
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/node/`,
        data:deleteNode
      }).then(res => {
        if(res.data.code === 0){
          _this.$emit("updateNodeOptionsEvent")
          _this.$emit("updateAssociatedNodesEvent")
          _this.closeEditNodeCard()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除节点失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除节点失败",
          type: 'error'
        });
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