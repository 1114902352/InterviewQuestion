package com.spring.circularDependence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class X {

    @Autowired
    private Y y;

    private String name = "XXX";

    public void check() {
        String otherName = "";
        if(y != null){
            otherName = y.getName();
        }
        System.out.println("Im X,I can get Y's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
