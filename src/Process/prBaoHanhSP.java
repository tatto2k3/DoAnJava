/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.BaoHanhSP;
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
public class prBaoHanhSP {
    public int insert(String maBH, String maSP, String ngayBH,double Chiphi, String motaLoi){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL THEM_BAOHANHSP(?,?,?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, maBH);
            pstmt.setString(2,maSP);
            pstmt.setString(3,ngayBH);
            pstmt.setDouble(4,Chiphi);
            pstmt.setString(5,motaLoi);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public int update (String maBH, String maSP, String ngayBH, double Chiphi, String motaLoi){
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{CALL CAPNHAT_BAOHANHSP(?,?,?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);  
            pstmt.setString(1, maBH);
            pstmt.setString(2,maSP);
            pstmt.setString(3,ngayBH);
            pstmt.setDouble(4,Chiphi);
            pstmt.setString(5,motaLoi);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult; 
    }
    
    public boolean delete(String maBH) throws Exception{
        String sql = "{CALL XOA_BAOHANHSP(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maBH);
                return pstmt.executeUpdate()>0;
                }
    }
    public BaoHanhSP FindByID(String maPBH) throws Exception{
        String sql = "SELECT * FROM BaoHanhSP WHERE MaBH = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maPBH);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       BaoHanhSP pbh = TaoBaoHanh(rs);
                       return pbh;
                   }
                }
            }
        return null;
    }
    public List<BaoHanhSP> FindAll() throws Exception{
        String sql = "SELECT * FROM BaoHanhSP";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <BaoHanhSP> list = new ArrayList<>();
                   while(rs.next()){
                       BaoHanhSP bh = TaoBaoHanh(rs);
                       list.add(bh);
                   }
                   return list;
                }
            }
    }

    private BaoHanhSP TaoBaoHanh(final ResultSet rs) throws SQLException {
        BaoHanhSP bh = new BaoHanhSP();
        bh.setMaBH(rs.getString("mabh"));
        bh.setMaSP(rs.getString("masp"));
        bh.setNgayBH(rs.getDate("ngaybh"));
        bh.setChiphi(rs.getDouble("chiphibh"));
        bh.setMotaLoi(rs.getString("motaloi"));
        return bh;
    }
    
    public int somaBH() throws Exception{
        int count=0;
        String sql= "SELECT count(maBH) sl FROM BAOHANHSP";
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
}
