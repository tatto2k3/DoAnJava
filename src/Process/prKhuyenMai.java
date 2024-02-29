/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class prKhuyenMai {
    public int insert(String maKM, String tenKM,String ngayBD, String ngayKT, double phantramKM){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL THEM_KHUYENMAI(?,?,?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, maKM);
            pstmt.setString(2,tenKM);
            pstmt.setString(3,ngayBD);
            pstmt.setString(4,ngayKT);
            pstmt.setDouble(5, phantramKM);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public int update (String maKM, String tenKM,String ngayBD, String ngayKT, double phantramKM){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL CAPNHAT_KHUYENMAI(?,?,?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);  
            pstmt.setString(1, maKM);
            pstmt.setString(2, tenKM);
            pstmt.setString(3,ngayBD);
            pstmt.setString(4,ngayKT);
            pstmt.setDouble(5, phantramKM);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public boolean delete(String maKM) throws Exception{
        String sql = "DELETE FROM KhuyenMai" +
                    " WHERE MaKM =?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maKM);
                return pstmt.executeUpdate()>0;
                }
    }
    public KhuyenMai FindByID(String maKM) throws Exception{
        String sql = "SELECT * FROM KhuyenMai WHERE MaKM = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maKM);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       KhuyenMai km = TaoKhuyenMai(rs);
                       return km;
                   }
                }
            }
        return null;
    }
    public List<KhuyenMai> FindAll() throws Exception{
        String sql = "SELECT * FROM KhuyenMai";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <KhuyenMai> list = new ArrayList<>();
                   while(rs.next()){
                       KhuyenMai km = TaoKhuyenMai(rs);
                       list.add(km);
                   }
                   return list;
                }
            }
    }

    private KhuyenMai TaoKhuyenMai(final ResultSet rs) throws SQLException {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(rs.getString("makm"));
        km.setTenKM(rs.getString("tenkm"));
        km.setNgayBD(rs.getDate("ngaybd"));
        km.setNgayKT(rs.getDate("ngaykt"));
        km.setPhantramKM(rs.getDouble("phantramkm"));
        return km;
    }
    
    public int somaKM() throws Exception{
        int count=0;
        String sql= "SELECT count(maKM) sl FROM KHUYENMAI";
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
   
    public HashMap<String,String> getListKhuyenMai() {
        HashMap<String,String> listKhachHang = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT makm,tenkm FROM KhuyenMai ORDER BY makm";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listKhachHang.put(rs.getString("tenkm"),rs.getString("makm"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listKhachHang;
    }
}
