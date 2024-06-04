<template>
  <div>
  <!--  头部-->
  <div>
    <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" style="width: 1250px; height:80px;margin-left: 20px">
      <el-menu-item index="/fillQuestion" @click="$router.push('/fillQuestion')">填空题</el-menu-item>
      <el-menu-item index="/multiQuestion" @click="$router.push('/multiQuestion')">选择题</el-menu-item>
      <el-menu-item index="/judgeQuestion" @click="$router.push('/judgeQuestion')">判断题</el-menu-item>
    </el-menu>
  </div>
<!--    内容-->
    <div style="border: 1px ;height: 96vh;margin-left: 20px;margin-top: 30px;background-color: white" >
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "myQuestion",


}
</script>

<style scoped>

</style>