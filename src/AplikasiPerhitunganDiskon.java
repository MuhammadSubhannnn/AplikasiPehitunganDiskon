/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AplikasiPerhitunganDiskon extends javax.swing.JFrame {
    private Map<String, Double> kodeKupon;
    private ArrayList<String> historyEntries;
    /**
     * Creates new form AplikasiPerhitunganDiskon
     */
    public AplikasiPerhitunganDiskon() {
          initComponents();
        initCustomComponents();
    }

    // Metode untuk menginisialisasi komponen kustom
    private void initCustomComponents() {
        // Inisialisasi kode kupon
        kodeKupon = new HashMap<>();
        kodeKupon.put("VOCER10", 10.0);  // Diskon 10%
        kodeKupon.put("VOCER20", 20.0);   // Diskon 20%
        kodeKupon.put("VOCER30", 30.0);   // Diskon 30%

        // Inisialisasi list untuk riwayat
        historyEntries = new ArrayList<>();

        // Tambahkan event listener ke tombol hitung
        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hitungDiskon();
            }
        });

        // Tambahkan event listener untuk mengubah diskonSlider sesuai persentase diskon
        diskonSlider.addChangeListener(e -> {
            int diskonSliderValue = diskonSlider.getValue();
            jLabel3.setText(diskonSliderValue + "%");
        });
    }

    private double getDiskonKupon(String kode) {
        return kodeKupon.getOrDefault(kode.toUpperCase(), 0.0);
    }

    private void hitungDiskon() {
        try {
            double harga = Double.parseDouble(hargaAwal.getText());
            int diskonPersen = diskonSlider.getValue();

            // Langkah 1: Hitung harga setelah diskon awal
            double penghematanAwal = harga * (diskonPersen / 100.0);
            double hargaSetelahDiskon = harga - penghematanAwal;

            // Langkah 2: Terapkan diskon kupon jika ada
            double diskonKupon = getDiskonKupon(kuponKode.getText());
            double penghematanKupon = hargaSetelahDiskon * (diskonKupon / 100.0);
            double hargaAkhirValue = hargaSetelahDiskon - penghematanKupon;

            // Hitung total penghematan
            double totalPenghematan = penghematanAwal + penghematanKupon;

            // Tampilkan hasil
            hargaAkhir.setText(String.format("Harga Akhir: Rp%.2f", hargaAkhirValue));
            savingLabel.setText(String.format("Total Penghematan Rp%.2f", totalPenghematan));

            // Memperbarui riwayat
            String historyEntry = String.format("Harga Awal: Rp%.2f, Diskon Awal: %d%%, Kupon: %.1f%%, Akhir: Rp%.2f", 
                                    harga, diskonPersen, diskonKupon, hargaAkhirValue);

            historyEntries.add(historyEntry);
            updateHistory();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan harga yang valid.", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateHistory() {
    historyArea.setText(""); // Mengosongkan JTextArea sebelum menambahkan riwayat baru
    for (String entry : historyEntries) {
        historyArea.append(entry + "\n");
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hargaAkhir = new javax.swing.JLabel();
        savingLabel = new javax.swing.JLabel();
        hargaAwal = new javax.swing.JTextField();
        kuponKode = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        diskonSlider = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tugas 3 Aplikasi Perhitungan Diskon"));

        jLabel1.setText("Masukkan Harga :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("APLIKASI PERHITUNGAN DISKON");

        jLabel3.setText("Masukkan Diskon : ");

        jLabel4.setText("Masukkan Kupon Diskon : ");

        hargaAkhir.setText("Harga Akhir");

        savingLabel.setText("Penghematan");

        hargaAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaAwalActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        historyArea.setColumns(20);
        historyArea.setRows(5);
        jScrollPane1.setViewportView(historyArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(hargaAkhir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hargaAwal)
                                    .addComponent(kuponKode)
                                    .addComponent(diskonSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(savingLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(diskonSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kuponKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hargaAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaAwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaAwalActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHitungActionPerformed

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
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPerhitunganDiskon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JSlider diskonSlider;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JTextField hargaAwal;
    private javax.swing.JTextArea historyArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kuponKode;
    private javax.swing.JLabel savingLabel;
    // End of variables declaration//GEN-END:variables
}
