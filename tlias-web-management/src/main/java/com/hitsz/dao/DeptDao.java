package com.hitsz.dao;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 23:16
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import java.io.IOException;
import java.util.List;

public interface DeptDao {
    public List<String> list() throws IOException;
}
