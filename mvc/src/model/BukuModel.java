/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import database.Connector;
import main.Buku;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Arif Fadhilah
 */
public class BukuModel {
    Connector konek = new Connector();
    
    public void insertBuku(Buku buku){
        String query = "INSERT into buku (kode, judul, penulis, penerbit, stok) values (?,?,?,?,?)";
        PreparedStatement pstm;
        
        try{
           konek.statement = konek.koneksi.createStatement();
           pstm = konek.koneksi.prepareStatement(query);
           pstm.setString(1, buku.getKode());
           pstm.setString(2, buku.getJudul());
           pstm.setString(3, buku.getPenulis());
           pstm.setString(4, buku.getPenerbit());
           pstm.setDouble(5, buku.getStok());
           pstm.executeUpdate();
   
        }catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
    
    public ArrayList<Buku> getBuku(){
        System.out.println("getBuku()");
        String query = "SELECT * from buku";
        PreparedStatement pstm;
        
        try{
           
           konek.statement = konek.koneksi.createStatement();
           pstm = konek.koneksi.prepareStatement(query);
           ResultSet rs = pstm.executeQuery();
           ArrayList<Buku> list = new ArrayList<>();
           Buku buku;
           while(rs.next()){
               buku = new Buku(
                    rs.getString("kode"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getString("penerbit"), 
                    rs.getDouble("stok"));
//               
               list.add(buku);
           }
           return list;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public boolean isContainBuku(){
        System.out.println("isContainBuku()");
        try{
            String query = "select count(*) as num from buku";
            PreparedStatement ptsm = konek.koneksi.prepareStatement(query);
            konek.statement = konek.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            rs.next();
            if(rs.getInt("num") > 0) return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
        
}
