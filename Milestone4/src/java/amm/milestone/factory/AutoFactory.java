/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.factory;

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
        /*
        listaAuto = new ArrayList<>();
        Auto auto = null;

        auto = new Auto(1,"FIAT","Panda");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoImmatricolazione(1995);
        auto.setTarga("GF635FD");
        auto.setDescrizione("Modello semi nuovo");
        auto.setPrezzo(2050);
        listaAuto.add(auto);

        auto = new Auto(2,"Renault","Twingo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoImmatricolazione(2001);
        auto.setTarga("TT636HH");
        auto.setDescrizione("Incidentata");
        auto.setPrezzo(1900);
        listaAuto.add(auto);

        auto = new Auto(3,"Opel","Aygo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoImmatricolazione(2011);
        auto.setTarga("GT453DD");
        auto.setDescrizione("Nuova");
        auto.setPrezzo(4500);
        listaAuto.add(auto);

        auto = new Auto(4,"Fiat","Panda");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoImmatricolazione(1999);
        auto.setTarga("AA998GB");
        auto.setDescrizione("Molto vecchia");
        auto.setPrezzo(1500);
        listaAuto.add(auto);

        auto = new Auto(5,"Renault","Twingo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setImage("images/image4.jpg");
        auto.setAnnoImmatricolazione(2003);
        auto.setTarga("AF884HH");
        auto.setDescrizione("Occasione");
        auto.setPrezzo(3100);
        listaAuto.add(auto);

        auto = new Auto(6,"Renault","Clio");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoImmatricolazione(2004);
        auto.setTarga("BA998LL");
        auto.setDescrizione("Di terza mano");
        auto.setPrezzo(1100);
        listaAuto.add(auto);

        auto = new Auto(7,"Opel","Adam");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoImmatricolazione(2011);
        auto.setTarga("EA888JU");
        auto.setDescrizione("Chilometri zero");
        auto.setPrezzo(8000);
        listaAuto.add(auto);

        auto = new Auto(8,"Chevrolet","Matiz");
        auto.setIdCategoria(1);
        auto.setIdCarburante(3);
        auto.setImage("images/image5.jpg");
        auto.setAnnoImmatricolazione(2006);
        auto.setTarga("CZ897HL");
        auto.setDescrizione("Con fendinebbia");
        auto.setPrezzo(900);
        listaAuto.add(auto);

        auto = new Auto(9,"Peugeot","106");
        auto.setIdCategoria(1);
        auto.setIdCarburante(3);
        auto.setAnnoImmatricolazione(2000);
        auto.setTarga("HY637XX");
        auto.setDescrizione("Cambio automatico");
        auto.setPrezzo(1700);
        listaAuto.add(auto);

        auto = new Auto(10,"Fiat","500");
        auto.setIdCategoria(2);
        auto.setIdCarburante(1);
        auto.setImage("images/image1.jpg");
        auto.setAnnoImmatricolazione(2012);
        auto.setTarga("EE777FR");
        auto.setDescrizione("Piccola");
        auto.setPrezzo(4400);
        listaAuto.add(auto);

        auto = new Auto(11,"Renault","Clio");
        auto.setIdCategoria(2);
        auto.setIdCarburante(1);
        auto.setAnnoImmatricolazione(2010);
        auto.setTarga("DE536GG");
        auto.setDescrizione("Tetto apribile");
        auto.setPrezzo(5100);
        listaAuto.add(auto);

        auto = new Auto(12,"Ford","Fiesta");
        auto.setIdCategoria(2);
        auto.setIdCarburante(2);
        auto.setImage("images/image2.jpg");
        auto.setAnnoImmatricolazione(2010);
        auto.setTarga("AA000AA");
        auto.setDescrizione("Tetto apribile");
        auto.setPrezzo(2100);
        listaAuto.add(auto);

        auto = new Auto(13,"Volkswagen","Polo");
        auto.setIdCategoria(2);
        auto.setIdCarburante(2);
        auto.setAnnoImmatricolazione(2014);
        auto.setTarga("ER432TK");
        auto.setDescrizione("Bicolore");
        auto.setPrezzo(4100);
        listaAuto.add(auto);

        auto = new Auto(14,"Peugeot","407");
        auto.setIdCategoria(2);
        auto.setIdCarburante(3);
        auto.setAnnoImmatricolazione(2015);
        auto.setTarga("FA378JJ");
        auto.setDescrizione("Da rottamare");
        auto.setPrezzo(200);
        listaAuto.add(auto);

        auto = new Auto(15,"Citroen","C2");
        auto.setIdCategoria(2);
        auto.setIdCarburante(3);
        auto.setAnnoImmatricolazione(2011);
        auto.setTarga("CD436HH");
        auto.setDescrizione("Cerchi in lega");
        auto.setPrezzo(3500);
        listaAuto.add(auto);

        auto = new Auto(16,"Volkswagen","Golf");
        auto.setIdCategoria(3);
        auto.setIdCarburante(1);
        auto.setImage("images/image3.jpg");
        auto.setAnnoImmatricolazione(2011);
        auto.setTarga("KI220KO");
        auto.setDescrizione("Cerchi in lega");
        auto.setPrezzo(5500);
        listaAuto.add(auto);
        */
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
            String sql = "delete AUTO where ID=?";
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
            stmt.setInt(11, auto.getId());
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModello());
            stmt.setInt(3, auto.getIdCategoria());
            stmt.setInt(4, auto.getIdCarburante());
            stmt.setInt(5, auto.getAnnoImmatricolazione());
            stmt.setString(6, auto.getTarga());
            stmt.setInt(7, auto.getPrezzo());
            stmt.setString(8, auto.getDescrizione());
            stmt.setString(9, auto.getImage());
            stmt.setInt(10, auto.getIdProprietario());
            status = stmt.executeUpdate();
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
        ArrayList<Auto> listaAuto = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from AUTO where proprietario_id > 0";
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
}
