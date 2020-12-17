package com.github.luyu.Entity;

public class bus_attr {
    private int bus_id;
    private String coin_box;
    private String monitor;
    private String indicator;
    private int layer_num;
    private int box_num;

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public String getCoin_box() {
        return coin_box;
    }

    public void setCoin_box(String coin_box) {
        this.coin_box = coin_box;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public int getLayer_num() {
        return layer_num;
    }

    public void setLayer_num(int layer_num) {
        this.layer_num = layer_num;
    }

    public int getBox_num() {
        return box_num;
    }

    public void setBox_num(int box_num) {
        this.box_num = box_num;
    }

    @Override
    public String toString() {
        return "bus_attr{" +
                "bus_id=" + bus_id +
                ", coin_box='" + coin_box + '\'' +
                ", monitor='" + monitor + '\'' +
                ", indicator='" + indicator + '\'' +
                ", layer_num=" + layer_num +
                ", box_num=" + box_num +
                '}';
    }
}
