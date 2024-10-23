package com.mtx.spring.bean;


public class Monster {
    private Integer id;
    private String name;
    private String shill;

    // 无参构造器 Spring反射创建对象时 需要使用
    public Monster() {
    }

    public Monster(Integer id, String name, String shill) {
        this.id = id;
        this.name = name;
        this.shill = shill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShill() {
        return shill;
    }

    public void setShill(String shill) {
        this.shill = shill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shill='" + shill + '\'' +
                '}';
    }
}
