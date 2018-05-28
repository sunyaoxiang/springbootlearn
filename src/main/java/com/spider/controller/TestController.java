package com.spider.controller;

import com.spider.entity.BondSpiderAnnoInfo;
import com.spider.service.ServeiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
//@RestController
//@RequestMapping(value = {"/api/v1/{tickerSymbol}"})
public class TestController {
    private final ServeiceInterface serveiceInterface;

    @Autowired
    public TestController(ServeiceInterface serveiceInterface) {
        this.serveiceInterface = serveiceInterface;
    }

//    @RequestMapping("/")
//    public List<BondSpiderAnnoInfo> getDefault(HttpServletResponse response, @PathVariable("tickerSymbol") String tickerSymbol) {
//        return getAllBondSpiderAnnoInfo(response, tickerSymbol);
//    }


    @RequestMapping(path = {"/all","/",""}, method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<BondSpiderAnnoInfo> getAllBondSpiderAnnoInfo(HttpServletResponse response, @PathVariable("tickerSymbol") String tickerSymbol) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serveiceInterface.findByTickerSymbol(tickerSymbol);
        if (bondSpiderAnnoInfos.isEmpty() == false) {
            return bondSpiderAnnoInfos;
        }
        return null;
    }

    @RequestMapping(path = "/first", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getFirstBondSpiderAnnoInfo(@PathVariable String tickerSymbol) {
        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serveiceInterface.findByTickerSymbol(tickerSymbol);
        for (BondSpiderAnnoInfo entity : bondSpiderAnnoInfos) {
            if (entity != null) {
                return entity.getTickerSymobol() + "|" + entity.getSecShortName() + "|" + entity.getPublishDate();
            }
        }
        return "-1";
    }

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String add(@Valid TestController testController, BindingResult result) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        return "ok";
//    }
}