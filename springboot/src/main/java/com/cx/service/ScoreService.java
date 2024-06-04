package com.cx.service;

import com.cx.pojo.Score;

import java.util.List;

public interface ScoreService {
    int insertScore(Score score);
    /*查询分数*/
    List<Score> queryStudentScore(Integer studentId);
    /*根据id查询分数*/
    Score queryScoreById(Integer studentId);
    /*查所有学生的分数*/
    List<Score> queryAllScore();
    /*更新主观题*/
    int updateSubScore(Integer subScore,Integer studentId);
    /*更新总分*/
    int updateScore(Integer score ,Integer studentId);
}
