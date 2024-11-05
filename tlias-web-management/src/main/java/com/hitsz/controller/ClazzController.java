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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*delete 的方法在路径中传递参数，需要从路径中读取路径参数；添加的注释@PathVariable
    * 注意：路径变量的名称必须与方法参数名称匹配，或者在注解中指定变量名称。*/
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) {
        log.info("deleteClazz ids={}", id);
        clazzService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("addClazz clazz={}", clazz);
        clazzService.insert(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result SelectById(@PathVariable Integer id) {
        log.info("SelectById clazz={}", id);
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    @PutMapping()
    public Result updateClazzById(@RequestBody Clazz clazz) {
        log.info("updateClazzById clazz={}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllClazz(){
        log.info("getAllClazz");
        List<Clazz> list = clazzService.selectAllClazz();
        return Result.success(list);
    }

}
