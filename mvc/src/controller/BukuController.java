/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Connector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import main.Buku;
import model.BukuModel;
import view.BukuView;
/**
 *
 * @author Arif Fadhilah
 */
public class BukuController {
    
    private ArrayList<Buku> list;
    private String kode;
    private String judul;
    private String penulis;
    private String penerbit;
    private double stok;
    
    public BukuController(BukuView view, BukuModel model){
        
        if(model.isContainBuku()){
            list = model.getBuku();
            String [][] data = convertData(list);
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data belum tersedia");
        }
        view.btnTambah.addActionListener((ActionEvent e) -> {
            String kode1 = view.getKode();
            String judul1 = view.getJudul();
            String penulis1 = view.getPenulis();
            String penerbit1 = view.getPenerbit();
            double stok1 = view.getStok();
            if (isValid(stok1)) {
                Buku buku = new Buku(kode1, judul1, penulis1, penerbit1, stok1);
                model.insertBuku(buku);
            }
            list = model.getBuku();
            System.out.println(list.get(0).getJudul());
            String [][] data = convertData(list);
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        });   
        
        view.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();
                kode = view.tabel.getValueAt(baris, 0).toString(); 
                judul = String.valueOf(view.tabel.getValueAt(baris, 1).toString());
                penulis = String.valueOf(view.tabel.getValueAt(baris, 2).toString());
                penerbit = String.valueOf(view.tabel.getValueAt(baris, 3).toString());
                stok = Double.valueOf(view.tabel.getValueAt(baris, 4).toString());
                
                view.tfKode.setText(kode);
                view.tfJudul.setText(String.valueOf(judul));
                view.tfPenulis.setText(String.valueOf(penulis));
                view.tfPenerbit.setText(String.valueOf(penerbit));
                view.tfStok.setText(String.valueOf(stok));
            }
            
        });
        
        view.btnReset.addActionListener((ActionEvent e) -> {
            view.tfKode.setText("");
            view.tfJudul.setText("");
            view.tfPenulis.setText("");
            view.tfPenerbit.setText("");
            view.tfStok.setText("");
        });
    }
   
    private boolean isValid(Double stok){
        return stok >= 0;
    }
    private String[][] convertData(ArrayList<Buku> list){
        String[][] data = new String[list.size()][5];
        
        for(int i = 0; i < list.size(); i++){
            data[i][0] = list.get(i).getKode();
            data[i][1] = String.valueOf(list.get(i).getJudul());
            data[i][2] = String.valueOf(list.get(i).getPenulis());
            data[i][3] = String.valueOf(list.get(i).getPenerbit());
            data[i][4] = String.valueOf(list.get(i).getStok());
        }
        
        return data;
    }    
}
