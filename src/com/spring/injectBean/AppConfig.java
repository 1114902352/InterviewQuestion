package com.spring.injectBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.injectBean")
public class AppConfig {

    @Bean
    public DataSource dataSource1(){
        return new DataSource("my name is datasource1");
    }

    @Bean
    public DataSource dataSource2(){
        return new DataSource("my name is datasource2");
    }

    @Bean
    public DataSource dataSource3(){
        return new DataSource("my name is datasource3");
    }

    @Bean
    public Service other(){
        Service s = new Service();
        s.setName("service1");
        return s;
    }

    @Bean
    public Service other2(){
        Service s = new Service();
        s.setName("service2");
        return s;
    }
}
