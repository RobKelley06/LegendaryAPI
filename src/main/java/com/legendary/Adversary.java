package com.legendary;

public class Adversary {
    private Integer power;
    private String name;
    private Integer id;

    public void setPower(Integer power) {
        this.power = power;
    }
    public Integer getPower() {
        return power;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{ Name: " + name + ", Power: " + power + ", ID: " + id + "}";
    }
}
