<template>
  <el-tabs type="border-card" >
    <el-tab-pane label="所有词汇">
      <v-word-all></v-word-all>
    </el-tab-pane>
<!--    <el-tab-pane label="注册新词汇">-->
<!--      <v-word-in-process></v-word-in-process>-->
<!--    </el-tab-pane>-->
    <el-tab-pane label="我提交的词汇">
      <v-my-word></v-my-word>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import WordAll from "@/components/word/WordAll";
// import WordInProcess from './WordInProcess'
import MyWord from './MyWord'
export default {

  components:{
    //使用组件
    // "v-word-in-process":WordInProcess,
    "v-my-word":MyWord,
    "v-word-all":WordAll,
  },
  data() {
    return  {

    }
  }
}

</script>

<style lang="scss" scoped>
//.el-tabs{
//    height: 100%;
//}
</style>