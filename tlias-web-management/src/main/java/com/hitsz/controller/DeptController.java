package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-09-29 - 2024 09 29 22:41
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Dept;
import com.hitsz.pojo.Result;
import com.hitsz.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    /*查询部门*/
    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    //限定当前请求的方式
    public Result list() throws IOException {
        List<Dept> list = deptService.list();
        // 3、响应数据
        return Result.success(list);
    }
    /*
    * 删除部门
    * */
    /*
    接收请求参数--方式一
    基于原始的request对象获取id（少用，需要类型转化）
    */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) throws IOException {
//        System.out.println("根据ID删除部门");
//        String id = request.getParameter("id");
//        int id_ = Integer.parseInt(id);
//        System.out.println("ID是"+id_);
//        return Result.success();
//    }

    /*
    * 方式二：
    * 通过SpringBoot提供的@RequestParam注解绑定请求参数到方法形参
    * 此处的id要和前端中的参数名对应相同
    *
    * 使用场景：前端传递的参数名与controller方法的形参名不一致
    * 注意事项：required参数默认是true，即必须传递参数
    * 若讲required的值修改为false，即对参数传递没有强制要求
    * */
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(name = "id",required = false) Integer _id) throws IOException {
//        System.out.println("根据ID删除部门");
//        System.out.println("ID是"+_id);
//        return Result.success();
//    }

    /*
    * 方案三：若前端传递的参数名和controller方法形参名字一致，省略@RequestParam
    * */
    @DeleteMapping("/depts")
    public Result delete(Integer id) throws IOException {
        System.out.println("根据ID删除部门");
        deptService.delete(id);
        return Result.success();
    }


    /*新增部门*/
    /*问号后的参数，可以直接通过简单形参接收，如果是json格式的参数，通常
    * 会使用一个实体对象进行接收。
    *
    * {"name":"....."}----->@RequestBody对象
    *
    * 规则：JSON的键名与方法形参的属性名相同，并需要使用@RequestBody注解标识*/
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门"+dept);
        deptService.add(dept);
        return Result.success();
    }

}
