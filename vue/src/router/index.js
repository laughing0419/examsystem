import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import Layout from "@/components/Layout";
import Personal from "@/views/Personal";
import Home from "@/views/Home";
import UpdatePwd from "@/components/UpdatePwd";
import TeacherInfo from "@/components/TeacherInfo";
import ReleasePaper from '@/views/ReleasePaper'
import Question from "@/views/Question";
import FillQuestion from "@/components/FillQuestion";
import MultiQuestion from "@/components/MultiQuestion";
import JudgeQuestion from "@/components/JudgeQuestion";
import ExamInfo from "@/components/ExamInfo";
import Paper from "@/views/Paper";
import MarkPaper from "@/views/MarkPaper";
import Invigilate from "@/views/Invigilate";
import DesignPaper from "@/components/DesignPaper";
import CompleteDesign from "@/components/CompleteDesign";
import Login from "@/views/Login";
//设置路由导出
export default new VueRouter({
    routes:[
        {
            path:'/layout',
            name:'Layout',
            component:Layout,
            // redirect:'/home',
            children:[
                {
                    path:'/personal',       //个人信息
                    name:'Personal',
                    component:Personal,
                    redirect:'/teacherInfo',
                    children:[
                        {
                        path:'/updatePwd',
                        component:UpdatePwd
                    },{
                        path:'/teacherInfo',
                        component:TeacherInfo
                        }
                    ]
                },
                {
                    path:'/home',           //首页
                    component:Home
                },
                {
                    path:'/releasePaper',   //发布试卷
                    component:ReleasePaper,
                    redirect:'/examInfo',
                    children:[
                        {
                            path: '/examInfo',
                            component: ExamInfo,
                            meta:{
                                keepAlive:true
                            }
                    },
                        {
                            path: '/designPaper',
                            component: DesignPaper
                        },
                        {
                            path: '/completeDesign',
                            component: CompleteDesign
                        }
                    ]
                },
                {
                    path:'/question',        //题库管理
                    component:Question,
                    redirect:'/multiQuestion',
                    children:[
                        {
                            path: '/fillQuestion',
                            component: FillQuestion

                         },
                        {
                            path: '/multiQuestion',
                            component: MultiQuestion

                        },
                        {
                            path: '/judgeQuestion',
                            component: JudgeQuestion

                        },
                    ]
                },
                {
                    path:'/paper',      //试卷管理
                    component:Paper,
                },
                {
                    path:'/markPaper', //批阅试卷
                    component:MarkPaper
                },
                {
                    path:'/invigilate'  ,    //监考
                    component:Invigilate
                }
            ]
        },{
            path:'/',
            component:Login
        }
        ]
})
