package com.cx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MultiQuestionService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有选择题的信息
    List<MultiQuestion> queryAllMultiQuestion();
    //根据id来查询选择题信息
    MultiQuestion queryMultiQuestionById(@Param("questionId") Integer id);
    //修改选择题信息
    int updateMultiQuestion(MultiQuestion multiQuestion);  //返回影响行数
    //删除选择题信息根据id
    int deleteMultiQuestion(@Param("questionId") Integer id);  //返回影响行数
    //插入选择题信息
    int insertMultiQuestion(MultiQuestion multiQuestion); //返回影响行数
    //随机抽取
    List<MultiQuestion> queryMultiQuestionByRandom(int num);
    //分页模糊查询
    Page<MultiQuestion> queryMultiQuestionByPage(Integer pagerNum, Integer pageSize,String search);
    //分页难度模糊查询
    Page<MultiQuestion> queryMultiQuestion(Integer pagerNum, Integer pageSize,String keyWord,String level);
    /*找考试的选择题*/
    List<MultiQuestion> queryMultiForExam(Integer paperId);
}
