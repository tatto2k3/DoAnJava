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
import Model.NhaCungCap;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class prNhaCungCap {
    public boolean insert(NhaCungCap ncc)
        throws Exception{
        String sql = "{CALL THEM_NHACUNGCAP(?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, ncc.getMaNCC());
                pstmt.setString(2, ncc.getTenNCC());
                pstmt.setString(3, ncc.getDiachi());
                pstmt.setString(4, ncc.getEmail());
                pstmt.setString(5, ncc.getSDT());
                return pstmt.executeUpdate()>0;
                }
    } 
    public boolean update(NhaCungCap ncc)
        throws Exception{
        String sql = "{CALL CAPNHAT_NHACUNGCAP(?,?,?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1, ncc.getMaNCC());
                pstmt.setString(2, ncc.getTenNCC());
                pstmt.setString(3, ncc.getDiachi());
                pstmt.setString(4, ncc.getEmail());
                pstmt.setString(5, ncc.getSDT());
                return pstmt.executeUpdate()>0;
                }
    }
    public boolean delete(String maNCC) throws Exception{
        String sql = "{CALL XOA_NHACUNGCAP(?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maNCC);
                return pstmt.executeUpdate()>0;
                }
    }
    public NhaCungCap FindByID(String maNCC) throws Exception{
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1,maNCC);
                try(ResultSet rs = pstmt.executeQuery();){
                   if(rs.next()){
                       NhaCungCap ncc = TaoNhaCungCap(rs);
                       return ncc;
                   }
                }
            }
        return null;
    }
    public List<NhaCungCap> FindAll() throws Exception{
        String sql = "SELECT * FROM NhaCungCap";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <NhaCungCap> list = new ArrayList<>();
                   while(rs.next()){
                       NhaCungCap ncc = TaoNhaCungCap(rs);
                       list.add(ncc);
                   }
                   return list;
                }
            }
    }

    private NhaCungCap TaoNhaCungCap(final ResultSet rs) throws SQLException {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(rs.getString("mancc"));
        ncc.setTenNCC(rs.getString("tenncc"));
        ncc.setDiachi(rs.getString("diachi"));
        ncc.setEmail(rs.getString("email"));
        ncc.setSDT(rs.getString("sdt"));
        return ncc;
    }
    
    public int somaNCC() throws Exception{
        int count=0;
        String sql= "SELECT count(maNCC) sl FROM NHACUNGCAP";
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
    public HashMap<String,String> getListNhaCungCap() {
        HashMap<String,String> listKhachHang = new HashMap<>();
        
        try ( Connection con = KetNoiDatabase.getOracleConnection()) {
            String SQL = "SELECT DISTINCT mancc,tenncc FROM NhaCungCap ORDER BY mancc";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                listKhachHang.put(rs.getString("tenncc"),rs.getString("mancc"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listKhachHang;
    }
}
