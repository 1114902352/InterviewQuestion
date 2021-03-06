package com.spring.beanFactoryPostProcessor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AOPConfig {

    @Before("execution(* com.spring.beanFactoryPostProcessor.Bean.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("AOP Before");
    }

    @After("execution(* com.spring.beanFactoryPostProcessor.Bean.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("AOP Before");
    }
}
