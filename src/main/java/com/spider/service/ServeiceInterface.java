package com.spider.service;

import com.spider.entity.BondSpiderAnnoInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@Repository
@Qualifier("datayesDataSource")
public interface ServeiceInterface extends CrudRepository<BondSpiderAnnoInfo, String> {

    List<BondSpiderAnnoInfo> findByTickerSymbol(String TICKER_SYMBOL);

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<BondSpiderAnnoInfo> findByPulishDate(Date publishDate) {
//        String sql = "SELECT " +
//                "[id]," +
//                "[tickerSymbol]," +
//                "[secShortName]," +
//                " [publishDate]" +
//                "  FROM " +
//                "[bond_spider_anno_info] " +
//                "where " +
//                "[PUBLISH_DATE] = \'" + publishDate + "\'";
//
//        return (List<BondSpiderAnnoInfo>) jdbcTemplate.query(sql, new RowMapper<BondSpiderAnnoInfo>() {
//
//            @Override
//            public BondSpiderAnnoInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//                BondSpiderAnnoInfo bondSpiderAnnoInfo = new BondSpiderAnnoInfo();
//                bondSpiderAnnoInfo.setId(rs.getLong("ID"));
//                bondSpiderAnnoInfo.setTickerSymobol(rs.getString("TICKER_SYMBOL"));
//                bondSpiderAnnoInfo.setSecShortName(rs.getString("SEC_SHORT_NAME"));
//                bondSpiderAnnoInfo.setPublishDate(rs.getDate("PUBLISH_DATE"));
//                return bondSpiderAnnoInfo;
//            }
//        });
//    }
}
