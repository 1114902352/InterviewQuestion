package com.spring.lifeCycle;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(Config.class);
        application.destroy();
    }
}
