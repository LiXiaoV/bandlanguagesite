<template>
  <el-dialog
      title="编辑中间范式"
      :visible.sync="paradigmEditDialogVisible"
      width="60%"
      center
      :before-close="handleClose"
      :append-to-body="Boolean(1)">
    <el-form :model="existParadigm" label-position="top">
      <el-form-item label="中间范式表示 *" :label-width="formLabelWidth">
        <el-input
            v-model="existParadigm.easyParadigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="举例 *" :label-width="formLabelWidth">
        <el-input
            v-model="existParadigm.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="200"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelEditParadigm">取消</el-button>
      <el-button type="primary" @click="confirmEditParadigm">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "ParadigmEdit",
  props:{
    paradigmEditDialogVisible: Boolean,
    paradigmId: Number,
  },
  data(){
    return {
      existParadigm: {
        easyParadigm: '',
        example: '',
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    handleClose(){
      this.cancelEditParadigm()
    },
    clearInput(){
      this.existParadigm={}
    },
    cancelEditParadigm(){
      this.clearInput()
      this.$emit('closeParadigmEditDialog')
    },
    confirmEditParadigm(){
      // 检查输入
      if(this.existParadigm.easyParadigm === '' || this.existParadigm.easyParadigm === undefined || this.existParadigm.easyParadigm === null){
        this.$message({
          showClose: true,
          message: "中间范式表示不能为空",
          type: 'error'
        });
        return;
      }
      if(this.existParadigm.example === '' || this.existParadigm.example === undefined || this.existParadigm.example === null){
        this.$message({
          showClose: true,
          message: "中间范式举例不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let editParadigm = {}
      editParadigm["paradigmId"] = _this.paradigmId
      editParadigm["easyParadigm"] = _this.existParadigm.easyParadigm
      editParadigm["example"] = _this.existParadigm.example
      editParadigm["userId"] = _this.$store.getters.getUser.userID
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/sentence/paradigm/`,
        data: editParadigm
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改中间范式成功",
            type: 'success'
          });
          _this.$emit('updateParadigms')
        }
        else {
          _this.$message({
            showClose: true,
            message: "修改中间范式失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "修改中间范式失败",
          type: 'error'
        });
      })
    },
    reloadExistParadigm(){
      const _this = this
      let paradigmId = this.$props.paradigmId
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/sentence/paradigm/${paradigmId}`
      }).then(res => {
        _this.existParadigm = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
  },
  watch:{
    paradigmEditDialogVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        this.reloadExistParadigm()
      }
    },
  }
}
</script>

<style scoped>

</style>