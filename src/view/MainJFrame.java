/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Helper.DialogHelper;
import Helper.ShareHelper;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Timer;


/**
 *
 * @author DELL
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        new ChaoJDialog(this, true).setVisible(true);
        initComponents();
     init();
        day();
     setLocationRelativeTo(null);
    }

    void init(){
         new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date now = new Date();
                SimpleDateFormat formats = new SimpleDateFormat();
                formats.applyPattern("hh:mm:s aa");
                lbltime.setText(formats.format(now));
            }   
                }).start();
          this.openLogin();
        this.mnudangnhap.setEnabled(false);
                 } 
    public void day() {
    Thread clock = new Thread() {
        public void run() {
            try {
                while (true) {
                    Calendar cal = new GregorianCalendar();                   
                    String thu;
                    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                    if (dayOfWeek == 1) {
                        thu = "Chủ nhật";
                    } else {
                        thu = "Thứ" + Integer.toString(dayOfWeek);
                    }
                    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    lblthu.setText(thu + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
                    lblthu.setText("thứ" + dayOfWeek + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
                    sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    clock.start();
}
 void openLogin(){
 new loginJDialog(this, true).setVisible(true);
 }
 void openWelcome(){
 new ChaoJDialog(this, true).setVisible(true);
 }
  void logoff(){
     ShareHelper.logoff();
 this.openLogin();
 }
 void exit(){
 if(DialogHelper.confirm(this, "Bạn thực sự muốn kết thúc?")){
 System.exit(0);
 }
 }
 void openNhanVien(){
 if(ShareHelper.authenticated()){
 new NhanvienJFrame().setVisible(true);
 }
 else{
 DialogHelper.alert(this, "Vui lòng đăng nhập!");
 }
 }
 void openKhoaHoc(){
 if(ShareHelper.authenticated()){
 new SanphamJFrame().setVisible(true);
 }
 else{
 DialogHelper.alert(this, "Vui lòng đăng nhập!");
 }
 }
 void openChuyenDe(){
 if(ShareHelper.authenticated()){
 new KhachhangJFrame().setVisible(true);
 }
 else{
 DialogHelper.alert(this, "Vui lòng đăng nhập!");
 }
 }
// void openAbout(){
// new GioiThieuJDialog(this, true).setVisible(true);
// }
// void openWebsite(){
// try {
//     Desktop.getDesktop().browse(new File("help/index.html").toURI());
// }
// catch (IOException ex) {
// DialogHelper.alert(this, "Không tìm thấy file hướng dẫn!");
// }
// }
                 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblthu = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btndangxuat = new javax.swing.JButton();
        btnquanli = new javax.swing.JButton();
        btndoanhthu = new javax.swing.JButton();
        btnketthuc = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnudangnhap = new javax.swing.JMenuItem();
        mnudangxuat = new javax.swing.JMenuItem();
        mnuketthuc = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuquanlinv = new javax.swing.JMenuItem();
        mnuquanlikh = new javax.swing.JMenuItem();
        mnuquanlisp = new javax.swing.JMenuItem();
        mnuquanlidoanhthu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/topmen.jpg"))); // NOI18N

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltime.setForeground(new java.awt.Color(0, 102, 51));
        lbltime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alarm.png"))); // NOI18N

        lblthu.setForeground(new java.awt.Color(51, 51, 255));

        jToolBar1.setRollover(true);

        btndangxuat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btndangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Closed door.png"))); // NOI18N
        btndangxuat.setText("Đăng xuất");
        btndangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangxuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btndangxuat);

        btnquanli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnquanli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Conference.png"))); // NOI18N
        btnquanli.setText("Quản lý nhân viên");
        btnquanli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquanliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnquanli);

        btndoanhthu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btndoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dollar.png"))); // NOI18N
        btndoanhthu.setText("Doanh thu");
        jToolBar1.add(btndoanhthu);

        btnketthuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anchor.png"))); // NOI18N
        btnketthuc.setText("Kết thúc");
        btnketthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketthucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnketthuc);

        jMenu1.setText("Hệ Thống");

        mnudangnhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnudangnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Happy.png"))); // NOI18N
        mnudangnhap.setText("Đăng nhập");
        jMenu1.add(mnudangnhap);

        mnudangxuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnudangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit.png"))); // NOI18N
        mnudangxuat.setText("Đăng xuất");
        jMenu1.add(mnudangxuat);

        mnuketthuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnuketthuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        mnuketthuc.setText("Kết thúc chương trình");
        jMenu1.add(mnuketthuc);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý");

        mnuquanlinv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Boy.png"))); // NOI18N
        mnuquanlinv.setText("Quản lý nhân viên");
        mnuquanlinv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuquanlinvActionPerformed(evt);
            }
        });
        jMenu2.add(mnuquanlinv);

        mnuquanlikh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clien list.png"))); // NOI18N
        mnuquanlikh.setText("Quản lý khách hàng");
        mnuquanlikh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuquanlikhActionPerformed(evt);
            }
        });
        jMenu2.add(mnuquanlikh);

        mnuquanlisp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gift.png"))); // NOI18N
        mnuquanlisp.setText("Quản Lý sản phẩm");
        mnuquanlisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuquanlispActionPerformed(evt);
            }
        });
        jMenu2.add(mnuquanlisp);

        mnuquanlidoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dollar.png"))); // NOI18N
        mnuquanlidoanhthu.setText("Quản lý doanh thu");
        jMenu2.add(mnuquanlidoanhthu);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Thống kê");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Trợ giúp");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblthu, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltime)
                    .addComponent(lblthu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuquanlikhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuquanlikhActionPerformed
       new KhachhangJFrame().setVisible(true);
    }//GEN-LAST:event_mnuquanlikhActionPerformed

    private void btnketthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketthucActionPerformed
        // TODO add your handling code here:
        this.exit();
    }//GEN-LAST:event_btnketthucActionPerformed

    private void btndangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangxuatActionPerformed
        // TODO add your handling code here:
        this.openLogin();
    }//GEN-LAST:event_btndangxuatActionPerformed

    private void mnuquanlinvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuquanlinvActionPerformed
        // TODO add your handling code here:
        new NhanvienJFrame().setVisible(true);
    }//GEN-LAST:event_mnuquanlinvActionPerformed

    private void mnuquanlispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuquanlispActionPerformed
        // TODO add your handling code here:
        new SanphamJFrame().setVisible(true);
    }//GEN-LAST:event_mnuquanlispActionPerformed

    private void btnquanliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquanliActionPerformed
        // TODO add your handling code here:
         new NhanvienJFrame().setVisible(true);
    }//GEN-LAST:event_btnquanliActionPerformed
         
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndangxuat;
    private javax.swing.JButton btndoanhthu;
    private javax.swing.JButton btnketthuc;
    private javax.swing.JButton btnquanli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblthu;
    private javax.swing.JLabel lbltime;
    private javax.swing.JMenuItem mnudangnhap;
    private javax.swing.JMenuItem mnudangxuat;
    private javax.swing.JMenuItem mnuketthuc;
    private javax.swing.JMenuItem mnuquanlidoanhthu;
    private javax.swing.JMenuItem mnuquanlikh;
    private javax.swing.JMenuItem mnuquanlinv;
    private javax.swing.JMenuItem mnuquanlisp;
    // End of variables declaration//GEN-END:variables
}
