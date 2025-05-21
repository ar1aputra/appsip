/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Aria
 */
public class koneksi {
    
    private Connection konek;
    private Statement st;   

public void koneksi () {
    try {
    String db = "jdbc:mysql://localhost:3306/appisp";
    String user = "root";
    String pass = "";
    Class.forName("com.mysql.jdbc.Driver");
    konek = DriverManager.getConnection(db,user,pass);            
    st = konek.createStatement();
  } catch (Exception e) {
        System.out.println("Koneksi Gagal : " + e);
        }
      }
    
public ResultSet ambilData (String sql) {
    ResultSet rs = null;
    try {
        koneksi();
       rs = st.executeQuery(sql);
    }catch (Exception e) {
        System.out.println(" Salah Ambil Data : " + e);
   }return rs;
}

public void simpanData(String sql) {
    try{
        koneksi();
        st.executeUpdate(sql);
    }catch (Exception e) {
        System.out.println("Salah Simpan data :" + e);
    }
}

public void UbahData(String sql) {
    try{
        koneksi();
        st.executeUpdate(sql);
    }catch (Exception e) {
        System.out.println("Salah Rubah data :" + e);
    }
}

public void hapus(String sql) {
    try {
        koneksi();
        st.executeUpdate(sql);
    } catch (Exception e) {
        System.out.println("gagal hapus data :" + e);
    }
}

public void tutupKoneksi (ResultSet rs) {
    try {
        if (rs != null){
            rs.close();
        }
        st.close();
        konek.close();
   } catch (Exception e) {
        System.out.println("Salah tutup koneksi : " +e);
        }
    } 
}
