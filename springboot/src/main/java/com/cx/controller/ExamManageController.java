package com.cx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.*;
import com.cx.service.*;
import com.cx.uitl.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/examManage")
public class ExamManageController {
    private int studentId;       //学生id
    private int paperId;        //试卷id
    private int obScore = 0;    //客观题总分
    private int subScore = 0;   //主观题总分
    @Autowired
    ExamManageService examManageService;
    @Autowired
    MultiQuestionService multiQuestionService;
    @Autowired
    JudgeQuestionService judgeQuestionService;
    @Autowired
    FillQuestionService fillQuestionService;
    @Autowired
    StudentPaperService studentPaperService;
    @Autowired
    ScoreService scoreService;
    @PostMapping
    public Result<?> examManege(@RequestBody ExamManage examManage){
        examManage.setPaperId(examManageService.queryPaperId()+1);
        examManage.setInstitute("软件工程学院");
        int i = examManageService.insertExamManage(examManage);
        if(i==0){
            return Result.error("-1","失败");
        }else {
            return Result.success("0","成功");
        }
    }
    @PutMapping
    public Result<?> updateExamManege(@RequestBody ExamManage examManage){
        examManage.setPaperId(examManageService.queryPaperId());
        int i = examManageService.updateExamManage(examManage);
        if(i==0){
            return Result.error("-1","失败");
        }else {
            return Result.success("0","成功");
        }
    }
    @GetMapping("/allQuestion")
    public Result<?> queryAllQuestion(){
        List<ExamManage> examManages = examManageService.queryAllExamManage();
        return Result.success(examManages);
    }
    @GetMapping("/queryExam")
    public Result<?> queryExam(){
        List<ExamManage> examManages = examManageService.queryAllExamManage();
        return Result.success(examManages);
    }
    @GetMapping("/queryExamByPaperId")
    public Result<?> queryExamByPaperId(@RequestParam() String paperId){
        ExamManage examManage = examManageService.queryExamByPaperId(Integer.parseInt(paperId));
        return Result.success(examManage);
    }
    /*获得考试的学生和试卷*/
    @GetMapping("/getStudentAndPaper")
    public Result<?> getStudentAndPaper(@RequestParam() String studentId,@RequestParam() String paperId){
        this.paperId = Integer.parseInt(paperId);
        this.studentId = Integer.parseInt(studentId);
        return Result.success("成功","0");
    }
    /*批阅选择题*/
    @PostMapping("/markMulti")
    public Result<?> markMulti(@RequestBody List<MultiQuestion> value){
        int multiScore = 0;
        StudentPaper studentPaper = new StudentPaper();
        studentPaper.setPaperId(paperId);
        studentPaper.setStudentId(studentId);
        //查这一题的正确答案
        //与学生答案进行对比 正确 multiScore+
        //将这记录到学生试卷表中
        //将分数存到分数表中！
        for (MultiQuestion multiQuestion : value) {
            String rightAnswer = multiQuestionService.queryMultiQuestionById(multiQuestion.getQuestionId()).getAnswer();
            String studentAnswer = multiQuestion.getAnswer().substring(0, 1);
            studentPaper.setQuestionId(multiQuestion.getQuestionId());
            studentPaper.setRightAnswer(rightAnswer);
            studentPaper.setStudentAnswer(studentAnswer);
            /*插入学生试卷*/
            studentPaperService.insertPaper(studentPaper);
            if(rightAnswer.equals(studentAnswer)){
                multiScore += multiQuestion.getScore();
            }
            System.out.println("选择题正确答案-->"+rightAnswer +"选择题学生答案"+studentAnswer);
        }
        this.obScore += multiScore;
        System.out.println("学生选择题总分----->"+multiScore);
        return Result.success("成功","0");
    }
    @PostMapping("/markJudge")
    public Result<?> markJudge(@RequestBody List<JudgeQuestion> valueJudge){
        int judgeScore = 0;
        StudentPaper studentPaper = new StudentPaper();
        studentPaper.setPaperId(paperId);
        studentPaper.setStudentId(studentId);
        for (JudgeQuestion judgeQuestion : valueJudge) {
            String rightAnswer = judgeQuestionService.queryJudgeQuestionById(judgeQuestion.getQuestionId()).getAnswer();
            String studentAnswer = judgeQuestion.getAnswer();
            studentPaper.setQuestionId(judgeQuestion.getQuestionId());
            studentPaper.setRightAnswer(rightAnswer);
            studentPaper.setStudentAnswer(studentAnswer);
            /*插入判断题*/
            studentPaperService.insertPaper(studentPaper);
            if(rightAnswer.equals(studentAnswer)){
                judgeScore += judgeQuestion.getScore();
            }

            System.out.println("判断题正确答案-->"+rightAnswer +"判断题学生答案"+studentAnswer);
        }
        this.obScore += judgeScore;
        /*存分数*/
        Integer examCode = examManageService.queryExamByPaperId(paperId).getExamCode();
        String source = examManageService.queryExamByPaperId(paperId).getSource();
        String examDate = examManageService.queryExamByPaperId(paperId).getExamDate();
        Score score = new Score(null,examCode,studentId,obScore,null,null,source,examDate,null,null);
        scoreService.insertScore(score);
        System.out.println("学生判断题总分----->"+judgeScore);
        this.obScore = 0;
        return Result.success("成功","0");
    }
    @PostMapping("/markFill")
    public Result<?>markFill(@RequestBody List<FillQuestion> valueFill){
        StudentPaper studentPaper = new StudentPaper();
        studentPaper.setPaperId(paperId);
        studentPaper.setStudentId(studentId);
        for (FillQuestion fillQuestion : valueFill) {
            String rightAnswer = fillQuestionService.queryFillQuestionById(fillQuestion.getQuestionId()).getAnswer();
            String studentAnswer = fillQuestion.getAnswer();
            studentPaper.setQuestionId(fillQuestion.getQuestionId());
            studentPaper.setStudentAnswer(studentAnswer);
            studentPaper.setRightAnswer(rightAnswer);
            studentPaperService.insertPaper(studentPaper);
            System.out.println("填空题正确答案-->"+rightAnswer +"    填空题学生答案--->"+studentAnswer);
        }
        return Result.success("成功","0");
    }
    @GetMapping("/fillStudent")
    public Result<?> fillStudent(@RequestParam String studentId){
        this.studentId = Integer.parseInt(studentId);
        return Result.success("0","成功");

    }
    @PostMapping("/statisticalScore")
    public Result<?> statisticalScore(@RequestBody List<FillQuestion> value){
        for (FillQuestion fillQuestion : value) {
            subScore+=fillQuestion.getScore();
        }
        System.out.println(subScore);
        System.out.println(studentId);
        scoreService.updateSubScore(subScore,studentId);
        Score score = scoreService.queryScoreById(studentId);
        scoreService.updateScore(score.getObScore()+score.getSubScore(),studentId);
        this.subScore = 0;
        return Result.success("0","成功");
    }
}
