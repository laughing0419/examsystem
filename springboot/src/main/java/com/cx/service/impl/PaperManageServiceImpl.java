package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cx.mapper.ExamManageMapper;
import com.cx.mapper.PaperManageMapper;
import com.cx.pojo.PaperManage;
import com.cx.service.ExamManageService;
import com.cx.service.PaperMangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperManageServiceImpl implements PaperMangeService {
    @Autowired
    ExamManageMapper examManageMapper;
    @Autowired
    PaperManageMapper paperManageMapper;

    @Override
    public void insertPaper(Integer[] questionId) {
        Integer paperId = examManageMapper.queryPaperId();
        String multi = "选择题";
        String fill = "填空题";
        String judge = "判断题";
        PaperManage paperManage = new PaperManage();
        paperManage.setPaperId(paperId);
        for(int i =0;i< questionId.length;i++){
            if(questionId[i]<20000){
                paperManage.setQuestionType(fill);
                paperManage.setQuestionId(questionId[i]);
                paperManageMapper.insert(paperManage);
            }else if(questionId[i]<30000&&questionId[i]>=20000){
                paperManage.setQuestionType(multi);
                paperManage.setQuestionId(questionId[i]);
                paperManageMapper.insert(paperManage);
            }else {
                paperManage.setQuestionType(judge);
                paperManage.setQuestionId(questionId[i]);
                paperManageMapper.insert(paperManage);
            }
        }
    }

    @Override
    public void insertPaper(Integer[]questionId,String[] score) {
        Integer paperId = examManageMapper.queryPaperId();
        String multi = "选择题";
        String fill = "填空题";
        String judge = "判断题";
        PaperManage paperManage = new PaperManage();
        paperManage.setPaperId(paperId);
        for(int i =0;i< questionId.length;i++){
            if(questionId[i]<20000){
                paperManage.setQuestionType(fill);
                paperManage.setQuestionId(questionId[i]);
                paperManage.setScore(score[i]);
                paperManageMapper.insert(paperManage);
            }else if(questionId[i]<30000&&questionId[i]>=20000){
                paperManage.setQuestionType(multi);
                paperManage.setQuestionId(questionId[i]);
                paperManage.setScore(score[i]);
                paperManageMapper.insert(paperManage);
            }else {
                paperManage.setQuestionType(judge);
                paperManage.setQuestionId(questionId[i]);
                paperManage.setScore(score[i]);
                paperManageMapper.insert(paperManage);
            }
        }

    }

    @Override
    public List<PaperManage> queryPaperManageById(Integer paperId) {
        QueryWrapper<PaperManage> queryWrapper = new QueryWrapper();
        queryWrapper.eq("paperId",paperId).lt("questionId",20000).ge("questionId",10000);
        return paperManageMapper.selectList(queryWrapper);
    }
}
