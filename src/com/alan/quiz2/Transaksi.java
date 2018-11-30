/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.quiz2;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ALAN
 */
public class Transaksi {
    //simpan nama kolom
    private String[] kolom;

    //konstruktor dengan array nama kolom
    public Transaksi() {
        this.kolom = new String[] {
            "Nama", "Harga", "Jumlah"
        };
    }
    //get kolomNama
    public String[] getKolomNama() {
        return this.kolom;
    }
}
