package storage;

import controller.ExportProduct;
import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ExportProductFile {
    public static void writeFile(ArrayList<ExportProduct> productList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos=null;
        try {
            fos = new FileOutputStream("list3.luong");
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

    public static ArrayList<ExportProduct> readFile(){
        File file = new  File("list3.luong");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<ExportProduct> ExportProductList = (ArrayList<ExportProduct>) result;
            ois.close();
            fis.close();
            return ExportProductList;
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
