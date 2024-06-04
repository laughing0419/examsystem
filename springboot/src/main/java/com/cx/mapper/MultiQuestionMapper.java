package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.FillQuestion;
import com.cx.pojo.MultiQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MultiQuestionMapper extends BaseMapper<MultiQuestion> {
    /*随机抽取*/
    @Select("select * from multi_question order by rand() limit #{num}")
    List<MultiQuestion> queryMultiQuestionByRandom(@Param("num") int num);
    /*找考试的选择题*/
    List<MultiQuestion> queryMultiForExam(Integer paperId);

}
