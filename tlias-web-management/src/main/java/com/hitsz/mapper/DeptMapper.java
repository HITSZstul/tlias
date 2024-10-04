package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-10-04 - 2024 10 04 11:27
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*部门管理的mapper接口*/
@Mapper
public interface DeptMapper {
    /*查询所有部门*/
//    @Results({
//            @Result(column = "create_time",property = "createTime"),//前是数据库的名
//            @Result(column = "update_time",property = "updateTime")
//    })
    //@Select("select id,name,create_time createTime,update_time updateTime from dept")
    @Select("select * from dept")
    public List<Dept> findAll();
    /*
    * 占位符号
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
