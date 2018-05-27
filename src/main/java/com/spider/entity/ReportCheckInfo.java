package com.spider.entity;


import java.util.List;


/**
 * Created by yaoxiang.sun on 2018/5/25.
 */
//@Entity
public class ReportCheckInfo {
    private Integer ID;
    private String tikcerSymbol;
    private String companyName;
    private String title;
    private String partingCotent;

    public ReportCheckInfo(Integer ID, String tikcerSymbol, String companyName, String title, String partingCotent) {
        this.ID = ID;
        this.tikcerSymbol = tikcerSymbol;
        this.companyName = companyName;
        this.title = title;
        this.partingCotent = partingCotent;
    }

    public ReportCheckInfo(List reportMsg) {
        this.ID = Integer.valueOf(reportMsg.get(0).toString());
        this.tikcerSymbol = reportMsg.get(1).toString();
        this.companyName = reportMsg.get(2).toString();
        this.title = reportMsg.get(3).toString();
        this.partingCotent = reportMsg.get(4).toString();
    }

    public Integer getID() {
        return ID;
    }

    public String getTikcerSymbol() {
        return tikcerSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTitle() {
        return title;
    }

    public String getPartingCotent() {
        return partingCotent;
    }
}
