<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>


/*import request from "@/utils/request";*/

export default {
  name: 'App',
  created() {
    /*request.get("/api/test").then(res=>{
      //拼接数组
      console.log(res.data.fillQuestions[0].concat(res.data.judgeQuestions[0]))
    })*/
    if (this.$router.path !== "/home")    //刷新回到首页
      this.$router.replace("home")
  },

  components: {
  }
}
</script>

<style>

</style>
