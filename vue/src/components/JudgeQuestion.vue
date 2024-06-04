<template>
  <div>
    <!--    搜索框-->
    <div style="margin: 10px 10px">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>
      <el-button type="primary" style="margin: 10px" @click="load" >查询</el-button>
      <el-button type="primary" @click="addJudge">新增</el-button>
    </div>

    <!--    表格展示题目-->
    <div style="padding-left: 10px;padding-right: 10px">
      <el-table :data="tableData" style="width: 100% ;" border="true">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="答案：">
                <span>{{ props.row.answer }}</span>
              </el-form-item>
              <el-form-item label="章节：">
                <span>{{ props.row.section }}</span>
              </el-form-item>
              <el-form-item label="解析：">
                <span>{{ props.row.analysis }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
            label="题目ID"
            prop="questionId">
        </el-table-column>
        <el-table-column
            label="题目内容"
            prop="question"
            width="600px"
            :show-overflow-tooltip="true">
        </el-table-column>
        <el-table-column
            label="分数"
            prop="score">
        </el-table-column>
        <el-table-column
            label="难度等级"
            prop="level">
        </el-table-column>
        <el-table-column
            label="操作"
            width="200">
          <template slot-scope="scope">
            <el-button @click="handleEdit(scope.row)"  size="mini" >编辑</el-button>
            <template>
              <el-popconfirm @confirm="handleDelete(scope.row.questionId)"
                             title="确定删除吗？"
              >
                <!--   scope.row.id获取本列id     -->
                <el-button   type="danger" slot="reference" size="mini" style="margin-left: 10px">删除</el-button>
              </el-popconfirm>
            </template>
          </template>
        </el-table-column>
      </el-table>
      <!--分页      -->
      <div style="margin: 10px 0">
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
        </el-pagination>
      </div>
    </div>
    <!--      弹出对话框-->
    <el-dialog title="修改题目信息" :visible.sync="dialogFormVisible" width="40%">
      <el-form :model="form" label-width="80px">
        <el-form-item label="题目内容" style="width: 100%">
          <el-input v-model="form.question" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="正确答案" style="width: 100%">
          <el-input v-model="form.answer" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分数" style="width: 100%">
          <el-input v-model="form.score" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="科目" style="width: 100%">
          <el-input v-model="form.subject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="章节" style="width: 100%">
          <el-input v-model="form.section" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="难度水平" style="width: 100%">
          <el-input v-model="form.level" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分析" style="width: 100%">
          <el-input v-model="form.analysis" autocomplete="off"></el-input>
        </el-form-item>
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
  name: "myMultiQuestion",
  data(){
    return{
      tableData: [{}],
      dialogFormVisible:false,
      search:'',
      currentPage: 1,
      pageSize:5,
      total:0,
      form: {},   //一个对象  包含很多属性  用于编辑
    }
  },
  created() {
    //在创建实例时就加载
    this.load()
  },
  methods:{
    handleEdit(row){  //编辑题目
      this.dialogFormVisible =true
      this.form = JSON.parse(JSON.stringify(row))  //将题目显示到表格中
    },
    handleDelete(questionId){   //根据id删除题目
      request.delete("/api/judgeQuestion/deleteJudge/"+questionId).
      then(resp=>{
        if(resp.code==='0'){
          this.$message({
            type:"success",
            message:resp.msg
          })
        }else {
          this.$message({
            type:"error",
            message:resp.msg
          })
        }
      })
      this.load();  //重新加载表格的数据
    },
    handleSizeChange(pageSize){  //改变当前每页的个数触发   10条每页
      this.pageSize =pageSize;
      this.load()

    },
    handleCurrentChange(pageNum){  //改变当前页码 < 1 2>
      this.currentPage = pageNum;
      this.load()
    },
    load(){     //从数据库中查表并且显示在表格中
      request.get("api/judgeQuestion/queryJudge",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          search:this.search,
        }
      }).
      then(resp=>{
        this.tableData = resp.data.records;
        this.total=resp.data.total;
      })
    },
    addJudge(){  //增加题目弹出框框
      this.dialogFormVisible = true;
      this.form = {}
    },
    save(){   //保存修改题目（新增和修改）
      if(this.form.questionId){
        request.put("/api/judgeQuestion/updateJudge",this.form).
        then(resp=>{
          if(resp.code==='0'){
            this.$message({
              type:"success",
              message:resp.msg
            })
            this.load();
          }else {
            this.$message({
              type:"error",
              message:resp.msg
            })
          }
        })
      }else {
        request.post("api/judgeQuestion/addJudge",this.form).
        then(resp=>{
          if(resp.code==='0'){
            this.$message({
              type:"success",
              message:resp.msg
            })
            this.load();
          }else {
            this.$message({
              type:"error",
              message:resp.msg
            })
          }
        })
      }
      this.dialogFormVisible =false
    }
  }
}
</script>

<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>