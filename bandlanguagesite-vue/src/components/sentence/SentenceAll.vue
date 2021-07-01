<template>
  <div>
    <el-input
        v-model="searchText"
        placeholder="搜索句型"
        :clearable="clearFlag"
        size="small"
        style="width: 20%; padding-bottom: 0.5rem"
        maxlength="20"
        show-word-limit
        prefix-icon="el-icon-search"
        @keyup.enter.native="searchSentence"
    ></el-input>
    <el-table
        :data="sentenceTableData.slice(startPage, endPage)"
        border
        style="width: 100%"
        ref="wordTable"
    >
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="a-table-expand">
            <el-form-item label="句型名：">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="描述：">
              <span>{{ props.row.description }}</span>
            </el-form-item>
            <el-form-item label="巴科斯范式表示：">
              <span>{{ props.row.paradigm }}</span>
            </el-form-item>
            <el-form-item label="中间范式：">
              <div v-for="(item,index) in props.row.paradigms" :key="index">
                {{item.easyParadigm}}
              </div>
            </el-form-item>
            <el-form-item label="状态：">
              <span>{{ props.row.isTypeInString }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column type="index" label="序号" width="60" align="center">
      </el-table-column>
      <el-table-column prop="name" label="句型名" min-width="30" align="center">
      </el-table-column>
      <el-table-column prop="description" label="描述" header-align="center">
      </el-table-column>
      <el-table-column prop="paradigm" label="巴科斯范式表示" header-align="center">
      </el-table-column>
    </el-table>
    <el-pagination
        :current-page.sync="currentPage"
        :page-size="pageSize"
        layout="prev, pager, next,total"
        :total="sentenceTableData.length"
        class="a-pagination"
    >
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "SentenceAll",
  data(){
    return {
      //搜索
      searchText: "",
      clearFlag:true,
      sentenceTableData: [],
      //分页：页面控制
      currentPage: 1,
      pageSize: 10,
    }
  },
  created() {
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

        // 是否录入状态
        if(element.isTypeIn === 0){
          element["isTypeInString"] = "未实现"
        }else if(element.isTypeIn === 1){
          element["isTypeInString"] = "已实现"
        }else {
          element["isTypeInString"] = "其它"
        }
      })
      _this.sentenceTableData = sentences
    }).catch( error => {
      console.log(error)
    })
    this.initWordTableData();
  },
  methods:{
    initWordTableData() {
    },
    //搜索句型
    searchSentence() {
      console.log("enter +1");
    },
    //按条件过滤
    filterType(value, row) {
      return row.type === value;
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
}
</script>

<style scoped>
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  width: 100%;
  height: fit-content;
}
</style>