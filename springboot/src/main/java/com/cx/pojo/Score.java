package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score")
public class Score {
    private Integer scoreId;    //分数编号
    private Integer examCode;   //考试编号
    private Integer studentId;  //学生id
    private Integer obScore;    //客观题分数
    private Integer subScore;   //主观题分数
    private Integer score;      //总分
    private String subject;     //考试科目
    private String answerDate;    //答题日期
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;        //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;        //更新时间
}
