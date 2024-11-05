package com.hitsz.mapper;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 10:37
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.DegreeInfo;
import com.hitsz.pojo.Student;
import com.hitsz.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> getStuByInfo(StudentQueryParam studentQueryParam);

    void delectStudentByIds(List<Integer> ids);

    void add(Student student);

    Student queryById(Integer id);

    void update(Student student);

    void deductPoint(Integer id, Integer score);

    List<DegreeInfo> studentDegreeData();

    @MapKey("className")
    List<Map> getClazzNumOfStu();
}
