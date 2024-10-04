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
import java.time.LocalDateTime;
import java.util.List;
@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() throws IOException {
        return deptMapper.findAll();
    }

    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }
    @Override
    public void add(Dept dept) {
        /*1.为基础属性赋值*/
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        /*2.调用mapper接口*/
        deptMapper.insert(dept);
    }

    /*根据id查询部门*/
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
