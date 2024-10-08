package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:37
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Emp;
import com.hitsz.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /*分页查询*/
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id limit #{start},#{pageSize}")
//    List<Emp> getRow(Integer start, Integer pageSize);

    /*获取总记录数*/
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id;")
//    Long getTotal();

    /*使用PageHelper
    * 1，自动执行count（0）的操作
    * 2，自动拼接上limit的数据列表
    * 3，注意事项：SQL语句结尾不用加分号，
    * PageHelper只会对紧跟在其后的第一条语句进行分页操作！！！*/
//    @Select("select emp.*, dept.name deptName from emp left join dept on emp.dept_id = dept.id " +
//            "where emp.name like #{name} and" +
//            " emp.gender = #{gender} and" +
//            " entry_date between #{start} and #{end} " +
//            "order by tlias.emp.update_time desc")
    List<Emp> getRow(EmpQueryParam empQueryParam);
}