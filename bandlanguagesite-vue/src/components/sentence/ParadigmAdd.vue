<template>
  <el-dialog
      title="添加中间范式"
      :visible.sync="paradigmAddDialogVisible"
      width="60%"
      center
      :before-close="handleClose"
      :append-to-body="Boolean(1)">
    <el-form :model="newParadigm" label-position="top">
      <el-form-item label="中间范式表示 *" :label-width="formLabelWidth">
        <el-input
            v-model="newParadigm.easyParadigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="举例 *" :label-width="formLabelWidth">
        <el-input
            v-model="newParadigm.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelAddParadigm">取消</el-button>
      <el-button type="primary" @click="confirmAddParadigm">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "ParadigmAdd",
  props:{
    paradigmAddDialogVisible: Boolean,
    sentenceId: Number,
  },
  data(){
    return {
      newParadigm: {
        easyParadigm: '',
        example: '',
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    handleClose(){
      this.cancelAddParadigm()
    },
    clearInput(){
      this.newParadigm.easyParadigm = ''
      this.newParadigm.example = ''
    },
    cancelAddParadigm(){
      this.clearInput()
      this.$emit('closeParadigmAddDialog')
    },
    confirmAddParadigm(){
      // 检查输入
      if(this.newParadigm.easyParadigm === '' || this.newParadigm.easyParadigm === undefined || this.newParadigm.easyParadigm === null){
        this.$message({
          showClose: true,
          message: "中间范式表示不能为空",
          type: 'error'
        });
        return;
      }
      if(this.newParadigm.example === '' || this.newParadigm.example === undefined || this.newParadigm.example === null){
        this.$message({
          showClose: true,
          message: "中间范式举例不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerParadigm = _this.newParadigm
      registerParadigm["userId"] = _this.$store.getters.getUser.userId
      registerParadigm["sentenceId"] = _this.sentenceId
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/sentence/paradigm/`,
        data: registerParadigm
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "添加中间泛式成功",
            type: 'success'
          });
          _this.$emit('updateParadigms')
          _this.cancelAddParadigm()
        }
        else {
          _this.$message({
            showClose: true,
            message: "添加中间泛式失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "添加中间泛式失败",
          type: 'error'
        });
      })
    }
  }
}
</script>

<style scoped>

</style>