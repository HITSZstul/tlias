package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-24 - 2024 10 24 23:24
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.ClazzNumOfStu;
import com.hitsz.pojo.DegreeInfo;
import com.hitsz.pojo.JobOption;
import com.hitsz.pojo.Result;
import com.hitsz.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData(){
        log.info("员工信息统计");
        JobOption jobOption = reportService.empJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData(){
        log.info("统计员工性别人数");
        List<Map> list= reportService.empGenderData();
        return Result.success(list);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData(){
        log.info("统计学员教育程度");
        List<DegreeInfo> degreeInfos= reportService.studentDegreeData();
        return Result.success(degreeInfos);
    }

    @GetMapping("/studentCountData")
    public Result studentCountData(){
        log.info("统计每个班的学员人数");
        ClazzNumOfStu clazzNumOfStu = reportService.getClazzNumOfStu();
        return Result.success(clazzNumOfStu);
    }

    @GetMapping("/log/page")
    public Result logPage(){
        log.info("查询日志信息");
        return Result.success();
    }
}
