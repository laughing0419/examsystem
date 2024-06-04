<template>
  <div>
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
    <el-table :data="tableData" style="width: 100%">
      <el-table-column type="index" :index="indexMethod"></el-table-column>
      <el-table-column prop="ename" label="考试名称" width="500"></el-table-column>
      <el-table-column prop="starttime" label="开考时间" width="350"></el-table-column>
      <el-table-column prop="endtime" label="截止时间" width="350"></el-table-column>
    </el-table>
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
  name: "quekao",
  data(){
    return{
      currentPage:1,
      tableData: [
          {
            ename:'数据结构第一次期末考试',
            starttime: '2021/12/1/12:00',
            endtime: '2021/12/1/13:30'
          }
      ]
    }
  },
  methods:{
    indexMethod(index){
      return index * 1;
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
