/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class NhanVien {
    private String MaNV,Hoten,CMND,Diachi,Email,SDT,MaPB,Songaylam;
    private int Gioitinh;

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getSongaylam() {
        return Songaylam;
    }

    public void setSongaylam(String Songaylam) {
        this.Songaylam = Songaylam;
    }

    public int getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(int Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public NhanVien(String MaNV, String Hoten, String CMND, String Diachi, String Email, String SDT, String MaPB, String Songaylam, int Gioitinh) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.CMND = CMND;
        this.Diachi = Diachi;
        this.Email = Email;
        this.SDT = SDT;
        this.MaPB = MaPB;
        this.Songaylam = Songaylam;
        this.Gioitinh = Gioitinh;
    }

   
}
