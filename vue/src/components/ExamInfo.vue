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
  <!--内容-->
  <div style="border: 1px ;height: 96vh;margin-left: 20px;margin-top: 30px;background-color: white;">
    <el-form ref="form" :model="form"  :rules="rules"  label-width="80px" style="padding:20px">
      <el-form-item label="*考试描述" >
        <el-input v-model="form.description" placeholder="2022年上期期末考试"></el-input>
      </el-form-item>
      <el-form-item label="*考试科目" >
        <el-input v-model="form.source" placeholder="计算机网络原理"> </el-input>
      </el-form-item>
      <el-form-item label="考试年级">
        <el-select v-model="form.grade" placeholder="请选择考试年级">
          <el-option label="2018" value="2018"></el-option>
          <el-option label="2019" value="2019"></el-option>
          <el-option label="2020" value="2020"></el-option>
          <el-option label="2021" value="2021"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="考试学期">
        <el-select v-model="form.term" placeholder="请选择考试学期">
          <el-option label="第一学期" value="1"></el-option>
          <el-option label="第二学期" value="2"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="考试专业">
        <el-select v-model="form.major" placeholder="请选择考试专业">
          <el-option label="软件工程" value="软件工程"></el-option>
          <el-option label="网络工程" value="网络工程"></el-option>
          <el-option label="物联网工程" value="物联网工程"></el-option>
          <el-option label="大数据" value="大数据"></el-option>
          <el-option label="数字媒体" value="数字媒体"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="*考试日期">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-time-picker placeholder="选择时间" v-model="form.examDate" style="width: 100%;" value-format="yyyy-MM-ddTHH:mm:ss"></el-time-picker>
        </el-col>
      </el-form-item>

      <el-form-item label="考试时间">
        <el-select v-model="form.totalTime" placeholder="请选择考试总时长">
          <el-option label="90分钟" value="90"></el-option>
          <el-option label="120分钟" value="120"></el-option>
          <el-option label="150分钟" value="150"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试总分">
        <el-select v-model="form.totalScore" placeholder="请选择考试总时长">
          <el-option label="100分" value="100"></el-option>
          <el-option label="120分" value="120"></el-option>
          <el-option label="150分" value="150"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试类型">
        <el-select v-model="form.type" placeholder="请选择考试总时长">
          <el-option label="期中考试" value="期中考试"></el-option>
          <el-option label="期末考试" value="期末考试"></el-option>
          <el-option label="平时测试" value="平时测试"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试须知">
        <el-input type="textarea" v-model="form.tips"></el-input>
      </el-form-item>
    </el-form>

    <div style="width: 100%;position: fixed;bottom: 0px;background-color: whitesmoke">
      <el-button type="primary" style="margin-left: 550px;width: 150px" @click="next" >保存&去设计师卷</el-button>
    </div>


  </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
name: "DesignPaper",
  data() {
    return {
      active: 0,
      form: {},
      flag:0,   //标识
    };
  },

  methods: {
    next() {
      if (this.form.description!=null
          &&this.form.source!=null
          &&this.form.examDate!=null)
      {
        if(this.flag===0){
          request.post("/api/examManage",this.form).
          then(resp=>{
            console.log(resp)
          })
          this.$router.push('/designPaper')
          this.flag++;
        }else {
          request.put("/api/examManage",this.form).
          then(resp=>{
            console.log(resp)
          })
          this.$router.push('/designPaper')
        }

        console.log(this.form.examDate)
        console.log(this.flag)
      }else {
        this.$message({
          message: '带*的不能为空噢~',
          type: 'warning'
        });

      }
    },

  }
}
</script>

<style scoped>

</style>