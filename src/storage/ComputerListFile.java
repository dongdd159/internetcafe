package storage;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComputerListFile {
    private static ComputerListFile COMPUTERINSTANCE;
    private ComputerListFile() {
    }
    public static ComputerListFile getINSTANCE() {
        if (COMPUTERINSTANCE == null){
            COMPUTERINSTANCE = new ComputerListFile();
        }
        return COMPUTERINSTANCE;
    }
    public List<Computer> readFile() throws IOException, ClassNotFoundException{
        File file = new File("ComputerList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Computer> list = (List<Computer>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Computer> computerList) throws IOException{
        File file = new File("ComputerList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(computerList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
