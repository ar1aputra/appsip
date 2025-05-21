/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Aria
 */
public class pelangganmodel {
    String idpelanggan, namapelanggan, alamatpelanggan, kodeproduk, namaproduk, hargaproduk;

    public String getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(String idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getNamapelanggan() {
        return namapelanggan;
    }

    public void setNamapelanggan(String namapelanggan) {
        this.namapelanggan = namapelanggan;
    }
    
    public String getAlamatpelanggan() {
        return alamatpelanggan;
    }    
    
    public void setAlamatpelanggan(String alamatpelanggan) {
        this.alamatpelanggan = alamatpelanggan;
    }
    
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
    
    public String getHargaroduk() {
        return hargaproduk;
    }    
    
    public void setHargaproduk(String hargaproduk) {
        this.hargaproduk = hargaproduk;
    }   
    
    koneksi db = null;
    public pelangganmodel() {
        db = new koneksi ();                
    }
            
    public koneksi getDb () {
        return db;
    }
    
    public void setDb (koneksi db) {
        this.db =db;
    }
    
   public List tampil() {
    List<pelangganmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    try {
        String sql = "SELECT k.idpelanggan, k.namapelanggan, k.alamatpelanggan, " +
                     "j.kodeproduk, j.namaproduk, j.hargaproduk " +
                     "FROM pelanggan k " +
                     "JOIN produk j ON k.kodeproduk = j.kodeproduk";

        hasil = db.ambilData(sql);
            hasil = db.ambilData(sql);
            while(hasil.next() ) {
               pelangganmodel km = new pelangganmodel();
                km.setIdpelanggan(hasil.getString("idpelanggan"));
                km.setNamapelanggan(hasil.getString("namapelanggan"));
                km.setAlamatpelanggan(hasil.getString("alamatpelanggan"));
                km.setNamaproduk(hasil.getString("namaproduk"));
                double harga = hasil.getDouble("hargaproduk");
                String gajiFormatted = formatter.format(harga);
                km.setHargaproduk(gajiFormatted);
                
                data.add(km);                
            }
            db.tutupKoneksi (hasil);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Salah tampil" +e);
    }
     return data;    
   }

public void tambah() {
    String sql = "insert into pelanggan values (null,'" + namapelanggan + "','" + alamatpelanggan + "') ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
}

public void hapusdata () {
    String sql = "delete from pelanggan where idpelanggan = '"+idpelanggan+"' ";
    db.simpanData(sql);
    db.tutupKoneksi(null);
    }

//edit data
public void edit() {
    String sql = "UPDATE pelanggan SET namapelanggan = '" + namapelanggan + 
            "', alamatpelanggan = '" + alamatpelanggan + "' , namaproduk = '" + namaproduk + "' WHERE idpelanggan = '" + idpelanggan + "'";
            db.simpanData(sql);
            db.tutupKoneksi(null);
        }


//untuk pencarian daata
public List caridata(String cari) {
    List<pelangganmodel> data = new ArrayList<>();
    ResultSet hasil = null;
    try {
        String sql = "select * from pelanggan where idpelanggan like "
                + "'%" +cari+ "%'  or namapelanggan like '%"+cari+"%' or alamatpelanggan like '%"+cari+"%'";
        hasil = db.ambilData(sql);
        while (hasil.next()){
        pelangganmodel km = new pelangganmodel();
        km.setIdpelanggan(hasil.getString("idpelanggan"));
        km.setNamapelanggan(hasil.getString("namapelanggan"));
        km.setAlamatpelanggan(hasil.getString("alamatpelanggan"));
        data.add(km);
        }
        db.tutupKoneksi(hasil);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Salah cari data" +e);
    }
    return data;
 }
}