<template>
<div>
  <div v-show="tableVisible">
  <el-table
      :data="tableStudentPaper"
      border
      style="width: 100%"
  >
    <el-table-column
        fixed
        prop="studentId"
        label="学号"
        width="150">
    </el-table-column>
    <el-table-column
        prop="subject"
        label="考试科目"
        width="120">
    </el-table-column>
    <el-table-column
        prop="obScore"
        label="客观题得分"
        width="120">
    </el-table-column>
    <el-table-column
        prop="subScore"
        label="主观题得分"
        width="120">
    </el-table-column>
    <el-table-column
        prop="score"
        label="总分"
        width="120"
        >
    </el-table-column>
    <el-table-column
        prop="createTime"
        label="交卷时间"
        width="450">
    </el-table-column>
    <el-table-column
        fixed="right"
        label="操作"
        width="220"
    >
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="medium">批阅试卷</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
  <div style="width: 1300px;">
    <div v-show="questionVisible" style="background-color: white">
      <p>填空题</p>
      <div v-for="(item,index) in fill" :key="index" style="margin-left: 20px">
        <p>{{item.question}}({{item.score}}分)
          <span style="margin-left: 1100px">老师评分:</span>
          <el-input style="float: right;width: 100px" v-model="form.textArray[index] " @change="hand(item,item.questionId,index,)"></el-input>
        </p>
        学生答案:<el-input readonly="true" v-model="item.studentAnswer" type="textarea" style="width: 500px"></el-input><br/>
        正确答案:<el-input readonly="true" v-model="item.rightAnswer" type="textarea" style="width: 500px;margin-top: 10px"></el-input>
        <div class="line" style="margin-top: 20px"/>
      </div>
      <div style="text-align: center">
        <el-button @click="submitScore" type="primary">提交</el-button>
      </div>
    </div>


  </div>
</div>
</template>

<script>
import request from "@/utils/request";
import moment from "moment";
export default {
  name: "MarkPaper",
  data(){
    return{
      tableVisible:true,
      questionVisible:false,
      tableStudentPaper:[{
        studentName:'张三',
        studentId:201904401,
        subject:'计算机网络原理',
        obScore:16,
        subScore:'',
        score:'',
        createTime:'',
      },],
      form:{ textArray: []},
      fill:[{}],
      paperManage:[{}],
      value:[],
    }
  },
  created() {
    if(this.$cookies.get("studentId")!=null){
      this.getStudentPaper();
    }else {
      console.log("不行")
    }
      this.getScore();
    },
  methods:{
    submitScore(){
      request.get("/api/examManage/fillStudent",{
        params:{
          studentId:this.$cookies.get("studentId")
        }
      }).then(resp=>{
        console.log(resp)
      })
      request.post("/api/examManage/statisticalScore",this.value).
      then(resp=>{
        console.log(resp)
      })
      console.log(this.value)
      this.$cookies.remove("studentId")
      this.tableVisible =true;
      this.questionVisible = false;
    },
    hand(item,id,index){
      let aa = {questionId:id,score:this.form.textArray[index]}
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
    handleClick(row){
      this.$cookies.set("studentId",row.studentId)
      this.tableVisible = false;
      this.questionVisible=true;
},
    getScore(){
      request.get("/api/score/getAllScore").
      then(resp=>{
        for(let i=0;i<resp.data.length;i++){
          resp.data[i].createTime = moment(new Date(resp.data[i].createTime)).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
        }
        this.tableStudentPaper = resp.data
      })
    },
    getStudentPaper(){

      request.get("/api/studentPaper",{
        params:{
          studentId:this.$cookies.get("studentId")
        }
      }).then(resp=>{
        console.log(resp)
        let paperId = resp.data[0].paperId
        request.get("/api/paperManage/queryPaperManageById",{
          params:{
            paperId
          }
        }).then(res=>{

          this.paperManage = res.data
          for (let i=0;i<this.fill.length;i++){
            this.fill[i].score = this.paperManage[i].score
            console.log("分数-----"+this.paperManage[i].score)
          }
        })
        /*for(let i =0;i<resp.data.length;i++){
          this.fill[i].score = resp.data[i].score;
          this.fill[i].studentAnswer = resp.data[i].studentAnswer;
          this.fill[i].rightAnswer = resp.data[i].rightAnswer;
        }*/
        this.fill =resp.data

      })
      console.log(this.fill)
    }
  }
}
</script>

<style scoped>
.line{
  float:right;
  width: 100%;
  height: 1px;
  margin-top: -0.5em;
  background:#d4c4c4;
  position: relative;
  text-align: center;
}
</style>