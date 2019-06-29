package controller;

import java.util.Scanner;

public class TestQLTask {
    public static void main(String[] args) {
        TestQLTask t = new TestQLTask();
        t.menu();
    }
    public static void menu() {
        QuanLyTask q = new QuanLyTask();
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1 them 1 nhan vien");
            System.out.println("2. in danh sach tat ca cac nhan vien");
            System.out.println("3. xoa 1 nhan vien theo ma so");
            System.out.println("4. sua thong tin nhan vien theo ma so");
            System.out.println("5. in ds cac task theo trang thai");
            System.out.println("6. in ds cac task qua deadline");
            System.out.println("7. thoat");
            System.out.print("Vui long chon chuc nang 1-7: ");
            op = sc.nextLine();
            switch (op) {
                case "1":
                    q.themTask();
                    break;
                case "2":
                    q.hienThiDSTask();
                    break;
                case "3":
                    System.out.print("nhap ma so task: ");
                    q.xoaTask(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print("nhap ma so task: ");
                    q.suaTask(sc.nextLine().trim());
                    break;
                case "5":
                    System.out.print("nhap trang thai: ");
                    q.hienThiDSTask(sc.nextLine().trim());
                    break;
                case "6":
                    q.hienThiDSTaskQuaDeadLine();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("thao tac khong hop le!");
            }
        }

    }
}
