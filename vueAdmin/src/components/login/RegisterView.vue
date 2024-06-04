<template>
  <div id="registerView">
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
      <el-row class="register-container">
        <h2 class="title-zc">用户注册</h2>
        <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px" class="register-form">
          <el-form-item label="账号" prop="username">
            <el-input v-model.number="form.username"></el-input>
          </el-form-item>
          <el-form-item label="昵称" prop="nickname">
            <el-input v-model.number="form.nickname"></el-input>
          </el-form-item>
          <el-form-item label="联系方式" prop="phone">
            <el-input v-model.number="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="form.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="form.checkPass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="人脸注册">
            <div @click="camera()">
              <el-button>去拍照</el-button>
            </div>
            <face-register v-if="cameraVisible" name="cameraPreview" ref="cameraPreview"></face-register>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('form')">提交</el-button>
            <el-button @click="resetForm('form')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-row>
    </div>
  </div>
</template>

<script>
import FaceRegister from "@/components/login/cameraPreview";
import axios from "axios";
export default {
  name: "Register",
  components: {FaceRegister},
  data(){
    var validatePhone = (rule,value,callback) =>{
      if(value ===""){
        callback(new Error("请输入手机号"));
      } else{
        if(value !== ""){
          var reg=/^1[3456789]\d{9}$/;
          if(!reg.test(value)){
            callback(new Error("请输入有效的手机号码"));
          }
        }
        callback();
      }
    };
    var validateEmail = (rule,value,callback) =>{
      if(value === ""){
        callback(new Error("请正确填写邮箱"));
      }else {
        if(value !== ""){
          var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
          if(!reg.test(value)){
            callback(new Error("请输入有效的邮箱"));
          }
        }
      }
    }
    var validatePass =(rule, value, callback) =>{
      //rule:password的详细值，value:password的值，callback:如果不满足，则正常提交
      if (value === ""){
        callback(new Error("请输入密码"));
      } else {
        if(this.form.checkPass !==""){
          this.$refs.form.validateField("checkPass");  //如果确认密码不为空，则去validatePass2这个函数
        }
        callback();
      }
    };
    var validatePass2 =(rule,value,callback) =>{
      if(value === ""){
        callback(new Error("请再次输入密码"));
      }else if(value !== this.form.password){
        callback(new Error("两次密码不一致！"));
      }else {
        callback();
      }
    }
    return{
      cameraVisible:false,
      form:{
        username:'',
        nickname:'',
        phone:'',
        password:'',
        email:'',
        checkPass:'',
      },
      rules:{
        username: [
          {required:true,message:"请输入账号",trigger:"blur"}
        ],
        nickname: [
          {required:true,message:"请输入昵称",trigger:"blur"}
        ],
        phone:[
          {validator:validatePhone,trigger:"blur"}
        ],
        // email: [
        //   {validator:validateEmail,trigger:"blur"}
        // ],
        password: [
          {validator:validatePass,trigger:"blur"}
        ],
        checkPass: [
          {validator:validatePass2,trigger:"blur"}
        ]
      }
    }
  },
  methods:{
    //打开相机
    camera(cameraType){
      this.cameraVisible = true
      this.$nextTick(() => {
        this.$refs.cameraPreview.init()
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) =>{
        if (valid){
          alert("注册成功！");
        } else {
          console.log("提交失败");
          return false;
        }
      });
      console.log(this.picValueZero)
      console.log(this.form)
    },
    resetForm(formName){
      this.$refs[formName].resetFields();
    },
  },
}
</script>

<style scoped>
.liZi{
  position: fixed;
  top: 0;
  width: 100%;
}
.register-container{
  position: absolute;
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
}
.register-form{
  width: 350px;
  margin: 50px auto;
  background-color: rgba(90,187,211,0.7);
  padding: 30px;
  border-radius: 20px;
}
.title-zc{
  text-align: center;
}
</style>
