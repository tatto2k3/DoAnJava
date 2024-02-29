/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.PhongBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class prPhongBan {
    public boolean insert(PhongBan pb)
        throws Exception{
        String sql = "{CALL THEM_PHONGBAN(?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, pb.getMaPB());
                pstmt.setString(2, pb.getTenPB());
                pstmt.setLong(3, pb.getSoluongNV());
                pstmt.setString(4, pb.getTrgPB());
                return pstmt.executeUpdate()>0;
                }
    } 
    public boolean update(PhongBan pb)
        throws Exception{
        String sql = "{CALL CAPNHAT_PHONGBAN(?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, pb.getMaPB());
                pstmt.setString(2, pb.getTenPB());
                pstmt.setLong(3, pb.getSoluongNV());
                pstmt.setString(4, pb.getTrgPB());
                return pstmt.executeUpdate()>0;
                }
    }
    public boolean delete(String maPB) throws Exception{
        String sql = "{CALL XOA_PHONGBAN(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maPB);
                return pstmt.executeUpdate()>0;
                }
    }
    public PhongBan FindByID(String maPB) throws Exception{
        String sql = "SELECT * FROM PhongBan WHERE MaPB = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maPB);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       PhongBan pb = TaoPhongBan(rs);
                       return pb;
                   }
                }
            }
        return null;
    }
    public List<PhongBan> FindAll() throws Exception{
        String sql = "SELECT * FROM PhongBan";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <PhongBan> list = new ArrayList<>();
                   while(rs.next()){
                       PhongBan pb = TaoPhongBan(rs);
                       list.add(pb);
                   }
                   return list;
                }
            }
    }

    private PhongBan TaoPhongBan(final ResultSet rs) throws SQLException {
        PhongBan pb = new PhongBan();
        pb.setMaPB(rs.getString("mapb"));
        pb.setTenPB(rs.getString("tenpb"));
        pb.setSoluongNV(rs.getLong("soluongnv"));
        pb.setTrgPB(rs.getString("truongpb"));
        return pb;
    }
    
    public int somaPB() throws Exception{
        int count=0;
        String sql= "SELECT count(MAPB) sl FROM PHONGBAN";
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
    
    public HashMap<String,String> getListPhongBan() {
        HashMap<String,String> listKhachHang = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT mapb,tenpb FROM PhongBan ORDER BY mapb";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listKhachHang.put(rs.getString("mapb"),rs.getString("mapb"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listKhachHang;
    }
}
