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

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    ClazzMapper clazzMapper;

    @Override
    public PageBean getClazz(ClazzQueryParam clazzQueryParam) {
        /*使用PageHelper对查询结果进行分页处理，这里查询到的是全部的数据
        * 根据页表的page：第几页；和pageSize：每页的数量，可以获得当前应返回的值
        * 而getTotal可以直接返回一共查询到的结果，即列表的元素数量*/
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> list = clazzMapper.getClazz(clazzQueryParam);

        Page<Clazz> page_list = (Page<Clazz>) list;
        return new PageBean(page_list.getTotal(), page_list.getResult());
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.SelectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> selectAllClazz() {
        return clazzMapper.getAllClazz();
    }
}
