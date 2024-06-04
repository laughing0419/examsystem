package com.cx.service;

import com.cx.pojo.Admin;
import com.cx.pojo.ExamManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamManageService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有管理员的信息
    List<ExamManage> queryAllExamManage();
    //根据id来查询管理员信息
    ExamManage queryExamManageById(@Param("examCode") Integer id);
    //修改管理员信息
    int updateExamManage(ExamManage examManage);  //返回影响行数
    //删除管理员信息根据id
    int deleteExamManage(@Param("examCode") Integer id);  //返回影响行数
    //插入管理员信息
    int insertExamManage(ExamManage examManage); //返回影响行数
    //查询最后一个paperId
    Integer queryPaperId();
    //查询试卷根据paeprId
    ExamManage queryExamByPaperId(Integer paperId);
}
