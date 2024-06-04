package com.cx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.pojo.ExamManage;
import com.cx.pojo.FillQuestion;
import com.cx.service.ExamManage2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("examManage2")
public class ExamManage2Controller {
    @Autowired
    private ExamManage2Service examManage2Service;

    @PostMapping
    public List<ExamManage> findAll(){
        return examManage2Service.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return examManage2Service.removeById(id);
    }

    @GetMapping("/page")
    public IPage<ExamManage> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(defaultValue = "") String description){
        IPage<ExamManage> page = new Page<>(pageNum,pageSize);
        QueryWrapper<ExamManage> queryWrapper = new QueryWrapper<>();
        if(!"".equals(description)){
            queryWrapper.like("description",description);
        }
        queryWrapper.orderByDesc("examCode");
        return examManage2Service.page(page,queryWrapper);
    }
}
