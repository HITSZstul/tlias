package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 22:42
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
