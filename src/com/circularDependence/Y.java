package com.circularDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Y {

    @Autowired
    private X x;

    private String name = "YYY";

    public void check() {
        System.out.println("Im Y,I can get X's Name:" + x.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
