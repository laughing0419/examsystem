package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cx.mapper.MultiQuestionMapper;
import com.cx.pojo.MultiQuestion;
import com.cx.service.MultiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {
    @Autowired
    MultiQuestionMapper multiQuestionMapper;
    @Override
    public List<MultiQuestion> queryAllMultiQuestion() {
        return multiQuestionMapper.selectList(null);
    }

    @Override
    public MultiQuestion queryMultiQuestionById(Integer id) {
        return multiQuestionMapper.selectById(id);
    }

    @Override
    public int updateMultiQuestion(MultiQuestion multiQuestion) {
        return multiQuestionMapper.updateById(multiQuestion);
    }

    @Override
    public int deleteMultiQuestion(Integer id) {
        return multiQuestionMapper.deleteById(id);
    }

    @Override
    public int insertMultiQuestion(MultiQuestion multiQuestion) {
        return multiQuestionMapper.insert(multiQuestion);
    }

    @Override
    public List<MultiQuestion> queryMultiQuestionByRandom(int num) {
        return multiQuestionMapper.queryMultiQuestionByRandom(num);
    }

    @Override       //分页模糊查询
    public Page<MultiQuestion> queryMultiQuestionByPage(Integer pagerNum, Integer pageSize,String search) {
        QueryWrapper<MultiQuestion> queryWrapper = new QueryWrapper();
        if(search!=null){
            queryWrapper.like("question",search);
        }
        Page<MultiQuestion> multiQuestionPage = multiQuestionMapper.selectPage(new Page<>(pagerNum, pageSize), queryWrapper);
        return multiQuestionPage;
    }

    @Override       //分页难度模糊查询
    public Page<MultiQuestion> queryMultiQuestion(Integer pagerNum, Integer pageSize, String keyWord, String level) {
        QueryWrapper<MultiQuestion> queryWrapper = new QueryWrapper<>();
        if(!keyWord.equals("")&&!level.equals("")){
            queryWrapper.like("question",keyWord).eq("level",level);
        }else if(keyWord.equals("")&&!level.equals("")){
            queryWrapper.eq("level",level);
        }else if(!keyWord.equals("")&&level.equals("")){
            queryWrapper.like("question",keyWord);
        }else {
            queryWrapper=null;
        }
        Page<MultiQuestion> multiQuestionPage = multiQuestionMapper.selectPage(new Page<>(pagerNum, pageSize), queryWrapper);
        return multiQuestionPage;
    }

    @Override
    public List<MultiQuestion> queryMultiForExam(Integer paperId) {
        return multiQuestionMapper.queryMultiForExam(paperId);
    }

}
