package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:38
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hitsz.mapper.EmpExprMapper;
import com.hitsz.mapper.EmpLogMapper;
import com.hitsz.mapper.EmpMapper;
import com.hitsz.pojo.*;
import com.hitsz.service.EmpLogService;
import com.hitsz.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

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

    /*
    * 可以作用在方法上，表示方法被spring被事务控制
    * 若作用在类上，表示类中所有方法被spring控制
    * 若放在接口上，表示所有实现类的方法都被spring控制
    *
    * 方法执行前，开启事务，成功执行完毕，提交事务，出现异常，回滚事务
    * 主要在大量的增删改的方法上
    *
    * 1.属性一：rollbackFor，遇到什么异常的时候回滚，属性接收列表，列表中填异常类型。
    * 2.propagation，当一个事务被另一个事务调用，该如何进行事务控制？
    *
    * 无论是成功还是失败，都打印当前的日志
    * */
    @Autowired
    private EmpLogService empLogService;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void add(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            /*插入员工工作经历信息，上述插入结束后，id自动更新
            * 批量保存员工经历信息，需要插入多项数据*/
            List<EmpExpr> empExprs = emp.getExprList();
            if(!CollectionUtils.isEmpty(empExprs)){
                empExprs.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(empExprs);
            }

        } finally {
            /*模拟新增员工日志，无论成功还是失败都要打印日志
            * 因此在finally中，保证该SQL一定执行
            * 我们在方法体上加入了Transaction注解，因此在出现exception时，会将所有
            * 内容进行回滚操作，因此就需要新建事务
            * 将事务注解移到Service层中*/
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),emp.toString());
            empLogService.insertLog(empLog);
        }
    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        /*1.批量删除员工的基本信息*/
        empMapper.deleteById(ids);

        /*2.删除员工的工作经历信息*/
        empExprMapper.deleteByEmpId(ids);
    }

    @Override
    public Emp query(Integer id) {
        return empMapper.query(id);
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
        empExprMapper.deleteByEmpId(Arrays.asList(emp.getId()));
        List<EmpExpr> empExprs = emp.getExprList();
        if(!CollectionUtils.isEmpty(empExprs)){
            empExprs.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empExprs);
        }
    }

    @Override
    public LoginInfo login(Emp e) {
        Emp emp = empMapper.loginInfo(e);
        if(emp != null){
            return new LoginInfo(emp.getId(),emp.getUsername(),emp.getName(),null);
        }else{
            return null;
        }
    }
}
