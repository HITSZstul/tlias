package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:37
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Emp;
import com.hitsz.pojo.EmpExpr;
import com.hitsz.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /*
    * 批量保存工作经历信息
    * 动态SQL，foreach，对数组和集合中的元素循环遍历，动态生成SQL语句
    */
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpId(List<Integer> empIds);
}
