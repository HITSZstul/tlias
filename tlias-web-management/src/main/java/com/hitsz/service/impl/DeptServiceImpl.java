package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 23:19
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.dao.DeptDao;
import com.hitsz.dao.impl.DeptDaoImpl;
import com.hitsz.pojo.Dept;
import com.hitsz.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    public List<Dept> list() throws IOException {
        //1.调用dao获取数据
        List<String> lines = deptDao.list();
        List<Dept> list = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String name = parts[1];
            LocalDateTime updateTime = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new Dept(id, name, updateTime);
        }).toList();
        return list;
    }
}
