package com.xsw.neo.service.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author xueshengwen
 * @since 2021/5/11 15:55
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    @Autowired
    private DataSource1Properties dataSource1Properties;

    @Autowired
    private DataSource2Properties dataSource2Properties;

    @Bean(name = "dataSource1")
    public DataSource dataSource1(){
        log.info("dataSource1初始化....");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSource1Properties.getUrl());
        dataSource.setUsername(dataSource1Properties.getUsername());
        dataSource.setPassword(dataSource1Properties.getPassword());
        dataSource.setDriverClassName(dataSource1Properties.getDriverClassName());
        return dataSource;
    }

    @Bean(name = "dataSource2")
    @Primary
    public DataSource dataSource2(){
        log.info("dataSource2初始化....");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSource2Properties.getUrl());
        dataSource.setUsername(dataSource2Properties.getUsername());
        dataSource.setPassword(dataSource2Properties.getPassword());
        dataSource.setDriverClassName(dataSource2Properties.getDriverClassName());
        return dataSource;
    }
}
