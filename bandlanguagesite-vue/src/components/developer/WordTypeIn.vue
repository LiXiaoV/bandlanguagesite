<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="录入规则" name="1">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="3">
              <el-select v-model="ruleOptionDefaultValue" placeholder="请选择规则">
                <el-option
                    v-for="item in ruleOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="1" style="margin-left: 0.5vw;">
              <el-button icon="iconfont iconadd" circle size="mini" @click="registerRule" style="margin-top: 0.5vh;"></el-button>
            </el-col>
          </el-row>
          <div v-if="ruleOptionDefaultValue !== ''">
            <v-rule-edit></v-rule-edit>
          </div>
        </div>

        <el-dialog
            title="新增规则"
            :visible.sync="registerRuleDialogVisible"
            width="70%"
            center
            append-to-body="true">
          <v-rule-add @closeRegisterRuleDialog="closeRegisterRuleDialog"></v-rule-add>
        </el-dialog>
      </el-collapse-item>
      <el-collapse-item title="录入节点" name="2">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="3">
              <el-select v-model="nodeOptionDefaultValue" placeholder="请选择节点">
                <el-option
                    v-for="item in nodeOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-col>

            <el-col :span="1" style="margin-left: 0.5vw;">
              <el-button icon="iconfont iconadd" circle size="mini" @click="registerNode" style="margin-top: 0.5vh;"></el-button>
            </el-col>
          </el-row>
          <div v-if="nodeOptionDefaultValue !== ''">
            <v-node-edit></v-node-edit>
          </div>
        </div>
        <el-dialog
            title="新增节点"
            :visible.sync="registerNodeDialogVisible"
            width="70%"
            center
            append-to-body="true">
          <v-node-add @closeRegisterNodeDialog="closeRegisterNodeDialog"></v-node-add>
        </el-dialog>
      </el-collapse-item>
    </el-collapse>
    <div slot="footer" style="text-align: right;margin-top: 3vh;">
      <el-button @click="confirm">确认并返回</el-button>
    </div>
  </div>
</template>

<script>
import RuleEdit from "@/components/developer/RuleEdit";
import RuleAdd from "@/components/developer/RuleAdd";
import NodeAdd from "@/components/developer/NodeAdd";
import NodeEdit from "@/components/developer/NodeEdit";
export default {
  name: "WordTypeIn",
  data() {
    return {
      activeNames: ['1'],
      ruleOptionDefaultValue: "",
      ruleOptions: [{
        value: 1,
        label: '规则1'
      }, {
        value: 2,
        label: '规则2'
      }, {
        value: 3,
        label: '规则3'
      }, {
        value: 4,
        label: '规则4'
      }, {
        value: 5,
        label: '规则5'
      }],
      nodeOptionDefaultValue: "",
      nodeOptions: [{
        value: 1,
        label: '节点1'
      }, {
        value: 2,
        label: '节点2'
      }, {
        value: 3,
        label: '节点3'
      }, {
        value: 4,
        label: '节点4'
      }, {
        value: 5,
        label: '节点5'
      }],
      registerRuleDialogVisible: false,
      registerNodeDialogVisible: false,
    };
  },
  methods: {
    handleChange(val) {
      console.log(val);
    },
    registerRule(){
      this.registerRuleDialogVisible = true
    },
    closeRegisterRuleDialog(flag){
      this.registerRuleDialogVisible = flag
    },
    registerNode(){
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
          "sceneId": _this.$route.params.id
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
          "sceneId": _this.$route.params.id
        }
      }).then(res => {
        _this.nodeOptions = res.data.data
      }).catch( error => {
        console.log(error)
      })
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
  }
}
</script>

<style scoped>

</style>