package com.spider.controller;

import com.spider.entity.BondSpiderAnnoInfo;
import com.spider.service.ServeiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@RestController
public class BondSpiderAnnoInfoController {

    @Autowired
    private ServeiceInterface serveiceInterface;
    @RequestMapping("/d")
//    @ResponseBody
    public String getWorkDay() {


        List<BondSpiderAnnoInfo> bondSpiderAnnoInfos = serveiceInterface.findByTickerSymbol("1880048");

        for (BondSpiderAnnoInfo entity :bondSpiderAnnoInfos) {
            if (entity != null) {
                return entity.getTickerSymobol() + "|" + entity.getSecShortName() + "|" +  entity.getPublishDate();
            }
        }

        return "-1";
    }

//    @Autowired
//    private BondSpiderAnnoInfoServeice bondSpiderAnnoInfoServeice;
//
//    @RequestMapping(path ="/getByPulishDate", value = "2018-04-22")
//    @ResponseBody
//    public String getBondSpiderAnnoInfoFindByPulishDate(@RequestParam(value = "2018-04-22") String publishDate) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try {
//            date = dateFormat.parse(publishDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<BondSpiderAnnoInfo> bondSpiderAnnoInfoList = bondSpiderAnnoInfoServeice.findByPulishDate(date);
//
//
//        if (bondSpiderAnnoInfoList.isEmpty() != false) {
//            for (BondSpiderAnnoInfo bondSpiderAnnoInfo : bondSpiderAnnoInfoList) {
//                return bondSpiderAnnoInfo.getTickerSymobol();
//            }
//        }
//        return "-1";
//    }

}
