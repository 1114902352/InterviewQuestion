package com.spring.circularDependence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class P {

    private Q q;

    private String name = "ppp";

    public P() {
    }

    public P(Q q) {
        this.q = q;
    }

    public void check() {
        String otherName = "";
        if(q != null){
            otherName = q.getName();
        }
        System.out.println("Im P,I can get Q's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
