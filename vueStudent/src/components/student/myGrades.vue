<template>
  <div>
    <!--头部-->
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
    <!--表格-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column fixed align="center" prop="studentId" label="学号" width="200"></el-table-column>
      <el-table-column prop="subject" label="考试科目" width="150"></el-table-column>
      <el-table-column prop="obScore" align="center" label="客观题" width="100"></el-table-column>
      <el-table-column prop="subScore" align="center" label="主观题" width="100"></el-table-column>
      <el-table-column prop="score" label="总分" width="250"></el-table-column>
      <el-table-column prop="createTime" label="提交时间" ></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看试卷</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import moment from "moment";
export default {
  name: "myGrades",
  data(){
    return{
      currentPage:1,
      tableData:'',
    }
  },
  created() {
    this.getScore();
  },
  methods:{
    getScore(){
      request.get("/api/score/getStudentScore",{
        params:{
          studentId:this.$cookies.get("studentId")
        }
      }).
      then(resp=>{
        for(let i=0;i<resp.data.length;i++){
          resp.data[i].createTime = moment(new Date(resp.data[i].createTime)).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
        }
        this.tableData = resp.data
      })


    },
    handleClick(row){
      console.log(row);
    },
    handleSizeChange(val){
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val){
      console.log(`当前页: ${val}`);
    }
  }
}
</script>

<style scoped>
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
