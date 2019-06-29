package controller;

import java.util.Scanner;

public class TestQLNV {
    public static void main(String[] args) {
        TestQLNV t = new TestQLNV();
        t.menu();
    }
    public static void menu() {
        QuanLyNV q = new QuanLyNV();
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1 them 1 nhan vien");
            System.out.println("2. in danh sach tat ca cac nhan vien");
            System.out.println("3. xoa 1 nhan vien theo ma so");
            System.out.println("4. sua thong tin nhan vien theo ma so");
            System.out.println("5. thoat");
            System.out.print("Vui long chon chuc nang 1-5: ");
            op = sc.nextLine();
            switch (op) {
                case "1":
                    q.themNV();
                    break;
                case "2":
                    q.hienThiDSNV();
                    break;
                case "3":
                    System.out.print("nhap ma so nv: ");
                    q.xoaNV(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.println("nhap ma so nv: ");
                    q.suaNV(sc.nextLine().trim());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("thao tac khong hop le!");
            }
        }

    }

}
