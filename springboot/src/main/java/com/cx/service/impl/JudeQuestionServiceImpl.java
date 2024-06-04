package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.mapper.JudgeQuestionMapper;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import com.cx.service.JudgeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudeQuestionServiceImpl implements JudgeQuestionService {
    @Autowired
    JudgeQuestionMapper judgeQuestionMapper;

    @Override
    public List<JudgeQuestion> queryAllJudgeQuestion() {
        return judgeQuestionMapper.selectList(null);
    }

    @Override
    public JudgeQuestion queryJudgeQuestionById(Integer id) {
        return judgeQuestionMapper.selectById(id);
    }

    @Override
    public int updateJudgeQuestion(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.updateById(judgeQuestion);
    }

    @Override
    public int deleteJudgeQuestion(Integer id) {
        return judgeQuestionMapper.deleteById(id);
    }

    @Override
    public int insertJudgeQuestion(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.insert(judgeQuestion);
    }

    @Override
    public List<JudgeQuestion> queryRandom(int num) {
        return judgeQuestionMapper.queryRandom(num);
    }

    @Override       //分页模糊查询
    public Page<JudgeQuestion> queryJudgeQuestionByPage(Integer pageNum, Integer pageSize, String search) {
        QueryWrapper<JudgeQuestion> queryWrapper = new QueryWrapper();
        if(search!=null){
            queryWrapper.like("question",search);
        }
        Page<JudgeQuestion> judgeQuestionPage = judgeQuestionMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        return judgeQuestionPage;
    }

    @Override
    public Page<JudgeQuestion> queryJudgeQuestion(Integer pagerNum, Integer pageSize, String keyWord, String level) {
        QueryWrapper<JudgeQuestion> queryWrapper = new QueryWrapper<>();
        if(!keyWord.equals("")&&!level.equals("")){
            queryWrapper.like("question",keyWord).eq("level",level);
        }else if(keyWord.equals("")&&!level.equals("")){
            queryWrapper.eq("level",level);
        }else if(!keyWord.equals("")&&level.equals("")){
            queryWrapper.like("question",keyWord);
        }else {
            queryWrapper=null;
        }
        Page<JudgeQuestion> judgeQuestionPage = judgeQuestionMapper.selectPage(new Page<>(pagerNum, pageSize), queryWrapper);
        return judgeQuestionPage;
    }

    @Override
    public List<JudgeQuestion> queryJudgeForExam(Integer paperId) {
        return judgeQuestionMapper.queryJudgeForExam(paperId);
    }
}
