package com.spider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yaoxiang.sun on 2018/5/8.
 */
//@RestController
public class DownLoadByStreaming {
    @RequestMapping("download")
    public StreamingResponseBody handle() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write('a');
                outputStream.write('\r');
                outputStream.write('d');
            }
        };
    }
}
