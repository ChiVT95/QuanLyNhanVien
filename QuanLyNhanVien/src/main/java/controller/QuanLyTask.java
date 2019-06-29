package controller;

import model.CongViec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLyTask implements IQuanLyTask {
    ArrayList<CongViec> ds = new ArrayList<>();
    @Override
    public void themTask() {
        CongViec c  =new CongViec();
        Scanner sc = new Scanner(System.in);
        Pattern p;
        Matcher m = null;
        while (true) {
            boolean co = false;
            System.out.print("Nhap ma so task: ");
            String Maso = sc.nextLine().trim();
            if (Maso.length()>0) {
                for (CongViec item : ds) {
                    if (item.getMaSoTask().equals(Maso)) {
                        co = true;
                        break;
                    }
                }
                if (co == true) {
                    System.out.println("mã số trùng");
                    continue;
                } else {
                    c.setMaSoTask(Maso);
                    break;
                }
            }
            System.out.println("Ma so khong hop le ! khong duoc de trong...... ");
        }

        while (true) {
            System.out.print("Nhap tieu de task: ");
            String tittle = sc.nextLine().trim();
            if (tittle.length() > 0) {
                c.setTieuDeTak(tittle);
                break;
            }
            System.out.println("ten tieu de task ko hop le ! Khong duoc de trong ,...... ");
        }

        p = Pattern.compile("(hold|finish|processing)");
        while (true) {
            System.out.print("Nhap trang thai task: ");
            String status = sc.nextLine().trim();
            m = p.matcher(status);
            if (m.matches()) {
                c.setTrangThaiTask(status);
                break;
            }

            System.out.println("trang thai task khong hop le ! (hold|finish|processing) ");
        }

        while (true) {
            System.out.print("Nhap ten du an co task dang thuc hien: ");
            String tenda = sc.nextLine().trim();
            if (tenda.length() > 0) {
                c.setTaskThuocDuAn(tenda);
                break;
            }
            System.out.println("ten du an co task dang thuc hien ko hop le ! Khong duoc de trong ,...... ");
        }

        while (true) {
            System.out.print("Nhap ten nhan vien dang phu trach task: ");
            String tennv = sc.nextLine().trim();
            if (tennv.length() > 0) {
                c.setNhanVienPhuTrachTask(tennv);
                break;
            }
            System.out.println("ten nhan vien khong hop le ! Khong duoc de trong ,...... ");
        }

        while (true) {
            System.out.println("Nhap ngay deadline task [yyyy-MM-dd]: ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String deadline = sc.nextLine();
            try {
                c.setDeadLineTask(sdf.parse(deadline));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
        }


        ds.add(c);

    }

    @Override
    public void suaTask(String ms) {
        Scanner sc = new Scanner(System.in);
        if (ds.isEmpty()){
            System.out.println("danh sach rong.");
            return;
        }
        boolean co= false;
        int size = ds.size();
        for (int i = 0; i < size; i++) {
            if(ds.get(i).getMaSoTask().contains(ms)){
                co=true;
                System.out.println("nhap lai ten task: ");
                ds.get(i).setTieuDeTak(sc.nextLine().trim());
                System.out.println("nhap lai trang thai task: ");
                ds.get(i).setTrangThaiTask(sc.nextLine().trim());
                System.out.println("nhap lai ten du an co task dang lam: ");
                ds.get(i).setTaskThuocDuAn(sc.nextLine().trim());
                System.out.println("nhap lai ten nhan vien phu trach task: ");
                ds.get(i).setNhanVienPhuTrachTask(sc.nextLine().trim());
                System.out.println("nhap lai ngay kiem tra tien do task: ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    ds.get(i).setDeadLineTask(sdf.parse(sc.nextLine()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
        if (!co) {
            System.out.printf("ma so %s khong ton tai\n", ms);
        }
    }

    @Override
    public void xoaTask(String ms) {
        if(ds.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }
        for (CongViec item : ds) {
            if(item.getMaSoTask().equals(ms)){
                ds.remove(item);
                System.out.println("da xoa thanh cong");
                return;
            }
        }
        System.out.println("khong tim thay ma so %s theo yeu cau"+ms);
    }

    @Override
    public void hienThiDSTask() {
        if(ds.isEmpty()){
            System.out.println("ds rong. bao loi");
            return;
        }

        for (CongViec item: ds) {
            System.out.println(item);
        }
    }

    @Override
    public void hienThiDSTask(String trangThai) {

        trangThai=trangThai.toLowerCase();
        int count=0;
        for (CongViec item : ds) {
            if(item.getTrangThaiTask().toLowerCase().contains(trangThai)){
                System.out.println(item);
                count++;
            }
        }

        if(count==0){
            System.out.println("ko tim thay "+trangThai);
        }
    }

    @Override
    public void hienThiDSTaskQuaDeadLine() {
        int cnt=0;
        Date dNow= new Date();
        for (CongViec item: ds) {
            if (item.getDeadLineTask().after(dNow)){
                System.out.println(item);
                cnt++;
            }
            else if (item.getDeadLineTask().before(dNow)){
                System.out.println(item);
                cnt++;
            }
            else if (item.getDeadLineTask().equals(dNow)){
                System.out.println(item);
                cnt++;
            }
        }

    }
}
