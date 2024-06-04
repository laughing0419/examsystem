package com.cx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cx.pojo.StudentPaper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPaperMapper extends BaseMapper<StudentPaper> {
    List<StudentPaper> queryStudentPaper(Integer studentId);
}
