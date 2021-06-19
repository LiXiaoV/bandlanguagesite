<template>
  <div>
    <el-form :model="newScript" label-position="top">
      <el-form-item label="剧本名称 *" :label-width="formLabelWidth">
        <el-input v-model="newScript.name" maxlength="100" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="剧本描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="newScript.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="剧本内容" :label-width="formLabelWidth">
        <el-input
            v-model="newScript.content"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="1000"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" style="text-align: center;margin-top: 3vh;">
      <el-button @click="cancelRegister">清除</el-button>
      <el-button type="primary" @click="confirmRegister">保存</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScriptAdd",
  data(){
    return {
      newScript: {
        name: "",
        content: "",
        description: "",
      },
      userId: 3,
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancelRegister() {
      this.newScript.name = ""
      this.newScript.content = ""
      this.newScript.description = ""
    },
    confirmRegister() {
      // 检查输入
      if(this.newScript.name === '' || this.newScript.name === undefined || this.newScript.name === null){
        this.$message({
          showClose: true,
          message: "剧本名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.newScript.description === '' || this.newScript.description === undefined || this.newScript.description === null){
        this.$message({
          showClose: true,
          message: "剧本描述不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerScript = _this.newScript
      registerScript["userId"] = _this.$store.getters.getUser.userId
      registerScript["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/script/`,
        data: registerScript
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "保存剧本成功",
            type: 'success'
          });
          this.cancelRegister()
        }
        else {
          _this.$message({
            showClose: true,
            message: "保存剧本失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "保存剧本失败",
          type: 'error'
        });
      })
    },
  }
}
</script>

<style scoped>

</style>