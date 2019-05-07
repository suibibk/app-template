package com.gdpost.utils;
 
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
 
@Configuration
public class DruidDataSourceConfiguration {
    private String dbUrl = PropertiesUtil.get("dataSource.url");
    private String username =PropertiesUtil.get("dataSource.username");
    private String password =PropertiesUtil.get("dataSource.password");
    private String driverClassName  =PropertiesUtil.get("dataSource.driver");
    private int initialSize=Integer.parseInt(PropertiesUtil.get("dataSource.initialSize","5"));
    private int minIdle= Integer.parseInt(PropertiesUtil.get("dataSource.minIdle","5"));
    private int maxActive= Integer.parseInt(PropertiesUtil.get("dataSource.maxActive","20"));
    private int maxWait= Integer.parseInt(PropertiesUtil.get("dataSource.maxWait","60000"));
    private int timeBetweenEvictionRunsMillis= Integer.parseInt(PropertiesUtil.get("dataSource.timeBetweenEvictionRunsMillis","60000"));
    private int minEvictableIdleTimeMillis= Integer.parseInt(PropertiesUtil.get("dataSource.minEvictableIdleTimeMillis","300000"));
    private String validationQuery= PropertiesUtil.get("dataSource.validationQuery","SELECT 1 FROM DUAL");
    private boolean testWhileIdle= Boolean.parseBoolean(PropertiesUtil.get("dataSource.testWhileIdle","true"));
    private boolean testOnBorrow= Boolean.parseBoolean(PropertiesUtil.get("dataSource.testOnBorrow","false"));
    private boolean testOnReturn= Boolean.parseBoolean(PropertiesUtil.get("dataSource.testOnReturn","false"));
    private boolean poolPreparedStatements=Boolean.parseBoolean(PropertiesUtil.get("dataSource.poolPreparedStatements","true"));
    private int maxPoolPreparedStatementPerConnectionSize= Integer.parseInt(PropertiesUtil.get("dataSource.maxPoolPreparedStatementPerConnectionSize","20"));
    //wall, 去掉这个，不然会报sql injection violation
    private String filters= PropertiesUtil.get("dataSource.filters","stat,log4j");
    private String connectionProperties= PropertiesUtil.get("dataSource.connectionProperties","druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
 
    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
 
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
 
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        datasource.setConnectionProperties(connectionProperties);
 
        return datasource;
    }
}