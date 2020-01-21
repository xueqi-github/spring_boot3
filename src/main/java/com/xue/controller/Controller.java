package com.xue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xueqi on 2020-01-16 12:37
 */
@Slf4j
@RestController
public class Controller {
//    http://localhost:8080/swagger-ui.html
    @GetMapping
    public String hello(@RequestParam(name = "content",required = false) String content){
        log.info("开始打印日志，内容为{}",content);
        return content;
    }

}
