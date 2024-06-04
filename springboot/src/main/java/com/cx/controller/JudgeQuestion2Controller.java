package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.JudgeQuestion;
import com.cx.service.JudgeQuestion2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/judge")
public class JudgeQuestion2Controller {
    @Autowired
    private JudgeQuestion2Service judgeQuestion2Service;

    @PostMapping
    public List<JudgeQuestion> findAll(){
        return judgeQuestion2Service.list();
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return judgeQuestion2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<JudgeQuestion> findPage(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize,
                                         @RequestParam(defaultValue = "") String question){
        IPage<JudgeQuestion> page = new Page<>(pageNum,pageSize);
        QueryWrapper<JudgeQuestion> queryWrapper = new QueryWrapper<>();
        if(!"".equals(question)){
            queryWrapper.like("question",question);
        }
        queryWrapper.orderByDesc("questionId");
        return judgeQuestion2Service.page(page,queryWrapper);
    }
}
