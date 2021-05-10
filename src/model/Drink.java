package model;

import controller.Service;

public class Drink extends Service {
    private String name = "Nước ngọt" ;
    private double price = 10000;
    public Drink() {
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
