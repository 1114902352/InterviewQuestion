package com.circularDependence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {

    @Autowired
    private Y y;

    private String name = "XXX";

    public void check() {
        System.out.println("Im X,I can get Y's Name:" + y.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
