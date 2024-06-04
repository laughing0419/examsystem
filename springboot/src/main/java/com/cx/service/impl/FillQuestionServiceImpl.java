package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.mapper.FillQuestionMapper;
import com.cx.pojo.Admin;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.MultiQuestion;
import com.cx.service.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillQuestionServiceImpl implements FillQuestionService {
    @Autowired
    FillQuestionMapper fillQuestionMapper;

    @Override
    public List<FillQuestion> queryAllFillQuestion() {
        return fillQuestionMapper.selectList(null);
    }

    @Override
    public FillQuestion queryFillQuestionById(Integer id) {
        return fillQuestionMapper.selectById(id);
    }

    @Override
    public int updateFillQuestion(FillQuestion fillQuestion) {
        return fillQuestionMapper.updateById(fillQuestion);
    }

    @Override
    public int deleteFillQuestion(Integer id) {
        return fillQuestionMapper.deleteById(id);
    }

    @Override
    public int insertFillQuestion(FillQuestion fillQuestion) {
        return fillQuestionMapper.insert(fillQuestion);
    }

    @Override
    public List<FillQuestion> queryFillQuestionByRandom(int num) {
        return fillQuestionMapper.queryFillQuestionByRandom(num);
    }

    @Override
    public Page<FillQuestion> queryFillQuestionByPage(Integer pagerNum, Integer pageSize, String search) {
        QueryWrapper<FillQuestion> queryWrapper = new QueryWrapper();
        if(search!=null){
            queryWrapper.like("question",search);
        }
        Page<FillQuestion> fillQuestionPage = fillQuestionMapper.selectPage(new Page<>(pagerNum, pageSize), queryWrapper);
        return fillQuestionPage;
    }

    @Override
    public Page<FillQuestion> queryFillQuestion(Integer pagerNum, Integer pageSize, String keyWord, String level) {
        QueryWrapper<FillQuestion> queryWrapper = new QueryWrapper<>();
        if(!keyWord.equals("")&&!level.equals("")){
            queryWrapper.like("question",keyWord).eq("level",level);
        }else if(keyWord.equals("")&&!level.equals("")){
            queryWrapper.eq("level",level);
        }else if(!keyWord.equals("")&&level.equals("")){
            queryWrapper.like("question",keyWord);
        }else {
            queryWrapper=null;
        }
        Page<FillQuestion> fillQuestionPage = fillQuestionMapper.selectPage(new Page<>(pagerNum, pageSize), queryWrapper);
        return fillQuestionPage;
    }

    @Override
    public List<FillQuestion> queryFillForExam(Integer paperId) {
        return fillQuestionMapper.queryFillForExam(paperId);
    }
}
