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
public class HoaDon {
     private String SoHD, MaSP, MaKH, MaPBH, MaNV;
     private long Soluong, Trigia;
     private Date ngayLapHD;

    public HoaDon() {
    }

    public HoaDon(String SoHD, String MaSP, String MaKH, String MaPBH, String MaNV, long Soluong, long Trigia, Date ngayLapHD) {
        this.SoHD = SoHD;
        this.MaSP = MaSP;
        this.MaKH = MaKH;
        this.MaPBH = MaPBH;
        this.MaNV = MaNV;
        this.Soluong = Soluong;
        this.Trigia = Trigia;
        this.ngayLapHD = ngayLapHD;
    }

    public String getSoHD() {
        return SoHD;
    }

    public void setSoHD(String SoHD) {
        this.SoHD = SoHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaPBH() {
        return MaPBH;
    }

    public void setMaPBH(String MaPBH) {
        this.MaPBH = MaPBH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public long getSoluong() {
        return Soluong;
    }

    public void setSoluong(long Soluong) {
        this.Soluong = Soluong;
    }

    public long getTrigia() {
        return Trigia;
    }

    public void setTrigia(long Trigia) {
        this.Trigia = Trigia;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }
     
}
