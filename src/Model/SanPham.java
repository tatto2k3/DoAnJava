/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class SanPham {
    private String MaSP, TenSP, MauSac, MaNCC, MaKM;
    private long Dongia, Soluong;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String MauSac, String MaNCC, String MaKM, long Dongia, long Soluong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MauSac = MauSac;
        this.MaNCC = MaNCC;
        this.MaKM = MaKM;
        this.Dongia = Dongia;
        this.Soluong =Soluong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public long getDongia() {
        return Dongia;
    }

    public void setDongia(long Dongia) {
        this.Dongia = Dongia;
    }
    
    public long getSoluong() {
        return Soluong;
    }

    public void setSoluong(long Soluong) {
        this.Soluong = Soluong;
    }
}