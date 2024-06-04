package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository  //代表持久层  //使用mybatis-plus自动实现CRUD
public interface StudentMapper extends BaseMapper<Student> {

}
