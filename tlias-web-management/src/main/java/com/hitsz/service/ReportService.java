package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-10-24 - 2024 10 24 23:27
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    List<Map> empGenderData() ;

    JobOption empJobData();
}
