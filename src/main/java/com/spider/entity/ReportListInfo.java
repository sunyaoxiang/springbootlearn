package com.spider.entity;


import java.util.List;


/**
 * Created by yaoxiang.sun on 2018/5/25.
 */
//@Entity
public class ReportListInfo {
    private String tikcerSymbol;
    private String companyName;
    private int algDataAllListLen;
    private int algDataEqualListLen;
    private int algDataUnequalListLen;
    private int zhaoyangDataAllListLen;
    private int zhaoyangDataEqualListLen;
    private int zhaoyangDataUnequalListLen;

    public ReportListInfo(String tikcerSymbol, String companyName, int algDataAllListLen, int algDataEqualListLen, int algDataUnequalListLen, int zhaoyangDataAllListLen, int zhaoyangDataEqualListLen, int zhaoyangDataUnequalListLen) {
        this.tikcerSymbol = tikcerSymbol;
        this.companyName = companyName;
        this.algDataAllListLen = algDataAllListLen;
        this.algDataEqualListLen = algDataEqualListLen;
        this.algDataUnequalListLen = algDataUnequalListLen;
        this.zhaoyangDataAllListLen = zhaoyangDataAllListLen;
        this.zhaoyangDataEqualListLen = zhaoyangDataEqualListLen;
        this.zhaoyangDataUnequalListLen = zhaoyangDataUnequalListLen;
    }

    public ReportListInfo(List reportMsg) {
        this.tikcerSymbol = reportMsg.get(0).toString();
        this.companyName = reportMsg.get(1).toString();
        this.algDataAllListLen = Integer.valueOf(reportMsg.get(2).toString());
        this.algDataEqualListLen = Integer.valueOf(reportMsg.get(3).toString());
        this.algDataUnequalListLen = Integer.valueOf(reportMsg.get(4).toString());
        this.zhaoyangDataAllListLen = Integer.valueOf(reportMsg.get(5).toString());
        this.zhaoyangDataEqualListLen = Integer.valueOf(reportMsg.get(6).toString());
        this.zhaoyangDataUnequalListLen = Integer.valueOf(reportMsg.get(7).toString());
    }

    public String getTikcerSymbol() {
        return tikcerSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getAlgDataAllListLen() {
        return algDataAllListLen;
    }

    public int getAlgDataEqualListLen() {
        return algDataEqualListLen;
    }

    public int getAlgDataUnequalListLen() {
        return algDataUnequalListLen;
    }

    public int getZhaoyangDataAllListLen() {
        return zhaoyangDataAllListLen;
    }

    public int getZhaoyangDataEqualListLen() {
        return zhaoyangDataEqualListLen;
    }

    public int getZhaoyangDataUnequalListLen() {
        return zhaoyangDataUnequalListLen;
    }
}
