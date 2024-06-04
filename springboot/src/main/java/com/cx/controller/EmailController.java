package com.cx.controller;

import com.cx.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {      //如果要实现群发邮件 读取学生的邮件 可以使用for循环实现
    @Autowired
    JavaMailSender mailSender;
    @GetMapping
    public Result<?> sendEmail(@RequestParam(defaultValue = "") String messageText,
                               @RequestParam(defaultValue = "1936018865@qq.com") String sender ,
                               @RequestParam(defaultValue = "") String addressee,
                               @RequestParam(defaultValue = "") String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(messageText);
        message.setFrom(sender);
        message.setTo(addressee);
        mailSender.send(message);
        return Result.success("0","发送成功!!");
    }
}
