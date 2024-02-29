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
public class BaoHanhSP {
    private String MaBH, MaSP, MotaLoi;
    private Date NgayBH;
    private double Chiphi;

    public BaoHanhSP() {
    }

    public BaoHanhSP(String MaBH, String MaSP, String MotaLoi, Date NgayBH, double Chiphi) {
        this.MaBH = MaBH;
        this.MaSP = MaSP;
        this.MotaLoi = MotaLoi;
        this.NgayBH = NgayBH;
        this.Chiphi = Chiphi;
    }

    public String getMaBH() {
        return MaBH;
    }

    public void setMaBH(String MaBH) {
        this.MaBH = MaBH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMotaLoi() {
        return MotaLoi;
    }

    public void setMotaLoi(String MotaLoi) {
        this.MotaLoi = MotaLoi;
    }

    public Date getNgayBH() {
        return NgayBH;
    }

    public void setNgayBH(Date NgayBH) {
        this.NgayBH = NgayBH;
    }

    public double getChiphi() {
        return Chiphi;
    }

    public void setChiphi(double Chiphi) {
        this.Chiphi = Chiphi;
    }
    
}
