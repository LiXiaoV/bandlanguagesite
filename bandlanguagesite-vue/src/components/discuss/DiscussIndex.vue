<template>
  <div class="v-global">
    <div class="v-header">
      <v-header></v-header>
    </div>
    <div class="v-content">
      <el-tabs type="border-card" >
        <el-tab-pane label="最热">
          <v-hottest-discuss></v-hottest-discuss>
        </el-tab-pane>
        <el-tab-pane label="最新">
          <v-newest-discuss></v-newest-discuss>
        </el-tab-pane>
      </el-tabs>
    </div>

  </div>
</template>

<script>
import Header from "@/components/common/Header";
import DiscussHottest from "@/components/discuss/DiscussHottest";
import DiscussNewest from "@/components/discuss/DiscussNewest";
export default {
  name: "DiscussIndex",
  components:{
    "v-header": Header,
    "v-hottest-discuss": DiscussHottest,
    "v-newest-discuss": DiscussNewest
  }
}
</script>

<style lang="scss" scoped>

.v-content{
  width: 65vw;
  margin-left: 7vw;
  margin-top: 4vh;
}
</style>