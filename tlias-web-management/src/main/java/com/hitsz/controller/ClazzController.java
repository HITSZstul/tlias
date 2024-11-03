package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-25 - 2024 10 25 16:38
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Clazz;
import com.hitsz.pojo.ClazzQueryParam;
import com.hitsz.pojo.PageBean;
import com.hitsz.pojo.Result;
import com.hitsz.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @GetMapping
    public Result getClazz(ClazzQueryParam clazzQueryParam) {
        log.info("getClazz clazzQueryParam={}", clazzQueryParam);
        PageBean clazzPageBean = clazzService.getClazz(clazzQueryParam);
        return Result.success(clazzPageBean);
    }

    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) {
        log.info("deleteClazz ids={}", id);
        clazzService.delete(id);
        return Result.success();
    }
}
