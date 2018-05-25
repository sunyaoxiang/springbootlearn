package com.spider.controller;

import com.spider.entity.BondSpiderAnnoInfo;
import com.spider.service.ServeiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@Controller
@RequestMapping("/annoinfo")
public class BondSpiderAnnoInfoController {

    @Autowired
    private ServeiceInterface serveiceInterface;

//    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
//    , produces = "application/json;charset=UTF-8"
//    @ResponseBody
    @RequestMapping("/list")
    public String listAnnoInfo(Model model) {
//        response.addHeader("Access-Control-Allow-Origin", "*");

        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serveiceInterface.findByTickerSymbol("136807");


        model.addAttribute("anninfos", bondSpiderAnnoInfos);
        return "/annoinfo/list";
    }
}