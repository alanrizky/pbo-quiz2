/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.quiz2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ALAN
 */
public class Barang {
    //hashMap
    private HashMap<String, Float> items = new HashMap<>();
    
    //konstruktor

    public Barang() {
        this.items.put("Gula", new Float(20000));
        this.items.put("Kopi", new Float(5000));
        this.items.put("Susu", new Float(15000));
    }

    public ArrayList<String> getJenisNama() {
        ArrayList<String> s = new ArrayList<>();
        for (String item : this.items.keySet()) {
            s.add(item);
        }
        return s;
    }
    
    public ArrayList<Float> getHargaBarang() {
        ArrayList<Float> f = new ArrayList<>();
        for (float item : this.items.values()) {
            f.add(item);
        }
        return f;
    }
    
    public void addItem(String nama, float harga) {
        this.items.put(nama, harga);
    }
}
