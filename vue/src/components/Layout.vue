<template>
  <div>
    <!--头部  -->
    <div style="height: 80px ;background-color: rebeccapurple ;line-height: 50px;display: flex">
      <div style="width: 200px ;padding-left: 30px ;font-weight: bold;color:white ;text-align: justify;margin: 10px 1px" >超星考试系统(老师)</div>
      <div style="flex: 1"></div>
      <div style="width: 100px; margin: 10px 1px">
        <el-dropdown>
  <span class="el-dropdown-link" style="color: white">
    {{teacherName}}<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="$router.push('/personal')" >个人中心</el-dropdown-item>
            <el-dropdown-item @click.native="loginOut" >退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!--侧边  -->
    <div style="float: left">
      <div class="demo-basic--circle" style="background-color: rebeccapurple;width: 202px;margin-left: 2px;margin-top: 2px;text-align: center;border-bottom:2px">
        <div class="block"><el-avatar :size="50"  :src="getImgUrl(gatherInfo.img)"></el-avatar></div>
        <div class="block" v-for="size in sizeList" :key="size">
          <el-avatar :size="size" :src="circleUrl"></el-avatar>
        </div>
        <div>
          <span style="color: white">{{teacherName}}</span>
        </div>
      </div>
      <el-col :span="12" style="width: 200px ;margin-left:2px;background-color: rebeccapurple">
        <el-menu
            style="width: 200px ;margin-left:2px;min-height: 100vh;border-radius: 10px"
            default-active="1"
            class="el-icon-s-home"
            background-color=rebeccapurple
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-menu-item index="1" @click.native="$router.push('/home')">
            <i class="el-icon-s-home"></i>
            <span slot="title" >首页</span>
          </el-menu-item>

          <el-menu-item index="2" @click.native="$router.push('/markPaper')">
            <i class="el-icon-edit"></i>
            <span slot="title">批阅试卷</span>
          </el-menu-item>

          <el-menu-item index="3" @click.native="$router.push('/releasePaper')">
            <i class="el-icon-s-marketing" ></i>
            <span slot="title">发布考试</span>
          </el-menu-item>

          <el-menu-item index="4" @click.native="$router.push('/invigilate')">
            <i class="el-icon-position"></i>
            <span slot="title">监考考试</span>
          </el-menu-item>

          <el-menu-item index="5" @click.native="$router.push('/question')">
            <i class="el-icon-document"></i>
            <span slot="title">试题中心</span>
          </el-menu-item>

          <el-menu-item index="6" @click.native="$router.push('/paper')">
            <i class="el-icon-notebook-2"></i>
            <span slot="title">试卷中心</span>
          </el-menu-item>

        </el-menu>
      </el-col>
    </div>
    <!--内容  -->
    <div style="display: flex; background-color: whitesmoke;">
      <router-view/>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "myLayout",
  components:{
  },
  data(){
    return{
      gatherInfo:{
        img:"icon2.jpg"
      },
      teacherName:'默认名字'
  }
  },
  created() {
    this.getTeacherInfo();
  },
  methods:{
    test(){
    },
    getImgUrl(img){
      return require("@/assets/"+img)
    },
    getTeacherInfo(){   //获取老师信息
      if(this.$cookies.get("teacherId")==null){
        this.$router.push('/')
      }else {
      request.get("api/teacher",{
        params:{
          teacherId:this.$cookies.get("teacherId")
        }
      }).then(resp=>{
          this.teacherName= resp.data.teacherName;
          this.gatherInfo.img = resp.data.icon
      })
      }
    },
    loginOut(){   //退出登录
        this.$cookies.remove("teacherId")
        this.$router.push('/')
    }
  }
}
</script>

<style scoped>

</style>