package com.spider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * Created by yaoxiang.sun on 2018/5/8.
 */
//@RestController
public class ResponseBodyEmitterLearn {
    private ResponseBodyEmitter emitter;

    @RequestMapping("/events")
    public ResponseBodyEmitter handle() {
        otherThread();
        return emitter;
    }

    public void otherThread() {

    }



}
