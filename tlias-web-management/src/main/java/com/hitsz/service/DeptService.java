package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 23:30
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Dept;

import java.io.IOException;
import java.util.List;

public interface DeptService {
    public List<Dept> list() throws IOException;
    public void add(Dept dept);
    public void delete(Integer id);
    public Dept getById(Integer id);
    public void update(Dept dept);
}
