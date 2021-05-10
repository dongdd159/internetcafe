package storage;

import controller.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListFile {
    private static EmployeeListFile EMPLOYEEINSTANCE;
    private EmployeeListFile() {
    }
    public static EmployeeListFile getINSTANCE() {
        if (EMPLOYEEINSTANCE == null){
            EMPLOYEEINSTANCE = new EmployeeListFile();
        }
        return EMPLOYEEINSTANCE;
    }
    public List<Employee> readFile() throws IOException, ClassNotFoundException{
        File file = new File("EmployeeList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Employee> list = (List<Employee>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Employee> employeeList) throws IOException{
        File file = new File("EmployeeList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employeeList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
