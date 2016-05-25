/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.factory;

import amm.milestone.model.Venditore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nando
 */
public class VenditoreFactory {
    private static VenditoreFactory vf;
    //static List<Venditore> listaVenditori = null;
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    public String getConnectionString() {
        return this.connectionString;
    }
    public static VenditoreFactory getInstance() {
        if (vf == null)
            vf = new VenditoreFactory();
        return vf;
    }
    private VenditoreFactory() {
        /*
        listaVenditori = new ArrayList<>();

        Venditore venditore1 = new Venditore();
        venditore1.setId(1);
        venditore1.setNome("Roberto");
        venditore1.setCognome("Formica");
        venditore1.setCodiceFiscale("FMCRRT76G12B345J");
        venditore1.setUsername("ven1");
        venditore1.setPassword("pwd1");
        listaVenditori.add(venditore1);

        Venditore venditore2 = new Venditore();
        venditore2.setId(2);
        venditore2.setNome("Luigi");
        venditore2.setCognome("Zucca");
        venditore2.setCodiceFiscale("ZCCLGU74T12H559F");
        venditore2.setUsername("ven2");
        venditore2.setPassword("pwd2");
        listaVenditori.add(venditore2);

        Venditore venditore3 = new Venditore();
        venditore3.setId(3);
        venditore3.setNome("Tiziano");
        venditore3.setCognome("Ferro");
        venditore3.setCodiceFiscale("FRRTZN86R42Y534L");
        venditore3.setUsername("ven3");
        venditore3.setPassword("pwd3");
        listaVenditori.add(venditore3);
        */
    }
    public List<Venditore> getVenditoreList() {
        ArrayList<Venditore> listaVenditori = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select u.* from VENDITORE v, UTENTE u where v.utente_id=u.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Venditore venditore = new Venditore();
                venditore.setId(set.getInt("ID"));
                venditore.setCodiceFiscale(set.getString("CODFISC"));
                venditore.setCognome(set.getString("COGNOME"));
                venditore.setNome(set.getString("NOME"));
                venditore.setPassword(set.getString("PASSWORD"));
                venditore.setUsername(set.getString("USERNAME"));
                venditore.setSaldo(set.getDouble("SALDO"));
                listaVenditori.add(venditore);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVenditori;
    }
    public Venditore getVenditoreById(Integer id) {
        Venditore venditore = null;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select u.* from VENDITORE v, UTENTE u where u.id = ? and v.utente_id=u.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                venditore = new Venditore();
                venditore.setId(set.getInt("ID"));
                venditore.setCodiceFiscale(set.getString("CODFISC"));
                venditore.setCognome(set.getString("COGNOME"));
                venditore.setNome(set.getString("NOME"));
                venditore.setPassword(set.getString("PASSWORD"));
                venditore.setUsername(set.getString("USERNAME"));
                venditore.setSaldo(set.getDouble("SALDO"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(VenditoreFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (venditore == null)
            Logger.getLogger("VenditoreServlet").log(Level.INFO, "Venditore non trovato: id = "+id);
        return venditore;
    }

    public Venditore getVenditoreAuth(String username, String password) {
        Venditore venditore = null;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select u.* from UTENTE u, VENDITORE v where u.username=? and u.password=? and u.id=v.utente_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                venditore = new Venditore();
                venditore.setId(set.getInt("ID"));
                venditore.setCodiceFiscale(set.getString("CODFISC"));
                venditore.setCognome(set.getString("COGNOME"));
                venditore.setNome(set.getString("NOME"));
                venditore.setPassword(set.getString("PASSWORD"));
                venditore.setUsername(set.getString("USERNAME"));
                venditore.setSaldo(set.getDouble("SALDO"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venditore;
    }
}
