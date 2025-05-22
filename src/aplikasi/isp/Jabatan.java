/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.isp;

/**
 *
 * @author Aria
 */
public class Jabatan {
    private int kodejabatan;
    private String namajabatan;

    public Jabatan(int Kodejabatan, String Namajabatan) {
        this.kodejabatan = Kodejabatan;
        this.namajabatan = Namajabatan;
    }

    public int getKode() {
        return kodejabatan;
    }

    @Override
    public String toString() {
        return namajabatan; // ditampilkan di ComboBox
    }
    
}


