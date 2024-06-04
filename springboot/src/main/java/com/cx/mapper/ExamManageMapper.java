package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.ExamManage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamManageMapper extends BaseMapper<ExamManage> {
    @Select("SELECT paperId FROM `exam_manage` ORDER BY paperId DESC LIMIT 1")
    Integer queryPaperId();


}
