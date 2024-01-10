package com.example.configuration;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Mybatis 설정
 */
@Configuration
@MapperScan(basePackages = "com.example.mvc.repository")
public class MybatisConfiguration {
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        // 1.dataSource 소스주입
        factoryBean.setDataSource(dataSource);

        // 2.mapper.xml 파일 경로 지정.
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/sql/*.xml"));

        // 3.옵션추가 (카멜케이스)
        SqlSessionFactory factory = factoryBean.getObject();
        factory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
