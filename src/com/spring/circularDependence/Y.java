package com.spring.circularDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Y {

    @Autowired
    private X x;

    private String name = "YYY";

    public void check() {
        String otherName = "";
        if(x != null){
            otherName = x.getName();
        }
        System.out.println("Im Y,I can get X's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
