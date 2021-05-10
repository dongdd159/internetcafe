package controller;

import model.Computer;

import java.io.IOException;
import java.util.List;

public class Manager {
    private static ComputerManagement computerManagement;

    public Manager(ComputerManagement computerManagement){
        this.computerManagement = computerManagement;
    }
    public ComputerManagement getComputerManagement() {
        return computerManagement;
    }
    public Manager() {
    }

    public void setComputerManagement(ComputerManagement computerManagement) {
        this.computerManagement = computerManagement;
    }
    public void setPriceanhour(double priceanhour){
        computerManagement.setPriceanhour(priceanhour);
    }
    public int displayNumber(){
        return computerManagement.displayNumber();
    }
    public void addCom(int id)throws IOException{
        computerManagement.addCom(id);
    }
    public void setId(int id, int newid)throws IOException{
        computerManagement.setId(id,newid);
    }
    public void removeCom(Computer computer)throws IOException{
        computerManagement.removeCom(computer);
    }
    public List<Computer> displayList(){
        return computerManagement.displayList();
    }
    public String checkStatus(int id)throws Exception{
        return computerManagement.checkStatus(id);
    }
    public void addService(Service service,int id)throws Exception{
        computerManagement.addService(service,id);
    }
    public double getPayment(int id, double hour)throws IOException{

        return computerManagement.getPayment(id,hour);
    }
    public Computer findbyid(int id){
        return computerManagement.findbyid(id);
    }
    @Override
    public String toString() {
        return "Manager{" +
                ", computerManagement=" + computerManagement +
                '}';
    }
}
