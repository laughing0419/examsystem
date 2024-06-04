package com.cx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import com.cx.service.MultiQuestionService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/multiQuestion")
public class MultiQuestionController {
    @Autowired
    MultiQuestionService multiQuestionService;
    @GetMapping     //查询题目
    public Result<?> queryMulti(@RequestParam() Integer pageNum, @RequestParam() Integer pageSize,@RequestParam(defaultValue = "") String search){
        Page<MultiQuestion> multiQuestionPage = multiQuestionService.queryMultiQuestionByPage(pageNum, pageSize,search);
        return Result.success(multiQuestionPage);
    }
    @PostMapping("/addMulti")       //增加题目
    public Result<?> addMulti(@RequestBody MultiQuestion multiQuestion){
        multiQuestion.setQuestionType("选择题");
        int i = multiQuestionService.insertMultiQuestion(multiQuestion);
        if(i==0){
            return Result.error("-1","增加失败");
        }else {
            return Result.success("0","增加成功");
        }
    }
    @DeleteMapping("/deleteMulti/{questionId}")     //删除题目
    public Result<?> deleteMulti(@PathVariable Integer questionId){
        int i = multiQuestionService.deleteMultiQuestion(questionId);
        if(i==0){
            return Result.error("-1","删除失败");
        }else {
            return Result.success("0","删除成功");
        }
    }
    @PutMapping("/updateMulti")     //更新题目
    public Result<?> updateMulti(@RequestBody MultiQuestion multiQuestion){
        int i = multiQuestionService.updateMultiQuestion(multiQuestion);
        if(i==0){
            return Result.error("-1","更新失败");
        }else {
            return Result.success("0","更新成功");
        }
    }
    @GetMapping("/allMulti")
    public Result<?> queryAllMutlti(@RequestParam() Integer pageNum,
                                    @RequestParam() Integer pageSize,
                                    @RequestParam(defaultValue = "") String keyWord,
                                    @RequestParam(defaultValue = "") String level
                                    ){
        Page<MultiQuestion> multiQuestionPage = multiQuestionService.queryMultiQuestion(pageNum, pageSize, keyWord, level);
        return Result.success(multiQuestionPage);
    }
    @GetMapping("/queryForExam")
    public Result<?> queryForExam(@RequestParam() String paperId){
        List<MultiQuestion> multiQuestions = multiQuestionService.queryMultiForExam(Integer.parseInt(paperId));
        return Result.success(multiQuestions);
    }


}
