/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.DangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class prTaoTaiKhoan {
    public boolean insert(DangNhap dn)
        throws Exception{
        String sql = "INSERT INTO DANGNHAP VALUES (?,?,?,?)";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,dn.getTenDangNhap());
                pstmt.setString(2, dn.getCapBac());
                pstmt.setString(3, dn.getMatKhau());
                pstmt.setString(4, dn.getMaNV());
                return pstmt.executeUpdate()>0;
                }
    } 
}
