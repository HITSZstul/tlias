package com.hitsz.service.impl;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 10:37
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hitsz.mapper.StudentMapper;
import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Student;
import com.hitsz.pojo.StudentQueryParam;
import com.hitsz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageBean queryByPage(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list = studentMapper.getStuByInfo(studentQueryParam);
        Page<Student> pageStu = (Page<Student>) list;
        return new PageBean(pageStu.getTotal(),pageStu.getResult());
    }

    @Override
    public void deleteStudentById(List<Integer> ids) {
        studentMapper.delectStudentByIds(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.add(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void deductPoint(Integer id, Integer score) {
        studentMapper.deductPoint(id,score);
    }


}
