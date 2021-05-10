package client;

import controller.Admin;
import controller.ComputerManagement;
import controller.Employee;
import model.Computer;
import model.Drink;
import model.Food;
import storage.ComputerListFile;
import storage.EmployeeListFile;
//import storage.EmployeeListFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ComputerManagement computerManagement = new ComputerManagement();
    static Admin admin = new Admin(computerManagement);
    static {
        try {
            admin.setEmployeeList(EmployeeListFile.getINSTANCE().readFile());
            computerManagement.setComputerList(ComputerListFile.getINSTANCE().readFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void displayNumber(){
        System.out.println(admin.displayNumber());
    }
    public static void addComputer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input id");
        try {
            int id = input.nextInt();
            admin.addCom(id);
            if (id < 0) {
                throw new InputMismatchException();
            }
            System.out.println("Done");
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Attach failed");
        }
    }
    public static void removeComputer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input id of computer you want to remove");
        try {
            int id = input.nextInt();
            Computer computer = admin.findbyid(id);
            if (computer==null){
                System.out.println("id không tồn tại");
                throw new InputMismatchException();
            }else {
                System.out.println("Are you sure?");
                System.out.println("1:Yes");
                System.out.println("2:No");
                int confirm = input.nextInt();
                if (confirm == 1) {
                    admin.removeCom(computer);
                    System.out.println("Done");
                } else if (confirm < 1 || confirm > 2) {
                    throw new InputMismatchException();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Remove failed");
        }
    }
    public static void displayList(){
        System.out.println(admin.displayList());
    }
    public static void checkStatus(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id:");
            int id3 = input.nextInt();
            System.out.println(admin.checkStatus(id3));
        } catch (Exception e) {
            System.out.println("checking failed id doesn't exist");
        }
    }
    public static void setComputerId(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id:");
            int id2 = input.nextInt();
            System.out.println("Input new id:");
            int newid = input.nextInt();
            if (id2 == newid) {
                throw new InputMismatchException();
            }
            admin.setId(id2, newid);
            System.out.println("Done");
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Set new id failed");
        }
    }
    public static void getPayment(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id:");
            int id4 = input.nextInt();
            System.out.println("Input time used:");
            double time = input.nextDouble();
            if (time < 0) {
                throw new InputMismatchException();
            }
            System.out.println("Totals:" + admin.getPayment(id4, time));
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("id or time used is invalid");
        }
    }
    public static void addService(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id:");
            int id5 = input.nextInt();
            System.out.println("Menu:");
            System.out.println("1:Food");
            System.out.println("2:Drink");
            System.out.println("3:None");
            int pick = input.nextInt();
            if (pick == 1) {
                admin.addService(new Food(), id5);
                System.out.println("Done");
            } else if (pick == 2) {
                admin.addService(new Drink(), id5);
                System.out.println("Done");
            } else if (pick < 1 || pick > 3) {
                throw new InputMismatchException();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Invalid");
        }
    }
    public static void addEmployee(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter new account:");
            String acc = input.next();
            if (acc == " ") {
                throw new InputMismatchException();
            }
            Employee employee = admin.addEmployee(acc);
            System.out.println("Employee "+employee.getName()+" added");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Cant set account name");
        }
    }
    public static void getIcome(){
        System.out.println("Income:"+admin.getIncome());
    }
    public static void displayEmployeeList(){
        System.out.println(admin.displayEmployeeList());
    }
    public static void setPriceperhour(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Set price per hour:");
            double price = input.nextInt();
            if (price<1000) {
                System.out.println("price must be at least 1000 or more");
                throw new InputMismatchException();
            }
            admin.setPriceanhour(price);
            System.out.println("Done");
        }catch (Exception e){
            System.out.println("Cant set price per hour");
        }
    }
    public static void adminmenu() {
        Scanner input = new Scanner(System.in);
        int select;
        System.out.println("1: Display number");
        System.out.println("2: Add computer");
        System.out.println("3: Set id");
        System.out.println("4: Remove");
        System.out.println("5: Display list");
        System.out.println("6: Display status");
        System.out.println("7: Get payment");
        System.out.println("8: Add services");
        System.out.println("9: Add Employee");
        System.out.println("10: Display income");
        System.out.println("11: Display employee list");
        System.out.println("12: Set price per hour");
        System.out.println("13: Sign out");
        select = input.nextInt();
        switch (select) {
            case 1:
                displayNumber();
                adminmenu();
                break;
            case 2:
                addComputer();
                adminmenu();
                break;
            case 3:
                setComputerId();
                adminmenu();
                break;
            case 4:
                removeComputer();
                adminmenu();
                break;
            case 5:
                displayList();
                adminmenu();
                break;
            case 6:
                checkStatus();
                adminmenu();
                break;
            case 7:
                getPayment();
                adminmenu();
                break;
            case 8:
                addService();
                adminmenu();
                break;
            case 9:
                addEmployee();
                adminmenu();
                break;
            case 10:
                getIcome();
                adminmenu();
                break;
            case 11:
                displayEmployeeList();
                adminmenu();
                break;
            case 12:
                setPriceperhour();
                adminmenu();
                break;
            case 13:
                mainmenu();
                break;
            default:
                break;
        }
    }
    public static void mainmenu(){
        Scanner input = new Scanner(System.in);
        int signin;
        String account;
        System.out.println("1: Admin account");
        System.out.println("2: Employee account");
        System.out.println("3: Exit");
        signin = input.nextInt();
        switch (signin){
            case 1:
                System.out.println("Please enter admin account:");
                account = input.next();
                if (account.equals(admin.getName())){
                    adminmenu();
                }else {
                    System.out.println("account is invalid");
                    mainmenu();
                }
                break;
            case 2:
                System.out.println("Please enter employee account:");
                account = input.next();
                    if (admin.checkAccount(account)){
                        employeemenu();
                    }
                    System.out.println("account is invalid");
                mainmenu();
                break;
            default:
                break;
        }
    }
    public static void employeemenu(){
        Scanner input = new Scanner(System.in);
        int select;
        System.out.println("1: Display number");
        System.out.println("2: Add computer");
        System.out.println("3: Set id");
        System.out.println("4: Remove");
        System.out.println("5: Display list");
        System.out.println("6: Display status");
        System.out.println("7: Get payment");
        System.out.println("8: Add services");
        System.out.println("9: Sign out");
        select = input.nextInt();
        switch (select) {
            case 1:
                displayNumber();
                employeemenu();
                break;
            case 2:
                addComputer();
                employeemenu();
                break;
            case 3:
                setComputerId();
                employeemenu();
                break;
            case 4:
                removeComputer();
                employeemenu();
                break;
            case 5:
                displayList();
                employeemenu();
                break;
            case 6:
                checkStatus();
                employeemenu();
                break;
            case 7:
                getPayment();
                employeemenu();
                break;
            case 8:
                addService();
                employeemenu();
                break;
            case 9:
                mainmenu();
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        mainmenu();
    }
}
