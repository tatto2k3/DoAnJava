/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class KhuyenMai {
    private String MaKM, TenKM;
    private Date NgayBD, NgayKT;
    private double PhantramKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, String TenKM, Date NgayBD, Date NgayKT, double PhantramKM) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.PhantramKM = PhantramKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public double getPhantramKM() {
        return PhantramKM;
    }

    public void setPhantramKM(double PhantramKM) {
        this.PhantramKM = PhantramKM;
    }
    
}
