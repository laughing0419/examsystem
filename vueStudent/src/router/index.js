import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../components/login/LoginView.vue'
import home from "@/components/common/home";
import Register from "@/components/login/Register";
import personal from "@/components/student/personal";
import exam from "@/components/student/exam";
import examcenter from "@/components/student/examcenter";
import myGrades from "@/components/student/myGrades";
import preexam from "@/components/student/preexam";
import quekao from "@/components/student/quekao";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'LoginView',   //登陆界面
    component: LoginView
  },
  {
    path: '/register',
    name: 'Register',
    component: Register   //注册界面
  },
  {
    path: '/home',
    component: home,     //首页
    children:[
      {
          path:'/personal',
          component: personal,
          meta: { title:'个人信息'}
      },
      {
        path: '/examcenter',
        component: examcenter,
        meta: { title:'考试中心'}
      },
      {
        path:'/mygrades',
        component: myGrades,
        meta: { title: '我的成绩'}
      },
      {
        path: '/quekao',
        component: quekao,
        meta: { title: '我的缺考'}
      }
    ]
  },
  {
    path: '/exam',
    component: exam
  },
  {
    path:'/preexam',
    component:preexam,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
