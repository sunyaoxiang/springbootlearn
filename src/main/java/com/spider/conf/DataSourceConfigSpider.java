package com.spider.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by yaoxiang.sun on 2018/5/3.
 */
@Configuration
public class DataSourceConfigSpider {

    @Bean(name = "spiderdbDS") @Qualifier("spiderdbDS")
    @Primary
    @ConfigurationProperties(prefix="spring.spiderdb.datasource")
    public DataSource spiderdbDataSource(){
        return DataSourceBuilder.create().build();
    }

}