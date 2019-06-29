package model;

import java.util.Date;

public class DuAn {
    //ID(có thể là những ký tự ALPHABET viết in hoa) tên dự án, DeadLine (ngày hết hạn của dự án)
    private String MaSoDA;
    private String TenDA;
    private Date DeadLineDA;

    @Override
    public String toString() {
        return String.format("%s, %s, %s", MaSoDA, TenDA, DeadLineDA);
    }

    public String getIDDA() {
        return MaSoDA;
    }

    public void setIDDA(String IDDA) {
        this.MaSoDA = IDDA;
    }

    public String getTenDA() {
        return TenDA;
    }

    public void setTenDA(String tenDA) {
        TenDA = tenDA;
    }

    public Date getDeadLineDA() {
        return DeadLineDA;
    }

    public void setDeadLineDA(Date deadLineDA) {
        DeadLineDA = deadLineDA;
    }
}
