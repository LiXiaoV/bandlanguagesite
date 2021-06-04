<template>
  <el-tabs type="border-card">
    <el-tab-pane label="所有句型">
      <v-sentence-all></v-sentence-all>
    </el-tab-pane>

    <el-tab-pane label="我提交的句型">
      <v-my-sentence></v-my-sentence>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import SentenceAll from "@/components/sentence/SentenceAll";
import MySentence from "@/components/sentence/MySentence";
export default {
  components: {
    "v-sentence-all": SentenceAll,
    "v-my-sentence": MySentence,
  },
  data() {
    return {};
  },
};
</script>

<style>
.el-tabs {
  height: 100%;
  background-color: #2c2b2b;
}
</style>
