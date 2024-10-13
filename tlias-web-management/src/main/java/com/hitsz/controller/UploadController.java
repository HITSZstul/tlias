package com.hitsz.controller;/*
 *@Author:Simon
 *@Date: 2024-10-13 - 2024 10 13 10:17
 *@Description:web-project-actual-combat
 *@version:1.0
 */

import com.hitsz.pojo.Result;
import com.hitsz.util.AliyunOSSProperties;
import com.hitsz.util.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
public class UploadController {
    /*
    * 本地存储：存储在服务器本地磁盘目录
    * */
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile file) throws IOException {
//        log.info("文件上传 username = {}, age = {}, file {}", username, age,file);
//
//        /*文件名称被写死，每次写入文件上次的文件内容就被覆盖了
//        * 希望构建一个新的文件，且不能重复
//        * 需要获取原始文件名，获取后缀
//        *
//        * 默认的文件上传大小是小于1m的，在配置文件中修改
//        *
//        * 接收上传的图片，将图片存储OSS起来
//        * 返回图片访问的URL
//        * */
////        String originalFilename = file.getOriginalFilename();
////        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
////        String newFileName = UUID.randomUUID().toString()+extName;
////        file.transferTo(new File("E:/image/"+newFileName));
//        /*
//        * */
//
//        return Result.success();
//    }
//    @Value("${aliyun.oss.endpoint}")
//    String endpoint;
//    @Value("${aliyun.oss.bucketName}")
//    String bucketName;
    @Autowired
    AliyunOSSProperties aliyunOssProperties;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("文件上传，上传文件名：{}", file.getOriginalFilename());
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String URL = AliyunOSSUtils.upload(aliyunOssProperties.getEndPoint(),aliyunOssProperties.getBuketKey(), file.getBytes(), extName);
        return Result.success(URL);
    }
}
