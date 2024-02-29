/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;


import ConnectDB_Notify.KetNoiDatabase;
import Model.DangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class prDangNhap {
    public DangNhap ktDangNhap(String tenDangNhap, String MatKhau)
        throws Exception{
        String sql = "select TenDN, MatKhau, CapBac, d.MaNV, HoTen from DangNhap d join NhanVien n on d.MaNV =n.MaNV"+
                    " where tenDN =? and MatKhau=? ";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, tenDangNhap);
                pstmt.setString(2, MatKhau);
                
                try(ResultSet rs = pstmt.executeQuery();){
                    if(rs.next()){
                        DangNhap dn = new DangNhap();
                        dn.setTenDangNhap(tenDangNhap);
                        dn.setCapBac(rs.getString("CapBac"));
                        dn.setMaNV(rs.getString("MaNV"));
                        dn.setTenNV(rs.getString("HoTen"));
                        return dn;
                    }
                }
        }
        return null;
    }
   
    public List<DangNhap> FindAll() throws Exception{
        String sql = "SELECT * FROM DangNhap";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <DangNhap> list = new ArrayList<>();
                   while(rs.next()){
                       DangNhap dn = TaoDangNhap(rs);
                       list.add(dn);
                   }
                   return list;
                }
            }
    }
    
     private DangNhap TaoDangNhap(final ResultSet rs) throws SQLException {
        DangNhap dn = new DangNhap();
        dn.setTenDangNhap(rs.getString("tendn"));
        dn.setCapBac(rs.getString("capbac"));
        dn.setMatKhau(rs.getString("matkhau"));
        dn.setMaNV(rs.getString("manv"));
        return dn;
    }
}
