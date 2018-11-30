/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.quiz2;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ALAN
 */
public class Transaksi {
    //kode pembayaran
    private final String code;
    //menampilkan yang dibeli
    private ArrayList<Item> i = new ArrayList();
    //untuk total pembayaran
    private float total = 0;

    //konstruktor
    public Transaksi(String code) {
        this.code = null;
    }

    public Transaksi(String code, ArrayList<Item> i) {
        this.code = code;
        this.i = i;
    }
    //total setter
    public void setTotal() {
        for (Item item : this.i) {
            total += item.getTotal();
        }
        this.total = total;
    }
    //output Transaksi
    public String pembayaran() {
        setTotal();
        String obj = "";
        obj += "Kode\t\t : " + this.code + "\n";
        obj += "Daftar Belanja : \n";
        for (Item item : this.ii) {
            obj += "\t" + item.getNama() + "(" + item.getJumlah() + ") : " + item.getTotal() + "\n";
        }
        obj += "Total\t\t : " + this.total;
        return obj;
    }
}
