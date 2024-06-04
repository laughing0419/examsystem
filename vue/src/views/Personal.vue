<template>
<div>
<!--  头部-->
  <div>
    <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" style="width: 1250px; height:200px;margin-left: 20px">
      <el-menu-item index="/teacherInfo" @click="$router.push('/teacherInfo')">基本资料</el-menu-item>
      <el-menu-item index="/updatePwd" @click="$router.push('/updatePwd')">修改密码</el-menu-item>
      <el-menu-item index="3">选择语言</el-menu-item>
      <el-menu-item index="4">修改头像</el-menu-item>
    </el-menu>
  </div>
<!--  内容区域-->
  <div style="border: 1px ;height: 80vh;margin-left: 20px;margin-top: 30px;background-color: white" >
    <router-view></router-view>
  </div>

</div>
</template>

<script>


export default {
  name: "myPersonal",
  components:{
  },
  methods:{
    click(){
      alert("123214")
    }
  }
}
</script>

<style scoped>

</style>