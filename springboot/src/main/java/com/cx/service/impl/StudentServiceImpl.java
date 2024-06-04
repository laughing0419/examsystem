package com.cx.service.impl;

import com.cx.mapper.StudentMapper;
import com.cx.pojo.Student;
import com.cx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service  //只能标注在实现类上 注入ioc容器中
public class StudentServiceImpl implements StudentService {

    @Autowired//自动配置
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.selectById(id);
    }

    @Override
    public int updateStudent(Student student) {

        return studentMapper.updateById(student);
    }

    @Override
    public int deleteStudent(Integer id) {

        return studentMapper.deleteById(id);
    }

    @Override
    public int insertStudent(Student student) {

        return studentMapper.insert(student);
    }
}
