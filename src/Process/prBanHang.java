/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB_Notify.KetNoiDatabase;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class prBanHang {
    public boolean insert_CTHD(HoaDon hd) throws Exception{
        String sql = "{CALL THEM_CTHD_BANSP(?,?,?)}";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                pstmt.setString(1, hd.getSoHD());
                pstmt.setString(2, hd.getMaSP());
                pstmt.setLong(3, hd.getSoluong());
                return pstmt.executeUpdate()>0;
                } 
    }
    public int insert_HD(String SoHD, String MaKH, String MaPBH, String MaNV, Date ngayLapHD, long triGia) {
        int countResult =0;
        try(Connection con = KetNoiDatabase.getOracleConnection()){
            String query = "{ CALL THEM_HD_BANSP(?,?,?,?,?,?)}";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, SoHD);
            pstmt.setString(2, MaKH);
            pstmt.setString(3, MaPBH);
            pstmt.setString(4, MaNV);
            pstmt.setDate(5,new java.sql.Date(ngayLapHD.getTime()));
            pstmt.setLong(6, triGia);
            countResult=pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
            return countResult;
        }
        return countResult;
    }
    public List<HoaDon> FindAll() throws Exception{
        String sql = """
                   SELECT c.SoHD, MaKH, MaPBH, MaNV, ngayLapHD, TriGia , MaSP, Soluong 
                   FROM HD_BANSP h JOIN CTHD_BANSP c ON h.SoHD = c.SoHD""";
        try(
                Connection con = KetNoiDatabase.getOracleConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                try(ResultSet rs = pstmt.executeQuery();){
                    List <HoaDon> list = new ArrayList<>();
                   while(rs.next()){
                       HoaDon hd = TaoHoaDon(rs);
                       list.add(hd);
                   }
                   return list;
                }
            }
    }
    private HoaDon TaoHoaDon(final ResultSet rs) throws SQLException {
        HoaDon hd = new HoaDon();
        hd.setSoHD(rs.getString("sohd"));
        hd.setMaKH(rs.getString("makh"));
        hd.setMaPBH(rs.getString("mapbh"));
        hd.setMaNV(rs.getString("manv"));
        hd.setNgayLapHD(rs.getDate("ngaylaphd"));
        hd.setTrigia(rs.getLong("trigia"));
        hd.setMaSP(rs.getString("masp"));
        hd.setSoluong(rs.getLong("soluong"));
        return hd;
    }
    
    public int soHD() throws Exception{
        int count=0;
        String sql= "SELECT count(soHD) sl FROM HD_BANSP";
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
