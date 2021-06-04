<template>
  <div class="box">
      <!-- <el-container>
        <el-container style="width:80%">
          <el-main>
            <v-command class="command"></v-command>
          </el-main>
        </el-container>
        <el-aside>
          <v-context style="width:100%"></v-context>
        </el-aside>
      </el-container> -->
      <v-command class="command"></v-command>
  </div>
</template>

<script>
import Command from "@/components/debugger/Command";
// import Context from "@/components/debugger/Context";
// import Result from "@/components/debugger/Result";

export default {
  components: {
    "v-command": Command,
    // "v-context": Context,
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

.command{
  width: 80%;
}
</style>
