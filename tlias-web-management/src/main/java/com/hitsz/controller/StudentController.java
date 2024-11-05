package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 10:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Result;
import com.hitsz.pojo.Student;
import com.hitsz.pojo.StudentQueryParam;
import com.hitsz.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /*分页查询*/
    @GetMapping
    public Result queryByPage(StudentQueryParam studentQueryParam){
        log.info("queryByPage studentQueryParam:{}", studentQueryParam);
        PageBean pageBean = studentService.queryByPage(studentQueryParam);
        return Result.success(pageBean);
    }

    /*批量删除学员的时候，其请求若是放在路径中，只能通过pathvariable的方式接收，使用String封装
    * 再进一步划分为集合*/
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids){
        log.info("delete ids:{}", ids);
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .toList();
        /*toList将当前对象转换为一个不可修改的列表*/
        studentService.deleteStudentById(idList);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("add student:{}", student);
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("getById:{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("update student:{}", student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result deductPoint(@PathVariable Integer id, @PathVariable Integer score){
        log.info("deductPoint id:{},score:{}", id, score);
        studentService.deductPoint(id,score);
        return Result.success();
    }
}
