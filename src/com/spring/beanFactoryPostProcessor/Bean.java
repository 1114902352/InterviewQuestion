package com.spring.beanFactoryPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class Bean {

    private String name = "Origin Bean";

    public void checkName(){
        System.out.println("Im "+name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
