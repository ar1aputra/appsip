/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class produkmodel {  
    String kodeproduk, namaproduk, hargaproduk;

    public String getKodeproduk() {
        return kodeproduk;
    }

    public void setKodeproduk(String kodeproduk) {
        this.kodeproduk = kodeproduk;
    }
    
    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }
    
    public String getHargaproduk() {
        return hargaproduk;
    }

    public void setHargaproduk(String hargaproduk) {
        this.hargaproduk = hargaproduk;
    }
    
    koneksi db = null;
    public produkmodel() {
        db = new koneksi ();                
    }
            
    public koneksi getDb () {
        return db;
    }
    
    public void setDb (koneksi db) {
        this.db =db;
    }
    
    public void simpan() {
    String sql = "INSERT INTO produk (kodeproduk, namaproduk, hargaproduk) VALUES (?, ?, ?)";   
    //String sql = "insert into jabatan values ('" + kodejabatan + "','" + namajabatan + "','" + gajijabatan + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
   }
    
    
    public List caridata(String cari) {
    List<produkmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "select * from produk where kodeproduk like "
                + "'%" +cari+ "%'  or namaproduk like '%"+cari+"%' or hargaproduk like '%"+cari+"%'";
        hasil = db.ambilData(sql);
        while (hasil.next()){
        produkmodel km = new produkmodel();
        km.setKodeproduk(hasil.getString("kodeproduk"));
        km.setNamaproduk(hasil.getString("namaproduk"));
        km.setHargaproduk(hasil.getString("hargaproduk"));
        data.add(km);
        }
        db.tutupKoneksi(hasil);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Salah cari data" +e);
    }
    return data;
 }
    public List tampil() {
       List<produkmodel> data = new ArrayList<>();
       ResultSet hasil = null;
       try {
            String sql = "select * from produk";
            hasil = db.ambilData(sql);
            while(hasil.next() ) {
                produkmodel km = new produkmodel();
                km.setKodeproduk(hasil.getString("kodeproduk"));
                km.setNamaproduk(hasil.getString("namaproduk"));
                km.setHargaproduk(hasil.getString("hargaproduk"));
                data.add(km);
            }
            db.tutupKoneksi (hasil);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salah tampil" +e);
    }
     return data;    
   }
    
}
