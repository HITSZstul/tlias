package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Emp;
import com.hitsz.pojo.EmpQueryParam;
import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Result;
import com.hitsz.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工emp:{}", emp);
        empService.add(emp);
        return Result.success();
    }

    /*两种方案接收：
    * 1.使用数组接收：数组名需要和参数名相同
    * 2.使用collection接收，需要增加requestParam的注解，一般推荐使用集合，集合的操作方法更多*/
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("id:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result Query(@PathVariable Integer id) {
        log.info("id:{}", id);
        Emp emp = empService.query(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("update emp:{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
