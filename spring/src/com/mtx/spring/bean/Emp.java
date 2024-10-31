package com.mtx.spring.bean;

public class Emp {
    private String name;
    private Dept dept;

    public Emp() {

    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
