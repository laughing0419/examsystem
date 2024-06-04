package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.FillQuestion;
import com.cx.service.FillQuestion2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fill")
public class FillQuestion2Controller {
    @Autowired
    private FillQuestion2Service fillQuestion2Service;

    @PostMapping
    public List<FillQuestion> findAll(){
        return fillQuestion2Service.list();
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return fillQuestion2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<FillQuestion> findPage(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize,
                                         @RequestParam(defaultValue = "") String question){
        IPage<FillQuestion> page = new Page<>(pageNum,pageSize);
        QueryWrapper<FillQuestion> queryWrapper = new QueryWrapper<>();
        if(!"".equals(question)){
            queryWrapper.like("question",question);
        }
        queryWrapper.orderByDesc("questionId");
        return fillQuestion2Service.page(page,queryWrapper);
    }
}
