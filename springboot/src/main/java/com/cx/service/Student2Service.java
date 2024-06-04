package com.cx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.mapper.StudentMapper;
import com.cx.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public class Student2Service extends ServiceImpl<StudentMapper, Student> {
    public boolean saveStudent(Student student){
        return saveOrUpdate(student);
    }
}
