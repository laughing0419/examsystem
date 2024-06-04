package com.cx.controller;

import com.cx.pojo.StudentPaper;
import com.cx.service.StudentPaperService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentPaper")
public class StudentPaperController {
    @Autowired
    StudentPaperService studentPaperService;
    @GetMapping
    public Result<?> getStudentPaper(@RequestParam() Integer studentId){
        List<StudentPaper> studentPapers = studentPaperService.queryStudentPaper(studentId);
        return Result.success(studentPapers);


    }

}
