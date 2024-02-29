/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB_Notify;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class KiemTraDuLieu {
     public static void DuLieuTrong(JTextField field,StringBuilder sb, String TbLoi){
        if(field.getText().equals("")){
            sb.append(TbLoi).append("\n");
           field.requestFocus();
        }
    }
    
     public static void DuLieuTrong(JPasswordField field,StringBuilder sb, String TbLoi){
        String password = new String(field.getPassword());
         if(password.equals("")){
            sb.append(TbLoi).append("\n");
           field.requestFocus();
        }
    }
}
