<!--登陆界面-->
<template>
  <div id="login">
    <div>
      <vue-particles
          color="#555"
          :particleOpacity="0.7"
          :particles-number="150"
          shape-type="circle"
          :particle-size="4"
          lines-color="#555"
          :lines-width="1"
          :line-linked="true"
          line-opacity="0.4"
          lines-distance="150"
          :move-speed="2"
          :hover-effect="true"
          hover-mode="grab"
          :click-effect="false"
          click-mode="push"
          class="liZi"
      ></vue-particles>
    </div>
    <el-row class="main-container">
      <el-col :lg="8" :xs="16" :md="10" :span="10">
        <div class="top">
          <i class="iconfont icon-kaoshi"></i><span class="title">在线考试系统</span>
        </div>
        <div class="bottom">
          <div class="container">
            <p class="title">账号登陆</p>
            <el-form :label-positon="labelPosition" label-width="80px" :model="formLogin">
              <el-form-item label="用户名">
                <el-input v-model="formLogin.teacherId" prefix-icon="el-icon-user" placeholder="请输入用户名"></el-input>
              </el-form-item>
              <el-form-item label="密码">
                <el-input v-model="formLogin.pwd" prefix-icon="el-icon-lock" placeholder="请输入密码" type="password"></el-input>
              </el-form-item>
              <el-form-item label="身份">
                <el-radio-group v-model="formLogin.role">
                  <el-radio label="教师" value="1"></el-radio>
                  <el-radio label="学生" value="2"></el-radio>
                  <el-radio label="管理员" value="0"></el-radio>
                </el-radio-group>
              </el-form-item>
              <div class="submit">
                <el-button type="primary" class="row-login" @click="login()">登录</el-button>
              </div>
              <div class="options">
                <span><a href=" ">找回密码</a> </span>
                <div class="register">
                  <span>没有账号？</span>
                  <span><router-link to="/register">去注册</router-link></span>
                </div>
              </div>
            </el-form>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-row class="footer">
      <el-col>
        <p class="msg2">版权所有 ©2022<!--南华大学软工2班411团队--> 保留所有权利</p>
      </el-col>
    </el-row>
  </div>

</template>

<script>

import request from "@/utils/request";

export default {
  name: "LoginView",
  data(){
    return{
      labelPosition: 'right',
      formLogin:{},
    }
  },
  methods:{
    //用户登录
    login(){
      if (this.formLogin.teacherId!=null&&this.formLogin.pwd!=null&&this.formLogin.role!=null){
      if(this.formLogin.role==='教师'){
        console.log(this.formLogin)
        request.post("/api/login/teacher",this.formLogin).
        then(resp=>{
          if(resp.code==='0'){
            this.$message({
              type:'success',
              message:resp.msg,
            })
            this.$router.push('/home')
          }else if(resp.code==='-1'){
            this.$message({
              type:'warning',
              message:resp.msg,
            })
          }else {
            this.$message({
              type:'error',
              message:resp.msg,
            })
          }
          console.log(resp)
        })
      }else if(this.formLogin.role==='学生'){
        this.$message({
          type:"warning",
          message:'你无权限'
        })
      }else {
        this.$message({
          type:"success",
          message:'模拟登录'
        })
      }
    }else {
        this.$message({
          type:'warning',
          message:'请输入账号或者密码!'
        })
      }
  }
}
}
</script>

<style scoped>
.liZi{
  position: fixed;
  top: 0;
  width: 100%;
}
.remind {
  border-radius: 4px;
  padding: 10px 20px;
  display: flex;
  position: fixed;
  right: 20px;
  bottom: 50%;
  flex-direction: column;
  color: #606266;
  background-color: #fff;
  border-left: 4px solid #409eff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)
}
.container {
  margin-bottom: 32px;
}
.container .el-radio-group {
  margin: 30px 0;
}
a:link {
  color:#ff962a;
  text-decoration:none;
}
#login {
  height: 100vh;
  font-size: 14px;
  color: #000;
  background-color: #fff;
  overflow-y: hidden;
}

#login .main-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
#login .main-container .top {
  margin-top: 100px;
  font-size: 30px;
  color: #ff962a;
  display: flex;
  justify-content: center;
}
#login .top .icon-kaoshi {
  font-size: 80px;
}
#login .top .title {
  margin-top: 20px;
}
#login .bottom {
  display:flex;
  justify-content: center;
  background-color:#fff;
  border-radius: 5px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
#login .bottom .title {
  text-align: center;
  font-size: 30px;
}
.bottom .container .title {
  margin: 30px 0;;
}
.bottom .submit .row-login {
  width: 100%;
  background-color: #04468b;
  border-color: #04468b;
  margin: 20px 0 10px 0;
  padding: 15px 20px;
}
.bottom .submit {
  display: flex;
  justify-content: center;
}
.footer {
  margin-top: 50px;
  text-align: center;
}
.footer .msg1 {
  font-size: 18px;
  color: #fff;
  margin-bottom: 15px;
}
.footer .msg2 {
  font-size: 14px;
  color: #e3e3e3;
  margin-top: 70px;
}
.bottom .options {
  margin-bottom: 40px;
  color: #ff962a;
  display: flex;
  justify-content: space-between;
}
.bottom .options > a {
  color: #ff962a;
}
.bottom .options .register span:nth-child(1) {
  color: #8C8C8C;
}
</style>
