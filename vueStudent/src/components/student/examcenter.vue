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
         <el-button type="primary">搜索</el-button>
       </div>
     </div>
   </el-card>
   <el-card style="margin-top: 10px">
     <el-card class="box-card" v-for="exam in exams">
       <div class="box-container" >
         <div style="margin: 5px">考试名称:  {{exam.description}}</div>
         <div style="margin: 5px">考试课程:  {{exam.source}}</div>
         <div style="margin: 5px">考试时间:  {{exam.examDate}}</div>
       </div>
<!--       $router.push('/preexam')-->
       <el-button type="primary" size="small" @click="enter" v-if="exam.tag==='进行中'">进入考试</el-button>
       <el-button type="danger" size="small"   disabled v-if="exam.tag==='未开始'">未开始</el-button>
       <el-button type="warning" size="small"   disabled v-if="exam.tag==='已结束'">已结束</el-button>
     </el-card>
   </el-card>

 </div>
</template>

<script>
import request from "@/utils/request";
import moment from "moment";
export default {
  name: "examcenter",
  created() {
    this.getExamInfo();
  },
  data(){
    return{
      exams:[],
      notStarted:false,
      hasEnd:false,
      flag:0,
    }
  },
  methods: {
    getExamInfo() {
      //当前时间
      let currentTime = this.dateFormat(new Date());
      request.get("/api/examManage/queryExam").then(resp => {
        for (let i = 0; i < resp.data.length; i++) {
          let time = moment(resp.data[i].examDate).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
          resp.data[i].examDate = time
          if (this.formatGap(time, currentTime) < 0) {
            resp.data[i].tag = '未开始'
          } else if (this.formatGap(time, currentTime) >= 0 && this.formatGap(time, currentTime) <= resp.data[i].totalTime) {
            resp.data[i].tag = '进行中'
          } else {
            resp.data[i].tag = '已结束'
          }
        }
        this.exams = resp.data
      })
    },
    //计算时间和
    formatAdd(start, totalTime) {
      let hour = parseInt(totalTime / 60);
      let min = totalTime % 60;
      let startTime = new Date(start);
      let addHour = startTime.setHours(startTime.getHours() + hour);
      let addMin = startTime.setMinutes(startTime.getMinutes() + min);
      return moment(new Date(addMin)).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
    },
    //获取当前时间
    dateFormat(time) {
      var date = new Date(time);
      var year = date.getFullYear();
      /* 在日期格式中，月份是从0开始的，因此要加0
       * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
       * */
      var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
      var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
      var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
      // 拼接
      return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
    },
    //时间差  分钟
    formatGap(start, end) {
      // let staytimeGap = new Date().getTime() - new Date(start).getTime();
      let staytimeGap = new Date(end).getTime() - new Date(start).getTime();
      let stayHour = Math.floor(staytimeGap / (3600 * 1000));  // 小时
      let leave1 = staytimeGap % (3600 * 1000);
      let stayMin = Math.floor(leave1 / (60 * 1000));  // 分钟
      let leave2 = leave1 % (60 * 1000);
      let staySec = Math.floor(leave2 / 1000);   // 秒
      // return stayHour * 60 + stayMin
      return stayHour * 60 + stayMin + staySec / 60;
    },
    enter() {
      let formatGap1 = 0;
      if (this.$cookies.get("flag") ===null) {
        /*获取进入考试的时间*/
        let currentTime = this.dateFormat(new Date())
        this.$router.push('/preexam')
        for (let i = 0; i < this.exams.length; i++) {
          if (this.exams[i].tag === '进行中') {
            /*获得总时间*/
            let totalTime = this.exams[i].totalTime
            /*获得开始时间*/
            let startTime = this.exams[i].examDate
            /*获得结束时间*/
            let endTime = this.formatAdd(startTime, totalTime);
            /*计算考试结束时间*/
            formatGap1 = this.formatGap(currentTime, endTime);
            /*设置cookies过期时间*/
            this.$cookies.set("paperId", this.exams[i].paperId, formatGap1 * 60)
          }
        }
        this.$cookies.set("flag",this.flag++,formatGap1 * 60);    //设置flag标记考试状态
        console.log(this.flag)
        let paperId = this.$cookies.get("paperId");
        console.log(paperId)
      }
      else {
        alert("你已经交卷!")
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
