package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-10-04 - 2024 10 04 11:27
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*部门管理的mapper接口*/
public interface DeptMapper {
    /*查询所有部门*/
    @Select("select * from dept")
    public List<Dept> findAll();

}
