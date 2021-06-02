<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="录入规则" name="1">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="3">
              <el-select v-model="ruleValue" placeholder="请选择规则" @visible-change="checkTheSceneValue">
                <el-option
                    v-for="item in ruleOptions"
                    :key="item.ruleId"
                    :label="item.chineseName"
                    :value="item.ruleId">
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="1" style="margin-left: 0.5vw;">
              <el-button icon="iconfont iconadd" circle size="mini" @click="registerRule" style="margin-top: 0.5vh;"></el-button>
            </el-col>
          </el-row>
          <div v-if="ruleValue !== ''">
            <v-rule-edit :sceneId="sceneId" :ruleObjId="ruleValue" @updateRuleOptionsEvent="updateRuleOptionsEvent"></v-rule-edit>
          </div>
        </div>

        <el-dialog
            title="新增规则"
            :visible.sync="registerRuleDialogVisible"
            width="70%"
            center
            :append-to-body="appendToBodyFlag">
          <v-rule-add :sceneId="sceneId"
                      @closeRegisterRuleDialog="closeRegisterRuleDialog"
                      @updateRuleOptionsEvent="updateRuleOptionsEvent"></v-rule-add>
        </el-dialog>
      </el-collapse-item>
      <el-collapse-item title="录入节点" name="2">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="3">
              <el-select v-model="nodeValue" placeholder="请选择节点" @visible-change="checkTheSceneValue">
                <el-option
                    v-for="item in nodeOptions"
                    :key="item.nodeId"
                    :label="item.name"
                    :value="item.nodeId">
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="1" style="margin-left: 0.5vw;">
              <el-button icon="iconfont iconadd" circle size="mini" @click="registerNode" style="margin-top: 0.5vh;"></el-button>
            </el-col>
          </el-row>
          <div v-if="nodeValue !== ''">
            <v-node-edit :sceneId="sceneId" :nodeObjId="nodeValue" @updateNodeOptionsEvent="updateNodeOptionsEvent"></v-node-edit>
          </div>
        </div>
        <el-dialog
            title="新增节点"
            :visible.sync="registerNodeDialogVisible"
            width="70%"
            center
            :append-to-body="appendToBodyFlag">
          <v-node-add :sceneId="sceneId"
                      @closeRegisterNodeDialog="closeRegisterNodeDialog"
                      @updateNodeOptionsEvent="updateNodeOptionsEvent"></v-node-add>
        </el-dialog>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
import RuleEdit from "@/components/developer/RuleEdit";
import RuleAdd from "@/components/developer/RuleAdd";
import NodeAdd from "@/components/developer/NodeAdd";
import NodeEdit from "@/components/developer/NodeEdit";
export default {
  name: "TypeIn",
  props:{
    sceneId: Number,
    developerEnter: Boolean,
    clearRuleOptionFlag: Boolean,
    clearNodeOptionFlag: Boolean,
  },
  data() {
    return {
      activeNames: [],
      appendToBodyFlag: true,
      ruleValue: '',
      ruleOptions: [],
      nodeValue: '',
      nodeOptions: [],
      registerRuleDialogVisible: false,
      registerNodeDialogVisible: false,
    };
  },
  methods: {
    handleChange(val) {
      console.log(val);
    },
    registerRule(){
      if(this.sceneId === 0 || this.sceneId === undefined || this.sceneId === null){
        this.$message({
          showClose: true,
          message: "没有选择正确的场景区",
          type: 'error'
        });
        return;
      }
      this.registerRuleDialogVisible = true
    },
    closeRegisterRuleDialog(flag){
      this.registerRuleDialogVisible = flag
    },
    registerNode(){
      if(this.sceneId === 0 || this.sceneId === undefined || this.sceneId === null){
        this.$message({
          showClose: true,
          message: "没有选择正确的场景区",
          type: 'error'
        });
        return;
      }
      this.registerNodeDialogVisible = true
    },
    closeRegisterNodeDialog(flag){
      this.registerNodeDialogVisible = flag
    },
    confirm(){
      this.$emit('closeWordTypeInDialog',false)
    },
    updateRuleOptions(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/rule/allSimpleRules/`,
        params: {
          "sceneId": _this.sceneId
        }
      }).then(res => {
        _this.ruleOptions = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    updateNodeOptions(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/node/allSimpleNodes/`,
        params: {
          "sceneId": _this.sceneId
        }
      }).then(res => {
        _this.nodeOptions = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    updateNodeOptionsEvent(){
      this.updateNodeOptions()
      this.$emit("typeInEvent")
    },
    updateRuleOptionsEvent(){
      this.updateRuleOptions()
      this.$emit("typeInEvent")
    },
    checkTheSceneValue(flag){
      if(flag === true){
        if(this.sceneId === 0 || this.sceneId === undefined || this.sceneId === null){
          this.$message({
            showClose: true,
            message: "没有选择正确的场景区",
            type: 'error'
          });
        }
      }
    }
  },
  components:{
    "v-rule-edit": RuleEdit,
    "v-rule-add": RuleAdd,
    "v-node-add": NodeAdd,
    "v-node-edit": NodeEdit,
  },
  created() {
    this.updateRuleOptions()
    this.updateNodeOptions()

    if(this.developerEnter === true){
      this.activeNames.push('1')
    }

    // console.log(this.sceneId)
  },
  watch:{
    sceneId(newValue,oldValue){
      // console.log("newValue:"+newValue)
      // console.log("oldValue:"+oldValue)
      if(newValue !== oldValue){
        this.updateRuleOptions()
        this.updateNodeOptions()
      }
    },
    ruleValue(newValue,oldValue){
      if(newValue !== oldValue){
        this.updateRuleOptions()
      }
    },
    nodeValue(newValue,oldValue){
      if(newValue !== oldValue){
        this.updateNodeOptions()
      }
    },
    clearRuleOptionFlag(){
      if(this.clearRuleOptionFlag === true){
        this.ruleValue = ''
        this.$emit("returnClearRuleOptionFlag")
      }
    },
    clearNodeOptionFlag(){
      if(this.clearNodeOptionFlag === true){
        this.nodeValue = ''
        this.$emit("returnClearNodeOptionFlag")
      }

    }
  }
}
</script>

<style scoped>

</style>