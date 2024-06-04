package com.cx.controller;

import com.cx.pojo.Student;
import com.cx.service.StudentService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public Result<?> register(@RequestBody Student student){
        int i = studentService.insertStudent(student);
        if(i==0){
            return Result.success("-1","失败");
        }else {
            return Result.success("0","成功");
        }
    }
}
