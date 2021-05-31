<template>
  <el-tabs type="border-card">
    <el-tab-pane label="词汇任务">
      <v-WordTask></v-WordTask>
    </el-tab-pane>

    <el-tab-pane label="句型任务">
      <v-SentenceTask></v-SentenceTask>
    </el-tab-pane>

<!--    <el-tab-pane label="场景管理"> </el-tab-pane>-->

<!--    <el-tab-pane label="节点管理"> </el-tab-pane>-->

<!--    <el-tab-pane label="规则管理"> </el-tab-pane>-->

<!--    <el-tab-pane label="方法管理"> </el-tab-pane>-->

<!--    <el-tab-pane>-->
<!--      <el-dropdown slot="label" placement="top" @command="scrollTo">-->
<!--        <span class="el-dropdown-link">-->
<!--          我的任务-->
<!--        </span>-->
<!--        <el-dropdown-menu slot="dropdown">-->
<!--          <el-dropdown-item icon="el-icon-plus" command="wordTable">词汇</el-dropdown-item>-->
<!--          <el-dropdown-item icon="el-icon-circle-plus" command="sentenceTable">句型</el-dropdown-item>-->
<!--          <el-dropdown-item icon="el-icon-circle-plus-outline" command="scene">场景</el-dropdown-item>-->
<!--        </el-dropdown-menu>-->
<!--      </el-dropdown>-->
<!--      <v-MyTask></v-MyTask>-->
<!--    </el-tab-pane>-->
  </el-tabs>
</template>

<script>
import WordTask from "@/components/developer/WordTask";
import SentenceTask from "@/components/developer/SentenceTask";
// import MyTask from "./MyTask";
export default {
  data() {
    return {};
  },
  methods: {
      scrollTo(command){
          let anchor_dom = this.$el.querySelector("#" + command); //获取元素
            if (anchor_dom) {
              anchor_dom.scrollIntoView({ behavior: "smooth", block: "start" }); //js的内置方法，可滚动视图位置至元素位置
              console.log("jump ok");
            }
      },
  },
  components: {
    "v-WordTask": WordTask,
    "v-SentenceTask": SentenceTask,
    // "v-MyTask": MyTask,
  },
};
</script>

<style scoped></style>
