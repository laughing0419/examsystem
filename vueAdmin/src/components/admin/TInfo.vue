<template>
  <div>
    <!--头部-->
    <el-card>
      <div slot="header" class="clearfix">
        <span style="font-size: 14px">教师信息</span>
      </div>
      <div class="boxcard">
        <div class="boxcard-inline">
          <label class="card-label" style="width: 100px">教师姓名</label>
          <el-input style="width: 200px" placeholder="请输入姓名" suffix-icon="el-icon-search" v-model="teacherName"></el-input>
          &nbsp;
          <el-button type="primary" @click="load">搜索</el-button>
          <el-button type="warning" @click="reset">重置</el-button>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </div>
      </div>
    </el-card>、
    <!--表格-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column fixed align="center" prop="teacherId" label="工号" width="150"></el-table-column>
      <el-table-column prop="teacherName" label="姓名" width="120"></el-table-column>
      <el-table-column prop="institute" label="学院" width="250"></el-table-column>
      <el-table-column prop="tel" label="电话" width="250"></el-table-column>
      <el-table-column prop="sex" label="性别" width="100"></el-table-column>
      <el-table-column prop="email" label="邮箱" width="250"></el-table-column>
      <el-table-column prop="cardId" label="身份证号" width="250"></el-table-column>
      <el-table-column prop="type" label="类别" width="150"></el-table-column>
      <el-table-column prop="residence" label="居住地" width="150"></el-table-column>
      <el-table-column prop="address" label="联系地址" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="180">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="success" size="small">编辑<i class="el-icon-edit"/></el-button>
          <el-button @click="del(scope.row.teacherId)" type="danger" size="small">删除<i class="el-icon-remove-outline"/></el-button>
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

    <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%" >
      <el-form label-width="80px" size="small">
        <el-form-item label="姓名" ><el-input v-model="form.teacherName" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="学院" ><el-input v-model="form.institute" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="电话" ><el-input v-model="form.tel" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="邮箱" ><el-input v-model="form.email" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="身份证号" ><el-input v-model="form.cardId" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="类别" ><el-input v-model="form.type" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="性别" ><el-input v-model="form.sex" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="居住地" ><el-input v-model="form.residence" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="性别" ><el-input v-model="form.address" autocomplete="off"></el-input></el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "TInfo",
  data(){
    return{
      total:0,
      pageNum:1,
      pageSize:5,
      teacherName:'',
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
    save(){
      request.post("api/teacher2",this.form).then(res=>{
        if(res){
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        }else {
          this.$message.error("保存失败")
        }
      })
    },
    reset(){
      this.teacherName = ''
      this.load()
    },
    load(){
      request.get("api/teacher2/page",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          teacherName:this.teacherName
        }
      }).then(res=>{
        console.log(res)
        this.tableData = res.records
        this.total = res.total
      })
    },
    del(teacherId){
      request.delete("api/teacher2/"+teacherId).then((res=>{
        if(res){
          this.$message.success("删除成功")
          this.load()
        }else {
          this.$message.error("删除失败")
        }
      }))
    },
    handleAdd(){
      this.dialogFormVisible = true
      this.form={}
    },
    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true
    }
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
