package com.cx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.*;
import com.cx.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    StudentService service;
    @Autowired
    TeacherService teacherService;
    @Autowired
    JudgeQuestionService judgeQuestionService;
    @Test  //测试数据库连接池对象
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }
    @Test  //测试CRUD
    void contextLoads2() {
        List<Student> students = service.queryAllStudent();
        students.forEach(System.out::println);
    }
    @Test  //测试随机抽取
    void contextLoads3() {
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.queryRandom(3);
        judgeQuestions.forEach(System.out::println);
    }
    /*第一次
    *   JudgeQuestion(questionId=10006, subject=计算机网络, question=UTP为屏蔽双绞线, answer=F, analysis=null, score=2, section=null)
        JudgeQuestion(questionId=10011, subject=计算机网络, question=利用BT下载时,用户越多,下载速度越快, answer=T, analysis=null, score=2, section=null)
        JudgeQuestion(questionId=10010, subject=计算机网络, question=任务管理器可以关闭所有的进程, answer=F, analysis=null, score=2, section=null)
    * */
    /*第二次
    *   JudgeQuestion(questionId=10006, subject=计算机网络, question=UTP为屏蔽双绞线, answer=F, analysis=null, score=2, section=null)
        JudgeQuestion(questionId=10002, subject=计算机网络, question=OSI参考模型中,不同节点的同等层具有不同的功能, answer=F, analysis=null, score=2, section=null)
        JudgeQuestion(questionId=10011, subject=计算机网络, question=利用BT下载时,用户越多,下载速度越快, answer=T, analysis=null, score=2, section=null)
    * */
    @Test
    void contextLoads4() {
       /* Student student = service.queryStudentById(1);

        System.out.println(student);*/
        /*List<Student> students = service.queryAllStudent();
        students.forEach(System.out::println);*/
        Teacher teacher = teacherService.queryTeacherById(20081001);
        System.out.println(teacher);
    }
    @Autowired
    ExamManageService examManageService;
    @Autowired
    MultiQuestionService multiQuestionService;
    @Test  //测试查询PaperId
    void contextLoads5() {
        /*Integer integer = examManageService.queryPaperId();
        System.out.println(integer);*/
        Page<MultiQuestion> multiQuestionPage = multiQuestionService.queryMultiQuestion(1, 5, "", "");
        System.out.println(multiQuestionPage.getRecords());
    }
    @Test
    void contextLoads6() {
        List<MultiQuestion> multiQuestions = multiQuestionService.queryMultiForExam(1010);
        multiQuestions.forEach(System.out::println);
    }
    @Test
    void contextLoads7() {
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.queryJudgeForExam(1010);
        judgeQuestions.forEach(System.out::println);
    }
    @Autowired
    FillQuestionService fillQuestionService;
    @Test
    void contextLoads8() {
        List<FillQuestion> fillQuestions = fillQuestionService.queryFillForExam(1010);
        fillQuestions.forEach(System.out::println);
    }
    @Autowired
    StudentPaperService studentPaperService;
    @Test
    void contextLoads9() {
        List<StudentPaper> studentPapers = studentPaperService.queryStudentPaper(20194001);

        System.out.println(studentPapers);
    }
}
