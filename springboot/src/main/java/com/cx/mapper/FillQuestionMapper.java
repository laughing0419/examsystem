package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.JudgeQuestion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillQuestionMapper extends BaseMapper<FillQuestion> {
    /*随机抽取*/
    @Select("select * from fill_question order by rand() limit #{num}")
    List<FillQuestion> queryFillQuestionByRandom(@Param("num") int num);
    /*找考试的填空题*/
    List<FillQuestion> queryFillForExam(Integer paperId);
}
