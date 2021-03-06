package com.spring.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.spring.beanFactoryPostProcessor")
@EnableAspectJAutoProxy
public class Config {
    @org.springframework.context.annotation.Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                // 获取BeanFactory
                DefaultListableBeanFactory factory = (DefaultListableBeanFactory)beanFactory;
                // 注入BeanDefinition
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Bean.class);
                AbstractBeanDefinition bd = builder.getBeanDefinition();
                bd.getPropertyValues().addPropertyValue("name","bean1");
                factory.registerBeanDefinition("bean1",bd);
                // 直接注入单例
                Bean b = new Bean();
                b.setName("bean2");
                factory.registerSingleton("bean2",b);
            }
        };
    }

    @org.springframework.context.annotation.Bean
    public static BeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor(){
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Bean.class);
                AbstractBeanDefinition bd = builder.getBeanDefinition();
                bd.getPropertyValues().addPropertyValue("name","bean3");
                registry.registerBeanDefinition("bean3",bd);
            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

            }
        };
    }

    @org.springframework.context.annotation.Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if(bean instanceof Bean){
                    System.out.println("before"+beanName);
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(bean instanceof Bean){
                    System.out.println("after"+beanName);
                }
                return bean;
            }
        };
    }

}
