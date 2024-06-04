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
@TableName("admin")  //role=0
public class Admin {
    @TableId(type = IdType.AUTO) //一定要写不然无法通过ID查询  IdType.AUTO:根据当前表中id最大值自增+1
    private Integer adminId;     //ID
    private String adminName;   //姓名
    private String sex;         //性别
    private String tel;         //电话
    private String email;       //邮箱
    private String pwd;         //密码
    private String cardId;      //身份证号码
    private String role;        ////角色(0管理员,1教师,2学生)

}
