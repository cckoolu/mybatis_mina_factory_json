package com.github.luyu.Entity;

public class currency_attr {
    private int attr_id;
    private int wheel;
    private String dyn_sys;
    private String exh_sys;
    private int member;
    private String size;
    private int car_door;
    private int car_light;
    private String Clutch;
    private int car_window;
    private String fuel;
    private String car_color;
    private car_attr car_attr;

    public int getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public String getDyn_sys() {
        return dyn_sys;
    }

    public void setDyn_sys(String dyn_sys) {
        this.dyn_sys = dyn_sys;
    }

    public String getExh_sys() {
        return exh_sys;
    }

    public void setExh_sys(String exh_sys) {
        this.exh_sys = exh_sys;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCar_door() {
        return car_door;
    }

    public void setCar_door(int car_door) {
        this.car_door = car_door;
    }

    public int getCar_light() {
        return car_light;
    }

    public void setCar_light(int car_light) {
        this.car_light = car_light;
    }

    public String getClutch() {
        return Clutch;
    }

    public void setClutch(String clutch) {
        Clutch = clutch;
    }

    public int getCar_window() {
        return car_window;
    }

    public void setCar_window(int car_window) {
        this.car_window = car_window;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public com.github.luyu.Entity.car_attr getCar_attr() {
        return car_attr;
    }

    public void setCar_attr(com.github.luyu.Entity.car_attr car_attr) {
        this.car_attr = car_attr;
    }

    @Override
    public String toString() {
        return "currency_attr{" +
                "attr_id=" + attr_id +
                ", wheel=" + wheel +
                ", dyn_sys='" + dyn_sys + '\'' +
                ", exh_sys='" + exh_sys + '\'' +
                ", member=" + member +
                ", size='" + size + '\'' +
                ", car_door=" + car_door +
                ", car_light=" + car_light +
                ", Clutch='" + Clutch + '\'' +
                ", car_window=" + car_window +
                ", fuel='" + fuel + '\'' +
                ", car_color='" + car_color + '\'' +
                ", car_attr=" + car_attr +
                '}';

    }
}