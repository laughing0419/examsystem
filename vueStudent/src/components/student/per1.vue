<template>

  <el-descriptions class="margin-top" title="个人信息" :column="3" :size="size" border>
    <template slot="extra">
      <el-button type="primary" size="small" @click="outerVisible = true">编辑</el-button>
      <el-dialog title="修改信息" :visible.sync="outerVisible">
        <el-form :model="user">
          <el-form-item label="用户名" :label-width="formLabelWidth">
            <el-input v-model="user.studentName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="手机号" :label-width="formLabelWidth">
            <el-input v-model="user.tel" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="班级" :label-width="formLabelWidth">
            <el-input v-model="user.clazz" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="学号/工号" :label-width="formLabelWidth">
            <el-input v-model="user.studentId" autocomplete="off" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="居住地" :label-width="formLabelWidth">
            <el-input v-model="user.residence" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio-group v-model="user.sex">
              <el-radio label="男">男</el-radio>
              <el-radio label="女">女</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="outerVisible = false">取消</el-button>
          <el-button type="primary" @click="save">确定</el-button>
        </div>
      </el-dialog>
    </template>

    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-user"></i>
        用户名
      </template>
      {{user.studentName}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-phone"></i>
        手机号
      </template>
      {{user.tel}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-s-home"></i>
        班级
      </template>
      {{user.clazz}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-s-custom"></i>
        学号/工号
      </template>
      {{user.studentId}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-location-outline"></i>
        居住地
      </template>
      {{user.residence}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-male"></i>
        性别
      </template>
      {{user.sex}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-tickets"></i>
        备注
      </template>
      <el-tag size="small">{{user.school}}</el-tag>
    </el-descriptions-item>
  </el-descriptions>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "per1",
  data(){
    return{
      size:'',
      outerVisible:false,
      formLabelWidth:'120px',
      user:{
        studentId:201912312,
        studentName:'',
        clazz:'',
        tel:'',
        residence:'衡阳市',
        school:'南华大学',
        sex:'',
      }
    }
  },
  created() {
    this.getStudentInfo();
  },
  methods:{
    getStudentInfo(){
      request.get("/api/student",{
        params:{
          studentId:this.$cookies.get("studentId")
        }
      }).then(resp=>{
        this.user.studentName = resp.data.studentName;
        this.user.clazz = resp.data.clazz;
        this.user.tel = resp.data.tel;
        this.user.studentId = resp.data.studentId;
        this.user.sex = resp.data.sex;
        this.user.residence = resp.data.residence;
      })
    },
    save(){
      request.put("/api/student/updateInfo",this.user).
      then(resp=>{
        if(resp.code==='0'){
          this.$message({
            type:'success',
            message:resp.msg,
          })
        }else {
          this.$message({
            type:'warning',
            message:resp.msg,
          })
        }
      })
      this.outerVisible = false;
    },

  }
}
</script>

<style scoped>

</style>
