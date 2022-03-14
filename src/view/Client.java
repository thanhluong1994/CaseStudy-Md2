package view;

import controller.ManagerProduct;

import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        int check = -1;
        while (check == -1) {
            System.out.println("(^-^)-(^-^) DANH SÁCH SẢN PHẨM (^-^)-(^-^)");
            ManagerProduct.showAllProduct();

            System.out.println("     ^^-****^^-MENU-^^****-^^   ");
            System.out.println("<--(^-^) 1.Thêm sản phẩm (^-^)-->");
            System.out.println("<--(^-^) 2.Sửa sản phẩm (^-^)-->");
            System.out.println("<--(^-^) 3.Xóa sản phẩm (^-^)-->");
            System.out.println("<--(^-^) 4.Tìm kiếm sản phẩm (^-^)-->");
            System.out.println("<--(^-^) 5.Sắp xếp sản phẩm tăng dần theo giá (^-^)-->");
            System.out.println("<--(^-^) 6.Xuất sản phẩm (^-^)-->");
            System.out.println("<--(^-^) 7.Danh sách sản phẩm đã xuất (^-^)-->");
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
                case 6:
                    ManagerProduct.addExportProduct();
                    break;
                case 7:
                    ManagerProduct.showExportProduct();
                    break;
                case 8:
                default:
                    System.out.println("Không hợp lệ.Mời bạn nhập lại");
            }
        }
    }
}
