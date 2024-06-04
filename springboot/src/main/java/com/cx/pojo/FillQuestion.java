package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fill_question")
public class FillQuestion {
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer questionId;     //id
    private String question;        //题目内容
    private String answer;          //题目答案
    private String subject;         //题目科目
    private Integer score;          //题目分数
    private String analysis;        //题目分析
    private String level;           //题目难度
    private String section;         //所属章节
    private String questionType;    //题目类型
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;        //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;        //更新时间
}
