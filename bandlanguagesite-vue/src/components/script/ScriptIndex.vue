<template>
  <el-tabs type="border-card" >
    <el-tab-pane label="所有剧本">
        <v-script-all></v-script-all>
    </el-tab-pane>

    <el-tab-pane label="新建剧本" >
        <v-script-edit></v-script-edit>
    </el-tab-pane>

  </el-tabs>
</template>

<script>
import ScriptAll from "@/components/script/ScriptAll";
import ScriptEdit from "@/components/script/ScriptEdit";
export default {
  components:{
    //使用组件
    "v-script-all":ScriptAll,
    "v-script-edit": ScriptEdit,
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