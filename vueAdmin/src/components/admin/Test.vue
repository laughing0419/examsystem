<template>
  <div>
    <!--头部-->
    <el-card>
      <div slot="header" class="clearfix">
        <span style="font-size: 14px">试卷管理</span>
      </div>
      <div class="boxcard">
        <div class="boxcard-inline">
          <label class="card-label" style="width: 100px">考试名称</label>
          <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="description"></el-input>
          &nbsp;
          <el-button type="primary" @click="load">搜索</el-button>
          <el-button type="warning" @click="reset">重置</el-button>
        </div>
      </div>
    </el-card>、
    <!--表格-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column fixed align="center" prop="examCode" label="考试编号" width="100"></el-table-column>
      <el-table-column prop="description" label="试卷名称" width="200"></el-table-column>
      <el-table-column prop="source" align="center" label="课程名称" width="150"></el-table-column>
      <el-table-column prop="paperId" align="center" label="试卷编号" width="100"></el-table-column>
      <el-table-column prop="examDate" label="考试日期" width="250"></el-table-column>
      <el-table-column prop="totalTime" align="center" label="时长" width="80"></el-table-column>
      <el-table-column prop="grade" align="center" label="年级" width="100"></el-table-column>
      <el-table-column prop="term" align="center" label="学期" width="50"></el-table-column>
      <el-table-column prop="major" label="专业" width="200"></el-table-column>
      <el-table-column prop="institute" label="学院" width="200"></el-table-column>
      <el-table-column prop="totalScore" label="总分" width="100"></el-table-column>
      <el-table-column prop="type" label="考试类型" width="120"></el-table-column>
      <el-table-column prop="tips" label="考生须知" width="250"></el-table-column>
      <el-table-column prop="tag" label="备注" width="120"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="del(scope.row.examCode)" type="danger" size="small">删除<i class="el-icon-remove-outline"/></el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  data(){
    return{
      total:0,
      pageNum:1,
      pageSize:5,
      description:'',
      form:{},
      tableData: []
    }
  },
  created() {
    this.load()
  },
  methods:{
    handleClick(row){
      console.log(row);
    },
    handleSizeChange(pageSize){
      console.log(`每页 ${pageSize} 条`);
      this.pageSize =pageSize;
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(`当前页: ${pageNum}`);
      this.pageNum = pageNum;
      this.load()
    },
    reset(){
      this.description = ''
      this.load()
    },
    load(){
      request.get("api/examManage2/page",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          description:this.description
        }
      }).then(res=>{
        console.log(res)
        this.tableData = res.records
        this.total = res.total
      })
    },
    del(id){
      request.delete("api/examManage2/"+id).then((res=>{
        if(res){
          this.$message.success("删除成功")
          this.load()
        }else {
          this.$message.error("删除失败")
        }
      }))
    },
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
