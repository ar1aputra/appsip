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
    private String namajabtan;

    public Jabatan(int Kodejabatan, String Namajabatan) {
        this.kodejabatan = Kodejabatan;
        this.namajabtan = Namajabatan;
    }

    public int getKode() {
        return kodejabatan;
    }

    @Override
    public String toString() {
        return namajabtan; // ditampilkan di ComboBox
    }
    
}


