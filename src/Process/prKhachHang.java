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
import Model.KhachHang;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class prKhachHang {
    public boolean insert(KhachHang kh)
        throws Exception{
        String sql = "{ CALL THEM_KHACHHANG(?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, kh.getMaKH());
                pstmt.setString(2,kh.getTenKH());
                pstmt.setString(3, kh.getDiachi());
                pstmt.setString(4, kh.getCMND());
                pstmt.setString(5, kh.getEmail());
                pstmt.setString(6, kh.getSDT());
                return pstmt.executeUpdate()>0;
                }
    } 
    public boolean update(KhachHang kh)
        throws Exception{
        String sql = "{ CALL CAPNHAT_KHACHHANG(?,?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, kh.getMaKH());
                pstmt.setString(2,kh.getTenKH());
                pstmt.setString(3, kh.getDiachi());
                pstmt.setString(4, kh.getCMND());
                pstmt.setString(5, kh.getEmail());
                pstmt.setString(6, kh.getSDT());
                
                return pstmt.executeUpdate()>0;
                }
    }
    public boolean delete(String maKH) throws Exception{
        String sql = "{ CALL XOA_KHACHHANG(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maKH);
                return pstmt.executeUpdate()>0;
                }
    }
    public KhachHang FindByID(String maKH) throws Exception{
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maKH);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       KhachHang kh = TaoKhachHang(rs);
                       return kh;
                   }
                }
            }
        return null;
    }
    public List<KhachHang> FindAll() throws Exception{
        String sql = "SELECT * FROM KhachHang";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <KhachHang> list = new ArrayList<>();
                   while(rs.next()){
                       KhachHang kh = TaoKhachHang(rs);
                       list.add(kh);
                   }
                   return list;
                }
            }
    }

    private KhachHang TaoKhachHang(final ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMaKH(rs.getString("makh"));
        kh.setTenKH(rs.getString("tenkh"));
        kh.setDiachi(rs.getString("diachi"));
        kh.setEmail(rs.getString("email"));
        kh.setSDT(rs.getString("sdt"));
        kh.setCMND(rs.getString("cmnd"));
        return kh;
    }
    
    public int somaKH() throws Exception{
        int count=0;
        String sql= "SELECT count(maKH) sl FROM KHACHHANG";
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
    
    public HashMap<String,String> getListKhachHang() {
        HashMap<String,String> listKhachHang = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT makh,tenkh FROM KhachHang ORDER BY makh";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listKhachHang.put(rs.getString("tenkh"),rs.getString("makh"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listKhachHang;
    }
}
