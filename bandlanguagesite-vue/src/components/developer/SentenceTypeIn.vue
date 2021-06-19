<template>
  <el-dialog
      :title="(editStyle === 0?'录入句型 -- ':'修改录入的句型 -- ')+typeInSentenceName"
      :visible.sync="sentenceTypeInDialogVisible"
      width="60%"
      center
      :before-close="handleClose">
    <v-type-in :developerEnter="Boolean(1)"
               :sceneId="Number(sceneId)"
               :editStyle="editStyle"
               :itemId="typeInSentenceId"
               :itemName="typeInSentenceName"
               :itemType="Number(2)"
               :clearRuleOptionFlag="clearRuleOptionFlag"
               :clearNodeOptionFlag="clearNodeOptionFlag"
               :closeRegisterCardFlag="closeRegisterCardFlag"
               @returnClearRuleOptionFlag="returnClearRuleOptionFlag"
               @returnClearNodeOptionFlag="returnClearNodeOptionFlag"
               @returnCloseRegisterCardFlag="returnCloseRegisterCardFlag"
               @typeInEvent="typeInEvent"></v-type-in>
    <div slot="footer" style="text-align: right;margin-top: 3vh;">
      <el-button @click="confirm">关闭</el-button>
    </div>
  </el-dialog>
</template>

<script>
import TypeIn from "@/components/developer/TypeIn";

export default {
  name: "SentenceTypeIn",
  props:{
    sentenceTypeInDialogVisible: Boolean,
    isSentenceTypeInFlag: Boolean,
    typeInSentenceId: Number,
    typeInSentenceName: String,
    editStyle: Number,
  },
  data(){
    return {
      sceneId:this.$route.params.id,

      clearRuleOptionFlag: false,
      clearNodeOptionFlag: false,
      closeRegisterCardFlag: false,
    }
  },
  components:{
    "v-type-in": TypeIn,
  },
  methods:{
    confirm(){
      // 关闭之前，先把RuleOption和NodeOption清空，把所有的注册页关了，
      //免得下一次进来这个dialog上一次的操作痕迹还在，就很影响体验
      this.clearRuleOptionFlag = true
      this.clearNodeOptionFlag = true
      this.closeRegisterCardFlag = true
      this.$emit('closeSentenceTypeInDialog')
    },
    handleClose(){
      this.confirm()
    },
    returnClearRuleOptionFlag(){
      this.clearRuleOptionFlag = false
    },
    returnClearNodeOptionFlag(){
      this.clearNodeOptionFlag = false
    },
    returnCloseRegisterCardFlag(){
      this.closeRegisterCardFlag = false
    },
    typeInEvent(){
      if(this.isSentenceTypeInFlag === false){
        // 更新该句型录入状态
        const _this = this
        let typeInSentenceId = _this.typeInSentenceId
        this.$axios({
          method: 'put',
          url: `${this.global.serverUrl}/sentence/updateTypeInStatus/${typeInSentenceId}/`,
        }).then(res => {
          if(res.data.code === 0){
            console.log("修改句型录入状态成功")
            // 提交跟新句型列表
            this.$emit('commitReloadSentences')
          }
          else {
            console.log("修改句型录入状态失败")
          }
        }).catch( () => {
          console.log("修改句型录入状态失败")
        })

      }

    }
  },
}
</script>

<style scoped>

</style>