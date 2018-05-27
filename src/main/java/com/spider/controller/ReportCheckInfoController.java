package com.spider.controller;

import com.spider.SystemConfig;
import com.spider.entity.ReportCheckInfo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/25.
 */
@Controller
@RequestMapping("/report")
public class ReportCheckInfoController {

//    @RequestMapping(value = "/{tikcerSymbol}", method = RequestMethod.GET)
//    public String listReportInfo(Model model, @PathVariable("tikcerSymbol") String tikcerSymbol) {
//        ArrayList<ReportCheckInfo> reportCheckInfoList = getJsonFromFile(tikcerSymbol);
//
//        model.addAttribute("reportAll", reportCheckInfoList);
//
//        return "report";
//    }

    @RequestMapping(value = "/{tikcerSymbol}", method = RequestMethod.GET)
    public String listReportInfo(Model model, @PathVariable("tikcerSymbol") String tikcerSymbol) {

        ArrayList reportCheckInfoList = getJsonFromFile(tikcerSymbol);
        if (reportCheckInfoList != null) {
            model.addAttribute("zhaoyangDataEqualList", reportCheckInfoList.get(0));
            model.addAttribute("algDataEqualList", reportCheckInfoList.get(1));
            return "report";
        }
        return "upload";
    }

    public static ArrayList<ReportCheckInfo> getJsonFromFile(String tikcerSymbol) {
        String filename = SystemConfig.getCheckDataDir() + tikcerSymbol + ".json";
        File file  = new File(filename);
        if (!file.exists()) {
            return null;
        }
        ArrayList<ReportCheckInfo> zhaoyangDataEqualList = new ArrayList<ReportCheckInfo>();
        ArrayList<ReportCheckInfo> algDataEqualList = new ArrayList<ReportCheckInfo>();

        ArrayList arrayList = new ArrayList();
        arrayList.add(zhaoyangDataEqualList);
        arrayList.add(algDataEqualList);

        try {
            BufferedReader brname;
            brname = new BufferedReader(new FileReader(filename));
//            brname = new BufferedReader(new FileReader("src/main/resources/templates/check_data/" + tikcerSymbol + ".json"));
            String allFileStr = "";
            String lineStr;
            while ((lineStr = brname.readLine()) != null) {
                allFileStr = allFileStr + lineStr;
            }

            allFileStr = allFileStr.
                    replace("\r", "").
                    replace("\n", "").
                    replace("\r\n", "").
                    replace("\t", "").
                    replace("None", "\'None\'");
//            System.out.println(allFileStr);

            JSONObject json = JSONObject.fromObject(allFileStr);

            List<List> zhaoyang_data_equal_list = json.getJSONArray("zhaoyang_data_equal_list");

            for (List each:zhaoyang_data_equal_list) {
//                ReportCheckInfo reportCheckInfo = new ReportCheckInfo(each);
                zhaoyangDataEqualList.add(new ReportCheckInfo(each));
            }

            List<List> alg_data_equal_list = json.getJSONArray("alg_data_equal_list");
            for (List each:alg_data_equal_list) {
//                ReportCheckInfo reportCheckInfo = ;
                algDataEqualList.add(new ReportCheckInfo(each));
            }

            brname.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return arrayList;

    }

    public static void main(String[] args) {
        getJsonFromFile("000006");
    }

}
