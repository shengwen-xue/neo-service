//package com.xsw.neo.service.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
///**
// * Druid数据源配置类
// *
// * @author xueshengwen
// * @since 2020/12/18 15:57
// */
//@Slf4j
//@Configuration
//public class DruidDBConfig {
//
//    @Value("${spring.datasource.datasource2.url}")
//    private String dbUrl;
//
//    @Value("${spring.datasource.datasource2.username}")
//    private String username;
//
//    @Value("${spring.datasource.datasource2.password}")
//    private String password;
//
//    @Value("${spring.datasource.datasource2.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.datasource2.druid.initial-size}")
//    private int initialSize;
//
//    @Value("${spring.datasource.datasource2.druid.min-idle}")
//    private int minIdle;
//
//    @Value("${spring.datasource.datasource2.druid.max-active}")
//    private int maxActive;
//
//    @Value("${spring.datasource.datasource2.druid.max-wait}")
//    private int maxWait;
//
//    @Value("${spring.datasource.datasource2.druid.time-between-eviction-runs-millis}")
//    private int timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.datasource2.druid.min-evictable-idle-time-millis}")
//    private int minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.datasource2.druid.validation-query}")
//    private String validationQuery;
//
//    @Value("${spring.datasource.datasource2.druid.test-while-idle}")
//    private boolean testWhileIdle;
//
//    @Value("${spring.datasource.datasource2.druid.test-on-borrow}")
//    private boolean testOnBorrow;
//
//    @Value("${spring.datasource.datasource2.druid.test-on-return}")
//    private boolean testOnReturn;
//
//    @Value("${spring.datasource.datasource2.druid.pool-prepared-statements}")
//    private boolean poolPreparedStatements;
//
//    @Value("${spring.datasource.datasource2.druid.max-pool-prepared-statement-per-connection-size}")
//    private int maxPoolPreparedStatementPerConnectionSize;
//
//    @Value("${spring.datasource.datasource2.druid.filter}")
//    private String filter;
//
//    @Value("${spring.datasource.datasource2.druid.connection-properties}")
//    private String connectionProperties;
//
//    @Value("${spring.datasource.datasource2.druid.use-global-data-source-stat}")
//    private String useGlobalDataSourceStat;
//
//    //声明其为Bean实例
//    //在同样的DataSource中，首先使用被标注的DataSource
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//
//        // configuration
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            datasource.setFilters(filter);
//        } catch (SQLException e) {
//            log.error("druid configuration initialization filter", e);
//        }
//        datasource.setConnectionProperties(connectionProperties);
//
//        return datasource;
//    }
//}
