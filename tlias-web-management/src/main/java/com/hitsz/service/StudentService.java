package com.hitsz.service;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 10:36
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Student;
import com.hitsz.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageBean queryByPage(StudentQueryParam studentQueryParam);

    void deleteStudentById(List<Integer> ids);

    void add(Student student);

    Student getById(Integer id);

    void update(Student student);

    void deductPoint(Integer id, Integer score);
}
