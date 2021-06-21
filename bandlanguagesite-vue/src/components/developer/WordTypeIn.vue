<template>
  <el-dialog
      :title="(editStyle === 0?'录入词汇 -- ':'修改录入的词汇 -- ')+typeInWordName"
      :visible.sync="wordTypeInDialogVisible"
      width="60%"
      center
      :before-close="handleClose">
    <v-type-in :developerEnter="Boolean(1)"
               :editStyle="editStyle"
               :sceneId="Number(sceneId)"
               :itemId="typeInWordId"
               :itemName="typeInWordName"
               :itemType="Number(1)"
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
  name: "WordTypeIn",
  props:{
    wordTypeInDialogVisible: Boolean,
    isWordTypeInFlag: Boolean,
    typeInWordId: Number,
    typeInWordName: String,
    editStyle: Number,  // 0: add 1: edit
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
      // this.$emit('closeRegisterRuleCard')
      // this.$emit('closeRegisterNodeCard')
      this.$emit('closeWordTypeInDialog')
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
      if(this.isWordTypeInFlag === false){
        // 更新该词汇录入状态
        const _this = this
        let typeInWordId = _this.typeInWordId
        this.$axios({
          method: 'put',
          url: `${this.global.serverUrl}/word/updateTypeInStatus/${typeInWordId}/`,
        }).then(res => {
          if(res.data.code === 0){
            console.log("修改词汇录入状态成功")
            // 提交跟新词汇列表
            this.$emit('commitReloadWords')
          }
          else {
            console.log("修改词汇录入状态失败")
          }
        }).catch( () => {
          console.log("修改词汇录入状态失败")
        })

      }

    }
  },
}
</script>

<style scoped>

</style>