/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class prSanPham {
    public boolean insert(SanPham sp)
        throws Exception{
        String sql = "{CALL THEM_SANPHAM(?,?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, sp.getMaSP());
                pstmt.setString(2, sp.getMaKM());
                pstmt.setString(3, sp.getMaNCC());
                pstmt.setString(4, sp.getTenSP());
                pstmt.setString(5, sp.getMauSac());
                pstmt.setLong(6, sp.getDongia());
                pstmt.setLong(7, sp.getSoluong());
                return pstmt.executeUpdate()>0;
                }
    } 
    public boolean update(SanPham sp)
        throws Exception{
        String sql = "{CALL CAPNHAT_SANPHAM(?,?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, sp.getMaSP());
                pstmt.setString(2, sp.getMaKM());
                pstmt.setString(3, sp.getMaNCC());
                pstmt.setString(4, sp.getTenSP());
                pstmt.setString(5, sp.getMauSac());
                pstmt.setLong(6, sp.getDongia());
                pstmt.setLong(7, sp.getSoluong());
                return pstmt.executeUpdate()>0;
                }
    }
    public boolean delete(String maSP) throws Exception{
        String sql = "{CALL XOA_SANPHAM(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maSP);
                return pstmt.executeUpdate()>0;
                }
    }
    public SanPham FindByID(String maSP) throws Exception{
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maSP);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       SanPham sp = TaoSanPham(rs);
                       return sp;
                   }
                }
            }
        return null;
    }
    public List<SanPham> FindAll() throws Exception{
        String sql = "SELECT * FROM SanPham";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <SanPham> list = new ArrayList<>();
                   while(rs.next()){
                       SanPham sp = TaoSanPham(rs);
                       list.add(sp);
                   }
                   return list;
                }
            }
    }

    private SanPham TaoSanPham(final ResultSet rs) throws SQLException {
        SanPham sp = new SanPham();
        sp.setMaSP(rs.getString("maSP"));
        sp.setTenSP(rs.getString("tenSP"));
        sp.setMauSac(rs.getString("mausac"));
        sp.setDongia(rs.getLong("dongia"));
        sp.setMaNCC(rs.getString("mancc"));
        sp.setMaKM(rs.getString("makm"));
        sp.setSoluong(rs.getLong("soluong"));
        return sp;
    }
    public int maSP() throws Exception{
        int count=0;
        String sql= "SELECT count(maSP) sl FROM SANPHAM";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                   while(rs.next()){
                       count= rs.getInt("sl");
                   }
                   
                }
            return count;
        }
   }
   public HashMap<String,String> getlistmaSP() {
        HashMap<String,String> listSanPham = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT masp,tensp FROM Sanpham ORDER BY masp";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listSanPham.put(rs.getString("manv"),rs.getString("manv"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listSanPham;
    }
}
