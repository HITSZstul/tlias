package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:38
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hitsz.mapper.EmpMapper;
import com.hitsz.pojo.Emp;
import com.hitsz.pojo.EmpQueryParam;
import com.hitsz.pojo.PageBean;
import com.hitsz.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(EmpQueryParam empQueryParam) {
        /*调用mapper接口计算总记录total*/
//        Long total = empMapper.getTotal();
        /*调用mapper接口获取结果列表*/
//        Integer start = (page - 1) * pageSize;
//        List<Emp> emp_list = empMapper.getRow(start, pageSize);
//        System.out.println("OK in Service");
//        return new PageBean(total,emp_list);

        /*使用PageHelper简化分页操作，提高开发效率
        * 设置分页参数：PageHelper*/
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> emp_list = empMapper.getRow(empQueryParam);
        /*Page 是ArrayList的实现类，因此可以使用List接收Mapper的返回，同时可以强转为Page类型并使用Page
        * 类的各种返回数据的方法*/
        Page<Emp> p = (Page<Emp>) emp_list;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
