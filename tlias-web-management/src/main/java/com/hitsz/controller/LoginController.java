package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 21:54
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Emp;
import com.hitsz.pojo.LoginInfo;
import com.hitsz.pojo.Result;
import com.hitsz.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工进行登录中....");
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }else{
            return Result.error("用户名或密码错误");
        }
    }
}
