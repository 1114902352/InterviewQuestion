package com.circularDependence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component
public class Z implements P{

    private P p;

    private String name = "ZZZ";

    public void check() {
        String otherName = "";
        if(p != null){
            otherName = p.getName();
        }
        System.out.println("Im Z,I can get P's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

