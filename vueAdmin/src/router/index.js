import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../components/login/LoginView.vue'
import home from "@/components/common/home";
import Register from "@/components/login/RegisterView";
import personal from "@/components/student/personal";
import exam from "@/components/student/exam";
import examcenter from "@/components/student/examcenter";
import myGrades from "@/components/student/myGrades";
import preexam from "@/components/student/preexam";
import quekao from "@/components/student/quekao";
import faceRegister from "@/components/login/cameraPreview";
import admin from "@/components/admin/admin";
import SInfo from "@/components/admin/SInfo";
import QuestionBank from "@/components/admin/QuestionBank";
import Test from "@/components/admin/Test";
import TInfo from "@/components/admin/TInfo";

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
    component:preexam
  },
  {
    path: '/face',
    component: faceRegister
  },
  {
    path: '/admin',
    component: admin,
    children: [
      {
        path: '/SInfo',
        component: SInfo,
        meta: {title: '学生信息'},
      },
      {
        path: '/TInfo',
        component: TInfo,
        meta:{title: '教师信息'}
      },
      {
        path: '/QuestionBank',
        component: QuestionBank,
        meta: {title: '题库管理'},
      },
      {
        path: '/Test',
        component: Test,
        meta: {title: '试卷管理'}
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
