package controller;

import model.Product;

import storage.ProductFile;


import java.io.IOException;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Scanner;

public class ManagerProduct {
    public static ArrayList<Product> productList = ProductFile.readFile();


    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thêm sản phẩm");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập id: ");
        Scanner scanner2 = new Scanner(System.in);
        String id = scanner2.nextLine();
        System.out.println("Nhập tên: ");
        Scanner scanner3 = new Scanner(System.in);
        String name = scanner3.nextLine();
        System.out.println("Nhập giá: ");
        Scanner scanner4 = new Scanner(System.in);
        int price = scanner4.nextInt();
        System.out.println("Nhập số lượng: ");
        Scanner scanner5 = new Scanner(System.in);
        double quantity = scanner5.nextDouble();

        Product newProduct = new Product(id, name, price, quantity);

        productList.add(newProduct);
        try {
            ProductFile.writeFile(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showAllProduct() {
        for (Product p : productList
        ) {
            System.out.println(p);
        }
    }

    public static void editProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id sản phẩm muốn sửa: ");
        String id = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getIdProduct())) {
                check = i;
            }
        }
        if (check != -1) {
            System.out.println("Nhập id: ");
            Scanner scanner6 = new Scanner(System.in);
            String id1 = scanner6.nextLine();
            System.out.println("Nhập tên: ");
            Scanner scanner7 = new Scanner(System.in);
            String name = scanner7.nextLine();
            System.out.println("Nhập giá: ");
            Scanner scanner8 = new Scanner(System.in);
            int price = scanner8.nextInt();
            System.out.println("Nhập số lượng: ");
            Scanner scanner9 = new Scanner(System.in);
            double quantity = scanner9.nextDouble();
            productList.get(check).setIdProduct(id1);
            productList.get(check).setName(name);
            productList.get(check).setPrice(price);
            productList.get(check).setQuantity(quantity);
            try {
                ProductFile.writeFile(productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Id bạn nhập không hợp lệ");
        }
    }

    public static void deleteProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phẩm muốn xóa: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getName())) {
                check = i;
            }
        }
        if (check != -1) {
            productList.remove(productList.get(check));
            try {
                ProductFile.writeFile(productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(productList.get(check).toString());
        } else {
            System.out.println("Sản phẩm không có trong danh sách");
        }
    }

    public static void searchProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phẩm muốn tìm: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getName())) {
                check = i;
            }
        }
        if (check != -1) {
            System.out.println(productList.get(check).toString());
        } else
            System.out.println("Sản phẩm bạn tìm không có");
    }


    public static ArrayList<Product> sortProductByPrice() {
        productList.sort(((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())));
        return productList;
    }

}