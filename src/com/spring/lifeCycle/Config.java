package com.spring.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
@ComponentScan(basePackages = "com.spring.lifeCycle")
public class Config {

    @Bean
    public BeanNameAware beanNameAware(){
        return new BeanNameAware() {
            @Override
            public void setBeanName(String name) {
                System.out.println("BeanNameAware:I can get beanName "+name);
            }
        };
    }

    @Bean
    public BeanClassLoaderAware beanClassLoaderAware(){
        return new BeanClassLoaderAware() {
            @Override
            public void setBeanClassLoader(ClassLoader classLoader) {
                System.out.println("BeanClassLoaderAware:I can get classLoader ");
            }
        };
    }

    @Bean
    public BeanFactoryAware beanFactoryAware(){
        return new BeanFactoryAware() {
            @Override
            public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
                System.out.println("BeanFactoryAware:I can get beanFactory ");
            }
        };
    }

//    @Bean
//    public ResourceLoaderAware resourceLoaderAware(){
//        return new ResourceLoaderAware() {
//            @Override
//            public void setResourceLoader(ResourceLoader resourceLoader) {
//                System.out.println("ResourceLoaderAware:I can get resourceLoader ");
//            }
//        };
//    }

//    @Bean
//    public ApplicationEventPublisherAware applicationEventPublisherAware(){
//        return new ApplicationEventPublisherAware() {
//            @Override
//            public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//                System.out.println("ApplicationEventPublisherAware:I can get applicationEventPublisher ");
//            }
//        };
//    }

//    @Bean
//    public MessageSourceAware messageSourceAware(){
//        return new MessageSourceAware() {
//            @Override
//            public void setMessageSource(MessageSource messageSource) {
//                System.out.println("MessageSourceAware:I can get messageSourceAware ");
//            }
//        };
//    }

    @Bean
    public ApplicationContextAware applicationContextAware(){
        return new ApplicationContextAware() {
            @Override
            public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                System.out.println("ApplicationContextAware:I can get applicationContext ");
            }
        };
    }

    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if(beanName.equalsIgnoreCase("bean")){
                    System.out.println("BeanPostProcessor-before:beanName "+beanName);
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(beanName.equalsIgnoreCase("bean")){
                    System.out.println("BeanPostProcessor-after:beanName "+beanName);
                }
                return bean;
            }
        };
    }

//    @Bean
//    public InitializingBean initializingBean(){
//        return new InitializingBean() {
//            @Override
//            public void afterPropertiesSet() throws Exception {
//                System.out.println("InitializingBean");
//            }
//        };
//    }
//
//    @Bean
//    public DisposableBean disposableBean(){
//        return new DisposableBean() {
//            @Override
//            public void destroy() throws Exception {
//                System.out.println("DisposableBean");
//            }
//        };
//    }

}
