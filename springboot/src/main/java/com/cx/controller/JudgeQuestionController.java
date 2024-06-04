package com.cx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import com.cx.service.JudgeQuestionService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("judgeQuestion")
public class JudgeQuestionController {
    @Autowired
    JudgeQuestionService judgeQuestionService;
    @GetMapping("/queryJudge")
    public Result<?> queryJudge(@RequestParam() Integer pageNum,
                               @RequestParam() Integer pageSize,
                               @RequestParam(defaultValue = "") String search)
    {
        Page<JudgeQuestion> judgeQuestionPage = judgeQuestionService.queryJudgeQuestionByPage(pageNum, pageSize, search);
        return Result.success(judgeQuestionPage);
    }

    @PostMapping("/addJudge")       //增加题目
    public Result<?> addJudge(@RequestBody JudgeQuestion judgeQuestion){
        judgeQuestion.setQuestionType("判断题");
        int i = judgeQuestionService.insertJudgeQuestion(judgeQuestion);
        if(i==0){
            return Result.error("-1","增加失败");
        }else {
            return Result.success("0","增加成功");
        }
    }
    @DeleteMapping("/deleteJudge/{questionId}")     //删除题目
    public Result<?> deleteJudge(@PathVariable Integer questionId){
        int i = judgeQuestionService.deleteJudgeQuestion(questionId);
        if(i==0){
            return Result.error("-1","删除失败");
        }else {
            return Result.success("0","删除成功");
        }
    }
    @PutMapping("/updateJudge")     //更新题目
    public Result<?> updateJudge(@RequestBody JudgeQuestion judgeQuestion){
        int i = judgeQuestionService.updateJudgeQuestion(judgeQuestion);
        if(i==0){
            return Result.error("-1","更新失败");
        }else {
            return Result.success("0","更新成功");
        }
    }
    @GetMapping("/allJudge")
    public Result<?> queryAllJudge(@RequestParam() Integer pageNum,
                                    @RequestParam() Integer pageSize,
                                    @RequestParam(defaultValue = "") String keyWord,
                                    @RequestParam(defaultValue = "") String level
    ){
        Page<JudgeQuestion> judgeQuestionPage = judgeQuestionService.queryJudgeQuestion(pageNum, pageSize, keyWord, level);
        return Result.success(judgeQuestionPage);

    }
    @GetMapping("/queryForExam")
    public Result<?> queryForExam(@RequestParam() String paperId){
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.queryJudgeForExam(Integer.parseInt(paperId));
        return Result.success(judgeQuestions);
    }

}
