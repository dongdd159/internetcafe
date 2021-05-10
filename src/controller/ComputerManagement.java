package controller;
import model.Computer;
import storage.ComputerListFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
public class ComputerManagement {
    ComputerListFile computerListFile = ComputerListFile.getINSTANCE();
    protected static List<Computer> computerList=new ArrayList<>();
    protected static double priceanhour=3000;
    protected static double income=0;
    protected double getPriceanhour() {
        return priceanhour;
    }

    protected void setPriceanhour(double priceanhour) {
        this.priceanhour = priceanhour;
    }
    protected List<Computer> getComputerList() throws IOException, ClassNotFoundException{
            computerList = computerListFile.readFile();
        return computerList;
    }
    public static void setComputerList(List<Computer> computerList) {
        ComputerManagement.computerList = computerList;
    }
    public ComputerManagement() {
    }
    protected int displayNumber(){
        return computerList.size();
    }
    protected void addCom(int id) throws IOException {
        computerList.add(new Computer(id));
        computerListFile.writeFile(computerList);
    }
    protected void setId(int id,int newid) throws IOException{
        for (Computer computer: computerList) {
            if (computer.getId()==id){
                computer.setId(newid);
            }
        }
        computerListFile.writeFile(computerList);
    }
    protected void removeCom(Computer computer) throws IOException{
        computerList.remove(computer);
        computerListFile.writeFile(computerList);
    }
    protected List<Computer> displayList(){
        return computerList;
    }
    protected String checkStatus(int id)throws IOException{
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
    protected void addService(Service service,int id)throws IOException{
        for (Computer computer: computerList) {
            if (computer.getId()==id){
                computer.addService(service);
            }
        }
        computerListFile.writeFile(computerList);
    }
    protected double getPayment(int id,double hour)throws IOException{
        Computer computer = findbyid(id);
        double payment = priceanhour*hour+computer.getServicePayment();
        income += payment;
        computerListFile.writeFile(computerList);
        return payment;
    }
    protected Computer findbyid(int id){
        Computer computer =null;
        for (Computer com:computerList) {
            if (com.getId()==id){
                computer = com;
            }
        }
        return computer;
    }

    protected static double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "ComputerManagement{}";
    }
}
