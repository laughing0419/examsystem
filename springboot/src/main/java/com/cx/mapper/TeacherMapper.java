package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository     //代表持久层  //继承BaseMapper<Teacher> 使用mybatis-plus自动实现CRUD
public interface TeacherMapper extends BaseMapper<Teacher> {

}
