<template>
  <el-card>
    <el-row type="flex">
      <el-col :span="12" :offset="11">
        <span style="font-size: 14px;">新增规则</span>
      </el-col>
      <el-col :span="1">
        <i class="custom-close-icon el-icon el-icon-close" @click="closeRegisterRuleCard"></i>
      </el-col>
    </el-row>
    
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
            maxlength="1000"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="关于该规则的相关描述" :label-width="formLabelWidth">
        <el-input
            v-model="ruleObj.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="代码 *" :label-width="formLabelWidth">
        <el-input
            v-model="ruleObj.code"
            type="textarea"
            :autosize="{ minRows: 10 }"
            maxlength="100000"
            show-word-limit
        ></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center;">
      <el-button @click="cancelRegisterRule">取消</el-button>
      <el-button type="primary" @click="confirmRegister">新增</el-button>
    </div>
  </el-card>
</template>

<script>

export default {
  name: "RuleAdd",
  props:{
    sceneId: Number,
  },
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
    cancelRegisterRule() {
      this.ruleObj.rule = ""
      this.ruleObj.chineseName = ""
      this.ruleObj.express = ""
      this.ruleObj.description = ""
      this.ruleObj.code = ""
      this.$emit('closeRegisterRuleCard',false)
    },
    confirmRegister() {
      // 检查输入
      if(this.ruleObj.rule === '' || this.ruleObj.rule === undefined || this.ruleObj.rule === null){
        this.$message({
          showClose: true,
          message: "规则名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.ruleObj.chineseName === '' || this.ruleObj.chineseName === undefined || this.ruleObj.chineseName === null){
        this.$message({
          showClose: true,
          message: "规则中文名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.ruleObj.express === '' || this.ruleObj.express === undefined || this.ruleObj.express === null){
        this.$message({
          showClose: true,
          message: "规则表达式不能为空",
          type: 'error'
        });
        return;
      }
      if(this.ruleObj.code === '' || this.ruleObj.code === undefined || this.ruleObj.code === null){
        this.$message({
          showClose: true,
          message: "规则代码不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerRuleObj = {}
      registerRuleObj["rule"] = _this.ruleObj.rule
      registerRuleObj["chineseName"] = _this.ruleObj.chineseName
      registerRuleObj["express"] = _this.ruleObj.express
      registerRuleObj["description"] = _this.ruleObj.description
      registerRuleObj["code"] = _this.ruleObj.code
      registerRuleObj["userId"] = _this.$store.getters.getUser.userId
      registerRuleObj["sceneId"] = _this.sceneId
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/rule/insert`,
        data: registerRuleObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "新增规则成功",
            type: 'success'
          });
          _this.$emit("updateRuleOptionsEvent")
          this.cancelRegisterRule()
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
          message: "新增规则失败",
          type: 'error'
        });
      })
    },
    closeRegisterRuleCard(){
      this.cancelRegisterRule()
    }
  },
  created() {
  }
}
</script>

<style scoped>

</style>