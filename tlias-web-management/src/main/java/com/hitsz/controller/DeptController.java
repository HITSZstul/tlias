package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 22:41
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Dept;
import com.hitsz.pojo.Result;
import com.hitsz.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    /*查询部门*/
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    //限定当前请求的方式
    public Result list() throws IOException {
        List<Dept> list = deptService.list();
        // 3、响应数据
        return Result.success(list);
    }
}
