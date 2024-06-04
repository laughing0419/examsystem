package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository     //代表持久层  //继承BaseMapper<Teacher> 使用mybatis-plus自动实现CRUD
public interface AdminMapper extends BaseMapper<Admin> {

}
