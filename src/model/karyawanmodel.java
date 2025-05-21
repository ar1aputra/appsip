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


public class karyawanmodel {
    String idkaryawan, namakaryawan, alamatkaryawan, namajabatan, kodejabatan, gajijabatan; 

    public String getIdkaryawan() {
        return idkaryawan;
    }

    public void setIdkaryawan(String idkaryawan) {
        this.idkaryawan = idkaryawan;
    }

    public String getNamakaryawan() {
        return namakaryawan;
    }

    public void setNamakaryawan(String namakaryawan) {
        this.namakaryawan = namakaryawan;
    }
    
    public String getAlamatkaryawan() {
        return alamatkaryawan;
    }

    public void setAlamatkaryawan(String alamatkaryawan) {
        this.alamatkaryawan = alamatkaryawan;
    }
    
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
    public karyawanmodel() {
        db = new koneksi ();                
    }
            
    public koneksi getDb () {
        return db;
    }
    
    public void setDb (koneksi db) {
        this.db =db;
    }
    
   public List tampil() {
        List<karyawanmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "SELECT k.idkaryawan, k.namakaryawan, k.alamatkaryawan, " +
                     "j.kodejabatan, j.namajabatan, j.gajijabatan " +
                     "FROM karyawan k " +
                     "JOIN jabatan j ON k.kodejabatan = j.kodejabatan";

        hasil = db.ambilData(sql);
            hasil = db.ambilData(sql);
            while(hasil.next() ) {
                karyawanmodel km = new karyawanmodel();
                km.setIdkaryawan(hasil.getString("idkaryawan"));
            km.setNamakaryawan(hasil.getString("namakaryawan"));
            km.setAlamatkaryawan(hasil.getString("alamatkaryawan"));
            km.setNamajabatan(hasil.getString("namajabatan"));
            km.setGajijabatan(hasil.getString("gajijabatan")); // bisa diformat ke Rupiah seperti sebelumnya
            data.add(km);
            }
            db.tutupKoneksi (hasil);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salah tampil" +e);
    }
     return data;    
   }

public void tambah() {
    String sql = "insert into karyawan values (null,'" + namakaryawan + "','" + namajabatan + "','" + alamatkaryawan + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
}

public void hapus () {
    String sql = "delete from karyawan where idkaryawan = '"+idkaryawan+"' ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
    }

//edit data
public void edit() {
    String sql = "UPDATE karyawan SET namakaryawan = '" + namakaryawan+ 
            "', alamatkaryawan = '" + alamatkaryawan + "' WHERE idkaryawan = '" + idkaryawan + "'";
            db.simpanData(sql);
            db.tutupKoneksi(null);
        }


//untuk pencarian daata
public List caridata(String cari) {
    List<karyawanmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "select * from karyawan where idkaryawan like "
                + "'%" +cari+ "%'  or namakaryawan like '%"+cari+"%' or alamatkaryawan like '%"+cari+"%' or divisibagian like '%"+cari+"%'";
        hasil = db.ambilData(sql);
        while (hasil.next()){
        karyawanmodel km = new karyawanmodel();
        km.setIdkaryawan(hasil.getString("idkaryawan"));
        km.setNamakaryawan(hasil.getString("namakaryawan"));
        km.setAlamatkaryawan(hasil.getString("alamatkaryawan"));
        data.add(km);
        }
        db.tutupKoneksi(hasil);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Salah cari data" +e);
    }
    return data;
 } 
}