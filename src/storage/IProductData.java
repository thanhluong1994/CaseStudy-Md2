package storage;

import model.Product;


import java.util.ArrayList;


public interface IProductData {
ArrayList<Product> readFile();
void writeFile(ArrayList<Product> arrayList) throws Exception;
}
