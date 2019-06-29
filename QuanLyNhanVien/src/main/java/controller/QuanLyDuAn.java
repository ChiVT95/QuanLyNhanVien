package controller;

import model.DuAn;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyDuAn implements IQuanLyDuAn {
    ArrayList<DuAn> ds = new ArrayList<>();
    @Override
    public void themDA() {
        DuAn d = new DuAn();
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m = null;
        p = Pattern.compile("[A-Z]{5,}");
        while (true) {
            boolean co = false;
            System.out.print("Nhap ma so ([ABCDE] 5 ki tu tro len) : ");
            String Maso = sc.nextLine().trim();
            m = p.matcher(Maso);
            if (m.matches()) {
                for (DuAn item : ds) {
                    if (item.getIDDA().equals(Maso)) {
                        co = true;
                        break;
                    }
                }
                if (co == true) {
                    System.out.println("mã số trùng");
                    continue;
                } else {
                    d.setIDDA(Maso);
                    break;
                }
            }
            System.out.println("Ma so khong hop le ! vd ABCDE TU 5 KY TU TRO LEN,...... ");
        }

        while (true) {
            System.out.print("Nhap ten du an: ");
            String Ten = sc.nextLine().trim();
            if (Ten.length() > 0) {
                d.setTenDA(Ten);
                break;
            }
            System.out.println("ten du an ko hop le ! Khong duoc de trong ,...... ");
        }

        while (true) {
            System.out.println("Nhap ngay deadline du an [yyyy-MM-dd]: ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String deadline = sc.nextLine();
            try {
                d.setDeadLineDA(sdf.parse(deadline));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
        }
        ds.add(d);
    }

    @Override
    public void xoaDA(String msDA) {
        if(ds.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }
        for (DuAn item : ds) {
            if(item.getIDDA().equals(msDA)){
                ds.remove(item);
                System.out.println("da xoa thanh cong");
                return;
            }
        }
        System.out.println("khong tim thay ma so %s theo yeu cau"+msDA);
    }

    @Override
    public void suaDA(String msDA) {
        Scanner sc = new Scanner(System.in);
        if (ds.isEmpty()){
            System.out.println("danh sach rong.");
            return;
        }
        boolean coSua= false;
        int size = ds.size();
        for (int i = 0; i < size; i++) {
            if(ds.get(i).getIDDA().contains(msDA)){
                coSua=true;
                System.out.println("nhap lai ten du an: ");
                ds.get(i).setTenDA(sc.nextLine().trim());
                System.out.println("nhap lai ngay deadline du an: ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    ds.get(i).setDeadLineDA(sdf.parse(sc.nextLine()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
        if (!coSua) {
            System.out.printf("ma so %s khong ton tai\n", msDA);
        }
    }

    @Override
    public void hienThiDSDA() {
        if(ds.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }

        for (DuAn item: ds) {
            System.out.println(item);
        }
    }
}
