package com.cx.controller;

import com.cx.pojo.*;
import com.cx.service.*;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/test")  /*测试接口 结合swagger使用 返回json字符串*/
public class TestController {


    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @Autowired
    JudgeQuestionService judgeQuestionService;
    @Autowired
    FillQuestionService fillQuestionService;
    @Autowired
    MultiQuestionService multiQuestionService;
    @GetMapping("/s")
    public Result<?> testStudent(){
        List<Student> studentList = studentService.queryAllStudent();

        return Result.success(studentList);
    }
    @PostMapping("/t")
    public Result<?> testTeacher(){
        Teacher teacher = teacherService.queryTeacherById(20081001);
        return Result.success(teacher);
    }
    /*测试结果
   resp: {
  "code": "0",
  "msg": "成功",
  "data": {
    "teacherId": 20081001,
    "teacherName": "张",
    "institute": "软件工程学院",
    "sex": "男",
    "tel": "13598458442",
    "email": "13598458442@163.com",
    "pwd": "123456",
    "cardId": "423423283498",
    "type": "讲师",
    "role": "1"
  }
}*/
    @PutMapping("/a")
    public Result<?> testAdmin(Admin admin){/*模拟前端发送数据过来*/
        //模拟前端
        int result = adminService.insertAdmin(admin);
        if (result == 0){
            return Result.error("-1","插入失败");
        }else {
            return Result.success("0","成功");
        }
    }
    /*结果
    resp{
  "code": "0",
  "msg": "成功",
  "data": null
    }*/
    @PutMapping("/jq")
    public Result<?> testJudgeQuestion(Integer num) {/*模拟前端发送数据过来*/
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.queryRandom(num);
        return Result.success(judgeQuestions);

    }
    @PostMapping("/fq")
    public Result<?> testFillQuestion(FillQuestion fillQuestion) {/*模拟前端发送数据过来*/
        int i = fillQuestionService.insertFillQuestion(fillQuestion);
        return Result.success("0","成功");


    }
    @PostMapping("/mp")
    public Result<?> testMultiQuestion(MultiQuestion multiQuestion) {/*模拟前端发送数据过来*/
        int i = multiQuestionService.insertMultiQuestion(multiQuestion);
        return Result.success("0","成功");

    }
    @GetMapping("/em")
    public Result<?> testExamMange(MultiQuestion multiQuestion) {/*模拟前端发送数据过来*/
        int i = multiQuestionService.insertMultiQuestion(multiQuestion);
        return Result.success("0","成功");

    }
    @GetMapping("/test")
    public Result<?> test1() {/*模拟前端发送数据过来*/
        List<FillQuestion> fillQuestions = fillQuestionService.queryAllFillQuestion();
        List<MultiQuestion> multiQuestions = multiQuestionService.queryAllMultiQuestion();
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.queryAllJudgeQuestion();
        Map<String, List<Object>> map = new HashMap<>();
        map.put("fillQuestions", Collections.singletonList(fillQuestions));
        map.put("multiQuestions", Collections.singletonList(multiQuestions));
        map.put("judgeQuestions", Collections.singletonList(judgeQuestions));
        return Result.success(map);
    }
}
