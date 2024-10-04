package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 23:19
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.mapper.DeptMapper;
import com.hitsz.pojo.Dept;
import com.hitsz.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() throws IOException {
        return deptMapper.findAll();
    }
}
