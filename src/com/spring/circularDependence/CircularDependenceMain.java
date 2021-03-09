package com.spring.circularDependence;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependenceMain {

    public static void main(String[] args) {
//        propertyInject();
        constructInject();
    }

    public static void propertyInject(){
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(Config.class);
//        关闭循环依赖
//        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();
//        AbstractAutowireCapableBeanFactory aacbf = (AbstractAutowireCapableBeanFactory) application.getBeanFactory();
//        aacbf.setAllowCircularReferences(false);
//        application.refresh();
        X x = (X)application.getBean("x");
        x.check();
        Y y = (Y)application.getBean("y");
        y.check();
    }

    public static void constructInject(){
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath:com/spring/circularDependence/application.xml");
        P p = (P) application.getBean("p");
        p.check();
        Q q = (Q)application.getBean("q");
        q.check();
    }
}
