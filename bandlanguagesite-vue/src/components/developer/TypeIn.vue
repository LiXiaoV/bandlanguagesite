<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item :title="editStyleName+'规则'" name="1">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="4">
              <el-select v-model="ruleValue" placeholder="选择已有规则" @visible-change="checkTheSceneValue">
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

          <div v-if="associatedRules.length > 0">
            <el-row style="font-size: 14px;margin: 1vh 0;">
              <span>与{{typeName}} "{{itemName}}"关联的规则：</span>
            </el-row>

              <span v-for="item in associatedRules" :key="item.ruleId" style="margin-left: 10px;">
                <el-tag type="info" size="small">
                  {{ item.chineseName }}
                    <el-popconfirm
                        :title="'确定删除'+typeName+'“'+itemName+'”'+'与此规则的关联吗？'"
                        @confirm="deleteRuleOfAssociate(item.ruleId)"
                    >
                      <i slot="reference" class="custom-close-icon el-icon el-icon-close"></i>
                    </el-popconfirm>
                </el-tag>

              </span>

          </div>

          <!-- 增加规则卡片-->
          <div v-if="registerRuleFlag" style="margin-top: 1vh;">
            <v-rule-add :sceneId="sceneId"
                        :itemId="itemId"
                        :itemType="itemType"
                        @updateAssociatedRulesEvent="updateAssociatedRulesEvent"
                        @closeRegisterRuleCard="closeRegisterRuleCard"
                        @updateRuleOptionsEvent="updateRuleOptionsEvent"></v-rule-add>
          </div>
          <!-- 编辑规则卡片-->
          <div v-if="ruleValue !== ''" style="margin-top: 1vh;">
            <v-rule-edit :sceneId="sceneId"
                         :ruleObjId="ruleValue"
                         :itemId="itemId"
                         :itemType="itemType"
                         @updateAssociatedRulesEvent="updateAssociatedRulesEvent"
                         @updateRuleOptionsEvent="updateRuleOptionsEvent"
                         @closeEditRuleCard="closeEditRuleCard"></v-rule-edit>
          </div>
        </div>

<!--        <el-dialog-->
<!--            title="新增规则"-->
<!--            :visible.sync="registerRuleDialogVisible"-->
<!--            width="70%"-->
<!--            center-->
<!--            :append-to-body="appendToBodyFlag">-->
<!--          <v-rule-add :sceneId="sceneId"-->
<!--                      @closeRegisterRuleDialog="closeRegisterRuleDialog"-->
<!--                      @updateRuleOptionsEvent="updateRuleOptionsEvent"></v-rule-add>-->
<!--        </el-dialog>-->
      </el-collapse-item>
      <el-collapse-item :title="editStyleName+'节点'" name="2">
        <div style="margin-left: 2vw;">
          <el-row>
            <el-col :span="4">
              <el-select v-model="nodeValue" placeholder="选择已有节点" @visible-change="checkTheSceneValue">
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
          <div v-if="associatedNodes.length > 0">
            <el-row style="font-size: 14px;margin: 1vh 0;">
              <span>与{{typeName}} "{{itemName}}"关联的节点：</span>
            </el-row>

            <span v-for="item in associatedNodes" :key="item.nodeId" style="margin-left: 10px;">
                <el-tag type="info" size="small">
                  {{ item.name }}
                  <el-popconfirm
                      :title="'确定删除'+typeName+'“'+itemName+'”'+'与此节点的关联吗？'"
                      @confirm="deleteNodeOfAssociate(item.nodeId)"
                  >
                      <i slot="reference" class="custom-close-icon el-icon el-icon-close"></i>
                  </el-popconfirm>
                </el-tag>
            </span>

          </div>
          <!-- 增加节点卡片-->
          <div v-if="registerNodeFlag === true" style="margin-top: 1vh;">
            <v-node-add :sceneId="sceneId"
                        :itemId="itemId"
                        :itemType="itemType"
                        @updateAssociatedNodesEvent="updateAssociatedNodesEvent"
                        @closeRegisterNodeCard="closeRegisterNodeCard"
                        @updateNodeOptionsEvent="updateNodeOptionsEvent"></v-node-add>
          </div>
          <!-- 编辑节点卡片-->
          <div v-if="nodeValue !== ''" style="margin-top: 1vh;">
            <v-node-edit :sceneId="sceneId"
                         :nodeObjId="nodeValue"
                         :itemId="itemId"
                         :itemType="itemType"
                         @updateAssociatedNodesEvent="updateAssociatedNodesEvent"
                         @updateNodeOptionsEvent="updateNodeOptionsEvent"
                         @closeEditNodeCard="closeEditNodeCard"></v-node-edit>
          </div>
        </div>

<!--        <el-dialog-->
<!--            title="新增节点"-->
<!--            :visible.sync="registerNodeDialogVisible"-->
<!--            width="70%"-->
<!--            center-->
<!--            :append-to-body="appendToBodyFlag">-->
<!--          <v-node-add :sceneId="sceneId"-->
<!--                      @closeRegisterNodeCard="closeRegisterNodeCard"-->
<!--                      @updateNodeOptionsEvent="updateNodeOptionsEvent"></v-node-add>-->
<!--        </el-dialog>-->
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
    closeRegisterCardFlag: Boolean,
    editStyle: Number,
    itemId: Number,
    itemName: String,
    itemType:Number,
  },
  data() {
    return {
      activeNames: [],
      // appendToBodyFlag: true,
      ruleValue: '',
      ruleOptions: [],
      nodeValue: '',
      nodeOptions: [],
      // registerRuleDialogVisible: false,
      // registerNodeDialogVisible: false,
      registerRuleFlag: false,
      registerNodeFlag: false,
      editStyleName: this.$props.editStyle === 1?"修改":"录入",
      associatedRules: [],
      associatedNodes: [],

      typeName: '',
    };
  },
  methods: {
    handleChange() {
      // console.log(val);
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
      // this.registerRuleDialogVisible = true
      this.registerRuleFlag = true
    },
    closeRegisterRuleCard(flag){
      // this.registerRuleDialogVisible = flag
      this.registerRuleFlag = flag
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
      // this.registerNodeDialogVisible = true
      this.registerNodeFlag = true
    },
    closeRegisterNodeCard(flag){
      // this.registerNodeDialogVisible = flag
      this.registerNodeFlag = flag
    },
    closeEditNodeCard(){
      this.nodeValue = ''
    },
    closeEditRuleCard(){
      this.ruleValue = ''
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
    },
    reloadAssociatedRules(){
      if(this.itemId > 0){
        if(this.itemType === 1){
          const _this = this
          this.$axios({
            method: 'get',
            url: `${this.global.serverUrl}/rule/wordAssociatedRules/`,
            params: {
              "wordId": _this.itemId
            }
          }).then(res => {
            _this.associatedRules = res.data.data
          }).catch( error => {
            console.log(error)
          })
        }else if(this.itemType === 2){
          const _this = this
          this.$axios({
            method: 'get',
            url: `${this.global.serverUrl}/rule/sentenceAssociatedRules/`,
            params: {
              "sentenceId": _this.itemId
            }
          }).then(res => {
            _this.associatedRules = res.data.data
          }).catch( error => {
            console.log(error)
          })
        }else
          this.associatedRules = []
      }else
        this.associatedRules = []
    },
    reloadAssociatedNodes(){
      if(this.itemId > 0){
        if(this.itemType === 1){
          const _this = this
          this.$axios({
            method: 'get',
            url: `${this.global.serverUrl}/node/wordAssociatedNodes/`,
            params: {
              "wordId": _this.itemId
            }
          }).then(res => {
            _this.associatedNodes = res.data.data
          }).catch( error => {
            console.log(error)
          })
        }else if(this.itemType === 2){
          const _this = this
          this.$axios({
            method: 'get',
            url: `${this.global.serverUrl}/node/sentenceAssociatedNodes/`,
            params: {
              "sentenceId": _this.itemId
            }
          }).then(res => {
            _this.associatedNodes = res.data.data
          }).catch( error => {
            console.log(error)
          })
        }else
          this.associatedNodes = []
      }else
        this.associatedNodes = []
    },
    updateAssociatedRulesEvent(){
      this.reloadAssociatedRules()
    },
    updateAssociatedNodesEvent(){
      this.reloadAssociatedNodes()
    },
    deleteRuleOfAssociate(id){
      const _this = this
      let deleteAssociateRule = {}
      deleteAssociateRule["ruleId"] = id
      deleteAssociateRule["userId"] = _this.$store.getters.getUser.userId
      deleteAssociateRule["itemId"] = _this.itemId
      deleteAssociateRule["type"] = _this.itemType
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/rule/deleteRuleOfAssociate`,
        data:deleteAssociateRule
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除关联规则成功",
            type: 'success'
          });
          _this.reloadAssociatedRules()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除关联规则失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除关联规则失败",
          type: 'error'
        });
      })
    },
    deleteNodeOfAssociate(id){
      const _this = this
      let deleteAssociateNode = {}
      deleteAssociateNode["nodeId"] = id
      deleteAssociateNode["userId"] = _this.$store.getters.getUser.userId
      deleteAssociateNode["itemId"] = _this.itemId
      deleteAssociateNode["type"] = _this.itemType
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/node/deleteNodeOfAssociate`,
        data:deleteAssociateNode
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除关联节点成功",
            type: 'success'
          });
          _this.reloadAssociatedNodes()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除关联节点失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除关联节点失败",
          type: 'error'
        });
      })
    },
    initTypeName(){
      if(this.itemType === 1){
        this.typeName = '词汇'
      }else if (this.itemType === 2){
        this.typeName = '句型'
      }else
        this.typeName = ''
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

    this.reloadAssociatedRules()
    this.reloadAssociatedNodes()

    if(this.developerEnter === true){
      this.activeNames.push('1')
    }
    this.initTypeName()

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

    },
    closeRegisterCardFlag(){
      if(this.closeRegisterCardFlag === true){
        this.registerRuleFlag = false
        this.registerNodeFlag = false
        this.$emit("returnCloseRegisterCardFlag")
      }

    },
    editStyle(){
      if(this.editStyle === 1){
        this.editStyleName = "修改"
      }else {
        this.editStyleName = "录入"
      }
    },
    itemId(newValue,oldValue){
      if(newValue !== oldValue){
        if(this.itemId !== null && this.itemId !== 0 && this.itemId !== undefined){
          // 请求后端数据
          this.reloadAssociatedRules()
          this.reloadAssociatedNodes()
          this.initTypeName()
        }else {
          this.associatedRules = []
          this.associatedNodes = []
        }
      }
    },

  }
}
</script>

<style scoped>

</style>