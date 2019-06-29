package controller;

import java.util.Scanner;

public class TestQLDA {
    public static void main(String[] args) {
        TestQLDA t = new TestQLDA();
        t.menu();
    }
    public static void menu() {
        QuanLyDuAn q = new QuanLyDuAn();
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1 them 1 du an");
            System.out.println("2. in danh sach tat ca cac du an");
            System.out.println("3. xoa 1 du an theo ma so");
            System.out.println("4. sua thong tin du an theo ma so");
            System.out.println("5. thoat");
            System.out.print("Vui long chon chuc nang 1-5: ");
            op = sc.nextLine();
            switch (op) {
                case "1":
                    q.themDA();
                    break;
                case "2":
                    q.hienThiDSDA();
                    break;
                case "3":
                    System.out.print("nhap ma so nv: ");
                    q.xoaDA(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.println("nhap ma so nv: ");
                    q.suaDA(sc.nextLine().trim());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("thao tac khong hop le!");
            }
        }

    }
}
