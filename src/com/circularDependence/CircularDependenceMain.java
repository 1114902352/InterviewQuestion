package com.circularDependence;


import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependenceMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(Config.class);
//        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();
//        AbstractAutowireCapableBeanFactory aacbf = (AbstractAutowireCapableBeanFactory) application.getBeanFactory();
//        aacbf.setAllowCircularReferences(false);
//        application.refresh();

        X x = (X)application.getBean("x");
        x.check();
//        Y y = (Y)application.getBean("y");
//        y.check();
    }
}
