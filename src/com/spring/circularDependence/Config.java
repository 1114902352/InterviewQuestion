package com.spring.circularDependence;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.circularDependence")
public class Config {

    /**
     * 关闭循环依赖
     * @return
     */
//    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                DefaultListableBeanFactory factory = (DefaultListableBeanFactory)beanFactory;
                factory.setAllowCircularReferences(false);
            }
        };
    }
}
