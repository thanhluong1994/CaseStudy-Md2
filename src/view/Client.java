package view;

import controller.ManagerProduct;

import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        int check = -1;
        while (check == -1) {
            System.out.println("----Danh sách sản phẩm----");
            ManagerProduct.showAllProduct();
            System.out.println("----Menu----");
            System.out.println("----1.Thêm sản phẩm----");
            System.out.println("----2.Sửa sản phẩm----");
            System.out.println("----3.Xóa sản phẩm----");
            System.out.println("----4.Tìm kiếm sản phẩm----");
            System.out.println("----5.Sắp xếp sản phẩm tăng dần theo giá----");
            System.out.println("Nhập lựa chọn của bạn: ");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    ManagerProduct.addProduct();
                    break;
                case 2:
                    ManagerProduct.editProductById();
                    break;
                case 3:
                    ManagerProduct.deleteProductByName();
                    break;
                case 4:
                    ManagerProduct.searchProductByName();
                    break;
                case 5:
                    ManagerProduct.sortProductByPrice();
                    break;

            }
        }
    }
}
