/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.ShareHelper;
import dao.NhanVienDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

/**
 *
 * @author DELL
 */
public class NhanvienJFrame extends javax.swing.JFrame {
    NhanVien nv = new NhanVien();
 List<NhanVien> listEM = new ArrayList<>();
    /**
     * Creates new form NhanvienJFrame
     */
    public NhanvienJFrame() {
        initComponents();
        init();
    }
int index = 0; // vị trí của nhân viên đang hiển thị trên form 
    NhanVienDAO dao = new NhanVienDAO();

    void init() {
        setLocationRelativeTo(null);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tbquanlinv.getModel();
        model.setRowCount(0);
        try {
            String keyword = txttimkiem.getText(); 
            List<NhanVien> list = dao.select();
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getManv(),
                    nv.getMatkhau(),
                    nv.getTennv(),
                    DateHelper.toString(nv.getNgaysinh()),
                    nv.getLuong(),
                    nv.isGioitinh(),
                    nv.getSdt()};
                
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        NhanVien model = getModel();

       
            try {
                dao.insert(model);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại!");
            }
       
    }

    void update() {
        NhanVien model = getModel();

       
            try {
                dao.update(model);
                this.load();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                DialogHelper.alert(this, "Cập nhật thất bại!");
            }
        }
    

    void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
            String manv = txtmanv.getText();
            try {
                dao.delete(manv);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    void edit() {
        try {
            String manv = (String) tbquanlinv.getValueAt(this.index, 0);
            NhanVien model = dao.findById(manv);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void clear() {  
         this.setModel(new NhanVien());
        this.setStatus(true);
         NhanVien model = new NhanVien(); 
//        model.setManv(ShareHelper.USER.getManv()); 
        model.setNgaysinh(DateHelper.now()); 
        this.setModel(model);
    }

    void setModel(NhanVien model) {
        txtmanv.setText(model.getManv());
        txtmatkhau.setText(model.getMatkhau());
        txttennv.setText(model.getTennv());
         txtngaysinh.setText(DateHelper.toString(model.getNgaysinh()));
       txtluong.setText(String.valueOf(model.getLuong())); 
      cbogioitinh.setSelectedIndex(model.isGioitinh()?0:1); 
       txtsdt.setText(model.getSdt());
    }

    NhanVien getModel() {
        NhanVien model = new NhanVien();
        model.setManv(txtmanv.getText());
        model.setMatkhau(txtmatkhau.getText());
        model.setTennv(txttennv.getText());
        model.setNgaysinh(DateHelper.toDate(txtngaysinh.getText()));
        model.setLuong(Float.valueOf(txtluong.getText())); 
        model.setGioitinh(cbogioitinh.getSelectedIndex() == 0); 
        model.setSdt(txtsdt.getText());
        
        return model;
    }

    void setStatus(boolean insertable) {
        txtmanv.setEditable(insertable);
        btnthem.setEnabled(insertable); 
        btnsua.setEnabled(!insertable);
        btnxoa.setEnabled(!insertable);

        boolean first = this.index > 0;
        boolean last = this.index < tbquanlinv.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnNext.setEnabled(!insertable && last);
        btnLast.setEnabled(!insertable && last);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmatkhau = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbogioitinh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnmoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbquanlinv = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabs.setForeground(new java.awt.Color(0, 102, 102));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel2.setLayout(null);

        jLabel1.setText("Mã Nhân Viên:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(70, 40, 100, 14);
        jPanel2.add(txtmanv);
        txtmanv.setBounds(182, 31, 182, 29);

        jLabel2.setText("Mật Khẩu");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 80, 90, 14);
        jPanel2.add(txtmatkhau);
        txtmatkhau.setBounds(182, 78, 182, 25);

        jLabel3.setText("Tên nhân viên :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 130, 100, 14);
        jPanel2.add(txttennv);
        txttennv.setBounds(182, 121, 182, 25);
        jPanel2.add(txtngaysinh);
        txtngaysinh.setBounds(180, 160, 182, 30);

        jLabel4.setText("Lương:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 210, 70, 14);

        jLabel5.setText("Ngày Sinh :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 170, 70, 14);
        jPanel2.add(txtluong);
        txtluong.setBounds(180, 200, 182, 25);

        jLabel6.setText("Giới Tính:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 250, 70, 14);

        cbogioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));
        jPanel2.add(cbogioitinh);
        cbogioitinh.setBounds(180, 240, 182, 26);

        jLabel7.setText("Số ĐT:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(70, 290, 70, 14);
        jPanel2.add(txtsdt);
        txtsdt.setBounds(180, 280, 182, 29);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Book.png"))); // NOI18N
        btnthem.setText("Thêm sp");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit.png"))); // NOI18N
        btnsua.setText("Sửa sp");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnxoa.setText("Xóa sp");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnmoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        btnmoi.setText("Làm mới");
        btnmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnsua)
                .addGap(33, 33, 33)
                .addComponent(btnxoa)
                .addGap(37, 37, 37)
                .addComponent(btnmoi)
                .addGap(19, 19, 19))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(439, 14, 127, 290);

        btnFirst.setText("|<");
        jPanel2.add(btnFirst);
        btnFirst.setBounds(120, 340, 45, 23);

        btnPrev.setText("<<");
        jPanel2.add(btnPrev);
        btnPrev.setBounds(220, 340, 49, 23);

        btnNext.setText(">>");
        jPanel2.add(btnNext);
        btnNext.setBounds(320, 340, 49, 23);

        btnLast.setText(">|");
        jPanel2.add(btnLast);
        btnLast.setBounds(420, 340, 45, 23);

        tabs.addTab("Nhân Viên", jPanel2);

        tbquanlinv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Ngày sinh", "Lương", "Giới tính", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbquanlinv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbquanlinvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbquanlinv);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        btntimkiem.setBackground(new java.awt.Color(255, 255, 255));
        btntimkiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm ");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btntimkiem)
                .addGap(69, 69, 69))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btntimkiem)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách nhân viên", jPanel1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoiActionPerformed
        // TODO add your handling code here:
        txtluong.setText("");
        txtmanv.setText("");
        txtmatkhau.setText("");
        txtngaysinh.setText("");
        txtsdt.setText("");
        txtsdt.setText("");
        txttennv.setText("");
    }//GEN-LAST:event_btnmoiActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         this.load();
        this.setStatus(true);
    }//GEN-LAST:event_formWindowOpened

    private void tbquanlinvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbquanlinvMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tbquanlinv.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tbquanlinvMouseClicked

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        this.load();
        this.clear();
    }//GEN-LAST:event_btntimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(NhanvienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanvienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanvienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanvienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanvienJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnmoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbogioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbquanlinv;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
