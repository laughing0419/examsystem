<template>
  <div class="header">
      <div class="collapse-btn" @click="collapseChange">
        <i v-if="!collapse" class="el-icon-s-fold"></i>
        <i v-else class="el-icon-s-unfold"></i>
      </div>
    <div class="logo">ExaminationSystem</div>
    <div class="header-right">
      <div class="header-user-con">
        <!--全屏显示-->
        <div class="btn-fullscreen" @click="handleFullScreen">
          <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
            <i class="el-icon-rank"></i>
          </el-tooltip>
        </div>
        <!--消息中心-->
        <div class="btn-bell">
          <el-tooltip
            effect="dark"
            :content="message?`有${message}条未读消息`:`消息中心`"
            placement="bottom"
          >
            <router-link to="">
              <i class="el-icon-bell"></i>
            </router-link>
          </el-tooltip>
          <span class="btn-bell-badge" v-if="message"></span>
        </div>
        <!--用户头像-->
        <div class="user-avator">
          <el-avatar :size="50"  :src="getImgUrl(gatherInfo.img)"></el-avatar>
        </div>
        <!--用户名下拉菜单-->
        <el-dropdown class="user-name" trigger="click" @command="handleCommand">
          <span class="el-dropdown-link">
            {{name}}
            <i class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="info">个人中心</el-dropdown-item>
<!--            <el-dropdown-item divided command="loginout">退出登录</el-dropdown-item>-->
            <el-dropdown-item @click.native="loginOut">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
import bus from "@/assets/js/bus";
import vpersonal from '../student/personal'
import request from "@/utils/request";
export default {
  name: "header",
  data(){
    return{
      collapse:false,
      fullscreen:false,
      name:'默认名字',
      message:2,
      gatherInfo:{
        img:'student3.png',
      },
    };
  },
  components:{
    vpersonal
  },
  computed:{
    username(){
      let username = localStorage.getItem('ms_username');
      return username ? username : this.name;
    }
  },
  created() {
    this.getStudentInfo();
  },
  methods:{
    loginOut(){
      this.$cookies.remove("studentId");
      this.$cookies.remove("paperId")
      this.$router.push('/')
    },
    getImgUrl(img){
      return require('@/assets/img/'+img)
    },
    getStudentInfo(){
      if(this.$cookies.get("studentId")==null){
        this.$router.push('/')
      }else {
        request.get("api/student",{
          params:{
            studentId:this.$cookies.get("studentId")
          }
        }).then(resp=>{
          this.name = resp.data.studentName;
          this.gatherInfo.img = resp.data.icon
        })
      }
    },


    //个人信息
    info(){
      this.$router.push('/personal');
    },
    /*//用户下拉菜单选择事件
    handleCommand(command){
      if(command === 'loginout'){
        localStorage.removeItem('ms_username');
        this.$router.push('/');
      }
    },*/
    //侧边栏折叠
    collapseChange(){
      this.collapse = !this.collapse;
      bus.$emit('collapse',this.collapse);
    },
    //全屏事件
    handleFullScreen(){
      let element = document.documentElement;
      if(document.fullscreen){
        if(document.exitFullscreen){
          document.exitFullscreen();
        }else if (document.webkitCancelFullScreen){
          document.webkitCancelFullScreen();
        }else if (document.mozCancelFullScreen){
          document.mozCancelFullScreen();
        }else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if(element.requestFullscreen){
          element.requestFullscreen();
        }else if (element.webkitRequestFullScreen){
          element.webkitRequestFullScreen();
        }else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          // IE11
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    }
  },
  mounted() {
    if(document.body.clientWidth<1500){
      this.collapseChange();
    }
  }
}
</script>

<style scoped>
.header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #fff;
  background-color: #242f42;
}
.collapse-btn {
  float: left;
  padding: 0 21px;
  cursor: pointer;
  line-height: 70px;
}
.header .logo {
  float: left;
  width: 250px;
  line-height: 70px;
}
.header-right {
  float: right;
  padding-right: 50px;
}
.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}
.btn-fullscreen {
  transform: rotate(45deg);
  margin-right: 5px;
  font-size: 24px;
}
.btn-bell,
.btn-fullscreen {
  position: relative;
  width: 30px;
  height: 30px;
  text-align: center;
  border-radius: 15px;
  cursor: pointer;
}
.btn-bell-badge {
  position: absolute;
  right: 0;
  top: -2px;
  width: 8px;
  height: 8px;
  border-radius: 4px;
  background: #f56c6c;
  color: #fff;
}
.btn-bell .el-icon-bell {
  color: #fff;
}
.user-name {
  margin-left: 10px;
}
.user-avator {
  margin-left: 20px;
}
.user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.el-dropdown-link {
  color: #fff;
  cursor: pointer;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
