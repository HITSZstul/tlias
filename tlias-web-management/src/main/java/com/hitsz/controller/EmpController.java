package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.EmpQueryParam;
import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Result;
import com.hitsz.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;


    /*参数过多，不便管理*/
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "0")Integer page,
//                       @RequestParam(defaultValue = "10")Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
//        log.info("进行分页查询{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
//        PageBean pg = empService.page(page,pageSize);
//        return Result.success(pg);
//    }

    /*方式二：将多个参数封装到一个对象中*/
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("empQueryParam:{}", empQueryParam);
        PageBean pageBean = empService.page(empQueryParam);
        return Result.success(pageBean);
    }
}
