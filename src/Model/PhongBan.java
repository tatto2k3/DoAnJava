/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class PhongBan {
    private String MaPB, TenPB,TrgPB;
    private long SoluongNV;

    public PhongBan() {
    }

    public PhongBan(String MaPB, String TenPB, String TrgPB, long SoluongNV) {
        this.MaPB = MaPB;
        this.TenPB = TenPB;
        this.TrgPB = TrgPB;
        this.SoluongNV = SoluongNV;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }

    public String getTrgPB() {
        return TrgPB;
    }

    public void setTrgPB(String TrgPB) {
        this.TrgPB = TrgPB;
    }

    public long getSoluongNV() {
        return SoluongNV;
    }

    public void setSoluongNV(long SoluongNV) {
        this.SoluongNV = SoluongNV;
    }
    
}
