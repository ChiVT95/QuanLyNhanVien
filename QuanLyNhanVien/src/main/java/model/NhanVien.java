package model;

import java.util.*;

public class NhanVien {
    //ID gồm 4 ký tự số, tên nhân viên, giới tính, lương, và cờ delete
    private String MasoNV;
    private String TenNV;
    private boolean GioiTinhNV;
    private int LuongNV;
    private boolean CoXoa;

    public String getMasoNV() {
        return MasoNV;
    }

    public void setMasoNV(String masoNV) {
        MasoNV = masoNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public boolean isGioiTinhNV() {
        return GioiTinhNV;
    }

    public void setGioiTinhNV(boolean gioiTinhNV) {
        GioiTinhNV = gioiTinhNV;
    }

    public int getLuongNV() {
        return LuongNV;
    }

    public void setLuongNV(int luongNV) {
        LuongNV = luongNV;
    }

    public boolean isCoXoa() {
        return CoXoa;
    }

    public void setCoXoa(boolean coXoa) {
        CoXoa = coXoa;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %s", MasoNV, TenNV, GioiTinhNV ? "Nam" : "Nu", LuongNV, CoXoa ? "Co" : "Khong");
    }
}
