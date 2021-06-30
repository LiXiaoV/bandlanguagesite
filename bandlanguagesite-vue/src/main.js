import Vue from 'vue'
import App from './App.vue'
import router from '@/router/index'
import Element from 'element-ui'
import axios from "axios"

import "element-ui/lib/theme-chalk/index.css"
import VueCodeMirror from 'vue-codemirror'
import 'codemirror/lib/codemirror.css'

// 引入jshint用于实现js自动补全提示
import jshint from "jshint";

// 引入全局变量
import global from "@/store/global";
window.JSHINT = jshint.JSHINT;

// 引入vuex
import store from '@/store/index'
import './assets/style/font.scss'

//vue-beauty
//import css
import 'vue-beauty/package/style/vue-beauty.min.css'

//import components
import vueBeauty from 'vue-beauty'
Vue.use(vueBeauty)

Vue.config.productionTip = false

axios.defaults.withCredentials = true
Vue.prototype.$axios = axios;
Vue.prototype.global = global;

Vue.use(Element)
Vue.use(VueCodeMirror)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
