package com.cx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.Admin;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.MultiQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FillQuestionService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有填空题的信息
    List<FillQuestion> queryAllFillQuestion();
    //根据id来查询填空题信息
    FillQuestion queryFillQuestionById(@Param("questionId") Integer id);
    //修改填空题信息
    int updateFillQuestion(FillQuestion fillQuestion);  //返回影响行数
    //删除填空题信息根据id
    int deleteFillQuestion(@Param("questionId") Integer id);  //返回影响行数
    //插入填空题信息
    int insertFillQuestion(FillQuestion fillQuestion); //返回影响行数
    //随机抽取
    List<FillQuestion> queryFillQuestionByRandom(@Param("num") int num);
    //分页模糊查询
    Page<FillQuestion> queryFillQuestionByPage(Integer pagerNum, Integer pageSize,String search);
    //分页难度模糊查询
    Page<FillQuestion> queryFillQuestion(Integer pagerNum, Integer pageSize, String keyWord, String level);
    /*找考试的填空题*/
    List<FillQuestion> queryFillForExam(Integer paperId);
}
