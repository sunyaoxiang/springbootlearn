package com.spider.controller;

import com.spider.bean.BondSpiderAnnoInfo;
import com.spider.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
//@Controller
//@RequestMapping("/annoinfo")
public class BondSpiderAnnoInfoController {

    @Autowired
    private ServiceInterface serviceInterface;

//    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
//    , produces = "application/json;charset=UTF-8"
//    @ResponseBody
//    @RequestMapping("/list")
    public String listAnnoInfo(Model model) {
//        response.addHeader("Access-Control-Allow-Origin", "*");

        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serviceInterface.findByTickerSymbol("136807");


        model.addAttribute("anninfos", bondSpiderAnnoInfos);
        return "/annoinfo/list";
    }
}