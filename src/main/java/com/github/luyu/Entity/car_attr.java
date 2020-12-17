package com.github.luyu.Entity;

public class car_attr {
    private int car_id;
    private int type_id;
    private int attr_id;
    private  String type_name;



    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "car_attr{" +
                "car_id=" + car_id +
                ", type_id=" + type_id +
                ", attr_id=" + attr_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
