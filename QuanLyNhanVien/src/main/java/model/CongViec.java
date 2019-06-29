package model;

import java.util.Date;

public class CongViec {

    private String MaSoTask;
    private String TieuDeTak;
    private String TrangThaiTask;
    private String TaskThuocDuAn;
    private String NhanVienPhuTrachTask;
    private Date DeadLineTask;

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s.%s", MaSoTask, TieuDeTak, TrangThaiTask, TaskThuocDuAn, NhanVienPhuTrachTask, DeadLineTask);
    }

    public String getMaSoTask() {
        return MaSoTask;
    }

    public void setMaSoTask(String maSoTask) {
        MaSoTask = maSoTask;
    }

    public String getTieuDeTak() {
        return TieuDeTak;
    }

    public void setTieuDeTak(String tieuDeTak) {
        TieuDeTak = tieuDeTak;
    }

    public String getTrangThaiTask() {
        return TrangThaiTask;
    }

    public void setTrangThaiTask(String trangThaiTask) {
        TrangThaiTask = trangThaiTask;
    }

    public String getTaskThuocDuAn() {
        return TaskThuocDuAn;
    }

    public void setTaskThuocDuAn(String taskThuocDuAn) {
        TaskThuocDuAn = taskThuocDuAn;
    }

    public String getNhanVienPhuTrachTask() {
        return NhanVienPhuTrachTask;
    }

    public void setNhanVienPhuTrachTask(String nhanVienPhuTrachTask) {
        NhanVienPhuTrachTask = nhanVienPhuTrachTask;
    }

    public Date getDeadLineTask() {
        return DeadLineTask;
    }

    public void setDeadLineTask(Date deadLineTask) {
        DeadLineTask = deadLineTask;
    }
}
