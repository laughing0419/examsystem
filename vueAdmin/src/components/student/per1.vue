<template>
  <el-descriptions class="margin-top" title="个人信息" :column="3" :size="size" border>
    <template slot="extra">
      <el-button type="primary" size="small" @click="outerVisible = true">编辑</el-button>
      <el-dialog title="修改信息" :visible.sync="outerVisible">
        <el-form :model="user">
          <el-form-item label="用户名" :label-width="formLabelWidth">
            <el-input v-model="user.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="手机号" :label-width="formLabelWidth">
            <el-input v-model="user.phone" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="班级" :label-width="formLabelWidth">
            <el-input v-model="user.class" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="学号/工号" :label-width="formLabelWidth">
            <el-input v-model="user.id" autocomplete="off" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="居住地" :label-width="formLabelWidth">
            <el-input v-model="user.location" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio-group v-model="user.sex">
              <el-radio label="男">男</el-radio>
              <el-radio label="女">女</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="outerVisible = false">取消</el-button>
          <el-button type="primary" @click="outerVisible = false">确定</el-button>
        </div>
      </el-dialog>
    </template>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-user"></i>
        用户名
      </template>
      {{user.name}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-phone"></i>
        手机号
      </template>
      {{user.phone}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-s-home"></i>
        班级
      </template>
      {{user.class}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-s-custom"></i>
        学号/工号
      </template>
      {{user.id}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-location-outline"></i>
        居住地
      </template>
      {{user.location}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-male"></i>
        性别
      </template>
      {{user.sex}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot="label">
        <i class="el-icon-tickets"></i>
        备注
      </template>
      <el-tag size="small">{{user.school}}</el-tag>
    </el-descriptions-item>
  </el-descriptions>
</template>

<script>
export default {
  name: "per1",
  data(){
    return{
      size:'',
      outerVisible:false,
      formLabelWidth:'120px',
      user:{
        id:'201912312',
        name:'王艾源',
        class:'软工02班',
        phone:'12312321',
        location:'衡阳市',
        school:'南华大学',
        sex:'男',
      }
    }
  }
}
</script>

<style scoped>

</style>
