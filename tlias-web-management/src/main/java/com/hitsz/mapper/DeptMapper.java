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
    /*查询所有部门
    * 以下当当前数据库中的名称与dept对应的变量名，若遵循驼峰命名，可以直接通过在properties文件中配置
    * */
//    @Results({
//            @Result(column = "create_time",property = "createTime"),//前是数据库的名
//            @Result(column = "update_time",property = "updateTime")
//    })
// @Select("select id,name,create_time createTime,update_time updateTime from dept")
    @Select("select * from dept")
    public List<Dept> findAll();


    /*
    * 占位符号，若此接口方法形参只有一个简单类型参数，在占位符中填写的值可以是任意
    * 可以是id，也可以是afla
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
