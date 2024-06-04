import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router/index'
import VueCookies from 'vue-cookies'
import VueParticles from "vue-particles";
import moment from "moment";
//导入离子效果模板
Vue.use(ElementUI)
Vue.use(moment)
Vue.use(VueParticles)
Vue.config.productionTip = false
Vue.use(VueCookies)
Vue.use(router)
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
