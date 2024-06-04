package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student_paper")
public class StudentPaper {
    private Integer studentId;  //学生id
    private Integer questionId; //题目id
    private Integer paperId;    //试卷id
    private String studentAnswer;   //学生答案
    private String rightAnswer;     //正确答案
    private String question;        //题目
}
