package com.cx.controller;

import com.cx.pojo.Student;
import com.cx.pojo.Teacher;
import com.cx.service.TeacherService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping
    public Result<?> getTeacherInfo(@RequestParam("teacherId") String teacherId){
        Teacher teacher = teacherService.queryTeacherById(Integer.parseInt(teacherId));
        return Result.success(teacher);
    }
    @GetMapping("/updatePwd")
    public Result<?> updatePwd(@RequestParam()String oldPassword,@RequestParam() String teacherId,@RequestParam() String newPassword){
        Teacher teacher = teacherService.queryTeacherById(Integer.parseInt(teacherId));
        if(oldPassword.equals(teacher.getPwd())){
            teacher.setPwd(newPassword);
            int i = teacherService.updateTeacher(teacher);
            if (i==0){
                return Result.error("-2","修改失败！请重试");
            }else {
                return Result.success("0","修改成功请重新登录");
            }
        }else {
            return Result.error("-1","旧密码输入有误！");
        }
    }

    @PutMapping("/updateInfo")
    public Result<?> updateInfo(@RequestBody Teacher teacher){
        int i = teacherService.updateTeacher(teacher);
        if(i==0){
            return Result.error("-1","更新失败");
        }else {
            return Result.success("0","成功");
        }
    }

}
