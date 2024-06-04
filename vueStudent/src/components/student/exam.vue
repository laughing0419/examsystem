<template>
  <div class="cognizance-box ">
<!--头部-->
<!--  <div style="width: 100%;position: fixed;bottom: 0px;background-color: whitesmoke">    -->
    <div style="width: 100%;height:5vh;border: 1px solid;background-color: whitesmoke;position: fixed;top: 0px">
      <div style="margin-top: 10px;font-size: medium">
      <span>考试科目:{{source}}</span>
      <span style="margin-left: 50px">考生姓名:{{studentName}}</span>
      <span style="margin-left: 50px">考试总分：{{totalScore}}分</span>
      <span style="margin-left: 50px">考试时长：{{totalTime}}分钟</span>
      <span style="margin-left: 50px"><el-button type="primary" size="mini" @click="toMulti">进入选择题</el-button></span>
      <span style="margin-left: 50px"><el-button type="primary" size="mini" @click="toFill">进入填空题</el-button></span>
      <span style="margin-left: 50px"><el-button type="primary" size="mini" @click="toJudge">进入判断题</el-button></span>
      <span style="margin-left: 50px"><el-button type="primary" size="mini" @click="dialogVisible=true">交卷</el-button></span>
      <span style="float: right">倒计时：{{count}}</span>
      </div>
    </div>

<!--    内容-->
    <div style="margin-left: 100px;margin-right: 100px;border: 1px solid;height: 100%">
<!--      选择题-->
      <div v-show="multiVisible"style="margin-left: 10px">
      <p style="font-size: large;margin-top: 50px">一、选择题</p>
      <div class="multi" v-for="(item,index) of multi ":key="index">
<!--      题目-->
        <p style="font-size: medium">{{item.question}}({{item.score}}分)</p>
<!--        选项-->
        <el-radio-group v-model="form.radioArray[index]" @change="hand(item,item.questionId,item.score,index)" style="font-size: medium">
          <el-radio :label="'A. '+item.answerA" :value="item.answerA"></el-radio>
          <el-radio :label="'B. '+item.answerB" :value="item.answerB"></el-radio>
          <el-radio :label="'C. '+item.answerC" :value="item.answerC"></el-radio>
          <el-radio :label="'D. '+item.answerD" :value="item.answerD"></el-radio>
        </el-radio-group>
      </div>
    </div>
      <!--判断题-->
      <div v-show="judgeVisible">
        <p style="font-size: large;margin-top: 50px">三、判断题</p>
        <div class="judge" v-for="(item,index) of judge ":key="index">
          <!--      题目-->
          <p>{{item.question}}({{item.score}}分)</p>
          <!--        选项-->
          <el-radio-group v-model="formJudge.radioArray[index]" @change="handJudge(item,item.questionId,item.score,index)">
            <el-radio :label='item.answerA' :value="item.answerA"></el-radio>
            <el-radio :label="item.answerB" :value="item.answerB"></el-radio>
          </el-radio-group>
        </div>
      </div>
<!--填空题-->
      <div v-show="fillVisible">
        <p style="font-size: large;margin-top: 50px">二、填空题</p>
        <div class="fill" v-for="(item,index) of fill ":key="index">
          <!--      题目-->
          <p>{{item.question}}({{item.score}}分)</p>
            答案：<el-input v-model="formFill.textArray[index]" @change="handFill(item,item.questionId,index,item.score)"></el-input>
        </div>
      </div>

      <el-dialog
          title="交卷提示"
          :visible.sync="dialogVisible"
          width="30%"
          >
        <span>你还有剩余的时间确定不好好检查一下吗？再确认一下是否交卷！</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">否</el-button>
    <el-button type="primary" @click="HandInThePaper">是</el-button>
  </span>
      </el-dialog>
  </div>
    <el-button @click="test"></el-button>
  </div>
</template>

<script>
import request from "@/utils/request";
import moment from "moment";
export default {
  name: "",
  data() {
    return {
      flag:0,
      /*选择题*/
      multi: [],
      form:{ radioArray: []},
      value:[],
      multiVisible:true,
      /*判断题*/
      judge:[],
      formJudge:{ radioArray: []},
      valueJudge:[],
      judgeVisible:false,
      /*填空题*/
      fill:[],
      formFill:{textArray:[]},
      valueFill:[],
      fillVisible:false,
      /*其他基本信息*/
      source:'计算机网络原理',
      studentName:'钱七',
      totalScore:0,
      totalTime:0,
      count: '', //倒计时
      seconds: this.totalTime*60 ,// 时间的秒数,
      examDate:'',
      dialogVisible:false   //交卷
    }
  },
  mounted() {
    this.Time() //调用定时器
  },
  created() {
    if(this.$cookies.get("paperId")===null){
      this.$message({
        type:"success",
        message:'考试结束！',
      })
      this.$router.push('/mygrades')
    }
    this.getStudent();
    this.getExam();
    this.getMulti();
    this.getJudge();
    this.getFill();

  },
  methods: {
    /*存答案*/
    hand(item,id,score,index){
      let aa = {questionId:id,answer:this.form.radioArray[index],score:score}
      this.value.push(aa)
      for (let i =0;i<this.value.length;i++){
        for (let j=i+1;j<this.value.length;j++){
          if(this.value[i].questionId == this.value[j].questionId){
            this.value.splice(i,1);
            j--;
          }
        }
      }
    },
    handJudge(item,id,score,index){
      let aa = {questionId:id,answer:this.formJudge.radioArray[index],score:score}
      this.valueJudge.push(aa)
      for (let i =0;i<this.valueJudge.length;i++){
        for (let j=i+1;j<this.valueJudge.length;j++){
          if(this.valueJudge[i].questionId == this.valueJudge[j].questionId){
            this.valueJudge.splice(i,1);
            j--;
          }
        }
      }
    },
    handFill(item,id,index,score){
      let aa = {questionId:id,answer:this.formFill.textArray[index],socre:score}
      this.valueFill.push(aa)
      for (let i =0;i<this.valueFill.length;i++){
        for (let j=i+1;j<this.valueFill.length;j++){
          if(this.valueFill[i].questionId == this.valueFill[j].questionId){
            this.valueFill.splice(i,1);
            j--;
          }
        }
      }
    },
    toMulti(){
      this.multiVisible = true;
      this.judgeVisible = false;
      this.fillVisible =false;
    },
    toFill(){
      this.multiVisible = false;
      this.judgeVisible = false;
      this.fillVisible =true;
    },
    toJudge(){
      this.multiVisible = false;
      this.judgeVisible = true;
      this.fillVisible =false;
    },
    /*获得考试学生*/
    getStudent(){
      request.get("api/student",{
        params:{
        studentId : this.$cookies.get("studentId")
        }
      }).then(resp=>{
        this.studentName = resp.data.studentName;
      })
    },
    /*获得考试试卷*/
    getExam(){
      request.get("/api/examManage/queryExamByPaperId",{
        params:{
          paperId:this.$cookies.get("paperId")
        }
      }).then(resp=>{
        this.totalTime = resp.data.totalTime;
        this.totalScore = resp.data.totalScore;
        this.examDate =moment(new Date(resp.data.examDate)).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
        this.source = resp.data.source;
      })
    },
    /*交卷*/
    HandInThePaper(){
      request.get("/api/examManage/getStudentAndPaper",{
        params:{
          studentId:this.$cookies.get("studentId"),
          paperId:this.$cookies.get("paperId"),
        }
      })
      request.post("/api/examManage/markMulti",this.value).
      then(resp=>{
        console.log(resp)
      })
      request.post("/api/examManage/markJudge",this.valueJudge).
      then(resp=>{
        console.log(resp)
      })
      request.post("/api/examManage/markFill",this.valueFill).
      then(resp=>{
        console.log(resp)
      })
      this.$message({
        type:"success",
        message:'考试结束！',
      })
      this.$router.push('/mygrades')
    },
    test(){
      console.log(this.value)
      console.log(this.valueJudge)
      console.log(this.valueFill)
    },
    /*渲染考试题目*/
    getMulti(){
      request.get("/api/multiQuestion/queryForExam",{
        params:{
          paperId:this.$cookies.get("paperId")
        }
      }).then(resp=>{
        this.multi = resp.data

      })
    },
    getJudge(){
      request.get("api/judgeQuestion/queryForExam",{
        params:{
          paperId:this.$cookies.get("paperId")
        }
      }).then(resp=>{
        this.judge = resp.data
      })
    },
    getFill(){
      request.get("api/fillQuestion/queryForExam",{
        params:{
          paperId:this.$cookies.get("paperId")
        }
      }).then(resp=>{
        this.fill=resp.data
      })
    },
    // 天 时 分 秒 格式化函数
    countDown() {
      let d = parseInt(this.seconds / (24 * 60 * 60))
      d = d < 10 ? "0" + d : d
      let h = parseInt(this.seconds / (60 * 60) % 24);
      h = h < 10 ? "0" + h : h
      let m = parseInt(this.seconds / 60 % 60);
      m = m < 10 ? "0" + m : m
      let s = parseInt(this.seconds % 60);
      s = s < 10 ? "0" + s : s
      this.count = h + ':' + m + ':' + s
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
      return stayHour * 60 *60+ stayMin*60 + staySec;
    },
    //定时器没过1秒参数减1
    Time() {
      setInterval(() => {
        let gap = this.formatGap(this.examDate,this.dateFormat(new Date()));
        this.seconds = this.totalTime*60 - gap;      //总时间-
        this.seconds -= 1
        this.countDown()
      }, 1000)
    },
  }
}
</script>

<style scoped>
::v-deep .el-radio{
  display: block;
  margin:10px 0;
}
.cognizance-box {
  width: 100%;
  height: 100vh;
  overflow-y: scroll;
  margin: 0 auto;
}
</style>