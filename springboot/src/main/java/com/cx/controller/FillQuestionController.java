package com.cx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.MultiQuestion;
import com.cx.service.FillQuestionService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fillQuestion")
public class FillQuestionController {
    @Autowired
    FillQuestionService fillQuestionService;
    @GetMapping("/queryFill")
    public Result<?> queryFill(@RequestParam() Integer pageNum,
                               @RequestParam() Integer pageSize,
                               @RequestParam(defaultValue = "") String search)
    {
        Page<FillQuestion> fillQuestionPage = fillQuestionService.queryFillQuestionByPage(pageNum, pageSize, search);
        return Result.success(fillQuestionPage);
    }

    @PostMapping("/addFill")       //增加题目
    public Result<?> addMulti(@RequestBody FillQuestion fillQuestion){
        fillQuestion.setQuestionType("填空题");
        int i = fillQuestionService.insertFillQuestion(fillQuestion);
        if(i==0){
            return Result.error("-1","增加失败");
        }else {
            return Result.success("0","增加成功");
        }
    }
    @DeleteMapping("/deleteFill/{questionId}")     //删除题目
    public Result<?> deleteMulti(@PathVariable Integer questionId){
        int i = fillQuestionService.deleteFillQuestion(questionId);
        if(i==0){
            return Result.error("-1","删除失败");
        }else {
            return Result.success("0","删除成功");
        }
    }
    @PutMapping("/updateFill")     //更新题目
    public Result<?> updateMulti(@RequestBody FillQuestion fillQuestion){
        int i = fillQuestionService.updateFillQuestion(fillQuestion);
        if(i==0){
            return Result.error("-1","更新失败");
        }else {
            return Result.success("0","更新成功");
        }
    }
    @GetMapping("/allFill")
    public Result<?> queryAllFill(@RequestParam() Integer pageNum,
                                    @RequestParam() Integer pageSize,
                                    @RequestParam(defaultValue = "") String keyWord,
                                    @RequestParam(defaultValue = "") String level
    ){
        Page<FillQuestion> fillQuestionPage = fillQuestionService.queryFillQuestion(pageNum, pageSize, keyWord, level);
        return Result.success(fillQuestionPage);

    }
    @GetMapping("/queryForExam")
    public Result<?> queryForExam(@RequestParam() String paperId){
        List<FillQuestion> fillQuestions = fillQuestionService.queryFillForExam(Integer.parseInt(paperId));
        return Result.success(fillQuestions);
    }

}
