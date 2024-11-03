package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-10-25 - 2024 10 25 16:56
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class ClazzQueryParam {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private Integer page = 1;
    private Integer pageSize = 10;
}
