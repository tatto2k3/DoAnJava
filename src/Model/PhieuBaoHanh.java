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
public class PhieuBaoHanh {
    private String MaPBH;
    private Date Ngaybatdau, Ngayhethan;
    

    public PhieuBaoHanh() {
    }

    public PhieuBaoHanh(String MaPBH, Date Ngaybatdau, Date Ngayhethan) {
        this.MaPBH = MaPBH;
        this.Ngaybatdau = Ngaybatdau;
        this.Ngayhethan = Ngayhethan;
    }

    public String getMaPBH() {
        return MaPBH;
    }

    public void setMaPBH(String MaPBH) {
        this.MaPBH = MaPBH;
    }

    public Date getNgaybatdau() {
        return Ngaybatdau;
    }

    public void setNgaybatdau(Date Ngaybatdau) {
        this.Ngaybatdau = Ngaybatdau;
    }

    public Date getNgayhethan() {
        return Ngayhethan;
    }

    public void setNgayhethan(Date Ngayhethan) {
        this.Ngayhethan = Ngayhethan;
    }

}
