package com.cx.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
public class Teacher {  //role=3
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer teacherId;     //ID
    private String teacherName; //姓名
    private String institute;   //专业
    private String sex;         //性别
    private String tel;         //电话号码
    private String email;       //电子邮件
    private String pwd;         //密码
    private String cardId;      //身份证号
    private String type;        //职称（讲师，教授。。）
    private String role;        //角色(0管理员,1教师,2学生)
    private String icon;        //头像
    private String residence;   //居住地
    private String address;     //联系地址
}
