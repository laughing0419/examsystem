package com.cx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //使用lombok插件自动生成
@AllArgsConstructor  //有参
@NoArgsConstructor  //无参
@TableName("student")
public class Student { //role = 2
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer studentId;  //ID
    private String  studentName;//姓名
    private String grade;       //年级
    private String major;       //专业
    private String clazz;       //班级
    private String institute;   //学院
    private String tel;         //电话号码
    private String email;       //电子邮件
//    @JsonIgnore
    private String pwd;         //密码
    private String cardId;      //身份证号
    private String sex;         //性别
    private String role;        //角色(0管理员,1教师,2学生)
    private String icon;        //头像
    private String residence;    //居住地
}
