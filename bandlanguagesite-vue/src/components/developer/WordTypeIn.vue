<template>
  <el-dialog
      :title="typeInWordName"
      :visible.sync="wordTypeInDialogVisible"
      width="60%"
      center
      :before-close="handleClose">
    <v-type-in :developerEnter="Boolean(1)"
               :sceneId="Number(sceneId)"
               :clearRuleOptionFlag="clearRuleOptionFlag"
               :clearNodeOptionFlag="clearNodeOptionFlag"
               @returnClearRuleOptionFlag="returnClearRuleOptionFlag"
               @returnClearNodeOptionFlag="returnClearNodeOptionFlag"
               @typeInEvent="typeInEvent"></v-type-in>
    <div slot="footer" style="text-align: right;margin-top: 3vh;">
      <el-button @click="confirm">确认并返回</el-button>
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
  },
  data(){
    return {
      sceneId:this.$route.params.id,

      clearRuleOptionFlag: false,
      clearNodeOptionFlag: false,
    }
  },
  components:{
    "v-type-in": TypeIn,
  },
  methods:{
    confirm(){
      this.clearRuleOptionFlag = true
      this.clearNodeOptionFlag = true
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