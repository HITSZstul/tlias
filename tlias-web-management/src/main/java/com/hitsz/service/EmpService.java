package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */
import com.hitsz.pojo.Emp;
import com.hitsz.pojo.EmpQueryParam;
import com.hitsz.pojo.LoginInfo;
import com.hitsz.pojo.PageBean;

import java.util.List;

public interface EmpService {
    PageBean page(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp query(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp e);
}
