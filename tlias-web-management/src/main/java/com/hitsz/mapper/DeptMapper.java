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
    /*
    * 查询所有部门
    *
    * 以下当当前数据库中的名称与dept对应的变量名，若遵循驼峰命名，可以直接通过在properties文件中配置
    * */
//    @Results({
//            @Result(column = "create_time",property = "createTime"),//前是数据库的名
//            @Result(column = "update_time",property = "updateTime")
//    })
// @Select("select id,name,create_time createTime,update_time updateTime from dept")
    @Select("select * from dept")
    List<Dept> findAll();


    /*
    * 删除部门
    *
    * 占位符号，若此接口方法形参只有一个简单类型参数，在占位符中填写的值可以是任意
    * 可以是id，也可以是afla
    *
    * #{}参数值传递，即预编译，会替换为？安全性能高。
    * ${}拼接SQL语句，不安全，性能低，在表名，字段名动态设置时候使用
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /*查询部门，根据前端id信息调用SQL语句
    * 由于id是唯一的，因此直接返回值放置在一个对象中即可
    * */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /*在更新数据时，如何做到只想更新某一个或几个字段呢----动态SQL
    * 随着用户输入或外部条件的变化而变化的SQL语句
    * 推荐在XML文件中
    * */
    //@Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
