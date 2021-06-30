<template>
  <div>
    <el-table :data="SentenceTasksList.slice(startPage, endPage)" border style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="a-table-expand">
            <el-form-item label="句型名：">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="句型描述：">
              <span>{{props.row.description}}</span>
            </el-form-item>
            <el-form-item label="句型的巴科斯范式表示：">
              <span>{{ props.row.paradigm }}</span>
            </el-form-item>
            <el-form-item label="状态：">
              <span>{{ props.row.isTypeInString }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column type="index" label="序号" width="60" align="center"> </el-table-column>
      <el-table-column prop="name" label="句型名" min-width="30" align="center"> </el-table-column>
      <el-table-column prop="description" label="描述" align="center"> </el-table-column>
      <el-table-column label="操作" align="center" min-width="20">
        <template v-slot:default="scope">
          <el-button size="mini" v-if="scope.row.isTypeIn === 1" @click="updateTypeInSentence(scope.row)" type="warning" plain> 修改 </el-button>
          <el-button size="mini" v-else @click="typeInSentence(scope.row)" type="info" plain> 录入 </el-button>
        </template>
      </el-table-column>
    </el-table>
    <v-sentence-type-in :sentenceTypeInDialogVisible="sentenceTypeInDialogVisible"
                    :isSentenceTypeInFlag="isSentenceTypeInFlag"
                    :editStyle="Number(editStyle)"
                    :typeInSentenceId="Number(typeInSentenceId)"
                    :typeInSentenceName="typeInSentenceName"
                    @closeSentenceTypeInDialog="closeSentenceTypeInDialog"
                    @commitReloadSentences="commitReloadSentences"></v-sentence-type-in>
    <el-pagination
        :current-page.sync="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next,total"
        :total="SentenceTasksList.length"
        class="a-pagination"
    >
    </el-pagination>
  </div>
</template>

<script>
import SentenceTypeIn from "@/components/developer/SentenceTypeIn";
export default {
  data() {
    return {
      SentenceTasksList: [],

      //分页：页面控制
      currentPage: 1,
      pageSize: 10,

      isSentenceTypeInFlag: false,
      sentenceTypeInDialogVisible: false,

      typeInSentenceId: 0,
      typeInSentenceName: "",
      editStyle: 0,

    };
  },
  methods: {
    typeInSentence(sentence){
      // console.log(sentence)
      this.sentenceTypeInDialogVisible = true
      this.typeInSentenceId = sentence.sentenceId
      this.typeInSentenceName = sentence.name
      this.isSentenceTypeInFlag = false
      this.editStyle = 0
    },
    updateTypeInSentence(sentence){
      this.sentenceTypeInDialogVisible = true
      this.typeInSentenceId = sentence.sentenceId
      this.typeInSentenceName = sentence.name
      this.isSentenceTypeInFlag = true
      this.editStyle = 1
    },
    closeSentenceTypeInDialog(){
      this.sentenceTypeInDialogVisible = false
    },
    initiateStatus() {
      // this.SentenceTasksList.forEach((element) => {
      //   switch (element.status) {
      //     case 0: {
      //       element.isTypeInString = "待领取";
      //       break;
      //     }
      //     case 1: {
      //       element.isTypeInString = "待开发";
      //       break;
      //     }
      //     case 2:{element.isTypeInString = "开发中";
      //       break;
      //     }
      //     case 3:{
      //       element.isTypeInString="待审核";
      //       break;
      //     }
      //     default: {
      //       element.isTypeInString = "处理完成";
      //     }
      //   }
      // });
    },
    reloadSentences(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/sentence/allSentences/`,
        params: {
          "sceneId": _this.$route.params.id
        }
      }).then(res => {
        let sentences = res.data.data
        sentences.forEach( (element) => {
          // 句型状态
          if(element.isTypeIn === 0){
            element["isTypeInString"] = "未录入"
          }else if(element.isTypeIn === 1){
            element["isTypeInString"] = "已录入"
          }else {
            element["isTypeInString"] = "其它"
          }
        })
        _this.SentenceTasksList = sentences
      }).catch( error => {
        console.log(error)
      })
    },
    commitReloadSentences(){
      this.reloadSentences()
    }

  },
  components:{
    "v-sentence-type-in": SentenceTypeIn,
  },
  computed: {
    startPage: function () {
      return (this.currentPage - 1) * this.pageSize;
    },
    endPage: function () {
      return this.currentPage * this.pageSize;
    },
  },
  mounted() {
    this.initiateStatus();
  },
  created() {
    this.reloadSentences()
  }
};
</script>

<style scoped>
.a-table-expand {
  font-size: 0;
}
.a-table-expand label {
  width: 100%;
  color: #99a9bf;
}
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  padding-top: 0.5rem;
  width: 100%;
  height: fit-content;
}

.a-input-desc {
  width: 30rem;
}
</style>
