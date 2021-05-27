<template>
  <el-tabs type="border-card">
    <el-tab-pane label="所有句型">
      <v-sentence-all></v-sentence-all>
    </el-tab-pane>

    <el-tab-pane label="注册新句型">
      <v-sentence-in-process></v-sentence-in-process>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import SentenceInProcess from "./SentenceInProcess";
import SentenceAll from "@/components/sentence/SentenceAll";
export default {
  components: {
    "v-sentence-in-process": SentenceInProcess,
    "v-sentence-all": SentenceAll,
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
