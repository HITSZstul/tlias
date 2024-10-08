package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-10-05 - 2024 10 05 21:32
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;//总记录数
    private List rows;//列表
}
