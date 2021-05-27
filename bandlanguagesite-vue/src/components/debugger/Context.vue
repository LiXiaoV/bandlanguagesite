<template>
  <div class="context">
    <el-input
        v-model="searchText"
        placeholder="请输入搜索内容"
        :clearable="clearFlag"
        size="small"
        style="padding-bottom: 0.5rem"
        show-word-limit
        prefix-icon="el-icon-search"
        @keyup.enter.native="searchContent"
    ></el-input>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>工具语境</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'工具语境 item' + o }}
      </div>
    </el-card>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>剧本语境</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'剧本语境 item' + o }}
      </div>
    </el-card>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>帮语语境</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'帮语语境 item' + o }}
      </div>
    </el-card>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>部门语境</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'部门语境 item' + o }}
      </div>
    </el-card>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>机构语境</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'机构语境 item' + o }}
      </div>
    </el-card>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>剧本库</span>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        {{'剧本' + o }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //搜索
      searchText: "",
      clearFlag:true,

      //剧本库分页控制
      // currentPage: 1,
      // pageSize: 6,
    };
  },
  methods: {
    //搜索内容
    searchContent() {
      console.log("enter +1");
    },
  }
};
</script>

<style lang="scss" scoped>
.text {
  font-size: 14px;
}

.item {
  //margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  margin-bottom: 1vh;
}
.context{
  background-color: #f5fdfd;
  max-height: 50vh;
  overflow-y: scroll;
}
</style>
