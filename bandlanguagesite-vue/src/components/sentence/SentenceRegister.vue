<template>
  <el-dialog title="注册新句型" :visible="registerFormVisible" :show-close="false">
    <el-form :model="newSentence" label-position="top">
      <el-form-item label="句型名称 *" :label-width="formLabelWidth">
        <el-input v-model="newSentence.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="句型描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="newSentence.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="句型的巴克斯范式表示" :label-width="formLabelWidth">
        <el-input
            v-model="newSentence.paradigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="巴克斯范式的中间范式" :label-width="formLabelWidth">
        <el-card>
          <el-table
              :data="paradigms"
              style="width: 100%"
          >
            <el-table-column type="index" label="序号" width="60" align="center">
            </el-table-column>
            <el-table-column prop="easyParadigm" label="中间范式表示" min-width="30" align="center">
            </el-table-column>
            <el-table-column prop="example" label="例子" min-width="30" align="center">
            </el-table-column>
          </el-table>
          <el-button icon="iconfont iconadd" circle size="mini" @click="addParadigm" style="margin-top: 1vh;"></el-button>
          <span style="margin-left: 5px;">添加中间范式</span>
          <div v-if="paradigmAddFlag === true" style="margin-top: 1vh;">
            <v-paradigm-add-in-reg-sentence @closeAddParadigmCard="closeAddParadigmCard"
                                            @addParadigmObj="addParadigmObj"></v-paradigm-add-in-reg-sentence>
          </div>

        </el-card>
      </el-form-item>
      <el-form-item label="句型所在的场景区 *" :label-width="formLabelWidth">
        <el-select v-model="sceneValue" placeholder="请选择场景区" style="margin-left: 1vw;">
          <el-option
              v-for="item in sceneOptions"
              :key="item.deptId"
              :label="item.name"
              :value="item.deptId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="录入规则与节点" :label-width="formLabelWidth">
        <v-type-in :sceneId="Number(sceneValue)"
                   :clearRuleOptionFlag="clearRuleOptionFlag"
                   :clearNodeOptionFlag="clearNodeOptionFlag"
                   @returnClearRuleOptionFlag="returnClearRuleOptionFlag"
                   @returnClearNodeOptionFlag="returnClearNodeOptionFlag"
                   @typeInEvent="typeInEvent"
                   style="margin-left: 1vw;"></v-type-in>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button @click="cancelRegister">取消</el-button>
      <el-button type="primary" @click="confirmRegister">注册</el-button>
    </div>
  </el-dialog>
</template>

<script>
import TypeIn from "@/components/developer/TypeIn";
import ParadigmAddInRegSentence from "@/components/sentence/ParadigmAddInRegSentence";
export default {
  data() {
    return {
      newSentence: {
        name: "",
        description: "",
        paradigm: "",
      },

      sceneValue: '',
      sceneOptions: [],
      clearRuleOptionFlag: false,
      clearNodeOptionFlag: false,

      // 是否录入的标识
      isSentenceTypeInFlag: false,
      paradigms: [],
      // 添加中间范式的标识
      paradigmAddFlag: false,
      formLabelWidth: "120px",
    };
  },
  props:{
    registerFormVisible:Boolean,
  },
  methods: {
    clearInput(){
      this.newSentence.name = ""
      this.newSentence.description = ""
      this.newSentence.paradigm = ""
      this.sceneValue = ''
      this.clearRuleOptionFlag = true
      this.clearNodeOptionFlag = true
      this.isSentenceTypeInFlag = false
    },
    cancelRegister() {
      this.clearInput()
      this.$emit('closeRegisterSentenceDialog',false)
    },
    confirmRegister() {
      // 检查输入
      if(this.newSentence.name === '' || this.newSentence.name === undefined || this.newSentence.name === null){
        this.$message({
          showClose: true,
          message: "句型名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.newSentence.description === '' || this.newSentence.description === undefined || this.newSentence.description === null){
        this.$message({
          showClose: true,
          message: "句型描述不能为空",
          type: 'error'
        });
        return;
      }
      if(this.sceneValue === '' || this.sceneValue === undefined || this.sceneValue === null){
        this.$message({
          showClose: true,
          message: "请选择句型所在的场景区",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerSentence = _this.newSentence
      registerSentence["paradigms"] = _this.paradigms
      registerSentence["isTypeIn"] = _this.isSentenceTypeInFlag?1:0
      registerSentence["userId"] = _this.$store.getters.getUser.userId
      registerSentence["sceneId"] = Number(_this.sceneValue)
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/sentence/`,
        data: registerSentence
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册句型成功",
            type: 'success'
          });
          _this.clearInput()
        }
        else {
          _this.$message({
            showClose: true,
            message: "注册句型失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "注册句型失败",
          type: 'error'
        });
      })
      this.$emit('closeRegisterSentenceDialog',false)
    },
    returnClearRuleOptionFlag(){
      this.clearRuleOptionFlag = false
    },
    returnClearNodeOptionFlag(){
      this.clearNodeOptionFlag = false
    },
    reloadSceneOptions(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/scene/scenes/`,
      }).then(res => {
        _this.sceneOptions = res.data.data
      }).catch( error => {
        console.log(error)
      })
    },
    typeInEvent(){
      this.isSentenceTypeInFlag = true
    },
    addParadigm(){
      this.paradigmAddFlag = true
    },
    closeAddParadigmCard(){
      this.paradigmAddFlag = false
    },
    addParadigmObj(paradigm){
      this.paradigms.push(paradigm)
    }

  },
  created() {
    this.reloadSceneOptions()
  },
  computed: {

  },
  components:{
    "v-type-in": TypeIn,
    "v-paradigm-add-in-reg-sentence": ParadigmAddInRegSentence,
  }
};
</script>

<style lang="scss">
//#type-in-sentence{
//.el-form-item__label{
//  font-size: 1rem;
//}
//}
</style>
