package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;


public class ProductFile {
public static void writeFile(ArrayList<Product> productList) throws IOException{
    FileOutputStream fos = null;
    ObjectOutputStream oos=null;
    try {
        fos = new FileOutputStream("list1.luong");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(productList);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        oos.close();
        fos.close();
    }
}

public static ArrayList<Product> readFile(){
    File file = new  File("list1.luong");
    try {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object result = ois.readObject();
        ArrayList<Product> productList = (ArrayList<Product>) result;
        ois.close();
        fis.close();
        return productList;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return new ArrayList<>();
}
}
