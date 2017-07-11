package org.litbear.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by litbear on 2017/6/29.
 */
@Configuration
@ComponentScan(
        basePackages = {"org.litbear.ssm"},
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                value = RootConfig.WebPackage.class
        )
)
@MapperScan("org.litbear.ssm.dao")
public class RootConfig {

    public static class WebPackage extends RegexPatternTypeFilter{
        public WebPackage() {
            super(Pattern.compile("org\\.litbear\\.ssm\\.web"));
        }
    }

    @Bean
    public PropertiesFactoryBean propertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean
                = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(new ClassPathResource("db.properties"));

        return propertiesFactoryBean;
    }

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource
                = new DruidDataSource();
        Properties properties = null;
        try {
            properties = propertiesFactoryBean().getObject();
            druidDataSource.setMaxActive(10);
            druidDataSource.setMinIdle(5);
            druidDataSource.setUrl(properties.getProperty("jdbc.url"));
            druidDataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
            druidDataSource.setUsername(properties.getProperty("jdbc.username"));
            druidDataSource.setPassword(properties.getProperty("jdbc.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean
                = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("org.litbear.ssm.pojo");
        return sqlSessionFactoryBean;
    }



}
