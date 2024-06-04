<template>
<div>
  {{}}
</div>
</template>

<script>
import moment from "moment";
export default {
  name: "myInvigilate",
  data(){
    return{
      date:'2022-04-08 14:00:00',
      totalTime:150
    }
  },
  created() {
    // this.formatAdd(this.date,this.totalTime);
    /*2022-04-08T18:30:02.951Z*/
    console.log(moment(new Date("2022-04-08T16:30:00.207Z")).utcOffset(480).format('YYYY-MM-DD HH:mm:ss'))
  },
  methods:{
    formatAdd(start, totalTime) {
      let hour = parseInt(totalTime/60);
      console.log(hour)
      let min = totalTime%60;
      console.log(min)
      let startTime = new Date(start);
      let addHour = startTime.setHours(startTime.getHours()+hour);
      console.log(new Date(addHour))
      let addMin = startTime.setMinutes(startTime.getMinutes()+min);
      console.log(new Date(addMin));
      console.log(moment(new Date(addMin)).utcOffset(480).format('YYYY-MM-DD HH:mm:ss'))
    },
  }
}
</script>

<style scoped>

</style>