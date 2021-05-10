package controller;
import model.Computer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
public abstract class ComputerManagement {
    String name;
    protected static List<Computer> computerList=new ArrayList<>();
    protected double priceanhour=3000;
    public String getName() {
        return name;
    }
    public double getPriceanhour() {
        return priceanhour;
    }
    public void setPriceanhour(double priceanhour) {
        this.priceanhour = priceanhour;
    }
    public List<Computer> getComputerList() {
        return computerList;
    }
    public static void setComputerList(List<Computer> computerList) {
        ComputerManagement.computerList = computerList;
    }
    public int displayNumber(){
        return computerList.size();
    }
    public void addCom(int id){
        computerList.add(new Computer(id));
    }
    public void setId(int id,int newid){
        for (Computer computer: computerList) {
            if (computer.getId()==id){
                computer.setId(newid);
            }
        }
    }
    public void removeCom(Computer computer){
        computerList.remove(computer);
    }
    public List<Computer> displayList(){
        return computerList;
    }
    public String checkStatus(int id)throws Exception{
        for (Computer computer: computerList) {
            if (computer.getId()==id){
                if (computer.isStatus()){
                    return "AVAIABLE ";
                }else {
                    return "DISEABLE";
                }
            }
        }
        return "id ko tồn tại";
    }
    public void addService(Service service,int id){
        for (Computer computer: computerList) {
            if (computer.getId()==id){
                computer.addService(service);
            }
        }
    }
    public double getPayment(int id,double hour){
        Computer computer = findbyid(id);
        return priceanhour*hour+computer.getServicePayment();
    }
    public Computer findbyid(int id){
        Computer computer =null;
        for (Computer com:computerList) {
            if (com.getId()==id){
                computer = com;
            }
        }
        return computer;
    }


    @Override
    public String toString() {
        return "ComputerManagement{}";
    }
}
