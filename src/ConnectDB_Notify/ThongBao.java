/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB_Notify;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ThongBao {
    public static void showThongBao(Component parent, String content, String tittle){
        JOptionPane.showMessageDialog(parent, content, tittle,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showLoi(Component parent, String content, String tittle){
        JOptionPane.showMessageDialog(parent, content, tittle, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showXacNhan(Component parent, String content, String tittle){
        int choose = JOptionPane.showConfirmDialog(parent, content, tittle,JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
