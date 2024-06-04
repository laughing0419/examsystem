import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'lib-flexible'
//导入element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//导入离子效果模板
import VueParticles from "vue-particles";
//导入vue-cookies
import VueCookies from 'vue-cookies'
//引入echarts
import echarts from 'echarts'
//引入axios
import axios from "axios";
//国际化
import locale from 'element-ui/lib/locale/lang/en';

import VueResource from 'vue-resource';
import request from "@/utils/request";

Vue.use(VueCookies)
Vue.use(VueParticles)
Vue.use(ElementUI,{locale});
Vue.use(VueResource);

Vue.config.productionTip = false
Vue.prototype.$echarts = echarts
Vue.prototype.$axios = axios
Vue.prototype.requset=request

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
