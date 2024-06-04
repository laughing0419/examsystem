package com.cx.controller;


import com.cx.pojo.Score;
import com.cx.service.ScoreService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/getStudentScore")
    public Result<?> getStudentScore(@RequestParam String studentId){
        List<Score> scores = scoreService.queryStudentScore(Integer.parseInt(studentId));
        if(scores!=null){
            return Result.success(scores);
        }else {
            return Result.error("-1","错误");
        }
    }
    @GetMapping("/getAllScore")
    public Result<?> getAllScore(){
        List<Score> scores = scoreService.queryAllScore();
        return Result.success(scores);
    }
}
