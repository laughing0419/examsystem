package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cx.mapper.ExamManageMapper;
import com.cx.pojo.ExamManage;
import com.cx.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    ExamManageMapper examManageMapper;


    @Override
    public List<ExamManage> queryAllExamManage() {
        return examManageMapper.selectList(null);
    }

    @Override
    public ExamManage queryExamManageById(Integer id) {
        return examManageMapper.selectById(id);
    }

    @Override
    public int updateExamManage(ExamManage examManage) {
        UpdateWrapper<ExamManage> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("paperId",examManage.getPaperId());

        return examManageMapper.update(examManage,updateWrapper);
    }

    @Override
    public int deleteExamManage(Integer id) {
        return examManageMapper.deleteById(id);
    }

    @Override
    public int insertExamManage(ExamManage examManage) {
        return examManageMapper.insert(examManage);
    }

    @Override
    public Integer queryPaperId() {
        return examManageMapper.queryPaperId();
    }

    @Override
    public ExamManage queryExamByPaperId(Integer paperId) {
        QueryWrapper<ExamManage> queryWrapper = new QueryWrapper();
        queryWrapper.eq("paperId",paperId);
        ExamManage examManage = examManageMapper.selectOne(queryWrapper);
        return examManage;
    }

}
