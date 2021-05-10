package controller;
import storage.EmployeeListFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Admin extends Manager{
    EmployeeListFile employeeListFile = EmployeeListFile.getINSTANCE();
    protected static List<Employee> employeeList = new ArrayList<>();
    ComputerManagement computerManagement;
    String name = "admin";
    public Admin(ComputerManagement computerManagement) {
        super(computerManagement);
    }
    public String getName() {
        return name;
    }
    public  List<Employee> getEmployeeList() throws IOException, ClassNotFoundException{
        employeeList = employeeListFile.readFile();
        return employeeList;
    }
    public void setPrice(double price){
        setPriceanhour(price);
    }
    public Employee addEmployee(String name) throws IOException{
        Employee employee = new Employee(name);
        employeeList.add(employee);
        employeeListFile.writeFile(employeeList);
        return employee;
    }
    public double getIncome() {
        return computerManagement.getIncome();
    }
    public List<Employee> displayEmployeeList(){
        return employeeList;
    }
    public boolean checkAccount(String acc){
        for (Employee employee:employeeList) {
            if (acc.equals(employee.getName())){
                return true;
            }
        }
        return false;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        Admin.employeeList = employeeList;
    }
}
