package com.spider.controller;

import com.spider.entity.ReportAllCount;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/25.
 */
@Controller
@RequestMapping("/report")
public class AllCountController {

    @RequestMapping(value = "/{tikcerSymbol}", method = RequestMethod.GET)
    public String listReportInfo(Model model, @PathVariable("tikcerSymbol") String tikcerSymbol) {
        ArrayList<ReportAllCount> reportAllCountList = getJsonFromFile(tikcerSymbol);

        model.addAttribute("reportAll", reportAllCountList);

        return "report";
    }

    public static ArrayList<ReportAllCount> getJsonFromFile(String tikcerSymbol) {
        ArrayList<ReportAllCount> reportAllCountList = new ArrayList<ReportAllCount>();

        try {
            BufferedReader brname;
            brname = new BufferedReader(new FileReader("src/main/resources/templates/check_data/" + tikcerSymbol + ".json"));
//            brname = new BufferedReader(new FileReader("src/main/resources/templates/check_data/" + tikcerSymbol + ".json"));
            String allFileStr = "";
            String lineStr;
            while ((lineStr = brname.readLine()) != null) {
                allFileStr = allFileStr + lineStr;
            }

            allFileStr = allFileStr.replace("\r", "").replace("\n", "").replace("\r\n", "").replace("\t", "");
//            System.out.println(allFileStr);

            JSONObject json = JSONObject.fromObject(allFileStr);

            List<List> list_data = json.getJSONArray("alg_data_all_list");

            for (List each:list_data) {
                ReportAllCount reportAllCount = new ReportAllCount(each);
                reportAllCountList.add(reportAllCount);
            }

            brname.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return reportAllCountList;

    }

    public static void main(String[] args) {
//        getJsonFromFile();
    }

}
