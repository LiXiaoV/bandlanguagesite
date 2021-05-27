<template>
  <div>
    <el-dialog
      :visible="wordDetailsVisible"
      width="30%"
      label-width="50px"
      label-position="right"
      :show-close="false"
    >
      <el-form :form="form">
        <el-form-item label="词汇名">
          <span>{{ form.name }}</span>
        </el-form-item>
        <el-form-item label="类型" v-if="form.status === 4">
          <span>{{ form.type }}</span>
        </el-form-item>
        <el-form-item label="描述">
          <span>{{ form.description }}</span>
        </el-form-item>
        <el-form-item label="状态">
          <span>{{ form.status }}</span>
        </el-form-item>
        <el-form-item label="结论">
          <span>{{ form.conclusion }}</span>
        </el-form-item>
        <el-form-item label="例子" v-if="form.status === 4">
          <span>{{ form.example }}</span>
        </el-form-item>
        <el-form-item label="同义词" v-if="form.status === 4">
          <span>
            <ul>
              <li v-for="synonym in form.synonyms" :key="synonym">{{ synonym }}</li>
            </ul>
          </span>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="primary" @click="closeDlg">关闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        name: "如果",
        type: "介词",
        description: "表示‘假如’的意思，一般用于 如果句型",
        status: 5,
        conclusion: "开发完成",
        example: "如果 陈聪颖的年龄大于20",
        synonyms: ["假如", "若"],
      },
    };
  },
  methods: {
    closeDlg() {
      this.$emit('closeWordDetailDialog',false)
    },
  },
  props:{
    wordDetailsVisible:Boolean,
    wordId:Number
  },
  computed: {
  },
  watch: {
    wordDetailsVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
      }
    },
  },
};
</script>
