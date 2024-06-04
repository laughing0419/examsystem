package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.mapper.StudentMapper;
import com.cx.pojo.Student;
import com.cx.service.Student2Service;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student2")
public class Student2Controller {
    @Autowired
    private Student2Service student2Service;

    @PostMapping
    public boolean save(@RequestBody Student student){
        return student2Service.saveStudent(student);
    }

    @GetMapping
    public List<Student> findAll(){
        return student2Service.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return student2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<Student> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String studentName){
        IPage<Student> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        if(!"".equals(studentName)){
            queryWrapper.like("studentName",studentName);
        }
        queryWrapper.orderByDesc("studentId");
        return student2Service.page(page,queryWrapper);
    }
}
