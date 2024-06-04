<template>
  <div class="personal">
    <!--顶部标签-->
    <el-tabs v-model="activeName" @tab_click="handleClick">
      <el-tab-pane label="选择题" name="first">
        <multi></multi>
      </el-tab-pane>
      <el-tab-pane label="主观题" name="second">
        <fill></fill>
      </el-tab-pane>
      <el-tab-pane label="判断题" name="third">
        <judge></judge>
      </el-tab-pane>
    </el-tabs>

  </div>
</template>

<script>
import fill from "@/components/admin/fill_Question";
import judge from "@/components/admin/judge_Question";
import multi from "@/components/admin/Muti_Question";
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
    }
  },
  components:{
    fill,
    judge,
    multi,
  }
}
</script>

<style scoped>
.personal{
  margin-left: 20px;
}
</style>
