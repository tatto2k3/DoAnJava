/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.NhanVien;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class prNhanVien {
    public boolean insert(NhanVien nv)
        throws Exception{
        String sql = "{CALL THEM_NHAVIEN(?,?,?,?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, nv.getMaNV());
                pstmt.setString(2, nv.getMaPB());
                pstmt.setString(3, nv.getHoten());
                pstmt.setInt(4, nv.getGioitinh());
                pstmt.setString(5, nv.getCMND());
                pstmt.setString(6, nv.getDiachi());
                pstmt.setString(7, nv.getEmail());
                pstmt.setString(8, nv.getSDT());
                pstmt.setString(9, nv.getSongaylam());

                return pstmt.executeUpdate()>0;
                }
    } 
    public boolean update(NhanVien nv)
        throws Exception{
        String sql = "{CALL CAPNHAT_NHAVIEN(?,?,?,?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, nv.getMaNV());
                pstmt.setString(2, nv.getMaPB());
                pstmt.setString(3, nv.getHoten());
                pstmt.setInt(4, nv.getGioitinh());
                pstmt.setString(5, nv.getCMND());
                pstmt.setString(6, nv.getDiachi());
                pstmt.setString(7, nv.getEmail());
                pstmt.setString(8, nv.getSDT());
                pstmt.setString(9, nv.getSongaylam());
                return pstmt.executeUpdate()>0;
                }
    }
    public boolean delete(String maNV) throws Exception{
        String sql = "{CALL XOA_NHANVIEN(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maNV);
                return pstmt.executeUpdate()>0;
                }
    }
    public NhanVien FindByID(String maNV) throws Exception{
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maNV);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       NhanVien nv = TaoNhanVien(rs);
                       return nv;
                   }
                }
            }
        return null;
    }
    public List<NhanVien> FindAll() throws Exception{
        String sql = "SELECT * FROM NhanVien";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <NhanVien> list = new ArrayList<>();
                   while(rs.next()){
                       NhanVien nv = TaoNhanVien(rs);
                       list.add(nv);
                   }
                   return list;
                }
            }
    }

    private NhanVien TaoNhanVien(final ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getString("manv"));
        nv.setHoten(rs.getString("hoten"));
        nv.setGioitinh(rs.getInt("gioitinh"));
        nv.setCMND(rs.getString("cmnd"));
        nv.setDiachi(rs.getString("diachi"));
        nv.setEmail(rs.getString("email"));
        nv.setSDT(rs.getString("sdt"));
        nv.setSongaylam(rs.getString("songaylam"));
        nv.setMaPB(rs.getString("mapb"));
        return nv;
    }
    
    public int somaNV() throws Exception{
        int count=0;
        String sql= "SELECT count(MANV) sl FROM NHANVIEN";
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
    
    public HashMap<String,String> getlistmaNhanVien() {
        HashMap<String,String> listNhanVien = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT manv,hoten FROM NhanVien ORDER BY manv";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listNhanVien.put(rs.getString("manv"),rs.getString("manv"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listNhanVien;
    }
}
