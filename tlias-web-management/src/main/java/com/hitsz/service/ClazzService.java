package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-10-25 - 2024 10 25 17:02
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Clazz;
import com.hitsz.pojo.ClazzQueryParam;
import com.hitsz.pojo.PageBean;

import java.util.List;

public interface ClazzService {
    PageBean getClazz(ClazzQueryParam clazzQueryParam);

    void delete(Integer ids);
}
