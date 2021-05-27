<template>
  <div class="box">
    <el-row class="top">
      <el-col :span="16">
        <!-------------命令输入区 --------->
        <v-command class="command"></v-command>
      </el-col>
      <el-col :span="8">
        <!-------- 语境区 -------->
              <v-context class="context"></v-context>
      </el-col>
    </el-row>
    <el-row>
      <!------- 结果区 -------->
      <!--      <v-result style="width: 100%; height: 100%"></v-result>-->
    </el-row>
  </div>
</template>

<script>
import Command from "@/components/debugger/Command";
import Context from "@/components/debugger/Context";
// import Result from "@/components/debugger/Result";

export default {
  components: {
    "v-command": Command,
    "v-context": Context,
    // "v-result": Result,
  },
  data() {
    return {

    };
  },
};
</script>

<style lang="scss" scoped>

.box {
  width: 100%;
  height: 100%;
  position: relative;
}
.top{
  max-height: 50vh;
}
.context{
  margin-left: 1vw;
}
</style>
