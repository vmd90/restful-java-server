package com.vmd.restfuljavaserver.repos;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAutoConfiguration
public class DataSourceBeans {

    @Primary
    @Bean(name = "spring.datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws URISyntaxException {

        return DataSourceBuilder.create().build();
    }
}
