<template>
  <div>
    <el-form :model="pdForm" :rules="rules" ref="pdForm" label-width="100px" class="demo-pdForm">
      <el-form-item label="旧密码" prop="oldPassword">
        <el-input v-model="pdForm.oldPassword" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input v-model="pdForm.newPassword" type="password" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="确认新密码" prop="againPassword">
        <el-input v-model="pdForm.againPassword" type="password" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="验证码" prop="verifyCode" class="verifyCodeItemCss">
        <el-input class="verify_css" v-model="pdForm.verifyCode" placeholder="请输入4位验证码" style="float: left ;width: 200px"></el-input>
        <div id="v-container"></div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('pdForm')">保存</el-button>
        <el-button @click="resetForm('pdForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {GVerify} from "@/assets/js/verifyCode";
import request from "@/utils/request";
export default {
  name: "per2",
  data(){
    return {
      pdForm: {
        oldPassword: '',
        newPassword: '',
        againPassword:'',
        verifyCode:''
      },
      rules:{
        oldPassword: [
          {required:true,message:'请输入旧密码',trigger:'blur'},
        ],
        newPassword: [
          {required:true,message:'请输入新密码',trigger:'blur'},
          {min:6,max:12,message: '长度在 6 到 12 个字符',trigger: 'blur'}
        ],
        againPassword: [
          {required:true,message:'请确认新密码',trigger:'blur'}
        ],
        verifyCode: null
      }
    };
  },
  mounted() {
    this.verifyCode = new GVerify('v-container')
  },
  methods:{
    submitForm(formName) {
      var that =this
      //获取验证码
      var verifyCode = this.pdForm.verifyCode
      var verifyFlag = this.verifyCode.validate(verifyCode)
      if(!verifyFlag){
        that.$notify.error({
          title:'系统提示',
          message:'验证码输入错误'
        })
        return;
      }else {
        that.$notify({
          title:'系统提示',
          message:'验证码输入正确',
          type:"success"
        })

      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          /*修改密码*/
          request.get("/api/student/updatePwd",{
            params:{
              studentId:this.$cookies.get("studentId"),
              oldPassword:this.pdForm.oldPassword,
              newPassword:this.pdForm.newPassword,
            }
          }).then(resp=>{
            if(resp.code==='0'){
              this.$message({
                type:"success",
                message:resp.msg
              })
              this.$cookies.remove("studentId")
              this.$router.push('/')
            }else if(resp.code==='-1'){
              this.$message({
                type:"warning",
                message:resp.msg
              })
              this.pdForm={}
            }else {
              this.$message({
                type:"warning",
                message:resp.msg
              })
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.verify_css{
  width: 45%;
}
#v-container{
  width: 100px;
  height: 40px;
  display: inline-flex;
}
</style>
