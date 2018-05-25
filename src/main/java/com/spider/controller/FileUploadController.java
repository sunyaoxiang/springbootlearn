package com.spider.controller;

import com.spider.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by yaoxiang.sun on 2018/5/9.
 */
@Controller
public class FileUploadController {
    @GetMapping("/upload")
    public String html() {
        return "upload";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            String filemainname = filename;
            String suffix = "";
            if (filename.contains(".")) {
                filemainname = filename.substring(0, filename.lastIndexOf("."));
                suffix = filename.substring(filename.lastIndexOf("."));
            }
            String path = SystemConfig.getUploadDir();
            Calendar now = Calendar.getInstance();
//            String path = ".\\src\\main\\resources\\upload\\";
            String timetag = new SimpleDateFormat("yyyyMMddHHmmss").format(now.getTime());

            FileOutputStream outStream = new FileOutputStream(path + filemainname + timetag + suffix);

            byte[] bytes = file.getBytes();
            outStream.write(bytes);
            outStream.close();
            return "uploadSuccess";
        }
        return "uploadFailure";
    }

//    @RequestMapping
//    public String myHandleMethod(WebRequest webRequest, Model model) {
//
//        long lastModified = // 1. 应用相关的方式计算得到(application-specific calculation)
//
//        if (request.checkNotModified(lastModified)) {
//            // 2. 快速退出 — 不需要更多处理了
//            return null;
//        }
//
//        // 3. 若资源更改了，那么再进行请求处理阶段，一般而言是准备响应内容
//        model.addAttribute(...);
//        return "myViewName";
//    }

//    @GetMapping("/uploadSuccess")
//    public void uploadSuccess() {
//    }
//    @GetMapping("/uploadFailure")
//    public void uploadFailure() {
//    }
}
