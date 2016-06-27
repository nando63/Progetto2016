/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

import amm.milestone.model.Auto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nando
 */
public class AutoFactory {
    private static AutoFactory af;
    //static ArrayList<Auto> listaAuto = null;
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    public String getConnectionString() {
        return this.connectionString;
    }
    public static AutoFactory getInstance() {
        if (af == null)
            af = new AutoFactory();
        return af;
    }
    private AutoFactory() {
    }
    public int insertAuto(Auto auto) {
        int status = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "insert into AUTO(MARCA,MODELLO,CATEGORIA_ID,CARBURANTE_ID,ANNO_IMMATRICOLAZIONE,"+
                    "TARGA,DESCRIZIONE,PREZZO,IMAGE,PROPRIETARIO_ID) "+
                    "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModello());
            stmt.setInt(3, auto.getIdCategoria());
            stmt.setInt(4, auto.getIdCarburante());
            stmt.setInt(5, auto.getAnnoImmatricolazione());
            stmt.setString(6, auto.getTarga());
            stmt.setString(7, auto.getDescrizione());
            stmt.setInt(8, auto.getPrezzo());
            stmt.setString(9, auto.getImage());
            stmt.setInt(10, auto.getIdProprietario());
            Logger.getLogger(AutoFactory.class.getName()).log(Level.INFO, stmt.toString());
            status = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (status == 0)
            Logger.getLogger(AutoFactory.class.getName()).log(Level.INFO, "Errore inserimento");
        return status;
    }
    public int deleteAuto(Integer id) {
        int status = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "delete from AUTO where ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            status = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public int updateAuto(Auto auto) {
        int status = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "update AUTO set MARCA=?,MODELLO=?,CATEGORIA_ID=?,CARBURANTE_ID=?,"+
                    "ANNO_IMMATRICOLAZIONE=?,TARGA=?,DESCRIZIONE=?,PREZZO=?,IMAGE=?,PROPRIETARIO_ID=? "+
                    "where ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModello());
            stmt.setInt(3, auto.getIdCategoria());
            stmt.setInt(4, auto.getIdCarburante());
            stmt.setInt(5, auto.getAnnoImmatricolazione());
            stmt.setString(6, auto.getTarga());
            stmt.setString(7, auto.getDescrizione());
            stmt.setInt(8, auto.getPrezzo());
            stmt.setString(9, auto.getImage());
            stmt.setInt(10, auto.getIdProprietario());
            stmt.setInt(11, auto.getId());
            status = stmt.executeUpdate();
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, "status=" + status +";id="+ auto.getId());
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public ArrayList<Auto> getAutoList() {
        ArrayList<Auto> listaAuto = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from AUTO";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Auto auto = new Auto();
                auto.setId(set.getInt("id"));
                auto.setIdCategoria(set.getInt("Categoria_id"));
                auto.setMarca(set.getString("marca"));
                auto.setModello(set.getString("modello"));
                auto.setAnnoImmatricolazione(set.getInt("anno_immatricolazione"));
                auto.setTarga(set.getString("targa"));
                auto.setIdCarburante(set.getInt("Carburante_id"));
                auto.setDescrizione(set.getString("descrizione"));
                auto.setPrezzo(set.getInt("prezzo"));
                auto.setImage(set.getString("image"));
                auto.setIdProprietario(set.getInt("Proprietario_id"));
                listaAuto.add(auto);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAuto;
    }
    public Auto getAutoById(Integer id) {
        try {
            Auto auto = null;
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from AUTO where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                auto = new Auto();
                auto.setId(set.getInt("id"));
                auto.setIdCategoria(set.getInt("Categoria_id"));
                auto.setMarca(set.getString("marca"));
                auto.setModello(set.getString("modello"));
                auto.setAnnoImmatricolazione(set.getInt("anno_immatricolazione"));
                auto.setTarga(set.getString("targa"));
                auto.setIdCarburante(set.getInt("Carburante_id"));
                auto.setDescrizione(set.getString("descrizione"));
                auto.setPrezzo(set.getInt("prezzo"));
                auto.setImage(set.getString("image"));
                auto.setIdProprietario(set.getInt("Proprietario_id"));
            }
            stmt.close();
            conn.close();
            return auto;
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        if (listaAuto != null && id != null) {
            for (Auto a : listaAuto) {
                if (a.getId().equals(id))
                    return a;
            }
        }
        */
        return null;
    }

    public ArrayList<Auto> getAutoProprietario(Integer id) {
        ArrayList<Auto> listaAuto = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from AUTO where proprietario_id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Auto auto = new Auto();
                auto.setId(set.getInt("id"));
                auto.setIdCategoria(set.getInt("Categoria_id"));
                auto.setMarca(set.getString("marca"));
                auto.setModello(set.getString("modello"));
                auto.setAnnoImmatricolazione(set.getInt("anno_immatricolazione"));
                auto.setTarga(set.getString("targa"));
                auto.setIdCarburante(set.getInt("Carburante_id"));
                auto.setDescrizione(set.getString("descrizione"));
                auto.setPrezzo(set.getInt("prezzo"));
                auto.setImage(set.getString("image"));
                auto.setIdProprietario(set.getInt("Proprietario_id"));
                listaAuto.add(auto);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAuto;
    }

    public ArrayList<Auto> getAutoInVendita() {
        return filtraAutoInVendita(null);
    }

    public ArrayList<Auto> filtraAutoInVendita(String q) {
        ArrayList<Auto> listaAuto = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select a.* from AUTO a, VENDITORE v where a.proprietario_id = v.utente_id";
            if (q != null && !q.equals(""))
                sql += " and (lower(a.marca) like ? or lower(a.modello) like ? or lower(a.descrizione) like ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            if (q != null && !q.equals("")) {
                q = "%"+q.toLowerCase()+"%";
                stmt.setString(1, q);
                stmt.setString(2, q);
                stmt.setString(3, q);
            }
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Auto auto = new Auto();
                auto.setId(set.getInt("id"));
                auto.setIdCategoria(set.getInt("Categoria_id"));
                auto.setMarca(set.getString("marca"));
                auto.setModello(set.getString("modello"));
                auto.setAnnoImmatricolazione(set.getInt("anno_immatricolazione"));
                auto.setTarga(set.getString("targa"));
                auto.setIdCarburante(set.getInt("Carburante_id"));
                auto.setDescrizione(set.getString("descrizione"));
                auto.setPrezzo(set.getInt("prezzo"));
                auto.setImage(set.getString("image"));
                auto.setIdProprietario(set.getInt("Proprietario_id"));
                listaAuto.add(auto);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAuto;
        
    }
}
