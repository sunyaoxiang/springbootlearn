package com.spider.service;

import com.spider.entity.BondSpiderAnnoInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@Repository
public interface ServeiceInterface extends CrudRepository<BondSpiderAnnoInfo, String> {

    List<BondSpiderAnnoInfo> findByTickerSymbol(String TICKER_SYMBOL);
    List<BondSpiderAnnoInfo> findAll();

}
