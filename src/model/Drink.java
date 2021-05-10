package model;

import controller.Service;

import java.io.Serializable;

public class Drink extends Service implements Serializable {
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
    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
