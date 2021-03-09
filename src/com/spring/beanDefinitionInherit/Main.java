package com.spring.beanDefinitionInherit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath:com/spring/beanDefinitionInherit/application.xml");
        Parent objA = (Parent) application.getBean("parent");
        objA.getMessage1();
        objA.getMessage2();

        Child objB = (Child) application.getBean("child");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
    }
}
