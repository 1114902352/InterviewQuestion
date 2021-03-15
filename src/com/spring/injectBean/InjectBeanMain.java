package com.spring.injectBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectBeanMain {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("classpath:com/spring/injectBean/application.xml");
//        Action action = (Action) application.getBean("action");
//        System.out.println(action.getService1().getName());
//        System.out.println(action.getService2().getName());

        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(AppConfig.class);
        Dao dao = (Dao) application.getBean("dao");
//        System.out.println(dao.getDataSource1().getName());
//        System.out.println(dao.getDataSource2().getName());
//        System.out.println(dao.getDataSource3().getName());
        System.out.println(dao.getOther());
    }
}
