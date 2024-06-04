<template>
<div>
  <el-descriptions title="个人基本资料" :column="3" border style="padding-top: 50px ;padding-left:20px;padding-right: 20px;">
    <template slot="extra">
      <el-button type="primary" size="big" @click="edit">编辑</el-button>
    </template>
    <el-descriptions-item label="姓名" label-class-name="my-label" content-class-name="my-content" >{{teacherName}}</el-descriptions-item>
    <el-descriptions-item label="手机号">{{ tel }}</el-descriptions-item>
    <el-descriptions-item label="居住地">{{ residence }}</el-descriptions-item>
    <el-descriptions-item label="单位">
      <el-tag size="small">{{ school }}</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="学院">{{ institute }}</el-descriptions-item>
    <el-descriptions-item label="性别">{{ sex }}</el-descriptions-item>
    <el-descriptions-item label="邮箱">{{ email }}</el-descriptions-item>
    <el-descriptions-item label="联系地址" :contentStyle="{'text-align': 'left'}">{{ address }}</el-descriptions-item>
  </el-descriptions>

  <el-dialog title="修改信息" :visible.sync="dialogFormVisible" width="30%">
    <el-form :model="form" label-width="80px">
      <el-form-item label="姓名" style="width: 100%">
        <el-input v-model="form.teacherName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="手机号" style="width: 100%">
        <el-input v-model="form.tel" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="居住地" style="width: 100%">
        <el-input v-model="form.residence" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio v-model="form.sex" label="男">男</el-radio>
        <el-radio v-model="form.sex" label="女">女</el-radio>
        <el-radio v-model="form.sex" label="未知">未知</el-radio>
      </el-form-item>
      <el-form-item label="邮箱" style="width: 100%">
        <el-input v-model="form.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="居住地" style="width: 100%">
        <el-input v-model="form.residence" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="联系地址" style="width: 100%">
        <el-input v-model="form.address" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>

      <el-button type="primary" @click="update">修 改</el-button>
    </div>
  </el-dialog>

</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "myTeacherInfo",
  data(){
    return{
      teacherName:'',
      tel:'',
      residence:'',
      school:'南华大学',
      address:'',
      institute:'',
      sex:'',
      email:'',
      dialogFormVisible:false,
      form:{}
    }
  },
  created() {
    this.getTeacherInfo()
  },
  methods:{
    edit(){
        this.dialogFormVisible =true;
    },
    getTeacherInfo(){   //获取老师信息
        request.get("api/teacher",{
          params:{
            teacherId:this.$cookies.get("teacherId")
          }
        }).then(resp=>{
          this.teacherName= resp.data.teacherName;
          this.tel = resp.data.tel;
          this.residence = resp.data.residence;
          this.address = resp.data.address;
          this.institute = resp.data.institute;
          this.sex = resp.data.sex;
          this.email = resp.data.email;
          this.form = resp.data
        })
      },
    update(){     //修改个人信息
      this.dialogFormVisible =false
      request.put("api/teacher/updateInfo",this.form).then(resp=>{
        if(resp.code==='0'){
          this.$message({
            type:"success",
            message:resp.msg
          })
          this.getTeacherInfo()
        }else {
          this.$message({
            type:"error",
            message:resp.msg
          })
        }
      })
    }
    },
}
</script>

<style scoped>

</style>