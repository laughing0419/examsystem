<template>
 <div class="examCenter">
   <el-card>
     <div slot="header" class="clearfix">
       <span style="font-size: 14px">我的考试</span>
     </div>
     <div class="boxcard">
       <div class="boxcard-inline">
         <label class="card-label" style="width: 100px">考试名称</label>
         <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search"></el-input>
         &nbsp;
         <el-button type="primary">搜索</el-button>
       </div>
     </div>
   </el-card>
   <el-card style="margin-top: 10px">
     <el-card class="box-card">
       <div class="box-container">
         <div style="margin: 5px">考试名称:  {{exam.ename}}</div>
         <div style="margin: 5px">考试课程:  {{exam.course}}</div>
         <div style="margin: 5px">考试时间:  {{exam.etime}}</div>
       </div>
       <el-button type="primary" size="small" @click="$router.push('/preexam')">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div style="margin: 5px">考试名称:</div>
         <div style="margin: 5px">考试课程:</div>
         <div style="margin: 5px">考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div>考试名称:</div>
         <div>考试课程:</div>
         <div>考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div>考试名称:</div>
         <div>考试课程:</div>
         <div>考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div>考试名称:</div>
         <div>考试课程:</div>
         <div>考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div>考试名称:</div>
         <div>考试课程:</div>
         <div>考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
     <el-card class="box-card">
       <div class="box-container">
         <div>考试名称:</div>
         <div>考试课程:</div>
         <div>考试时间:</div>
       </div>
       <el-button type="primary" size="small">进入考试</el-button>
     </el-card>
   </el-card>

 </div>
</template>

<script>
export default {
  name: "examcenter",
  data(){
    return{
      exam:{
        ename:'数据结构第一次期末考试',
        course:'数据结构',
        etime:'2019.12.1 12:00'
      }
    }
  }
}
</script>

<style scoped>

.box-card{
  font-size: 14px;
  height: 140px;
  width: 300px;
  float: left;
  margin: 20px;
}
.box-card .box-container{
  margin-bottom: 10px;
  border: 10px;
}
.boxcard{
  margin-bottom: 15px;
}
.boxcard .boxcard-inline{
  margin-bottom: 5px;
  margin-right: 10px;
  vertical-align: middle;
  position: relative;
}
.card-label{
  max-width: 100%;
  margin-bottom: 5px;
  position: relative;
  float: left;
  display: block;
  padding: 9px 15px;
  font-weight: 400;
  line-height: 20px;
  text-align: right;
  font-size: 14px;
}

</style>
