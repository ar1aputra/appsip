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
 * @author Aria
 */
public class jabatanmodel {
    String kodejabatan, namajabatan, gajijabatan;

    public String getKodejabatan() {
        return kodejabatan;
    }

    public void setKodejabatan(String kodejabatan) {
        this.kodejabatan = kodejabatan;
    }
    
    public String getNamajabatan() {
        return namajabatan;
    }

    public void setNamajabatan(String namajabatan) {
        this.namajabatan = namajabatan;
    }
    
    public String getGajijabatan() {
        return gajijabatan;
    }

    public void setGajijabatan(String gajijabatan) {
        this.gajijabatan = gajijabatan;
    }
    
    koneksi db = null;
    public jabatanmodel() {
        db = new koneksi ();                
    }
            
    public koneksi getDb () {
        return db;
    }
    
    public void setDb (koneksi db) {
        this.db =db;
    }
    
    public void simpan() {
    String sql = "INSERT INTO jabatan (kodejabatan, namajabatan, gajijabatan) VALUES (?, ?, ?)";   
    //String sql = "insert into jabatan values ('" + kodejabatan + "','" + namajabatan + "','" + gajijabatan + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
   }
    
    public List caridata(String cari) {
    List<jabatanmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "select * from jabatan where kodejabatan like "
                + "'%" +cari+ "%'  or namajabatan like '%"+cari+"%' or gajijabatan like '%"+cari+"%'";
        hasil = db.ambilData(sql);
        while (hasil.next()){
        jabatanmodel km = new jabatanmodel();
        km.setKodejabatan(hasil.getString("kodejabatan"));
        km.setNamajabatan(hasil.getString("namajabatan"));
        km.setGajijabatan(hasil.getString("gajijabatan"));
        data.add(km);
        }
        db.tutupKoneksi(hasil);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Salah cari data" +e);
    }
    return data;
 }
    public List tampil() {
       List<jabatanmodel> data = new ArrayList<>();
       ResultSet hasil = null;
       try {
            String sql = "select * from jabatan";
            hasil = db.ambilData(sql);
            while(hasil.next() ) {
                jabatanmodel km = new jabatanmodel();
                km.setKodejabatan(hasil.getString("kodejabatan"));
                km.setNamajabatan(hasil.getString("namajabatan"));
                km.setGajijabatan(hasil.getString("gajijabatan"));
                data.add(km);
            }
            db.tutupKoneksi (hasil);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salah tampil" +e);
    }
     return data;    
   }
}