/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class DoanhThu{
    private long dtThang,dtNam,sohdThang, soHDKH;
    private int thang, nam;

    public DoanhThu() {
    }

    public DoanhThu(long dtThang, long dtNam, long sohdThang, long soHDKH, int thang, int nam) {
        this.dtThang = dtThang;
        this.dtNam = dtNam;
        this.sohdThang = sohdThang;
        this.soHDKH = soHDKH;
        this.thang = thang;
        this.nam = nam;
    }

    public long getDtThang() {
        return dtThang;
    }

    public void setDtThang(long dtThang) {
        this.dtThang = dtThang;
    }

    public long getDtNam() {
        return dtNam;
    }

    public void setDtNam(long dtNam) {
        this.dtNam = dtNam;
    }

    public long getSohdThang() {
        return sohdThang;
    }

    public void setSohdThang(long sohdThang) {
        this.sohdThang = sohdThang;
    }

    public long getSoHDKH() {
        return soHDKH;
    }

    public void setSoHDKH(long soHDKH) {
        this.soHDKH = soHDKH;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }


}
