package com.cx.service;

import com.cx.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有学生的信息
    List<Student> queryAllStudent();
    //根据id来查询学生信息
    Student queryStudentById(Integer id);
    //修改学生信息
    int updateStudent(Student student);  //返回影响行数
    //删除学生信息根据id
    int deleteStudent(Integer id);  //返回影响行数
    //插入学生信息
    int insertStudent(Student student); //返回影响行数
}

