package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("multi_question")
public class MultiQuestion {
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer questionId;     //ID
    private String subject;         //所属科目
    private String question;        //题目内容
    private String answerA;         //选项A
    private String answerB;         //选项B
    private String answerC;         //选项C
    private String answerD;         //选项D
    private String answer;          //正确选项
    private String analysis;        //分析
    private Integer score;          //分数
    private String section;         //所属章节
    private String level;           //题目难度
    private String questionType;    //题目类型
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;        //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;        //更新时间
}
