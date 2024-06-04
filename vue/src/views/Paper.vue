<template>
<div>
<!--  <span>当前时间:{{dateFormat(date)+1}}</span>
  <span>时间差:{{formatGap(start,end)}}</span>-->
  <div style="background-color: white ;width: 1300px">
  <el-table
      ref="filterTable"
      :data="tableData"
      style="width: 100%"
      border="true"
  >
<!--    <el-table-column
        prop="date"
        label="日期"
        sortable
        width="180"
        column-key="date"
        :filters="[{text: '2016-05-01', value: '2016-05-01'}, {text: '2016-05-02', value: '2016-05-02'}, {text: '2016-05-03', value: '2016-05-03'}, {text: '2016-05-04', value: '2016-05-04'}]"
        :filter-method="filterHandler"
    >
    </el-table-column>-->
    <el-table-column
        prop="description"
        label="考试描述"
        width="180">
    </el-table-column>
    <el-table-column
        prop="source"
        label="考试科目"
        width="180">
    </el-table-column>
    <el-table-column
        prop="totalTime"
        label="考试时长(分钟)"
        width="180">
    </el-table-column>
    <el-table-column
        prop="totalScore"
        label="考试总分"
        width="180">
    </el-table-column>

    <el-table-column
        prop="examDate"
        label="考试时间"
        show-overflow-tooltip>
    </el-table-column>
    <el-table-column
        prop="tag"
        label="状态"
        width="100"
        :filters="[{ text: '未开始', value: '未开始' }, { text: '已结束', value: '已结束' },{ text: '进行中', value: '进行中' }]"
        :filter-method="filterTag"
        filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
            :type=state
            disable-transitions>{{scope.row.tag}}</el-tag>
      </template>
    </el-table-column>
  </el-table>
  </div>

</div>
</template>

<script>
import request from "@/utils/request";
import moment from 'moment'
export default {
  name: "myPaper",
  data(){
    return{
      /*date:new Date(),
      start:'2020-02-02 14:12:12',
      end:'2020-02-02 12:42:12',*/
      state:"scope.row.tag === '进行中' ? 'primary' : 'success'",
      tableData: [{
        tag:''
      }]
    }
  },
  created() {
    this.load();
  },
  methods:{
    load(){
      //当前时间
      let currentTime = this.dateFormat(new Date());
      console.log(currentTime)
      request.get("/api/examManage/allQuestion").
      then(resp=>{
        if(resp.code==='0'){
          console.log(resp.data.length)
          /*  Moment(resp.data[1].examDate).utcOffset(480).format('YYYY-MM-DD HH:mm:ss'); */
          for(let i =0;i<resp.data.length;i++){
            let time = moment(resp.data[i].examDate).utcOffset(480).format('YYYY-MM-DD HH:mm:ss')
            resp.data[i].examDate = time
            if(this.formatGap(time,currentTime)<0){
              resp.data[i].tag = '未开始'
            }else if(this.formatGap(time,currentTime)>=0&&this.formatGap(time,currentTime)<=resp.data[i].totalTime){
              resp.data[i].tag = '进行中'
            }else {
              resp.data[i].tag = '已结束'
            }
          }
          this.tableData = resp.data
        }
      })
    },
    //获取当前时间
    dateFormat(time) {
      var date=new Date(time);
      var year=date.getFullYear();
      /* 在日期格式中，月份是从0开始的，因此要加0
       * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
       * */
      var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
      var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
      var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
      var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
      var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
      // 拼接
      return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
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
      return stayHour*60 +stayMin+staySec/60;
    },
    resetDateFilter() {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    formatter(row) {
      return row.address;

    },
    filterTag(value, row) {
      return row.tag === value;
    },
    filterHandler(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    }
  }
}
</script>

<style scoped>

</style>