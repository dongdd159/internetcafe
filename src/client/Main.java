package client;

import controller.Admin;
import controller.ComputerManagement;
import model.Computer;
import model.Drink;
import model.Food;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Admin computerManagement = new Admin();
    public static void mainmenu() {
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
        System.out.println("11: Sign out");
        select = input.nextInt();
        switch (select) {
            case 1:
                System.out.println(computerManagement.displayNumber());
                mainmenu();
                break;
            case 2:
                System.out.println("Input id");
                try {
                    int id = input.nextInt();
                    computerManagement.addCom(id);
                    if (id < 0) {
                        throw new InputMismatchException();
                    }
                    System.out.println("Done");
                } catch (Exception e) {
                    System.out.println("Attach failed");
                }
                mainmenu();
                break;
            case 3:
                try {
                    System.out.println("Input id:");
                    int id2 = input.nextInt();
                    System.out.println("Input new id:");
                    int newid = input.nextInt();
                    if (id2 == newid) {
                        throw new InputMismatchException();
                    }
                    computerManagement.setId(id2, newid);
                    System.out.println("Done");
                } catch (Exception e) {
                    System.out.println("Set new id failed");
                }
                mainmenu();
                break;
            case 4:
                System.out.println("Input id of computer you want to remove");
                try {
                    int id = input.nextInt();
                    Computer computer = computerManagement.findbyid(id);
                    if (computer==null){
                        System.out.println("id không tồn tại");
                        throw new InputMismatchException();
                    }else {
                        System.out.println("Are you sure?");
                        System.out.println("1:Yes");
                        System.out.println("2:No");
                        int confirm = input.nextInt();
                        if (confirm == 1) {
                            computerManagement.removeCom(computer);
                            System.out.println("Done");
                        } else if (confirm < 1 || confirm > 2) {
                            throw new InputMismatchException();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Remove failed");
                }
                mainmenu();
                break;
            case 5:
                System.out.println(computerManagement.displayList());
                mainmenu();
                break;
            case 6:
                try {
                    System.out.println("Input id:");
                    int id3 = input.nextInt();
                    System.out.println(computerManagement.checkStatus(id3));
                } catch (Exception e) {
                    System.out.println("checking failed id doesn't exist");
                }
                mainmenu();
                break;
            case 7:
                try {
                    System.out.println("Input id:");
                    int id4 = input.nextInt();
                    System.out.println("Input time used:");
                    double time = input.nextDouble();
                    if (time < 0) {
                        throw new InputMismatchException();
                    }
                    System.out.println("sdsd");
                    System.out.println("Totals:" + computerManagement.getPayment(id4, time));
                } catch (Exception e) {
                    System.out.println("id or time used is invalid");
                }
                mainmenu();
                break;
            case 8:
                try {
                    System.out.println("Input id:");
                    int id5 = input.nextInt();
                    System.out.println("Menu:");
                    System.out.println("1:Food");
                    System.out.println("2:Drink");
                    System.out.println("3:None");
                    int pick = input.nextInt();
                    if (pick == 1) {
                        computerManagement.addService(new Food(), id5);
                        System.out.println("Done");
                    } else if (pick == 2) {
                        computerManagement.addService(new Drink(), id5);
                        System.out.println("Done");
                    } else if (pick < 1 || pick > 3) {
                        throw new InputMismatchException();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid");
                }
                mainmenu();
                break;
            case 9:
                try {
                    System.out.println("Enter new account:");
                    String acc = input.next();
                    if (acc == "") {
                        throw new InputMismatchException();
                    }
                    computerManagement.addEmployee(acc);
                    System.out.println("Done");
                }catch (Exception e){
                    System.out.println("Please enter account name");
                }
                mainmenu();
                break;
            case 10:
                System.out.println("Income:"+computerManagement.getIncome());
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
