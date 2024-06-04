<template>
<div>
  <!--  头部-->
  <div style="width: 1250px;margin: 10px 20px;">
    <el-steps :active="active" finish-status="success">
      <el-step title="考试信息"></el-step>
      <el-step title="设计试卷"></el-step>
      <el-step title="发布试卷"></el-step>
    </el-steps>
  </div>

  <!-- 内容-->
  <div style="background-color: white">
    <div style="border-bottom:1px solid silver ;font-size: large">
    <span style="margin-left: 20px;">以下任意一种方式通知考生参加考试</span>
    </div>
<!--    方式一-->
    <div>
    <div style="margin-left: 20px;margin-top: 20px">
    <span>1、将二维码发给考生，扫描参加考试</span>
    </div>
    <div class="demo-image__placeholder" style="width: 250px;height: 250px;margin-left: 400px;">
      <div class="block">
        <el-image :src="src"></el-image>
      </div>
    </div>
    </div>
<!--    方式二-->
    <div>
      <div style="margin-left: 20px;margin-top: 20px">
        <span>2、复制考试链接发给考生，打开链接参加考试</span>
        <el-input style="width: 350px;height: 50px;margin-left: 50px" v-model="link"></el-input>
        <el-button style="margin-left: 10px">复制链接</el-button>
      </div>
    </div>
<!--    方式三-->
    <div>
      <div style="margin-left: 20px;margin-top: 20px">
        <span>3、发送考试邮件，通知考生参加考试</span>
        <el-button class="el-icon-message" style="margin-left: 115px" @click="send">发送考试通知</el-button>
      </div>
    </div>
  </div>
  <!--底部-->
  <div>
    <div style="width: 100%;position: fixed;bottom: 0px;background-color: whitesmoke">
      <el-button type="primary" style="margin-left: 550px;width: 150px" @click="next" >完成</el-button>
    </div>
  </div>
  <el-dialog title="修改信息" :visible.sync="dialogFormVisible" width="60%">
    <el-form :model="form" label-width="80px">
      <el-form-item label="邮件标题" style="width: 100%">
        <el-input v-model="form.subject" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="邮件内容" style="width: 100%">
        <el-input type="textarea" v-model="form.messageText" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="收件人邮箱" style="width: 100%">
        <el-input type="textarea" v-model="form.addressee" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="save" >确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "CompleteDesign",
  data(){
    return{
      active:2,
      src: require('../assets/' + '2.png'),
      link:'https://mail.qq.com/',
      dialogFormVisible:false,
      form:{
      },
    }
  },
  methods:{
    send(){
      this.dialogFormVisible = true;
    },
    save(){
      request.get("/api/email",{
        params:{
          /*messageText:'你好啊',
          addressee:'1936018865@qq.com',
          subject:'你好啊！',*/
          subject:(this.form.subject).toString(),
          messageText:(this.form.messageText).toString(),
          addressee:(this.form.addressee).toString(),
        }
      }).then(res=>{
        console.log(res.msg)
      })
      this.dialogFormVisible = false
      this.$message({
        type:"success",
        message: "发送成功！",
      });
    },
    next(){
      alert("确认完成吗？");
      this.$router.push('/paper')
    }
  }
}
</script>

<style scoped>

</style>