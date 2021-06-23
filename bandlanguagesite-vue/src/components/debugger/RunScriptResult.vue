<template>
  <el-card style="min-height: 20vh;">
    <el-row type="flex" justify="end">
      <el-col :span="10">
        <span style="font-size: 1rem;font-weight: bold;margin-top: 1vh;">剧本运行结果：</span>
      </el-col>
      <el-col :span="10">
      </el-col>
      <el-col :span="3">
        <el-button type="info" size="small" @click="clearResults">清空结果区</el-button>
      </el-col>
      <el-col :span="1">
      </el-col>
    </el-row>

    <div v-for="(item,index) in results" :key="index" style="margin: 1vh 0 1vh 1vw;">
      {{index}} --> {{item}}
    </div>
  </el-card>
</template>

<script>
export default {
  name: "RunScriptResult",
  props:{
    addResultFlag:Boolean,
    result: String,
  },
  data(){
    return {
      results:[],
    }
  },
  methods:{
    clearResults(){
      this.results = []
    }
  },
  watch:{
    addResultFlag(newValue,oldValue){
      if(newValue === true && oldValue === false){
        this.results.push(this.result)
        // console.log(this.results)
        this.$emit("returnAddResult")
      }
    }
  }
}
</script>

<style scoped>

</style>