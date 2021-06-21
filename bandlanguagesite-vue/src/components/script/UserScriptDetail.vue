<template>
  <el-dialog
      :visible="scriptDetailsVisible"
      width="30%"
      label-width="50px"
      label-position="right"
      :show-close="false"
  >
    <el-form :form="detailScript">
      <el-form-item label="剧本名：">
        <span>{{ detailScript.name }}</span>
      </el-form-item>
      <el-form-item label="剧本描述：">
        <span>{{ detailScript.description }}</span>
      </el-form-item>
      <el-form-item label="剧本内容：">
        <span>{{ detailScript.content }}</span>
      </el-form-item>
      <el-form-item label="创建者：">
        <span>{{ detailScript.creatorNickname }}</span>
      </el-form-item>
      <el-form-item label="最近的修改者：">
        <span>{{ detailScript.editorNickname }}</span>
      </el-form-item>
      <el-form-item label="最近的修改时间：">
        <span>{{ detailScript.updateTime }}</span>
      </el-form-item>
      <el-form-item label="剧本运行次数：">
        <span>{{ detailScript.runTimes }}</span>
      </el-form-item>
    </el-form>
    <div slot="footer">
      <el-button type="primary" @click="closeDlg">关闭</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "UserScriptDetail",
  props:{
    scriptDetailsVisible:Boolean,
    scriptId:Number
  },
  data() {
    return {
      detailScript: {},
    };
  },
  methods: {
    closeDlg() {
      this.$emit('closeScriptDetailDialog',false)
    },
  },
  computed: {
  },
  watch: {
    scriptDetailsVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        const _this = this
        let scriptId = this.$props.scriptId
        this.$axios({
          method: 'get',
          url: `${this.global.serverUrl}/script/${scriptId}`
        }).then(res => {
          _this.detailScript = res.data.data
        }).catch( error => {
          console.log(error)
        })
      }
    },
  },
  created() {

  }
}
</script>

<style scoped>

</style>