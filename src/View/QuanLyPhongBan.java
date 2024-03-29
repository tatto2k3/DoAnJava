/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import ConnectDB_Notify.KiemTraDuLieu;
import ConnectDB_Notify.ThongBao;
import Model.PhongBan;
import Process.prNhanVien;
import Process.prPhongBan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class QuanLyPhongBan extends javax.swing.JPanel {
    private GiaoDienChinh parentForm;
    private DefaultTableModel tblModel;
    ArrayList<String> listmaNV = null;
    /**
     * Creates new form QuanLyPhongBan
     */
    public QuanLyPhongBan() {
        initComponents();
        
        initTable();
        
        loadDataToTable();
        
        setListNhanVien();
    }
    
    private void initTable(){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã phòng ban","Tên phòng ban","Số lượng nhân viên", "Trưởng phòng"});
        tablePB.setModel(tblModel);
    }
    
    private void loadDataToTable(){
        try{
            prPhongBan kt = new prPhongBan();
            List<PhongBan> list = kt.FindAll();
            tblModel.setRowCount(0);
            for(PhongBan it :list){
                tblModel.addRow(new Object[]{
                it.getMaPB(), it.getTenPB(), it.getSoluongNV(), it.getTrgPB(), 
                });
            }
            tblModel.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
    private String getmaKM(){
        int count =0;
        prPhongBan kt = new prPhongBan();
        try {
            count = kt.somaPB();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count<9){
            return "PB00" +(count+1);
        }else if(count>=9 && count<99){
            return "PB" +0 +(count+1);
        }else
            return "PB" +(count+1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmaPB = new javax.swing.JTextField();
        txttenPB = new javax.swing.JTextField();
        txtslNV = new javax.swing.JTextField();
        btnThemPB = new javax.swing.JButton();
        btnxoaPB = new javax.swing.JButton();
        btncapnhatPB = new javax.swing.JButton();
        btnluuPB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtmaPB1 = new javax.swing.JTextField();
        btntracuuPB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePB = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        cbmaTrgP = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Phòng Ban");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN PHÒNG BAN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã phòng ban:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên phòng ban:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng NV:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã trưởng phòng:");

        txtmaPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txttenPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtslNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThemPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/add.png"))); // NOI18N
        btnThemPB.setText("Thêm mới");
        btnThemPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPBActionPerformed(evt);
            }
        });

        btnxoaPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnxoaPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/delete.png"))); // NOI18N
        btnxoaPB.setText("Xóa");
        btnxoaPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaPBActionPerformed(evt);
            }
        });

        btncapnhatPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncapnhatPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/update.png"))); // NOI18N
        btncapnhatPB.setText("Cập nhật");
        btncapnhatPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatPBActionPerformed(evt);
            }
        });

        btnluuPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnluuPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/save.png"))); // NOI18N
        btnluuPB.setText("Lưu");
        btnluuPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuPBActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mã phòng ban:");

        txtmaPB1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btntracuuPB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntracuuPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        btntracuuPB.setText("Tra cứu");
        btntracuuPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntracuuPBActionPerformed(evt);
            }
        });

        tablePB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePB);

        cbmaTrgP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbmaTrgP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btncapnhatPB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemPB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtmaPB, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttenPB, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtslNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnxoaPB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnluuPB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbmaTrgP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmaPB1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntracuuPB)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntracuuPB)
                    .addComponent(txtmaPB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmaPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttenPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtslNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbmaTrgP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemPB)
                            .addComponent(btnluuPB))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncapnhatPB)
                            .addComponent(btnxoaPB))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPBActionPerformed
        txtmaPB.setText(getmaKM());
        txttenPB.setText("");
        txtslNV.setText("0");
        txtslNV.setEnabled(false);
        loadDataToTable();
    }//GEN-LAST:event_btnThemPBActionPerformed

    private void btnxoaPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaPBActionPerformed
        StringBuilder sb =new StringBuilder();
        KiemTraDuLieu.DuLieuTrong(txtmaPB, sb, "Mã phòng ban trống!!");
        if(sb.length()>0){
            ThongBao.showLoi(parentForm, sb.toString(), "Lỗi!!");
            return;
        }
        if(ThongBao.showXacNhan(parentForm, "Bạn có muốn xóa phòng ban không?", "Hỏi")== JOptionPane.NO_OPTION){
            return;
        }
        try{
            prPhongBan kt = new prPhongBan();
            if(kt.delete(txtmaPB.getText())){
                ThongBao.showThongBao(parentForm, "Phòng ban đã được xóa", "Thông báo");
                btnThemPBActionPerformed(evt);
                loadDataToTable();
            }else{
                ThongBao.showXacNhan(parentForm, "Lỗi!! Không thể xóa.", "Cảnh báo");
            }
            txtslNV.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnxoaPBActionPerformed

    private void btncapnhatPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatPBActionPerformed
        StringBuilder sb =new StringBuilder();
        KiemTraDuLieu.DuLieuTrong(txtmaPB, sb, "Mã phòng trống!!");
        KiemTraDuLieu.DuLieuTrong(txttenPB, sb, "Tên phòng ban trống!!");
        if(sb.length()>0){
            ThongBao.showLoi(parentForm, sb.toString(), "Lỗi!!");
            return;
        }
        if(ThongBao.showXacNhan(parentForm, "Bạn có muốn cập nhật phòng ban không?", "Hỏi")== JOptionPane.NO_OPTION){
            return;
        }
        try{
            PhongBan pb =new PhongBan();
            pb.setMaPB(txtmaPB.getText());
            pb.setTenPB(txttenPB.getText());
            pb.setSoluongNV(Long.parseLong(txtslNV.getText()));
            pb.setTrgPB(cbmaTrgP.getSelectedItem().toString());
            
            prPhongBan kt = new prPhongBan();
            if(kt.update(pb)&& pb.getSoluongNV()>=0){
                ThongBao.showThongBao(parentForm, "Phòng ban đã được cập nhật", "Thông báo");
                loadDataToTable();
            }else{
                ThongBao.showXacNhan(parentForm, "Lỗi!! Không thể cập nhật.", "Cảnh báo");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btncapnhatPBActionPerformed

    private void btnluuPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuPBActionPerformed
        StringBuilder sb =new StringBuilder();
        KiemTraDuLieu.DuLieuTrong(txtmaPB, sb, "Mã phòng ban trống!!");
        KiemTraDuLieu.DuLieuTrong(txttenPB, sb, "Tên phòng ban trống!!");
        if(sb.length()>0){
            ThongBao.showLoi(parentForm, sb.toString(), "Lỗi!!");
            return;
        }
        try{
            PhongBan pb =new PhongBan();
            pb.setMaPB(txtmaPB.getText());
            pb.setTenPB(txttenPB.getText());
            pb.setSoluongNV(Long.parseLong(txtslNV.getText()));
            pb.setTrgPB(cbmaTrgP.getSelectedItem().toString());
            
            prPhongBan kt = new prPhongBan();
            if(kt.insert(pb)){
                ThongBao.showThongBao(parentForm, "Phòng ban đã được lưu", "Thông báo");
                loadDataToTable();
            }else{
                ThongBao.showXacNhan(parentForm, "Lỗi!! Không thể lưu.", "Cảnh báo");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnluuPBActionPerformed

    private void tablePBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePBMouseClicked
       try{
            int row = tablePB.getSelectedRow();
            
            if(row>=0){
                String id = (String) tablePB.getValueAt(row, 0);
                prPhongBan kt = new prPhongBan();
                PhongBan pb = kt.FindByID(id);
                
                if(pb != null){
                    txtmaPB.setText(pb.getMaPB());
                    txttenPB.setText(pb.getTenPB());
                    txtslNV.setText(String.format("%.0f", (double)pb.getSoluongNV()));
                    cbmaTrgP.setSelectedItem(pb.getTrgPB());

                }
            }
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tablePBMouseClicked

    private void btntracuuPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntracuuPBActionPerformed
        try{
            prPhongBan kt =new prPhongBan();
            PhongBan pb = kt.FindByID(txtmaPB1.getText());
            
            if(pb != null){
                txtmaPB.setText(pb.getMaPB());
                txttenPB.setText(pb.getTenPB());
                txtslNV.setText(String.format("%.0f", (double)pb.getSoluongNV()));
                cbmaTrgP.setSelectedItem(pb.getTrgPB());

            }else{
                ThongBao.showThongBao(parentForm, "Không tìm thấy mã phòng ban theo yêu cầu", "Thông báo");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            ThongBao.showLoi(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btntracuuPBActionPerformed

    private void setListNhanVien(){
        prNhanVien kt = new prNhanVien();
        HashMap<String, String> listmaNhanVien = kt.getlistmaNhanVien();
        listmaNV = new ArrayList<String>();
        listmaNV.addAll(listmaNhanVien.keySet());
        ArrayList<String> listMaNV = new ArrayList<String>();
        listMaNV.addAll(listmaNhanVien.values());
        cbmaTrgP.setModel(new DefaultComboBoxModel(listMaNV.toArray()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemPB;
    private javax.swing.JButton btncapnhatPB;
    private javax.swing.JButton btnluuPB;
    private javax.swing.JButton btntracuuPB;
    private javax.swing.JButton btnxoaPB;
    private javax.swing.JComboBox<String> cbmaTrgP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tablePB;
    private javax.swing.JTextField txtmaPB;
    private javax.swing.JTextField txtmaPB1;
    private javax.swing.JTextField txtslNV;
    private javax.swing.JTextField txttenPB;
    // End of variables declaration//GEN-END:variables
}
