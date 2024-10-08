package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */
import com.hitsz.pojo.EmpQueryParam;
import com.hitsz.pojo.PageBean;

public interface EmpService {
    PageBean page(EmpQueryParam empQueryParam);
}
