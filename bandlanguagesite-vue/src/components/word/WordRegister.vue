<template>
  <el-dialog title="注册新词汇" :visible="registerFormVisible" :show-close="false">
    <el-form :model="newWord" label-position="top">
      <el-form-item label="词汇名称 *" :label-width="formLabelWidth">
        <el-input v-model="newWord.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="词汇描述 *" :label-width="formLabelWidth">
        <el-input
          v-model="newWord.description"
          type="textarea"
          :autosize="{ minRows: 2 }"
          maxlength="250"
          show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇例子" :label-width="formLabelWidth">
        <el-input
            v-model="newWord.example"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="词汇类型与场景区 *">
        <el-row style="margin-left: 1vw;">
          <el-col :span="6">
            <el-select v-model="wordTypeValue" placeholder="请选择词汇类型">
              <el-option
                  v-for="item in wordTypeOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </el-col>

          <el-col :span="6" style="margin-left: 0.5vw;">
            <el-select v-model="sceneValue" placeholder="请选择场景区">
              <el-option
                  v-for="item in sceneOptions"
                  :key="item.deptId"
                  :label="item.name"
                  :value="item.deptId">
              </el-option>
            </el-select>
          </el-col>
        </el-row>
<!--        <el-radio-group v-model="newWord.type">-->
<!--          <el-radio :label="1">名词</el-radio>-->
<!--          <el-radio :label="2">动词</el-radio>-->
<!--          <el-radio :label="3">形容词</el-radio>-->
<!--          <el-radio :label="4">副词</el-radio>-->
<!--          <el-radio :label="5">数词</el-radio>-->
<!--          <el-radio :label="6">量词</el-radio>-->
<!--          <el-radio :label="7">代词</el-radio>-->
<!--          <el-radio :label="8">叹词</el-radio>-->
<!--          <el-radio :label="9">拟声词</el-radio>-->
<!--          <el-radio :label="10">介词</el-radio>-->
<!--          <el-radio :label="11">连词</el-radio>-->
<!--          <el-radio :label="12">助词</el-radio>-->
<!--        </el-radio-group>-->
      </el-form-item>
      <el-form-item label="录入规则与节点" :label-width="formLabelWidth">
<!--        <el-input-->
<!--            v-model="newWord.synonym"-->
<!--            type="textarea"-->
<!--            :autosize="{ minRows: 2 }"-->
<!--            maxlength="250"-->
<!--            show-word-limit-->
<!--        ></el-input>-->
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
export default {
  data() {
    return {
      newWord: {
        name: "",
        description: "",
        example: "",
      },
      wordTypeValue: '',
      wordTypeOptions: [
        {
          value: 1,
          label: '名词',
        },
        {
          value: 2,
          label: '动词',
        },
        {
          value: 3,
          label: '形容词',
        },
        {
          value: 4,
          label: '副词',
        },
        {
          value: 5,
          label: '数词',
        },
        {
          value: 6,
          label: '量词',
        },
        {
          value: 7,
          label: '代词',
        },
        // {
        //   value: 8,
        //   label: '叹词',
        // },
        // {
        //   value: 9,
        //   label: '拟声词',
        // },
        {
          value: 10,
          label: '介词',
        },
        {
          value: 11,
          label: '连词',
        },
        // {
        //   value: 12,
        //   label: '助词',
        // },
      ],
      sceneValue: '',
      sceneOptions: [],
      clearRuleOptionFlag: false,
      clearNodeOptionFlag: false,

      // 是否录入的标识
      isWordTypeInFlag: false,
      formLabelWidth: "120px",
    };
  },
  props:{
    registerFormVisible:Boolean,
  },
  methods: {
    clearInput(){
      this.newWord.name = ""
      this.newWord.description = ""
      this.newWord.example = ""
      this.wordTypeValue = ''
      this.sceneValue = ''
      this.clearRuleOptionFlag = true
      this.clearNodeOptionFlag = true
      this.isWordTypeInFlag = false
    },
    cancelRegister() {
      this.clearInput()
      this.$emit('closeRegisterWordDialog',false)
    },
    confirmRegister() {
      // 检查输入
      if(this.newWord.name === '' || this.newWord.name === undefined || this.newWord.name === null){
        this.$message({
          showClose: true,
          message: "词汇名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.newWord.description === '' || this.newWord.description === undefined || this.newWord.description === null){
        this.$message({
          showClose: true,
          message: "词汇描述不能为空",
          type: 'error'
        });
        return;
      }
      if(this.wordTypeValue === '' || this.wordTypeValue === undefined || this.wordTypeValue === null){
        this.$message({
          showClose: true,
          message: "请选择词汇类型",
          type: 'error'
        });
        return;
      }
      if(this.sceneValue === '' || this.sceneValue === undefined || this.sceneValue === null){
        this.$message({
          showClose: true,
          message: "请选择词汇所在的场景区",
          type: 'error'
        });
        return;
      }

      const _this = this
      let registerWord = _this.newWord
      registerWord["type"] = Number(_this.wordTypeValue)
      registerWord["isTypeIn"] = _this.isWordTypeInFlag?1:0
      registerWord["userId"] = _this.$store.getters.getUser.userId
      registerWord["sceneId"] = Number(_this.sceneValue)
      this.$axios({
        method: 'post',
        url: `${this.global.serverUrl}/word/`,
        data: registerWord
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "注册词汇成功",
            type: 'success'
          });
          _this.clearInput()
        }
        else {
          _this.$message({
            showClose: true,
            message: "注册词汇失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "注册词汇失败",
          type: 'error'
        });
      })
      // console.log("newWord:")
      // console.log(this.newWord)
      this.$emit('closeRegisterWordDialog',false)
    },
    updateSceneOptions(){
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
    returnClearRuleOptionFlag(){
      this.clearRuleOptionFlag = false
    },
    returnClearNodeOptionFlag(){
      this.clearNodeOptionFlag = false
    },
    typeInEvent(){
      this.isWordTypeInFlag = true
    }
  },
  created() {
    this.updateSceneOptions()
  },
  components:{
    "v-type-in": TypeIn,
  },
  mounted() {
    // console.log("word register mounted")
  },
};
</script>

<style lang="scss" scoped>
//.type-in-word{
//  .el-form-item__label{
//    font-size: 1rem;
//  }
//}
</style>
