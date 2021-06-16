<template>
  <el-card>
    <el-row type="flex">
      <el-col :span="12" :offset="11">
        <span style="font-size: 14px;">修改规则</span>
      </el-col>
      <el-col :span="1">
        <i class="custom-close-icon el-icon el-icon-close" @click="closeEditRuleCard"></i>
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
    <div style="text-align: center; margin-top: 1vh;">
      <el-popconfirm
          title="确定删除此规则吗？"
          @confirm="deleteRule(ruleObj.ruleId)"
          placement="top-start"
      >
        <el-button type="danger" slot="reference" style="margin-right: 10px;">删除</el-button>
      </el-popconfirm>
      <el-button @click="cancel">重置修改</el-button>
      <el-button type="primary" @click="confirmRuleEdit">确认修改</el-button>
    </div>
  </el-card>
</template>

<script>

export default {
  name: "RuleEdit",
  props:{
    sceneId: Number,
    ruleObjId: Number,
    itemId: Number,
    itemType: Number,
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
    cancel() {
      this.updateRuleObj()
    },
    confirmRuleEdit() {
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
      let editRuleObj = {}
      editRuleObj["ruleId"] = _this.ruleObj.ruleId
      editRuleObj["rule"] = _this.ruleObj.rule
      editRuleObj["chineseName"] = _this.ruleObj.chineseName
      editRuleObj["express"] = _this.ruleObj.express
      editRuleObj["description"] = _this.ruleObj.description
      editRuleObj["code"] = _this.ruleObj.code
      editRuleObj["userId"] = _this.$store.getters.getUser.userId
      editRuleObj["sceneId"] = _this.sceneId
      if(_this.itemId > 0 && _this.itemType > 0){
        editRuleObj["type"] = _this.itemType
        editRuleObj["itemId"] = _this.itemId
      }
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/rule/update`,
        data: editRuleObj
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改规则成功",
            type: 'success'
          });
          _this.$emit("updateRuleOptionsEvent")
          _this.$emit("updateAssociatedRulesEvent")
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
          message: "修改规则失败",
          type: 'error'
        });
      })
    },
    updateRuleObj(){
      const _this = this
      let ruleId = _this.ruleObjId
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/rule/${ruleId}/`,
      }).then(res => {
        _this.ruleObj = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    closeEditRuleCard(){
      // console.log("关闭编辑规则卡片")
      this.ruleObj.rule = ''
      this.ruleObj.chineseName = ''
      this.ruleObj.express = ''
      this.ruleObj.description = ''
      this.ruleObj.code = ''
      this.$emit("closeEditRuleCard")
    },
    deleteRule(id){
      const _this = this
      let deleteRule = {}
      deleteRule["ruleId"] = id
      deleteRule["userId"] = _this.$store.getters.getUser.userId
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/rule/deleteRule`,
        data:deleteRule
      }).then(res => {
        if(res.data.code === 0){
          _this.$emit("updateRuleOptionsEvent")
          _this.$emit("updateAssociatedRulesEvent")
          _this.closeEditRuleCard()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除规则失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除规则失败",
          type: 'error'
        });
      })
    }
  },
  created() {
    this.updateRuleObj()
  },
  mounted() {
    // console.log("this.ruleObj:")
    // console.log(this.ruleObj)
  },
  watch:{
    ruleObjId(newValue,oldValue){
      // console.log("ruleObjId",newValue,oldValue)
      if(newValue !== oldValue){
        this.updateRuleObj()
      }
    }
  }
}
</script>

<style scoped>

</style>