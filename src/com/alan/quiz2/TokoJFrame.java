/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.quiz2;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.alan.quiz2.Transaksi;
import javax.swing.JOptionPane;
import com.alan.quiz2.Item;
/**
 *
 * @author ALAN
 */
public class TokoJFrame extends javax.swing.JFrame {
    //id transaksi
    private int id = 0;
    //kode transaksi
    private String code;
    //table model
    private DefaultTableModel modelT;
    //combobox model
    private DefaultComboBoxModel modelC;
    //pembelanjaan transaksi item
    private ArrayList<Item> i = new ArrayList<>();
    //constructor
    public TokoJFrame() {
        Barang b = new Barang();
        this.modelC = new DefaultComboBoxModel<>(b.getJenisNama().toArray());
        
        TabelTransaksi tModel = new TabelTransaksi();
        this.modelT = new DefaultTableModel(tModel.getKolomNama(), 0);
        initComponents();
    }
    
    private void increment() {
        this.id += 1;
    }
    
    private void decrement() {
        this.id -= 1;
    }
    
    private Object[] addItem(String nama, int jumlah) {
        float harga = 0;
        Barang item = new Barang();
        for (int i = 0; i < item.getHargaBarang().size(); i++) {
            if (nama.equalsIgnoreCase(item.getJenisNama().get(i))) {
                harga = item.getHargaBarang().get(i);
            }
        }
        Object[] o = {
            nama,
            harga,
            jumlah
        };
        return o;
    }
    
    private String setCode() {
        this.increment();
        //tanggal
        String sk = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code = String.format(sk + "%02d", this.id);
        return code;
    }
    
    //update fungsi jumlah
    private void updateJumlah(String nama, int add) {
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < modelT.getRowCount(); i++) {
            item.add(modelT.getValueAt(i, 0).toString());
        }
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).equals(nama)) {
                int jumlah = new Integer(modelT.getValueAt(i, 2).toString());
                modelT.setValueAt(jumlah + add, i, 2);
            }
        }
    }
    
    private boolean duplikat(String nama) {
        boolean rs = false;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < modelT.getRowCount(); i++) {
            item.add(modelT.getValueAt(i, 0).toString());
        }
        for (String i : item) {
            if (i.equals(nama)) {
                rs = true;
            }
        }
        return rs;
    }
    
    
    private void belanja() {
        if (isEmpty()) {
            this.btnSave.setEnabled(false);
            this.btnRemove.setEnabled(false);
        }
        else {
            this.btnSave.setEnabled(true);
            this.btnRemove.setEnabled(true);
        }
    }
    
    private boolean isEmpty() {
        return this.table.getModel().getRowCount() <= 0;
    }
    
    private void newTransaksi() {
        this.txtJumlahItem.setText("");
        this.txtCode.setText("");
        this.btnNew.setEnabled(true);
        this.btnSave.setEnabled(false);
        this.btnCancel.setEnabled(false);
        this.btnAdd.setEnabled(false);
        this.btnRemove.setEnabled(false);
        this.btnRemove.setEnabled(false);
        this.txtJumlahItem.setEnabled(false);
        this.comboItem.setEnabled(false);
        this.modelT.setRowCount(0);
        this.i.clear();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lableCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        labelItem = new javax.swing.JLabel();
        comboItem = new javax.swing.JComboBox<>();
        txtJumlahItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lableCode.setText("Code");

        txtCode.setEnabled(false);

        labelItem.setText("Items");

        comboItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Susu", "Kopi", "Gula" }));
        comboItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboItemActionPerformed(evt);
            }
        });

        txtJumlahItem.setText("1");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Harga", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(table);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lableCode)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtJumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancel))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lableCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelItem)
                    .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.txtJumlahItem.setText("1");
        this.btnNew.setEnabled(false);
        this.btnCancel.setEnabled(true);
        this.btnAdd.setEnabled(true);
        this.txtJumlahItem.setEnabled(true);
        this.comboItem.setEnabled(true);
        this.txtCode.setText(this.setCode());
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void comboItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboItemActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        newTransaksi();
        this.decrement();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String nama = this.comboItem.getSelectedItem().toString();
        int jumlah = new Integer(this.txtJumlahItem.getText());
        if (duplikat(nama)) {
            updateJumlah(nama, jumlah);
        }
        else {
            modelT.addRow(addItem(nama, jumlah));
        }
        this.belanja();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            for (int i = 0; i < modelT.getRowCount(); i++) {
                String nama = modelT.getValueAt(i, 0).toString();
                float harga = new Float(modelT.getValueAt(i, 1).toString());
                int jumlah = new Integer(modelT.getValueAt(i, 2).toString());
                this.i.add(new Item(nama, harga, jumlah));
            }
            Transaksi t = new Transaksi(this.code, this.i);
            StringBuilder sb = new StringBuilder();
            sb.append(t.pembayaran());
            JOptionPane.showMessageDialog(this, sb, "Log", JOptionPane.INFORMATION_MESSAGE);
            newTransaksi();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        //mengecek apakah ada baris yang di klik
        if (table.getSelectedRow() < 0) {
            String s = "Pilih item yang akan di hapus";
            JOptionPane.showMessageDialog(this, s, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            //ada baris yang dipilih
            int count = table.getSelectedRows().length;
            for (int i = 0; i < count; i++) {
                modelT.removeRow(table.getSelectedRow());
            }
        }
        this.belanja();
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(TokoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TokoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TokoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TokoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TokoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel lableCode;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtJumlahItem;
    // End of variables declaration//GEN-END:variables
}
