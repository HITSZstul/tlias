package com.hitsz.dao.impl;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 23:18
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.dao.DeptDao;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<String> list() throws IOException {
        // 1. 加载并读写dept.txt中的数据
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        // 2. 解析文本中的数据，封装为对象，多个对象封装到集合中
        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");
        return lines;
    }
}
