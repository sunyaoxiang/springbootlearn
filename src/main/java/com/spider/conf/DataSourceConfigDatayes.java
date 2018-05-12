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
public class DataSourceConfigDatayes {

    @Bean(name = "datayesdbDS") @Qualifier("datayesdbDS")
    @Primary
    @ConfigurationProperties(prefix="spring.datayesdb.datasource")
    public DataSource datayesdbDataSource(){
        return DataSourceBuilder.create().build();
    }

}