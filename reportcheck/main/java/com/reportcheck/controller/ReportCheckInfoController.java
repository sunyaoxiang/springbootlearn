package com.reportcheck.controller;

import com.reportcheck.SystemConfig;
import com.reportcheck.entity.ReportCheckInfo;
import com.reportcheck.entity.ReportListInfo;
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
//    @RequestMapping("/find/mybatis/page")
//    public String findUserPageFromMybatis(HttpServletRequest request, Integer pageNum, Integer pageSize) {
//        pageNum = pageNum == null ? 1 : pageNum;
//        pageSize = pageSize == null ? 10 : pageSize;
//        PageHelper.startPage(pageNum, pageSize);
//        List<UserMo> list = userMapper.selectUserList();
//        PageInfo pageInfo = new PageInfo(list);
//        Page page = (Page) list;
//        return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " + JSON.toJSONString(page);
//    }

    @RequestMapping(value = {"/list/{pageNum}/{pageSize}"}, method = RequestMethod.GET)
    public String allReportList(Model model, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 50 : pageSize;
        String group_dict = "group_dict_up";
        String filename = SystemConfig.getCheckDataDir() + group_dict + ".json";
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }

        JSONObject json = getJSONobjectByFileName(filename);

        ArrayList<ReportListInfo> allReportList = new ArrayList<ReportListInfo>();

        List<List> groupDictUp = json.getJSONArray("group_dict_up");



//        Integer lastPageNum = groupDictUp.size() % pageSize;
        Integer infosCount = groupDictUp.size();
        Integer pagesCount = infosCount / pageSize;Integer startNum = pageNum * pageSize;
        Integer endNum = (pageNum + 1) * pageSize < infosCount ? (pageNum + 1) * pageSize : infosCount;

        ArrayList<Integer>  pageInfo = new ArrayList<Integer>();
        pageInfo.add(pageNum);
        pageInfo.add(pageSize);
        pageInfo.add(infosCount);
        pageInfo.add(pagesCount);
        pageInfo.add(startNum);
        pageInfo.add(endNum);

        for (int i = startNum; i < endNum; i++) {
            allReportList.add(new ReportListInfo(groupDictUp.get(i)));
        }

//        for (List each : groupDictUp) {
//            allReportList.add(new ReportListInfo(each));
//        }

        model.addAttribute("alg_group_data", allReportList);
        model.addAttribute("pageInfo", pageInfo);

        return "reportlist";
    }

    @RequestMapping(value = "/{tikcerSymbol}", method = RequestMethod.GET)
    public String listReportInfo(Model model, @PathVariable("tikcerSymbol") String tikcerSymbol) {

        ArrayList reportCheckInfoList = getJsonFromFile(tikcerSymbol);
        if (reportCheckInfoList != null) {
            model.addAttribute("alg_data_equal_list", reportCheckInfoList.get(0));
            model.addAttribute("zhaoyang_data_equal_list", reportCheckInfoList.get(1));
            model.addAttribute("alg_data_unequal_list", reportCheckInfoList.get(2));
            model.addAttribute("zhaoyang_data_unequal_list", reportCheckInfoList.get(3));
            model.addAttribute("alg_data_all_list", reportCheckInfoList.get(4));
            model.addAttribute("zhaoyang_data_all_list", reportCheckInfoList.get(5));
            return "report";
        }
        return "/report/all";
    }

    public static ArrayList<ReportCheckInfo> getJsonFromFile(String tikcerSymbol) {
        String filename = SystemConfig.getCheckDataDir() + tikcerSymbol + ".json";
        File file = new File(filename);
        if (!file.exists()) {
            return null;
        }

//        alg_data_equal_list;
        ArrayList<ReportCheckInfo> algDataEqualList = new ArrayList<ReportCheckInfo>();
//        zhaoyang_data_equal_list;
        ArrayList<ReportCheckInfo> zhaoyangDataEqualList = new ArrayList<ReportCheckInfo>();

//        alg_data_unequal_list;
        ArrayList<ReportCheckInfo> algDataUnequalList = new ArrayList<ReportCheckInfo>();
//        zhaoyang_data_unequal_list;
        ArrayList<ReportCheckInfo> zhaoyangDataUnequalList = new ArrayList<ReportCheckInfo>();

//        alg_data_all_list;
        ArrayList<ReportCheckInfo> algDataAllList = new ArrayList<>();
//        zhaoyang_data_all_list;
        ArrayList<ReportCheckInfo> zhaoyangDataAllList = new ArrayList<ReportCheckInfo>();

        ArrayList arrayList = new ArrayList();

        arrayList.add(algDataEqualList);
        arrayList.add(zhaoyangDataEqualList);

        arrayList.add(algDataUnequalList);
        arrayList.add(zhaoyangDataUnequalList);


        arrayList.add(algDataAllList);
        arrayList.add(zhaoyangDataAllList);


        JSONObject json = getJSONobjectByFileName(filename);

        List<List> alg_data_equal_list = json.getJSONArray("alg_data_equal_list");
        for (List each : alg_data_equal_list) {
            algDataEqualList.add(new ReportCheckInfo(each));
        }

        List<List> zhaoyang_data_equal_list = json.getJSONArray("zhaoyang_data_equal_list");
        for (List each : zhaoyang_data_equal_list) {
//                ReportCheckInfo reportCheckInfo = new ReportCheckInfo(each);
            zhaoyangDataEqualList.add(new ReportCheckInfo(each));
        }

        List<List> alg_data_unequal_list = json.getJSONArray("alg_data_unequal_list");
        for (List each : alg_data_unequal_list) {
            algDataUnequalList.add(new ReportCheckInfo(each));
        }

        List<List> zhaoyang_data_unequal_list = json.getJSONArray("zhaoyang_data_unequal_list");
        for (List each : zhaoyang_data_unequal_list) {
            zhaoyangDataUnequalList.add(new ReportCheckInfo(each));
        }

        List<List> alg_data_all_list = json.getJSONArray("alg_data_all_list");
        for (List each : alg_data_all_list) {
            algDataAllList.add(new ReportCheckInfo(each));
        }

        List<List> zhaoyang_data_all_list = json.getJSONArray("zhaoyang_data_all_list");
        for (List each : zhaoyang_data_all_list) {
            zhaoyangDataAllList.add(new ReportCheckInfo(each));
        }

        return arrayList;

    }

    public static JSONObject getJSONobjectByFileName(String filename) {
        JSONObject json = null;
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

            json = JSONObject.fromObject(allFileStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

//    public static void main(String[] args) {
//        allReportList("000006");
//    }

}
