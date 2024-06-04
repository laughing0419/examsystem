package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cx.mapper.TeacherMapper;
import com.cx.pojo.Teacher;
import com.cx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> queryAllTeacher() {
        return teacherMapper.selectList(null);//传入null查询全部用户
    }

    @Override
    public Teacher queryTeacherById(Integer id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("teacherId",teacher.getTeacherId());
        updateWrapper.set("teacherName",teacher.getTeacherName());
        updateWrapper.set("institute",teacher.getInstitute());
        updateWrapper.set("sex",teacher.getSex());
        updateWrapper.set("tel",teacher.getTel());
        updateWrapper.set("email",teacher.getEmail());
        updateWrapper.set("residence",teacher.getInstitute());
        updateWrapper.set("address",teacher.getAddress());

        return teacherMapper.update(null,updateWrapper);  //修改相应的字段
    }

    @Override
    public int deleteTeacher(Integer id) {
        return teacherMapper.deleteById(id);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return 0;
    }
}
