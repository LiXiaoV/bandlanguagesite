<template>
<el-tabs type="border-card" >
    <el-tab-pane label="审核词汇">
        <v-checkWord></v-checkWord>
    </el-tab-pane>

    <el-tab-pane label="发布词汇" >
        <v-issueWord></v-issueWord>
    </el-tab-pane>

    <el-tab-pane label="审核句型">
        <v-checkSentence></v-checkSentence>
    </el-tab-pane>

    <el-tab-pane label="发布句型">
        <v-issueSentence></v-issueSentence>
    </el-tab-pane>

  </el-tabs>
</template>

<script>
    import CheckWord from "./CheckWord"
    import IssueWord from "./IssueWord"
    import CheckSentence from "./CheckSentence"
    import IssueSentence from "./IssueSentence"
    export default {
        components:{ 
            //使用组件
            "v-checkWord":CheckWord,
            "v-issueWord":IssueWord,
            "v-checkSentence":CheckSentence,
            "v-issueSentence":IssueSentence,
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