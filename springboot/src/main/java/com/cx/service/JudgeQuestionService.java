package com.cx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.Admin;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgeQuestionService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有判断题的信息
    List<JudgeQuestion> queryAllJudgeQuestion();
    //根据id来查询判断题信息
    JudgeQuestion queryJudgeQuestionById(@Param("questionId") Integer id);
    //修改判断题信息
    int updateJudgeQuestion(JudgeQuestion judgeQuestion);  //返回影响行数
    //删除判断题信息根据id
    int deleteJudgeQuestion(@Param("questionId") Integer id);  //返回影响行数
    //插入判断题信息
    int insertJudgeQuestion(JudgeQuestion judgeQuestion); //返回影响行数
    //随机抽取
    List<JudgeQuestion> queryRandom(int num);
    //分页模糊查询
    Page<JudgeQuestion> queryJudgeQuestionByPage(Integer pageNum,Integer pageSize,String search);
    //分页难度模糊查询
    Page<JudgeQuestion> queryJudgeQuestion(Integer pagerNum, Integer pageSize, String keyWord, String level);
    /*找考试的判断题*/
    List<JudgeQuestion> queryJudgeForExam(Integer paperId);
}
