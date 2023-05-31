/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Arif Fadhilah
 */
public class Buku {
    private String kode;
    private String judul;
    private String penulis;
    private String penerbit;
    private Double stok;

    public Buku(String kode, String judul, String penulis, String penerbit, int harga) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.stok = stok;   
    } 

    public Buku(String kode, String judul, String penulis, String penerbit, double stok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    public double getStok() {
        return stok;
    }

    public void setStok(double stok) {
        this.stok = stok;
    }
    

    @Override
    public String toString() {
        return "Buku{" + "kode" + kode + ", judul=" + judul + ", penulis=" + penulis + ", penerbit=" + penerbit + ", stok=" + stok + '}';
    }
    
    
 
}
