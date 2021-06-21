<template>
  <el-tabs type="border-card" >
    <el-tab-pane label="所有剧本">
        <v-script-all></v-script-all>
    </el-tab-pane>

    <el-tab-pane label="新建剧本" >
        <v-script-edit></v-script-edit>
    </el-tab-pane>

    <el-tab-pane label="我提交的剧本" >
      <v-my-script></v-my-script>
    </el-tab-pane>

  </el-tabs>
</template>

<script>
import ScriptAll from "@/components/script/ScriptAll";
import ScriptEdit from "@/components/script/ScriptAdd";
import MyScript from "@/components/script/MyScript";
export default {
  components:{
    //使用组件
    "v-script-all":ScriptAll,
    "v-script-edit": ScriptEdit,
    "v-my-script": MyScript,
  },
  data() {
      return  {

      }
  }
}
</script>

<style lang="scss" scoped>
.el-tabs{
    height: 100%;
}
</style>