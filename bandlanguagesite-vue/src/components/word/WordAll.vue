<template>
  <div>
    <el-row type="flex">
      <el-col :span="23">
        <el-input
            v-model="searchText"
            placeholder="搜索词汇"
            :clearable="clearFlag"
            size="small"
            style="width: 20%; padding-bottom: 0.5rem"
            maxlength="20"
            show-word-limit
            prefix-icon="el-icon-search"
            @keyup.enter.native="searchWord"
        ></el-input>
      </el-col>
    </el-row>
    <el-table
        :data="wordTableData.slice(startPage, endPage)"
        border
        style="width: 100%"
        ref="wordTable"
    >
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
              <span>{{ props.row.description }}</span>
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
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="词汇名" min-width="30" align="center">
      </el-table-column>
      <el-table-column
          prop="typeString"
          label="类型"
          min-width="30"
          align="center"
          :filters="types"
          :filter-method="filterType"
      >
      </el-table-column>
      <el-table-column prop="description" label="描述" header-align="center">
      </el-table-column>
      <el-table-column prop="example" label="例子" align="center">
      </el-table-column>
      <el-table-column prop="isTypeInString" label="状态" min-width="30" align="center">
      </el-table-column>
    </el-table>
    <el-pagination
        :current-page.sync="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next,total"
        :total="wordTableData.length"
        class="a-pagination"
    >
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "WordAll",
  data(){
    return {
      //搜索
      searchText: "",
      clearFlag:true,
      wordTableData: [],
      types: [
        // 1：名词 2：动词 3：形容词 4：副词 5：数词 6：量词 7：代词 8：叹词  9：拟声词 10：介词 11：连词 12：助词
        { text: "名词", value: "名词" },
        { text: "动词", value: "动词" },
        { text: "形容词", value: "形容词" },
        { text: "副词", value: "副词" },
        { text: "数词", value: "数词" },
        { text: "量词", value: "量词" },
        { text: "代词", value: "代词" },
        { text: "叹词", value: "叹词" },
        { text: "拟声词", value: "拟声词" },
        { text: "介词", value: "介词" },
        { text: "连词", value: "连词" },
        { text: "助词", value: "助词" },
      ],
      //分页：页面控制
      currentPage: 1,
      pageSize: 10,
    }
  },
  created() {
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
      _this.wordTableData = words
    }).catch( error => {
      console.log(error)
    })
    this.initWordTableData();
  },
  methods:{
    initWordTableData() {
    },
    //搜索词汇
    searchWord() {
      console.log("enter +1");
    },
    //按条件过滤
    filterType(value, row) {
      return row.typeString === value;
    },
  },
  computed: {
    startPage: function () {
      return (this.currentPage - 1) * this.pageSize;
    },
    endPage: function () {
      return this.currentPage * this.pageSize;
    },
  },
  components:{

  }
}
</script>

<style scoped>
@import "../../assets/style/iconfont/iconfont.css";
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  width: 100%;
  height: fit-content;
}
</style>