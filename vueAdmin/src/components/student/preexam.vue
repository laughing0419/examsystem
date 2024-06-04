<template>
  <div class="ksxz">
    <el-form>
      <center>
        <div class="es-row-wrap">
          <div class="page-header text-center">
            <h3>
              <span>{{stu.ename}}</span>
            </h3>
          </div>
          <div style="width: 1000px;border: 0">
            <table style="width: 900px;border: 0">
              <tbody>
                <tr>
                  <td width="170px" align="right">
                    <b>考生&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.name}}</td>
                  <td align="left" rowspan="5" width="150px">
                    <img width="143px" height="166px" style="border:1px solid #8c8b8b" alt="">
                  </td>
                </tr>
                <tr>
                  <td align="right">
                    <b>学号&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.number}}</td>
                </tr>
                <tr>
                  <td align="right">
                    <b>考试名称&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.ename}}</td>
                </tr>
                <tr>
                  <td align="right">
                    <b>总分&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.amount}}</td>
                </tr>
                <tr>
                  <td align="right">
                    <b>考试时间&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.starttime}}&nbsp;至{{stu.endtime}}</td>
                </tr>
                <tr>
                  <td align="right">
                    <b>考试时长&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;{{stu.amounttime}}</td>
                </tr>
                <tr>
                  <td align="right">
                    <b>考试须知&nbsp;:&nbsp;&nbsp;</b>
                  </td>
                  <td align="left">&nbsp;&nbsp;考试要求:本次考试为在线考试形式，考生需自行准备符合要求的考试设备、监控设备和考试场所。
                    请考生知悉：根据考试主办方的管理要求，考试全程需同时开启两路 在线视频监控，以满足远程在线监考的必需。
                    为保证考试的公正性和严肃性，本次考试采用在线考试，启用人脸识别对考生身份特征识别；
                    考中全程 AI 监考技术、人工远程监考以及考后 监控记录核查等方式对考试过程进行全面监控,考生应自觉遵守考试纪律。
                    特别提醒：
                    1、如考生在考试中因系统或网络故障、电源故障、个人操作不当等
                    造成的考试时间损失或无法完成考试，此类因考生个人设备、网络原因、
                    断电、操作不当等造成的问题将不会得到补时或补考的机会，且由考生
                    自行承担责任。
                    2、如若考生考试中途退出系统，将不得再次进入考试系统作答！</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div>
            <el-button type="primary" @click="$router.push('/exam')">开始考试</el-button>
          </div>
        </div>
      </center>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "preexam",
  data(){
    return{
      stu:{
        name:'王艾源',
        number:'20190441312',
        ename: '数据结构第一次期末考试',
        amount:'100.00分',
        starttime:'2020/12/1 12:00',
        endtime:'2020/12/1 13:30',
        amounttime:'90min'
      }
    }
  }
}
</script>

<style scoped>
*{
  margin: 0;
  padding:0;
  box-sizing: border-box;
}
body{
  font: 14px "Helvetica Neue",Helvetica,"PingFang SC",Tahoma,Arial,sans-serif;
  background-color: white;
}
.ksxz{
  width: 960px;
  margin: 0 auto;
  padding-top: 30px;
  background-color: #fafafa;
  background-attachment: fixed;
}
.es-row-wrap{
  margin-bottom: 20px;
  background: white;
  border: 1px solid #e1e1e1;
  border-radius: 4px;
  padding-top: 20px;
  min-height: 480px;
  width: 960px;
  font-size: 14px;
}
.es-row-wrap .page-header{
  margin-top:25px;
}
.page-header{
  padding-bottom: 9px;
  margin: 40px 0 20px;
  border-bottom: 1px solid #eeeeee;
}
.text-center{
  text-align: center;
}
</style>
