/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arif Fadhilah
 */
public class BukuView extends JFrame implements ActionListener{
    JLabel lKode = new JLabel("Kode");
    JLabel lJudul = new JLabel("Judul");
    JLabel lPenulis = new JLabel("Penulis");
    JLabel lPenerbit = new JLabel("Penerbit");
    JLabel lStok = new JLabel("Stok");

    public JTextField tfKode = new JTextField();
    public JTextField tfJudul = new JTextField();
    public JTextField tfPenulis = new JTextField();
    public JTextField tfPenerbit = new JTextField();
    public JTextField tfStok = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Kode", "Judul", "Penulis", "Penerbit", "Stok"};
    
    public BukuView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        tabel.setForeground(Color.gray);
        
        setTitle("Data Buku");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(1200,700);
        setBackground(Color.BLUE);
        
        add(scrollPane);
        scrollPane.setBounds(250, 270, 700, 300);
        scrollPane.setBackground(Color.BLUE);
        
        add(lKode);
        lKode.setBounds(450, 20, 90, 20);
        lKode.setBackground(Color.BLUE);
        add(tfKode);
        tfKode.setBounds(550, 20, 210, 20);

        add(lJudul);
        lJudul.setBounds(450, 50, 120, 20);
        add(tfJudul);
        tfJudul.setBounds(550, 50, 210, 20);

        add(lPenulis);
        lPenulis.setBounds(450, 80, 120, 20);
        add(tfPenulis);
        tfPenulis.setBounds(550, 80, 210, 20);

        add(lPenerbit);
        lPenerbit.setBounds(450, 110, 90, 20);
        add(tfPenerbit);
        tfPenerbit.setBounds(550, 110, 210, 20);
        
        add(lStok);
        lStok.setBounds(450, 140, 120, 20);
        add(tfStok);
        tfStok.setBounds(550, 140, 210, 20);
        
        add(btnTambah);
        btnTambah.setBounds(500, 210, 90, 20);
        btnTambah.setBackground(Color.BLUE);
        btnTambah.setForeground(Color.GRAY);
        
        add(btnReset);
        btnReset.setBounds(600, 210, 90, 20);
        btnReset.setBackground(Color.BLUE);
        btnReset.setForeground(Color.GRAY);
    }

     public void actionPerformed(ActionEvent e) {
     if(e.getSource() == btnReset){
            tfKode.setText("");
            tfJudul.setText("");
            tfPenulis.setText("");
            tfPenerbit.setText("");
            tfStok.setText("");
        }
     }

    public String getKode(){
        return tfKode.getText();
    }

    public String getJudul(){
        return String.valueOf(tfJudul.getText());
    }

    public String getPenulis(){
        return String.valueOf(tfPenulis.getText());   
    }

    public String getPenerbit(){
        return String.valueOf(tfPenerbit.getText());
    }
    
    public double getStok(){
        return Double.valueOf(tfStok.getText());
    }
    
}
