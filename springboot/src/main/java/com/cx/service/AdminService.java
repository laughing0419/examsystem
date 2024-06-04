package com.cx.service;

import com.cx.mapper.AdminMapper;
import com.cx.pojo.Admin;
import com.cx.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdminService {
    /*Service调用mapper层*/
    /*基本业务*/
    //查询所有管理员的信息
    List<Admin> queryAllAdmin();
    //根据id来查询管理员信息
    Admin queryAdminById(@Param("questionId") Integer id);
    //修改管理员信息
    int updateAdmin(Admin admin);  //返回影响行数
    //删除管理员信息根据id
    int deleteAdmin(@Param("adminId") Integer id);  //返回影响行数
    //插入管理员信息
    int insertAdmin(Admin admin); //返回影响行数

}
