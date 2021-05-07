package com.xsw.neo.service;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ActivitiApiApplicationTests {

    /**
     * 生成代码Test
     */
    @Test
    void generatingCodeTest() {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 输出路径
        globalConfig.setOutputDir("D://code");
        // 设置文件重写
        globalConfig.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        globalConfig.setActiveRecord(true);
        // XML 二级缓存
        globalConfig.setEnableCache(false);
        // XML ResultMap
        globalConfig.setBaseResultMap(true);
        // XML columList
        globalConfig.setBaseColumnList(false);
        globalConfig.setAuthor("xue-sheng-wen");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true");
        mpg.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名 ORACLE 注意
        // strategy.setCapitalMode(true);
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix("i_");
        // 表名生成策略 underline_to_camel：强调驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xsw.activitiapi")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setEntity("model.entity")
                .setXml("mapper.xml");
        mpg.setPackageInfo(packageConfig);

        // 执行生成
        mpg.execute();
    }
}
