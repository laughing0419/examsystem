<template>
<div class="personal">
  <!--顶部标签-->
  <el-tabs v-model="activeName" @tab_click="handleClick">
    <el-tab-pane label="个人信息" name="first">
      <vper1></vper1>
    </el-tab-pane>
    <el-tab-pane label="密码管理" name="second">
      <vper2></vper2>
    </el-tab-pane>
  </el-tabs>

</div>
</template>

<script>
import vper1 from './per1.vue'
import vper2 from './per2.vue'
export default {
  name: "personal",
  data(){
    return{
      activeName:'first',
    }
  },
  methods:{
    handleClick(tab,event){
      console.log(tab,event)
    },

  },
  components:{
    vper1,
    vper2
  }
}
</script>

<style scoped>
.personal{
  margin-left: 20px;
}
</style>
