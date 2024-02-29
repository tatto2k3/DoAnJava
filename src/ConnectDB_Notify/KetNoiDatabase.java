/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB_Notify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class KetNoiDatabase {
     public static Connection getOracleConnection() throws SQLException,ClassNotFoundException{
        String hostName ="localhost";
        String sid ="orcl";
        String userName="DOANJAVA"; 
        String password = "123456";
        return getOracleConnecttion(hostName,sid,userName,password);
    }  

    private static Connection getOracleConnecttion(String hostName, String sid, String userName, String password)
            throws SQLException,ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        String connectionURL = "jdbc:oracle:thin:@"+hostName+":1521:"+sid;
        Connection conn = DriverManager.getConnection(connectionURL,userName,password);
        return conn;
    }

    public static KetNoiDatabase openConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
