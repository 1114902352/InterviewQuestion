package com.spring.circularDependence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Q {

    private P p;

    private String name = "qqq";

    public Q() {
    }

    public Q(P p) {
        this.p = p;
    }

    public void check() {
        String otherName = "";
        if(p != null){
            otherName = p.getName();
        }
        System.out.println("Im Q,I can get P's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
