package com.cx.controller;

import com.cx.pojo.Admin;
import com.cx.pojo.Student;
import com.cx.pojo.Teacher;
import com.cx.service.AdminService;
import com.cx.service.StudentService;
import com.cx.service.TeacherService;
import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @PostMapping("/student")
    public Result<?> studentLogin(@RequestBody Student student, HttpServletRequest req, HttpServletResponse resp){
        Student studentById = studentService.queryStudentById(student.getStudentId());
        if(studentById==null){
            return Result.error("-1","学生不存在！");
        }else {
            if(student.getPwd().equals(studentById.getPwd())){
                Cookie cookie = new Cookie("studentId", studentById.getStudentId().toString());        //存cookie
                cookie.setPath("/");
                cookie.setMaxAge(60*60*60);        //设置cookie的过期时间
                resp.addCookie(cookie);
                return Result.success("0","登陆成功");
            }else {
                return Result.error("-2","密码错误");
            }
        }
    }
    @PostMapping("/teacher")
    public Result<?> teacherLogin(@RequestBody Teacher teacher, HttpServletRequest req, HttpServletResponse resp){
        Teacher teacherById = teacherService.queryTeacherById(teacher.getTeacherId());
        System.out.println(teacher);
        System.out.println(teacherById);
        if(teacherById==null){
            return Result.error("-1","老师账号不存在！");
        }else {
            if(teacherById.getPwd().equals(teacher.getPwd())){
                /*HttpSession session = req.getSession();
                session.setAttribute("teacher",teacherById);*/
                Cookie cookie = new Cookie("teacherId", teacherById.getTeacherId().toString());        //存cookie
                cookie.setPath("/");
                cookie.setMaxAge(60*60*60);        //设置cookie的过期时间
                resp.addCookie(cookie);
                return Result.success("0","登陆成功");
            }else {
                return Result.error("-2","密码错误");
            }
        }
    }
    @PostMapping("/admin")
    public Result<?> adminLogin(@RequestBody Admin admin,HttpServletRequest req, HttpServletResponse resp){
        Admin adminById = adminService.queryAdminById(admin.getAdminId());
        if(adminById==null){
            return Result.error("-1","你无权限或者管理员账号不存在！");
        }else {
            if(admin.getPwd().equals(adminById.getPwd())){
                Cookie cookie = new Cookie("adminId", adminById.getAdminId().toString());        //存cookie
                cookie.setPath("/");
                cookie.setMaxAge(60*15);        //设置cookie的过期时间
                resp.addCookie(cookie);
                return Result.success("0","登陆成功");
            }else {
                return Result.error("-2","密码错误");
            }
        }
    }
}
