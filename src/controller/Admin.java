package controller;

import model.Computer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Admin extends ComputerManagement{
    protected static List<Employee> employeeList = new ArrayList<>();
    static double income;

    public Admin() {
        super();
        this.name = "admin";
    }

    public void setPrice(double price){
        setPriceanhour(price);
    }
    public void addEmployee(String name){
        employeeList.add(new Employee(name));
    }
    public double getPayment(int id,double hour){
        Computer computer = findbyid(id);
        double payment = priceanhour*hour+computer.getServicePayment();
        income += payment;
        return payment;
    }
    public static double getIncome() {
        return income;
    }
    public List<Employee> displayEmployeeList(){
        return employeeList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                '}';
    }
}
