package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("exam_manage")
public class ExamManage {
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer examCode;
    private String description;
    private String source;
    private Integer paperId;
    private String examDate;
    private Integer totalTime;
    private String grade;
    private String term;
    private String major;
    private String institute;
    private Integer totalScore;
    private String type;
    private String tips;
    private String tag;

}
