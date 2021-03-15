package com.spring.injectBean;

public class Action {

    private Service service1;

    private Service service2;

    public Action(Service service1) {
        this.service1 = service1;
    }

    public Service getService1() {
        return service1;
    }

//    public void setService1(Service service1) {
//        this.service1 = service1;
//    }

    public Service getService2() {
        return service2;
    }

    public void setService2(Service service2) {
        this.service2 = service2;
    }
}
