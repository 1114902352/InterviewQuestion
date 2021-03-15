package com.spring.injectBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Dao {

    private DataSource dataSource1;

    @Autowired
    private DataSource dataSource2;

    private DataSource dataSource3;

    @Autowired
    public Dao(DataSource dataSource1) {
        this.dataSource1 = dataSource1;
    }

    public DataSource getDataSource1() {
        return dataSource1;
    }

    public void setDataSource1(DataSource dataSource1) {
        this.dataSource1 = dataSource1;
    }

    public DataSource getDataSource2() {
        return dataSource2;
    }

    public void setDataSource2(DataSource dataSource2) {
        this.dataSource2 = dataSource2;
    }

    public DataSource getDataSource3() {
        return dataSource3;
    }

    @Autowired
    public void setDataSource3(DataSource dataSource3) {
        this.dataSource3 = dataSource3;
    }




    @Autowired
    private Other other;

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}
