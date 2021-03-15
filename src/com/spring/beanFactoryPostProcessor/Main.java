package com.spring.beanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(Config.class);
        Bean b1 = (Bean) application.getBean("bean");
        b1.checkName();
//        Bean b2 = (Bean) application.getBean("bean2");
//        b2.checkName();
//        Bean b3 = (Bean) application.getBean("bean3");
//        b3.checkName();
    }
}
