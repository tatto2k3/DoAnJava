/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.PhieuBaoHanh;
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
public class prPhieuBaoHanh {
    public int insert(String maPBH, String ngayBD, String ngayHH){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL THEM_PHIEUBAOHANH(?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, maPBH);
            pstmt.setString(2,ngayBD);
            pstmt.setString(3,ngayHH);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public int update (String maPBH, String ngayBD, String ngayHH){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL CAPNHAT_PHIEUBAOHANH(?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);  
            pstmt.setString(1, maPBH);
            pstmt.setString(2,ngayBD);
            pstmt.setString(3,ngayHH);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public boolean delete(String maPBH) throws Exception{
        String sql = "{CALL XOA_PHIEUBAOHANH(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maPBH);
                return pstmt.executeUpdate()>0;
                }
    }
    public PhieuBaoHanh FindByID(String maPBH) throws Exception{
        String sql = "SELECT * FROM PhieuBaoHanh WHERE MaPBH = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maPBH);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       PhieuBaoHanh pbh = TaoBaoHanh(rs);
                       return pbh;
                   }
                }
            }
        return null;
    }
    public List<PhieuBaoHanh> FindAll() throws Exception{
        String sql = "SELECT * FROM PhieuBaoHanh";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <PhieuBaoHanh> list = new ArrayList<>();
                   while(rs.next()){
                       PhieuBaoHanh pbh = TaoBaoHanh(rs);
                       list.add(pbh);
                   }
                   return list;
                }
            }
    }

    private PhieuBaoHanh TaoBaoHanh(final ResultSet rs) throws SQLException {
        PhieuBaoHanh pbh = new PhieuBaoHanh();
        pbh.setMaPBH(rs.getString("mapbh"));
        pbh.setNgaybatdau(rs.getDate("ngaybatdau"));
        pbh.setNgayhethan(rs.getDate("ngayhethan"));
        return pbh;
    }
    
    public int somaPBH() throws Exception{
        int count=0;
        String sql= "SELECT count(maPBH) sl FROM PHIEUBAOHANH";
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
    
    public HashMap<String,String> getListPhieuBaoHanh() {
        HashMap<String,String> listPhieuBaoHanh = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT mapbh FROM PhieuBaoHanh ORDER BY mapbh";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listPhieuBaoHanh.put(rs.getString("mapbh"),rs.getString("mapbh"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listPhieuBaoHanh;
    }
}
