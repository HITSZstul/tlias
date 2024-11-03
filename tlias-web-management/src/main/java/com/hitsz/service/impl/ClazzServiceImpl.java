package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-10-25 - 2024 10 25 17:02
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hitsz.mapper.ClazzMapper;
import com.hitsz.pojo.Clazz;
import com.hitsz.pojo.ClazzQueryParam;
import com.hitsz.pojo.PageBean;
import com.hitsz.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    ClazzMapper clazzMapper;

    @Override
    public PageBean getClazz(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.getClazz(clazzQueryParam);
        Page<Clazz> page = (Page<Clazz>) list;
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public void delete(Integer ids) {
        clazzMapper.deleteById(ids);
    }
}
