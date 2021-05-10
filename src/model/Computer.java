package model;

import controller.ComputerManagement;
import controller.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Serializable {
    int id;
    boolean status;
    List<Service> serviceList = new ArrayList<>();
    public Computer(int id) {
        this.id = id;
        this.status = false;
    }
    public double getServicePayment() {
        double payment=0;
        if (serviceList.size()==0){
            return payment;
        }
        for (Service service: serviceList) {
            payment += service.getPrice();
        }
        serviceList.removeAll(serviceList);
        return payment;
    }
    public void addService(Service service){
        serviceList.add(service);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", status=" + status +
                ", serviceList=" + serviceList +
                '}';
    }
}
