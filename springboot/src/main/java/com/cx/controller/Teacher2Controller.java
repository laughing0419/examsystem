package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.Teacher;
import com.cx.service.Teacher2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher2")
public class Teacher2Controller {
    @Autowired
    private Teacher2Service teacher2Service;

    @PostMapping
    public boolean save(@RequestBody Teacher teacher){
        return teacher2Service.saveTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> findAll(){
        return teacher2Service.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return teacher2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<Teacher> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String teacherName){
        IPage<Teacher> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if(!"".equals(teacherName)){
            queryWrapper.like("teacherName",teacherName);
        }
        queryWrapper.orderByDesc("teacherId");
        return teacher2Service.page(page,queryWrapper);
    }
}
