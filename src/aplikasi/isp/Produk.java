/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.isp;

/**
 *
 * @author Administrator
 */
public class Produk {
    private int kodeproduk;
    private String namaproduk;

    public Produk (int Kodeproduk, String Namaproduk) {
        this.kodeproduk = Kodeproduk;
        this.namaproduk = Namaproduk;
    }

    public int getKode() {
        return kodeproduk;
    }

    @Override
    public String toString() {
        return namaproduk; // ditampilkan di ComboBox
    }
    
}
