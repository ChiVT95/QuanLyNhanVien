package controller;

import model.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyNV implements IQuanLyNV {
    ArrayList<NhanVien> dsNV = new ArrayList<>();
    int dem=0;
    @Override
    public void themNV() {
        NhanVien nv = new NhanVien();
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m = null;
        p = Pattern.compile("[0-9]{4}");
        while (true) {
            boolean co = false;
            System.out.print("Nhap ma so nhan vien [xxxx]: ");
            String MasoNV = sc.nextLine().trim();
            m = p.matcher(MasoNV);
            if (m.matches()) {
                for (NhanVien item : dsNV) {
                    if (item.getMasoNV().equals(MasoNV)) {
                        co = true;
                        break;
                    }
                }
                if (co == true) {
                    System.out.println("mã số trùng");
                    continue;
                } else {
                    nv.setMasoNV(MasoNV);
                    break;
                }
            }
            System.out.println("Ma so nv ko hop le ! vi du 1234 ,...... ");
        }

        while (true) {
            System.out.print("Nhap ho ten nhan vien: ");
            String TenNV = sc.nextLine().trim();
            if (TenNV.length() > 0) {
                nv.setTenNV(TenNV);
                break;
            }
            System.out.println("Ho ten nv ko hop le ! Khong duoc de trong ,...... ");
        }

        while (true) {
            System.out.print("Nhap gioi tinh nhan vien [true:Nam|false:Nu]: ");
            boolean GioiTinhNV = Boolean.parseBoolean(sc.nextLine().trim());
            nv.setGioiTinhNV(GioiTinhNV);
            break;
        }

        while (true) {
            System.out.print("Nhap luong nhan vien: ");
            int LuongNV = Integer.parseInt(sc.nextLine().trim());
            if (LuongNV > 0) {
                nv.setLuongNV(LuongNV);
                break;
            }
            System.out.println("luong phai hon 0 !");
        }

        while (true) {
            System.out.print("Nhap co lenh xoa [true:Co|false:Khong]: ");
            boolean CoXoa = Boolean.parseBoolean(sc.nextLine().trim());
            nv.setCoXoa(CoXoa);
            break;
        }
        dsNV.add(nv);
    }

    @Override
    public void xoaNV(String  masoID) {
        if(dsNV.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }
        for (NhanVien item : dsNV) {
            if(item.getMasoNV().equals(masoID)){
                dsNV.remove(item);
                System.out.println("da xoa thanh cong");
                return;
            }
        }
        System.out.println("khong tim thay ma so %s theo yeu cau"+masoID);
    }

    @Override
    public void suaNV(String masoNV) {
        Scanner sc = new Scanner(System.in);
        if (dsNV.isEmpty()){
            System.out.println("danh sach rong.");
            return;
        }
        boolean coSua= false;
        int size = dsNV.size();
        for (int i = 0; i < size; i++) {
            if(dsNV.get(i).getMasoNV().contains(masoNV)){
                coSua=true;
                System.out.println("nhap lai ten: ");
                dsNV.get(i).setTenNV(sc.nextLine().trim());
                System.out.println("nhap lai gioi tinh [true:Nam|false:Nu]: ");
                dsNV.get(i).setGioiTinhNV(Boolean.parseBoolean(sc.nextLine().trim()));
                System.out.println("nhap lai luong: ");
                dsNV.get(i).setLuongNV(Integer.parseInt(sc.nextLine().trim()));
                System.out.println("nhap lai co xoa [true:Co|false:Khong]: ");
                dsNV.get(i).setCoXoa(Boolean.parseBoolean(sc.nextLine().trim()));
                break;
            }
        }
        if (!coSua) {
            System.out.printf("ma so %s khong ton tai\n", masoNV);
        }

    }

    @Override
    public void hienThiDSNV() {
        if(dsNV.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }

        for (NhanVien item: dsNV) {
            System.out.println(item);
        }
    }


}
