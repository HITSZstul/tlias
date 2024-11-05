package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-10-25 - 2024 10 25 17:06
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Clazz;
import com.hitsz.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /*实现分页查询 clazzQueryParam中保存的是 具有page和pageSize属性的，这些将在service中处理*/
    List<Clazz> getClazz(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz SelectById(Integer id);

    void update(Clazz clazz);

    List<Clazz> getAllClazz();
}
