package com.cx.service.impl;

import com.cx.mapper.AdminMapper;
import com.cx.pojo.Admin;
import com.cx.pojo.Student;
import com.cx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> queryAllAdmin() {
        return adminMapper.selectList(null);
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public int deleteAdmin(Integer id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }
}
