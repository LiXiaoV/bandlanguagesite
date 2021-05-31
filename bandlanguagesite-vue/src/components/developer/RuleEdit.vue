<template>
  <div>
    <el-form :model="ruleObj" label-position="top">
      <el-form-item label="规则符号 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="ruleObj.rule" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="中文名称 *" :label-width="formLabelWidth">
        <el-input placeholder="" v-model="ruleObj.chineseName" maxlength="100" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="规则表达式 *" :label-width="formLabelWidth">
        <el-input
            v-model="ruleObj.express"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="500"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="关于该规则的相关描述" :label-width="formLabelWidth">
        <el-input
            v-model="ruleObj.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="500"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="代码 *" :label-width="formLabelWidth">
        <el-input
            v-model="ruleObj.code"
            type="textarea"
            :autosize="{ minRows: 10 }"
            maxlength="500"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" style="text-align: center;">
      <el-button @click="cancel">撤销修改</el-button>
      <el-button type="primary" @click="confirmRuleEdit">确认修改</el-button>
    </div>
  </div>
</template>

<script>

export default {
  name: "RuleEdit",
  data(){
    return {
      ruleObj: {
        rule: "",
        chineseName: "",
        express: "",
        description: "",
        code: "",
      },
      formLabelWidth: "120px",
    }
  },
  methods:{
    cancel() {
      this.ruleObj.rule = ""
      this.ruleObj.chineseName = ""
      this.ruleObj.express = ""
      this.ruleObj.description = ""
      this.ruleObj.code = ""
      this.$emit('closeRegisterRuleDialog',false)
    },
    confirmRuleEdit() {
      const _this = this
      let registerRuleObj = {}
      registerRuleObj["rule"] = _this.ruleObj.rule
      registerRuleObj["chineseName"] = _this.ruleObj.chineseName
      registerRuleObj["express"] = _this.ruleObj.express
      registerRuleObj["description"] = _this.ruleObj.description
      registerRuleObj["code"] = _this.ruleObj.code
      registerRuleObj["userId"] = _this.$store.getters.getUser.userId
      registerRuleObj["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/developer/registerRule`,
        data: registerRuleObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册规则成功",
            type: 'success'
          });
          this.cancel()
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
          message: "注册规则失败",
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