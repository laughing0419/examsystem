package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("judge_question")
public class JudgeQuestion {
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer questionId;      //id
    private String subject;         //考试科目
    private String question;        //试题内容
    private String answerA;
    private String answerB;
    private String answer;          //正确答案
    private String analysis;        //题目解析
    private Integer score;              //题目分数
    private String section;         //所属章节
    private String level;           //题目难度
    private String questionType;    //题目类型
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;        //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;        //更新时间

}
