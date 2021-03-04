package com.spring.lifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean {

    @Autowired
    private ReferenceBean referenceBean;

    public Bean(){
        System.out.println("1. Bean Construct");
    }

//    @PostConstruct
    public void init(){
        System.out.println("Bean @PostConstruct");
    }

//    @PreDestroy
    public void destroy(){
        System.out.println("Bean @PreDestroy");
    }
}
