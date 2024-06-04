package com.cx.controller;

import com.alibaba.druid.util.StringUtils;
import com.cx.pojo.PaperManage;
import com.cx.service.ExamManageService;
import com.cx.service.PaperMangeService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paperManage")
public class PaperManageController {
    @Autowired
    PaperMangeService paperMangeService;
    private Integer[] questionTest;
    @PostMapping
    public Result<?> insertPaper(@RequestBody Integer[] questionId){
        Integer[] questionIdByInt = new Integer[questionId.length];
        if (questionId!=null)
            for (int i = 0; i < questionId.length; i++) {
                questionIdByInt[i] = questionId[i];
            }
        questionTest = questionIdByInt;
        for (Integer integer : questionTest) {
            System.out.println("questionTest--->"+integer);
        }
        return Result.success("0","成功");
    }
    @PostMapping("/score")
    public Result<?> insertScore(@RequestBody String[] score){
        String [] scoreByString = new String[score.length];
        if (score!=null)
            for (int i = 0; i < score.length; i++) {
                scoreByString[i] = score[i];
            }
        paperMangeService.insertPaper(questionTest,scoreByString);
        /*for (String s : scoreByString) {
            System.out.println("scoreByString---->"+s);
        }
        for (Integer integer : questionTest) {
            System.out.println("questionTest--->"+integer);
        }*/
        return Result.success("0","成功");
    }
    @GetMapping("/queryPaperManageById")
    public Result<?> queryPaperManageById(@RequestParam() Integer paperId){
        List<PaperManage> paperManages = paperMangeService.queryPaperManageById(paperId);

        return Result.success(paperManages);


    }
}
