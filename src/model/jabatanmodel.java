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
    String sql = "INSERT INTO karyawan (idkaryawan, namakaryawan, kodejabatan) VALUES (?, ?, ?)";   
    //String sql = "insert into jabatan values ('" + kodejabatan + "','" + namajabatan + "','" + gajijabatan + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
   }
}