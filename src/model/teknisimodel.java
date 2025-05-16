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
public class teknisimodel {
     String idteknisi, namateknisi, alamatteknisi, divisibagian;

    public String getIdteknisi() {
        return idteknisi;
    }

    public void setIdteknisi(String idteknisi) {
        this.idteknisi = idteknisi;
    }

    public String getNamateknisi() {
        return namateknisi;
    }

    public void setNamateknisi(String namateknisi) {
        this.namateknisi = namateknisi;
    }
    
    public String getAlamatteknisi() {
        return alamatteknisi;
    }

    public void setAlamatteknisi(String alamatteknisi) {
        this.alamatteknisi = alamatteknisi;
    }
    
    public String getDivisibagian() {
        return divisibagian;
    }

    public void setDivisibagian(String divisibagian) {
        this.divisibagian = divisibagian;
    }
       
    
    koneksi db = null;
    public teknisimodel() {
        db = new koneksi ();                
    }
            
    public koneksi getDb () {
        return db;
    }
    
    public void setDb (koneksi db) {
        this.db =db;
    }
    
   public List tampil() {
       List<teknisimodel> data = new ArrayList<>();
       ResultSet hasil = null;
       try {
            String sql = "select * from teknisi";
            hasil = db.ambilData(sql);
            while(hasil.next() ) {
                teknisimodel km = new teknisimodel();
                km.setIdteknisi(hasil.getString("idteknisi"));
                km.setNamateknisi(hasil.getString("namateknisi"));
                km.setAlamatteknisi(hasil.getString("alamatteknisi"));
                km.setDivisibagian(hasil.getString("divisibagian"));
                data.add(km);
            }
            db.tutupKoneksi (hasil);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salah tampil" +e);
    }
     return data;    
   }

public void tambah() {
    String sql = "insert into teknisi values (null,'" + namateknisi + "','" + alamatteknisi + "', '" + divisibagian + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
}

public void hapus () {
    String sql = "delete from teknisi where idteknisi = '"+idteknisi+"' ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
    }

//edit data
public void edit() {
    String sql = "UPDATE teknisi SET namateknisi = '" + namateknisi+ 
            "', alamatteknisi = '" + alamatteknisi + "',divisibagian = '" + divisibagian + "' WHERE idteknisi = '" + idteknisi + "'";
            db.simpanData(sql);
            db.tutupKoneksi(null);
        }


//untuk pencarian daata
public List caridata(String cari) {
    List<teknisimodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "select * from teknisi where idteknisi like "
                + "'%" +cari+ "%'  or namateknisi like '%"+cari+"%' or alamatteknisi like '%"+cari+"%' or divisibagian like '%"+cari+"%'";
        hasil = db.ambilData(sql);
        while (hasil.next()){
        teknisimodel km = new teknisimodel();
        km.setIdteknisi(hasil.getString("idteknisi"));
        km.setNamateknisi(hasil.getString("namateknisi"));
        km.setAlamatteknisi(hasil.getString("alamatteknisi"));
        km.setDivisibagian(hasil.getString("divisibagian"));
        data.add(km);
        }
        db.tutupKoneksi(hasil);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Salah cari data" +e);
    }
    return data;
 } 
}