/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.quiz2;

/**
 *
 * @author ALAN
 */
public class Item {
    //nama barang
    private String nama;
    //harga barang
    private float harga;
    //jumlah barang
    private int jumlah;

    //konstruktor
    public Item() {
    }

    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    //setter dan getter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    //hasil perkalian harga dan jumlah
    public float getTotal() {
        return this.harga * this.jumlah;
    }
    
    //toString
    @Override
    public String toString() {
        return this.nama;
    }
}
