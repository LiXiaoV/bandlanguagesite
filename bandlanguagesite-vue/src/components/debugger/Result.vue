<template>
  <div class="mirrorWrapper" id="wrapper">
    <codemirror ref="mycode" :value="curCode" :options="cmOptionsResult"> </codemirror>
  </div>
</template>

<script>
import { codemirror } from "vue-codemirror";

import "codemirror/addon/hint/show-hint.css";
let CodeMirror = require("codemirror/lib/codemirror");
import "codemirror/lib/codemirror.css";
require("codemirror/mode/javascript/javascript"); // 这里引入的模式的js，根据设置的mode引入
require("codemirror/mode/python/python.js");

require("codemirror/addon/fold/foldcode.js");
require("codemirror/addon/fold/foldgutter.js");
require("codemirror/addon/fold/brace-fold.js");
require("codemirror/addon/fold/xml-fold.js");
require("codemirror/addon/fold/indent-fold.js");
require("codemirror/addon/fold/markdown-fold.js");
require("codemirror/addon/fold/comment-fold.js");

require("codemirror/mode/sql/sql");

require("codemirror/addon/hint/show-hint");
require("codemirror/addon/hint/sql-hint");

export default {
  components: {
    codemirror,
  },
  data() {
    return {
      //结果区编辑器参数
      cmOptionsResult: {
        theme: "duotone-light",
        value: "",
        mode: "javascript",
        indentUnit: 2, //缩进单位
        smartIndent: true,
        tabSize: 4, //默认缩进
        extraKeys: { Ctrl: "autocomplete" }, //自动提示配置
        showCursorWhenSelecting: true,
        lineNumbers: true, //是否显示行号
        firstLineNumber: 1,
      },

      curCode: "",
    };
  },
  mounted() {
    // this.$refs.mycode.setSize("100%", "100%");
  },
  computed: {},
  watch: {},
};
</script>

<style scoped lang="scss">
.mirrorWrapper {
  width: 100%;
  height: 100%;
  .vue-codemirror {
    height: 100%;
  }
}
</style>
