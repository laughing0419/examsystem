package com.cx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.mapper.TeacherMapper;
import com.cx.pojo.Teacher;
import org.springframework.stereotype.Service;

@Service
public class Teacher2Service extends ServiceImpl<TeacherMapper, Teacher> {
    public boolean saveTeacher(Teacher teacher){
        return saveOrUpdate(teacher);
    }
}
