<template>
  <div>
    <!--头部-->
    <el-card>
      <div slot="header" class="clearfix">
        <span style="font-size: 14px">选择题</span>
      </div>
      <div class="boxcard">
        <div class="boxcard-inline">
          <label class="card-label" style="width: 100px">题目</label>
          <el-input style="width: 200px" placeholder="请输入内容" suffix-icon="el-icon-search" v-model="question"></el-input>
          &nbsp;
          <el-button type="primary" @click="load">搜索</el-button>
          <el-button type="warning" @click="reset">重置</el-button>
        </div>
      </div>
    </el-card>、
    <!--表格-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column fixed align="center" prop="questionId" label="题号" width="150"></el-table-column>
      <el-table-column prop="subject" label="科目" width="120"></el-table-column>
      <el-table-column prop="answerA" label="选项A" width="250"></el-table-column>
      <el-table-column prop="answerB" label="选项B" width="250"></el-table-column>
      <el-table-column prop="answerC" label="选项C" width="250"></el-table-column>
      <el-table-column prop="answerD" label="选项D" width="250"></el-table-column>
      <el-table-column prop="answer" label="正确答案" width="100"></el-table-column>
      <el-table-column prop="analysis" label="题目解析" width="250"></el-table-column>
      <el-table-column prop="score" label="分值" width="100"></el-table-column>
      <el-table-column prop="level" label="难度" width="150"></el-table-column>
      <el-table-column prop="section" label="所属章节" width="150"></el-table-column>
      <el-table-column prop="questionType" label="题目类型" width="150"></el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="150"></el-table-column>
      <el-table-column prop="updateTime" label="更新时间" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="del(scope.row.questionId)" type="danger" size="small">删除<i class="el-icon-remove-outline"/></el-button>
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
  name: "Muti_Question",
  data(){
    return{
      total:0,
      pageNum:1,
      pageSize:5,
      question:'',
      dialogFormVisible:false,
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
      this.question = ''
      this.load()
    },
    load(){
      request.get("api/multi/page",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          question:this.question
        }
      }).then(res=>{
        console.log(res)
        this.tableData = res.records
        this.total = res.total
      })
    },
    del(questionId){
      request.delete("api/multi/"+questionId).then((res=>{
        if(res){
          this.$message.success("删除成功")
          this.load()
        }else {
          this.$message.error("删除失败")
        }
      }))
    },
  },
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
