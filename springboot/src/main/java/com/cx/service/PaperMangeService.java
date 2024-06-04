package com.cx.service;

import com.cx.pojo.PaperManage;

import java.util.List;

public interface PaperMangeService {
    void insertPaper(Integer[] questionId);
    void insertPaper(Integer[] questionId,String[] score);
    List<PaperManage> queryPaperManageById(Integer paperId);
}
