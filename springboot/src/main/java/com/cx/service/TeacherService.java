package com.cx.service;

import com.cx.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有老师的信息
    List<Teacher> queryAllTeacher();
    //根据id来查询老师信息
    Teacher queryTeacherById(Integer teacherId);
    //修改学生信息
    int updateTeacher(Teacher teacher);  //返回影响行数
    //删除老师信息根据id
    int deleteTeacher(Integer id);  //返回影响行数
    //插入老师信息
    int insertTeacher(Teacher teacher); //返回影响行数
}
