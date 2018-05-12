package com.spider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.Callable;

/**
 * Created by yaoxiang.sun on 2018/5/8.
 */
@RestController
@RequestMapping("/concurrent")
public class ConcurrentLearn {
    @RequestMapping(method = RequestMethod.GET)
    public Callable<String> processUpload(final MultipartFile file) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "concurrent views";
            }
        };
    }

//    @RequestMapping("/quotes")
//    @ResponseBody
    public DeferredResult<String> quotesGetDeferredResult() {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @RequestMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = quotesGetDeferredResult();
        deferredResult.setResult("case");
        return deferredResult;
    }
}
