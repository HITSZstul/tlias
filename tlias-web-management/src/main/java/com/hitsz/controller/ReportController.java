package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-24 - 2024 10 24 23:24
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.JobOption;
import com.hitsz.pojo.Result;
import com.hitsz.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
