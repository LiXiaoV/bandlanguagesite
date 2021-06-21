<template>
  <div>
    <el-table :data="WordTasksList.slice(startPage, endPage)" border style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="a-table-expand">
            <el-form-item label="词汇名">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="类型">
              <span>{{ props.row.typeString }}</span>
            </el-form-item>
            <el-form-item label="描述">
              <span>{{props.row.description}}</span>
            </el-form-item>
            <el-form-item label="例子">
              <span>{{ props.row.example }}</span>
            </el-form-item>
            <el-form-item label="同义词">
              <span>{{ props.row.synonym }}</span>
            </el-form-item>
            <el-form-item label="状态">
              <span>{{ props.row.isTypeInString }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column type="index" label="序号" width="60" align="center"> </el-table-column>
      <el-table-column prop="name" label="词汇名" min-width="30" align="center"> </el-table-column>
      <el-table-column prop="typeString" label="类型" align="center" min-width="45"> </el-table-column>
      <el-table-column prop="description" label="描述" align="center"> </el-table-column>
      <el-table-column label="操作" align="center" min-width="20">
        <template v-slot:default="scope">
          <el-button size="mini" v-if="scope.row.isTypeIn === 1" @click="updateTypeInWord(scope.row)" type="warning" plain> 修改 </el-button>
          <el-button size="mini" v-else @click="typeInWord(scope.row)" type="info" plain> 录入 </el-button>
        </template>
      </el-table-column>
    </el-table>
    <v-word-type-in :wordTypeInDialogVisible="wordTypeInDialogVisible"
                    :editStyle="Number(editStyle)"
                    :isWordTypeInFlag="isWordTypeInFlag"
                    :typeInWordId="Number(typeInWordId)"
                    :typeInWordName="typeInWordName"
                    @closeWordTypeInDialog="closeWordTypeInDialog"
                    @commitReloadWords="commitReloadWords"></v-word-type-in>
    <el-pagination
        :current-page.sync="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next,total"
        :total="WordTasksList.length"
        class="a-pagination"
    >
    </el-pagination>
  </div>

</template>

<script>
import WordTypeIn from "@/components/developer/WordTypeIn";
export default {
  data() {
    return {
      WordTasksList: [],

      //分页：页面控制
      currentPage: 1,
      pageSize: 10,

      isWordTypeInFlag: false,
      wordTypeInDialogVisible: false,

      typeInWordId: 0,
      typeInWordName: "",
      editStyle: 0, // 0表示录入，1表示修改

    };
  },
  methods: {

    typeInWord(word){
      // console.log(word.name)
      this.wordTypeInDialogVisible = true
      this.typeInWordId = word.wordId
      this.typeInWordName = ""+word.name
      this.isWordTypeInFlag = false
      this.editStyle = 0
    },
    updateTypeInWord(word){
      this.wordTypeInDialogVisible = true
      this.typeInWordId = word.wordId
      this.typeInWordName = word.name
      this.isWordTypeInFlag = true
      this.editStyle = 1
    },
    closeWordTypeInDialog(){
      this.wordTypeInDialogVisible = false
    },
    initiateStatus() {
      // this.WordTasksList.forEach((element) => {
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
    reloadWords(){
      const _this = this
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/word/allWords/`,
        params: {
          "sceneId": _this.$route.params.id
        }
      }).then(res => {
        let words = res.data.data
        words.forEach( (element) => {
          // 词汇类型 1：名词 2：动词 3：形容词 4：副词 5：数词 6：量词 7：代词 8：叹词  9：拟声词 10：介词 11：连词 12：助词
          if(element.type === 1){
            element["typeString"] = "名词"
          }else if(element.type === 2){
            element["typeString"] = "动词"
          }else if(element.type === 3){
            element["typeString"] = "形容词"
          }else if(element.type === 4){
            element["typeString"] = "副词"
          }else if(element.type === 5){
            element["typeString"] = "数词"
          }else if(element.type === 6){
            element["typeString"] = "量词"
          }else if(element.type === 7){
            element["typeString"] = "代词"
          }else if(element.type === 8){
            element["typeString"] = "叹词"
          }else if(element.type === 9){
            element["typeString"] = "拟声词"
          }else if(element.type === 10){
            element["typeString"] = "介词"
          }else if(element.type === 11){
            element["typeString"] = "连词"
          }else if(element.type === 12){
            element["typeString"] = "助词"
          }

          // 词汇状态
          if(element.isTypeIn === 0){
            element["isTypeInString"] = "未录入"
          }else if(element.isTypeIn === 1){
            element["isTypeInString"] = "已录入"
          }else {
            element["isTypeInString"] = "其它"
          }
        })
        _this.WordTasksList = words
      }).catch( error => {
        console.log(error)
      })
    },
    commitReloadWords(){
      this.reloadWords()
    }

  },
  components:{
    "v-word-type-in": WordTypeIn,
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
    this.reloadWords()
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
