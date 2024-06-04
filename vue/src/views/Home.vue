<template>
  <div>
    <el-calendar v-model="value">
    </el-calendar>

  </div>
</template>

<script>


export default {
  name: "myHome",
  components:{
  },
  created() {
    var teacherName = this.$cookies.get("teacherName");
    console.log(teacherName)
  },
  data() {
    return {
      value: new Date()
    }
  }
}
</script>

<style scoped>

</style>