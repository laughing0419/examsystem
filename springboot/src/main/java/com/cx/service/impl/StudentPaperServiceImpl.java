package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cx.mapper.StudentPaperMapper;
import com.cx.pojo.StudentPaper;
import com.cx.service.StudentPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPaperServiceImpl implements StudentPaperService {
    @Autowired
    StudentPaperMapper studentPaperMapper;
    @Override
    public int insertPaper(StudentPaper studentPaper) {
        return studentPaperMapper.insert(studentPaper);
    }

    @Override
    public List<StudentPaper> queryStudentPaper(Integer studentId) {
        return studentPaperMapper.queryStudentPaper(studentId);
    }
}
