/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crud;

import com.mysql.cj.protocol.Resultset;
import crud.Koneksi;
//import java.beans.Statement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author dimas
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    
    String nimu = "";
    
    public View() {
        initComponents();
        table();
    }
    
    void cari(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nim");
        tbl.addColumn("Nama");
        tbl.addColumn("Jurusan");
        tbl.addColumn("Jenis Kelamin");
        
        try {
            Statement stmt = (Statement) Koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM tb_mahasiswa WHERE nim LIKE '%" + tCari.getText() + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow(new Object[] {
                    rs.getString("Nim"),
                    rs.getString("Nama"),
                    rs.getString("Jurusan"),
                    rs.getString("Jenis_Kelamin")
                });
                jTable1.setModel(tbl);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    void hapus(){
        tNim.setText("");
        tNama.setText("");
        tJurusan.setSelectedIndex(0);
        rLaki.setSelected(false);
        rPerempuan.setSelected(false);
    }

    public void table() {
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nim");
        tbl.addColumn("Nama");
        tbl.addColumn("Jurusan");
        tbl.addColumn("Jenis Kelamin");
        
        //Koneksi() kn = new Koneksi();
        try {
            Statement stmt = (Statement) Koneksi.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_mahasiswa");
            
            while(rs.next()){
              tbl.addRow(new Object[] {
                  rs.getString("Nim"),
                  rs.getString("Nama"),
                  rs.getString("Jurusan"),
                  rs.getString("Jenis_Kelamin")
              });
              jTable1.setModel(tbl);
            }
            JOptionPane.showMessageDialog(null, "koneksi database berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi database gagal" + e.getMessage());
        }
        
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tNim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tJurusan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rLaki = new javax.swing.JRadioButton();
        rPerempuan = new javax.swing.JRadioButton();
        tEdit = new javax.swing.JButton();
        tHapus = new javax.swing.JButton();
        tSimpan = new javax.swing.JButton();
        bCari = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA MAHASISWA");

        tNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNimActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nim :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nama :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Jurusan :");

        tJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Teknologi Informasi", "Psikologi", "Hukum", "Pariwisata", "Perbankan", "Ilmu Sosial dan Politik", "Ekonomi dan Bisnis", "Pascasarjana" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Jenis Kelamin :");

        rLaki.setText("Laki - Laki");
        rLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLakiActionPerformed(evt);
            }
        });

        rPerempuan.setText("Perempuan");
        rPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPerempuanActionPerformed(evt);
            }
        });

        tEdit.setBackground(new java.awt.Color(0, 102, 102));
        tEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tEdit.setForeground(new java.awt.Color(255, 255, 255));
        tEdit.setText("Edit");
        tEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEditActionPerformed(evt);
            }
        });

        tHapus.setBackground(new java.awt.Color(0, 102, 102));
        tHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tHapus.setForeground(new java.awt.Color(255, 255, 255));
        tHapus.setText("Hapus");
        tHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHapusActionPerformed(evt);
            }
        });

        tSimpan.setBackground(new java.awt.Color(0, 102, 102));
        tSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tSimpan.setForeground(new java.awt.Color(255, 255, 255));
        tSimpan.setText("Simpan");
        tSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSimpanMouseClicked(evt);
            }
        });

        bCari.setBackground(new java.awt.Color(0, 102, 102));
        bCari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bCari.setForeground(new java.awt.Color(255, 255, 255));
        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(208, 208, 208))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tSimpan)
                    .addComponent(bCari))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(tEdit)
                        .addGap(27, 27, 27)
                        .addComponent(tHapus)))
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNim)
                            .addComponent(tNama)
                            .addComponent(tJurusan, 0, 284, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rLaki)
                                .addGap(30, 30, 30)
                                .addComponent(rPerempuan)))))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rLaki)
                    .addComponent(rPerempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tEdit)
                    .addComponent(tHapus)
                    .addComponent(tSimpan))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCari)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNimActionPerformed

    private void tSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSimpanMouseClicked
        // TODO add your handling code here:
        try {
            String jk = null;
            if (rLaki.isSelected()){
                jk = "Laki - Laki";
            }            
            if (rPerempuan.isSelected()){
                jk = "Perempuan";
            }            
            
            String sql = "INSERT INTO `tb_mahasiswa` (`nim`, `nama`, `jurusan`, `jenis_kelamin`) VALUES ('"+tNim.getText()+"', '"+tNama.getText()+"', '"+tJurusan.getSelectedItem()+"', '"+jk+"')";
            Connection con = (Connection) Koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            table();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e.getMessage());
        }
    }//GEN-LAST:event_tSimpanMouseClicked

    private void tHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_tHapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nim = jTable1.getValueAt(baris, 0).toString();
        nimu = nim;
        tNim.setText(nim);
        String nama = jTable1.getValueAt(baris, 1).toString();
        tNama.setText(nama);
        String jurusan = jTable1.getValueAt(baris, 2).toString();
        int size = tJurusan.getItemCount();
        for (int i = 0; i < size; i++) {
          String item = tJurusan.getItemAt(i);
          if (jurusan.equals(item)) {
              tJurusan.setSelectedIndex(i);
          }
        }
        String jenis = jTable1.getValueAt(baris, 3).toString();
        if (jenis.equals("Laki - Laki")){
            rLaki.setSelected(true);
            rPerempuan.setSelected(false);
        }
        if (jenis.equals("Perempuan")){
            rPerempuan.setSelected(true);
            rLaki.setSelected(false);
        }
        
//        tJurusan.setSelectedItem(ABORT);
    }//GEN-LAST:event_jTable1MouseClicked

    private void rPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPerempuanActionPerformed
        // TODO add your handling code here:
        rLaki.setSelected(false);
    }//GEN-LAST:event_rPerempuanActionPerformed

    private void rLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLakiActionPerformed
        // TODO add your handling code here:
        rPerempuan.setSelected(false);
    }//GEN-LAST:event_rLakiActionPerformed

    private void tEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEditActionPerformed
        // TODO add your handling code here:
        try {
            String jk = null;
            if (rLaki.isSelected()){
                jk = "Laki - Laki";
            }            
            if (rPerempuan.isSelected()){
                jk = "Perempuan";
            }            
            
            String sql = "UPDATE `tb_mahasiswa` SET `nim` = '"+tNim.getText()+"', `nama` = '"+tNama.getText()+"', `jurusan` = '"+tJurusan.getSelectedItem().toString()+"', `jenis_kelamin` = '"+jk+"' WHERE `tb_mahasiswa`.`nim` = '"+nimu+"'";
            Connection con = (Connection) Koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            table();
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mengubah" + e.getMessage());
        }
    }//GEN-LAST:event_tEditActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_bCariActionPerformed

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCariActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rLaki;
    private javax.swing.JRadioButton rPerempuan;
    private javax.swing.JTextField tCari;
    private javax.swing.JButton tEdit;
    private javax.swing.JButton tHapus;
    private javax.swing.JComboBox<String> tJurusan;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNim;
    private javax.swing.JButton tSimpan;
    // End of variables declaration//GEN-END:variables
}
