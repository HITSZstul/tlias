package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 10:40
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private String name;
    private Integer degree;
    private Integer clazzId;

    private Integer page;
    private Integer pageSize;
}
