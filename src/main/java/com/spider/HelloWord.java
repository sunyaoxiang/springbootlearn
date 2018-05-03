package com.spider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@RestController
public class HelloWord {
    @RequestMapping("/h")
    public String sayHello() {
        return "Hello,World!";
    }
}
