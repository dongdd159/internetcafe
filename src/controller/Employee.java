package controller;

import storage.ComputerListFile;
import storage.EmployeeListFile;

import java.io.Serializable;

public class Employee extends Manager implements Serializable {
    String name;
    public Employee(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\''+
                '}';
    }
}

