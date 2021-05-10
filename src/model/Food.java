package model;

import controller.Service;

public class Food extends Service {
    private String name = "Bánh Mỳ" ;
    private double price = 15000;
    public Food() {
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
