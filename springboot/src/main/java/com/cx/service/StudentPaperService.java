package com.cx.service;

import com.cx.pojo.StudentPaper;

import java.util.List;

public interface StudentPaperService {
    /*插入学生考试试卷*/
    int insertPaper(StudentPaper studentPaper);
    /*查询学生答案*/
    List<StudentPaper> queryStudentPaper(Integer studentId);

}
