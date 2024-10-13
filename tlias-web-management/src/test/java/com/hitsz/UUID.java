package com.hitsz;/*
 *@Author:Simon
 *@Date: 2024-10-13 - 2024 10 13 10:32
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import org.junit.jupiter.api.Test;

public class UUID {
    @Test
    public void test() {
        for(int i=0;i<10;i++){
            System.out.println(java.util.UUID.randomUUID().toString());
        }
    }
}
