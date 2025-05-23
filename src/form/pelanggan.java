/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import aplikasi.isp.Jabatan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.koneksi2;
import model.pelangganmodel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import aplikasi.isp.Produk;

/**
 *
 * @author Aria
 */
//public final class pelanggan extends javax.swing.JDialog {
public final class pelanggan extends javax.swing.JFrame {
    int xx, xy;
    pelangganmodel km = new pelangganmodel();
    DefaultTableModel tbl;
    List<pelangganmodel> datapelanggan = new ArrayList<>();
    public pelanggan() {
    //super((java.awt.Frame)null, true);
    initComponents();
    buatkolom();
    tampilpelanggan();
    combobox ();
    bersih();        
    kondisi(false);
    aturtombol();
    txtidpelanggan.setEnabled(false);
    setLocationRelativeTo(null);
    }

    /**
     * Creates new form pelanggan
     */
    public pelanggan(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        buatkolom();
        tampilpelanggan();
        bersih();        
        kondisi(false);
        aturtombol();
        combobox();
        txtidpelanggan.setEnabled(false);
        setLocationRelativeTo(null);
    }
    
    public void tampilpelanggan() {
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        datapelanggan.clear();
        datapelanggan = km.tampil();
        String[] kolom = {"IDPelanggan", "Nama", "Alamat", "NamaProduk", "Harga"};
            tblpelanggan.setModel(tbl);
            datapelanggan = km.tampil();
        for (pelangganmodel k : datapelanggan) {
            Object[] row = new Object[5];
            row[0] = k.getIdpelanggan();
            row[1] = k.getNamapelanggan();
            row[2] = k.getAlamatpelanggan();
            row[3] = k.getNamaproduk();
            row[4] = k.getHargaroduk();
            tbl.addRow(row);
        }
       }
    
    public void combobox (){
        try {
        Connection conn = koneksi2.getConnection();
        String sql = "SELECT * FROM produk";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        btncomboproduk.removeAllItems(); 
        btncomboproduk.addItem(null);    
        while (rs.next()) {
            int kode = rs.getInt("kodeproduk");
            String nama = rs.getString("namaproduk");
            btncomboproduk.addItem(new Produk (kode, nama));
        }

        rs.close();
        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal load produk: " + e.getMessage());
     }
   }
         
     public void bersih() {
       txtidpelanggan.setText(null);
       txtnamapelanggan.setText(null);
       txtalamatpelanggan.setText (null);
       txtcaridata.setText(null);
   }
     
    public void aturtombol () {
        btntambah.setEnabled(true);
        btnsimpan.setEnabled (false);
        btnhapus.setEnabled (false);
        btnedit.setEnabled (false); 
    }
    
    public void kondisi (boolean x) {
    txtnamapelanggan.setEnabled (x);
    txtalamatpelanggan.setEnabled (x);
    }   
           
    public void buatkolom(){
    tbl = new DefaultTableModel ();
    tbl.addColumn ("ID");
    tbl.addColumn ("Nama Pelanggan");
    tbl.addColumn ("Alamat");
    tbl.addColumn("Produk");
    tbl.addColumn("Tagihan perbulan");
   
    tblpelanggan.setModel (tbl);
   
    tblpelanggan.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
    tblpelanggan.getColumnModel().getColumn(0).setPreferredWidth(30);
    tblpelanggan.getColumnModel().getColumn(1).setPreferredWidth(140);
    tblpelanggan.getColumnModel().getColumn(2).setPreferredWidth(250);
    tblpelanggan.getColumnModel().getColumn(3).setPreferredWidth(110);
    tblpelanggan.getColumnModel().getColumn(4).setPreferredWidth(120);
    }  

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtcaridata = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpelanggan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnkeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidpelanggan = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        txtnamapelanggan = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnhapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        btncetak = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btncomboproduk = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtalamatpelanggan = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cari");

        txtcaridata.setText("jTextField1");
        txtcaridata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcaridataKeyTyped(evt);
            }
        });

        tblpelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpelanggan);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        btnkeluar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-close-24.png"))); // NOI18N
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Master Pelanggan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Alamat");

        txtidpelanggan.setText("jTextField1");

        btntambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-plus-16.png"))); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        txtnamapelanggan.setText("jTextField2");

        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-diskette-16.png"))); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-delete-16.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nama");

        btnedit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-edit-16.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btncetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncetak.setText("Cetak");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Produk Pelanggan");

        btncomboproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomboprodukActionPerformed(evt);
            }
        });

        txtalamatpelanggan.setColumns(20);
        txtalamatpelanggan.setRows(5);
        jScrollPane3.setViewportView(txtalamatpelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnsimpan)
                            .addGap(14, 14, 14)
                            .addComponent(btnhapus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnedit)
                            .addGap(18, 18, 18)
                            .addComponent(btncetak)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(btncomboproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnamapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnamapelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncomboproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnsimpan)
                    .addComponent(btnhapus)
                    .addComponent(btnedit)
                    .addComponent(btncetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaridataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaridataKeyTyped
        // TODO add your handling code here:
        tbl.getDataVector().removeAllElements();
        tbl.fireTableDataChanged();
        datapelanggan.clear();
        datapelanggan = km.caridata(txtcaridata.getText());
        for (int i = 0; i < datapelanggan.size(); i++) {
            Object[] data = new Object[3];
            data[0] = datapelanggan.get(i).getIdpelanggan();
            data[1] = datapelanggan.get(i).getNamapelanggan();
            data[2] = datapelanggan.get(i).getAlamatpelanggan();
            tbl.addRow(data);
        }        
    }//GEN-LAST:event_txtcaridataKeyTyped

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try {
            JasperPrint jp = JasperFillManager.fillReport(
                getClass().getResourceAsStream("/report/reportpelanggan.jasper"),null, koneksi2.getConnection());
            JasperViewer.viewReport(jp, false);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + e.getMessage());
            e.printStackTrace();
            System.out.println("Path: " + getClass().getResource("/report/reportPelanggan.jasper"));
        }
        //this.setVisible(true);
    }//GEN-LAST:event_btncetakActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        if (btnedit.getText().equalsIgnoreCase("Edit")) {
        if (txtidpelanggan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang akan diedit");
            return;
        }
        kondisi(true);
        btnedit.setText("batal");
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnsimpan.setEnabled(true);
    } else {
        btnedit.setText("Edit");
        kondisi(false);
        bersih();
        aturtombol();
     }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        if (txtidpelanggan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang ingin dihapus");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            km.setIdpelanggan(txtidpelanggan.getText());
            km.hapusdata();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            
            bersih();
            tampilpelanggan();
            kondisi(false);
            aturtombol();
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        if (txtnamapelanggan.getText().isEmpty() || txtalamatpelanggan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data belum Lengkap");
            return;
        }
        String nama = txtnamapelanggan.getText();
        String alamat = txtalamatpelanggan.getText();
        Produk produk = (Produk) btncomboproduk.getSelectedItem();
        int kodeproduk = produk.getKode();

        // SIMPAN DATA BARU
        if (btntambah.getText().equalsIgnoreCase("batal")) {
            try {
                String sql = "INSERT INTO pelanggan (idpelanggan, namapelanggan, alamatpelanggan, kodeproduk) VALUES (null, ?, ?, ?)";
                Connection conn = koneksi2.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, nama);
                pstm.setString(2, alamat);
                pstm.setInt(3, kodeproduk);
                pstm.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Salah Simpan data: " + e.getMessage());
            }
        }
        // EDIT DATA
        else if (btnedit.getText().equalsIgnoreCase("batal")) {
            try {
                String sql = "UPDATE pelanggan SET namapelanggan = ?, alamatpelanggan = ?, kodeproduk = ? WHERE idpelanggan = ?";
                Connection conn = koneksi2.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, nama);
                pstm.setString(2, alamat);
                pstm.setInt(3, kodeproduk);
                pstm.setString(4, txtidpelanggan.getText());
                pstm.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Salah Edit data: " + e.getMessage());
            }
        }
        // Reset UI dan data
        bersih();
        kondisi(false);
        tampilpelanggan();
        aturtombol();
        btntambah.setText("Tambah");
        btnedit.setText("Edit");
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        if(btntambah.getText().equalsIgnoreCase("Tambah")) {
            btntambah.setText("Batal");
            btntambah.setEnabled(true);
            btnsimpan.setEnabled(true);
            btnhapus.setEnabled(false);
            btnedit.setEnabled(false);
            bersih();
        }

        else {
            btntambah.setText("Tambah");
            bersih ();
            kondisi(false);
            aturtombol();
        }
        kondisi (true);
    }//GEN-LAST:event_btntambahActionPerformed

    private void tblpelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpelangganMouseClicked
        // TODO add your handling code here:
        int baris = tblpelanggan.getSelectedRow();
        txtidpelanggan.setText(tblpelanggan.getModel().getValueAt(baris, 0).toString());
        txtnamapelanggan.setText(tblpelanggan.getModel().getValueAt(baris, 1).toString());
        txtalamatpelanggan.setText(tblpelanggan.getModel().getValueAt(baris, 2).toString());
        
        btntambah.setText("Tambah");
        btnedit.setText("edit");
        btnsimpan.setEnabled(false);
        btntambah.setEnabled(true);
        btnhapus.setEnabled(true);
        btnedit.setEnabled(true);
    }//GEN-LAST:event_tblpelangganMouseClicked

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btncomboprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomboprodukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncomboprodukActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pelanggan dialog = new pelanggan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetak;
    private javax.swing.JComboBox btncomboproduk;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblpelanggan;
    private javax.swing.JTextArea txtalamatpelanggan;
    private javax.swing.JTextField txtcaridata;
    private javax.swing.JTextField txtidpelanggan;
    private javax.swing.JTextField txtnamapelanggan;
    // End of variables declaration//GEN-END:variables
}
