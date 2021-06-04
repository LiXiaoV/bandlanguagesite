<template>
  <el-dialog title="编辑剧本" :visible="editFormVisible" :show-close="false">
    <el-form :model="existScript" label-position="top">
      <el-form-item label="剧本名称 *" :label-width="formLabelWidth">
        <el-input v-model="existScript.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="剧本描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="existScript.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="剧本内容" :label-width="formLabelWidth">
        <el-input
            v-model="existScript.content"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelEdit">取消</el-button>
      <el-button type="primary" @click="confirmEdit">更新</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "ScriptEdit",
  data() {
    return {
      existScript: {
        name: "",
        description: "",
        content: "",
      },

      formLabelWidth: "120px",
    };
  },
  props:{
    editFormVisible:Boolean,
    scriptId:Number
  },
  methods: {
    clearInput(){
      this.existScript = {}
    },
    cancelEdit() {
      this.clearInput()
      this.$emit('closeEditScriptDialog',false)
    },
    confirmEdit() {
      // 检查输入
      if(this.existScript.name === '' || this.existScript.name === undefined || this.existScript.name === null){
        this.$message({
          showClose: true,
          message: "剧本名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.existScript.description === '' || this.existScript.description === undefined || this.existScript.description === null){
        this.$message({
          showClose: true,
          message: "剧本描述不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let updateScript = _this.existScript
      updateScript["userId"] = _this.$store.getters.getUser.userId
      updateScript["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/script/update/`,
        data: updateScript
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改剧本成功",
            type: 'success'
          });
          _this.cancelEdit()
        }
        else {
          _this.$message({
            showClose: true,
            message: "修改剧本失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "修改剧本失败",
          type: 'error'
        });
      })
      // console.log("existScript:")
      // console.log(this.existScript)
      this.$emit('closeEditScriptDialog',false)
    },
  },
  watch: {
    editFormVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        const _this = this
        let scriptId = this.$props.scriptId
        this.$axios({
          method: 'get',
          url: `${this.global.serverUrl}/script/${scriptId}`
        }).then(res => {
          _this.existScript = res.data.data
        }).catch( error => {
          console.log(error)
        })
      }
    },
  },
  created() {},
  computed: {

  },
}
</script>

<style scoped>

</style>