package com.spider.controller;

import com.spider.entity.BondSpiderAnnoInfo;
import com.spider.service.ServeiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@RestController
public class BondSpiderAnnoInfoController {

    @Autowired
    private ServeiceInterface serveiceInterface;

    //    @RequestMapping("/d")
    @RequestMapping(value = {"/api/v1/test"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getWorkDay(HttpServletResponse response) {
//    public BondSpiderAnnoInfo getWorkDay(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serveiceInterface.findByTickerSymbol("1880048");

        for (BondSpiderAnnoInfo entity : bondSpiderAnnoInfos) {
            if (entity != null) {
                return entity.getTickerSymobol() + "|" + entity.getSecShortName() + "|" + entity.getPublishDate();
            }
        }
        return "-1";
    }
}