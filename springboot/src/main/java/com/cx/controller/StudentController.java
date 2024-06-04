package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.Student;
import com.cx.service.StudentService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public Result<?> getStudentInfo(@RequestParam("studentId") String studentId){
        Student student = studentService.queryStudentById(Integer.parseInt(studentId));

        return Result.success(student);
    }
    @PutMapping("/updateInfo")
    public Result<?> updateInfo(@RequestBody Student student){
        int i = studentService.updateStudent(student);
        if(i==0){
            return Result.error("-1","更新失败");
        }else {
            return Result.success("0","成功");
        }
    }
    @GetMapping("/updatePwd")
    public Result<?> updatePwd(@RequestParam()String oldPassword,@RequestParam() String studentId,@RequestParam() String newPassword ){
        Student student = studentService.queryStudentById(Integer.parseInt(studentId));

        if(oldPassword.equals(student.getPwd())){
            student.setPwd(newPassword);
            int i = studentService.updateStudent(student);
            if (i==0){
                return Result.error("-2","修改失败！请重试");
            }else {
                return Result.success("0","修改成功请重新登录");
            }
        }else {
                return Result.error("-1","旧密码输入有误！");
        }

    }

}
