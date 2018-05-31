package com.spider.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
//@Entity
//@Table(name = "bond_spider_anno_info")
public class BondSpiderAnnoInfo {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "TICKER_SYMBOL")
    private String tickerSymbol;

    @Column(name = "SEC_SHORT_NAME")
    private String secShortName;

    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickerSymobol() {
        return tickerSymbol;
    }

    public void setTickerSymobol(String tickerSymobol) {
        this.tickerSymbol = tickerSymobol;
    }

    public String getSecShortName() {
        return secShortName;
    }

    public void setSecShortName(String secShortName) {
        this.secShortName = secShortName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}

