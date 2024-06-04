package com.cx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cx.mapper.ScoreMapper;
import com.cx.pojo.Score;
import com.cx.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public int insertScore(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public List<Score> queryStudentScore(Integer studentId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper();
        queryWrapper.eq("studentId",studentId);
        List<Score> scores = scoreMapper.selectList(queryWrapper);


        return scores;
    }

    @Override
    public Score queryScoreById(Integer studentId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper();
        queryWrapper.eq("studentId",studentId);
        return scoreMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Score> queryAllScore() {
        return scoreMapper.selectList(null);
    }

    @Override
    public int updateSubScore(Integer subScore,Integer studentId) {
        UpdateWrapper<Score> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("studentId",studentId);
        updateWrapper.set("subScore",subScore);
        return scoreMapper.update(null,updateWrapper);
    }

    @Override
    public int updateScore(Integer score,Integer studentId) {
        UpdateWrapper<Score> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("studentId",studentId);
        updateWrapper.set("score",score);
        return scoreMapper.update(null,updateWrapper);
    }
}
