package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("paper_manage")
public class PaperManage  {
    private Integer paperId;
    private String questionType;
    private Integer questionId;
    private String score;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;        //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;        //更新时间
}
