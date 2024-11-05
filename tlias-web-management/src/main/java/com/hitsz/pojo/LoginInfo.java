package com.hitsz.pojo;/*
 *@Author:Simon
 *@Date: 2024-11-03 - 2024 11 03 21:49
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private Integer id;
    private String username;//用户名
    private String name;//姓名
    private String token;//令牌

}
