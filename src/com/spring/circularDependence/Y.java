package com.spring.circularDependence;

import org.springframework.stereotype.Component;

@Component
public class Y implements P{

//    @Autowired
    private P p;

    private String name = "YYY";

    public void check() {
        String otherName = "";
        if(p != null){
            otherName = p.getName();
        }
        System.out.println("Im Y,I can get P's Name:" + otherName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
