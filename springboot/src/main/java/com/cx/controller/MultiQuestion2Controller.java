package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.MultiQuestion;
import com.cx.pojo.Teacher;
import com.cx.service.MultiQuestion2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multi")
public class MultiQuestion2Controller {

    @Autowired
    private MultiQuestion2Service multiQuestion2Service;

    @PostMapping
    public List<MultiQuestion> findAll(){
        return multiQuestion2Service.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return multiQuestion2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<MultiQuestion> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String question){
        IPage<MultiQuestion> page = new Page<>(pageNum,pageSize);
        QueryWrapper<MultiQuestion> queryWrapper = new QueryWrapper<>();
        if(!"".equals(question)){
            queryWrapper.like("question",question);
        }
        queryWrapper.orderByDesc("questionId");
        return multiQuestion2Service.page(page,queryWrapper);
    }
}
