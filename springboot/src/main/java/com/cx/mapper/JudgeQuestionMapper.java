package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.JudgeQuestion;
import com.cx.pojo.MultiQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeQuestionMapper extends BaseMapper<JudgeQuestion> {
    /*随机抽取*/
    @Select("select * from judge_question  order by rand() limit #{num}")
    List<JudgeQuestion> queryRandom(@Param("num") int num);
    /*找考试的判断题*/
    List<JudgeQuestion> queryJudgeForExam(Integer paperId);


}
