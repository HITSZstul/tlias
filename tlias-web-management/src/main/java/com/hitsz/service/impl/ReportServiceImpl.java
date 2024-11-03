package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-10-24 - 2024 10 24 23:27
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.mapper.EmpMapper;
import com.hitsz.pojo.JobOption;
import com.hitsz.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Map> empGenderData() {
        return empMapper.getGender();
    }

    @Override
    public JobOption empJobData() {
        JobOption jobOption = new JobOption();
        List<Map> jobData = empMapper.getJobData();
        System.out.println();
        System.out.println(jobData);
        /*[{poscount=13, pose=班主任}, {poscount=1, pose=学工主管}, {poscount=6, pose=讲师}, {poscount=6, pose=咨询师
                }, {poscount=1, pose=other}]

        这里定义的是一个List<Map<String,Object>>类型的数据，每次封装是定义一个map类型，然后在map中添加两个键值对
        例如：*/

        /*
        * // 创建一个 List 来存储多个 Map 对象
        List<Map<String, Object>> jobData = new ArrayList<>();

        // 创建第一个 Map 对象
        Map<String, Object> map1 = new HashMap<>();
        map1.put("poscount", 13);
        map1.put("pose", "班主任");
        jobData.add(map1);

        // 创建第二个 Map 对象
        Map<String, Object> map2 = new HashMap<>();
        map2.put("poscount", 1);
        map2.put("pose", "学工主管");
        jobData.add(map2);*/

        System.out.println();
        List<Object> jobList = jobData.stream().map(map ->{
            return map.get("pose");
        }).collect(Collectors.toList());

        List<Object> dataList = jobData.stream().map(map ->{
            return map.get("poscount");
        }).collect(Collectors.toList());

        jobOption.setDataList(dataList);
        jobOption.setJobList(jobList);
        return jobOption;
    }
}
