package controller;

import model.Product;

import storage.ExportProductFile;
import storage.ProductFile;


import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

public class ManagerProduct {
    public static ArrayList<Product> productList = ProductFile.readFile();
    public static ExportProductFile exportProductFile = new ExportProductFile();

//Thêm sản phẩm
    public static void addProduct() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập id: ");
        String id = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập giá: ");
        int price = scanner3.nextInt();
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập số lượng: ");
        double quantity = scanner4.nextDouble();

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
//Sửa sản phẩm
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
            Scanner scanner1 = new Scanner(System.in);
            String id1 = scanner1.nextLine();
            System.out.println("Nhập tên: ");
            Scanner scanner2 = new Scanner(System.in);
            String name = scanner2.nextLine();
            System.out.println("Nhập giá: ");
            Scanner scanner3 = new Scanner(System.in);
            int price = scanner3.nextInt();
            System.out.println("Nhập số lượng: ");
            Scanner scanner4 = new Scanner(System.in);
            double quantity = scanner4.nextDouble();
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
//Xóa sản phẩm
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
        } else {
            System.out.println("Tên sản phẩm không hợp lệ");
        }
    }
//Tìm kiếm sản phẩm
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

//Sắp xếp danh sách sản phẩm
    public static ArrayList<Product> sortProductByPrice() {
        productList.sort(((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())));
        return productList;
    }
//Xuất sản phẩm
    public static  ArrayList<ExportProduct> exportProductList= exportProductFile.readFile();

    public static void addExportProduct(){
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String name= scanner1.nextLine();
        int check=-1;
        for (int i = 0; i < productList.size() ; i++) {
            if (productList.get(i).getName().equals(name)){
                check=i;
                break;
            }
        }
        if (check!=-1){
            Scanner scanner3=new Scanner(System.in);
            System.out.println("Mời bạn nhập số lượng: ");
            double quantity= scanner3.nextDouble();
            Scanner scanner4=new Scanner(System.in);
            System.out.println("Nhập ngày: ");
            int day= scanner4.nextInt();
            Scanner scanner5=new Scanner(System.in);
            System.out.println("Mời bạn nhập tháng: ");
            int month= scanner5.nextInt();
            Scanner scanner6=new Scanner(System.in);
            System.out.println("Mời bạn nhập năm: ");
            int year= scanner6.nextInt();
            LocalDate date=LocalDate.of(year,month,day);

            if (quantity<productList.get(check).getQuantity()){
                productList.get(check).setQuantity(productList.get(check).getQuantity()-quantity);
                ExportProduct exportProduct = new ExportProduct(name,quantity,date);
                exportProductList.add(exportProduct);
                try {
                    ProductFile.writeFile(productList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    ExportProductFile.writeFile(exportProductList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else
            System.out.println("Không hợp lệ! Mời bạn nhập lại");
    }
    //In danh sách sản phẩm đã xuất

    public static void showExportProduct(){
        for (ExportProduct e: exportProductList
             ) {
            System.out.println(e);
        }
    }
}