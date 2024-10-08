package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-10-07 - 2024 10 07 21:13
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class EmpQueryParam {
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private Integer page = 1;
    private Integer pageSize = 10;
}
