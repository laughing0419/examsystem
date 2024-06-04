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
      <el-table-column fixed align="center" prop="id" label="序号" width="55"></el-table-column>
      <el-table-column prop="name" label="考试名称" width="350"></el-table-column>
      <el-table-column prop="score" align="center" label="得分" width="100"></el-table-column>
      <el-table-column prop="amount" align="center" label="满分" width="100"></el-table-column>
      <el-table-column prop="starttime" label="进入时间" width="250"></el-table-column>
      <el-table-column prop="endtime" label="提交时间" width="250"></el-table-column>
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
export default {
  name: "myGrades",
  data(){
    return{
      currentPage:1,
      tableData:[
        {
          id:1,
          name:'王小虎',
          score:'90',
          amount:'100',
          starttime:'2021/10/01 14:32:20',
          endtime:'2021/10/01 14:50:20'
        },
        {
          id:2,
          name:'王小虎',
          score:'88',
          amount:'100',
          starttime:'2021/10/01 14:32:20',
          endtime:'2021/10/01 14:50:20'
        },
        {
          id:3,
          name:'王小虎',
          score:'65',
          amount:'100',
          starttime:'2021/10/01 14:32:20',
          endtime:'2021/10/01 14:50:20'
        },
        {
          id:4,
          name:'王小虎',
          score:'89',
          amount:'100',
          starttime:'2021/10/01 14:32:20',
          endtime:'2021/10/01 14:50:20'
        },
      ]
    }
  },
  methods:{
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
