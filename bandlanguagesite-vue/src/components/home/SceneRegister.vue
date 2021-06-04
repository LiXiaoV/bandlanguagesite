<template>
  <el-dialog title="新增场景区" :visible="registerFormVisible" :show-close="false">
    <el-form :model="newScene" label-position="top">
      <el-form-item label="场景区名称 *" :label-width="formLabelWidth">
        <el-input v-model="newScene.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="场景区描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="newScene.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelRegister">取消</el-button>
      <el-button type="primary" @click="confirmRegister">提交</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "SceneRegister",
  data() {
    return {
      newScene: {
        name: "",
        description: "",
      },

      formLabelWidth: "120px",
    };
  },
  props:{
    registerFormVisible:Boolean,
  },
  methods: {
    clearInput(){
      this.newScene.name = ''
      this.newScene.description = ''
    },
    cancelRegister() {
      this.clearInput()
      this.$emit('closeRegisterSceneDialog',false)
    },
    confirmRegister() {
      // 检查输入
      if(this.newScene.name === '' || this.newScene.name === undefined || this.newScene.name === null){
        this.$message({
          showClose: true,
          message: "场景区名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.newScene.description === '' || this.newScene.description === undefined || this.newScene.description === null){
        this.$message({
          showClose: true,
          message: "场景区描述不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerScene = _this.newScene
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/scene/insert/`,
        data: registerScene
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "添加场景区成功",
            type: 'success'
          });
          _this.cancelRegister()
        }
        else {
          _this.$message({
            showClose: true,
            message: "添加场景区失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "添加场景区失败",
          type: 'error'
        });
      })
    },
  },
  created() {},
  computed: {

  },
}
</script>

<style scoped>

</style>