/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.factory;

import amm.milestone.model.Cliente;
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
public class ClienteFactory {
    private static ClienteFactory cf;
    //private static ArrayList<Cliente> listaClienti = null;
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    public String getConnectionString() {
        return this.connectionString;
    }
    public static ClienteFactory getInstance() {
        if (cf == null) {
            cf = new ClienteFactory();
        }
        return cf;
    }
        
    private ClienteFactory() {
        /*
        listaClienti = new ArrayList<>();

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("Mauro");
        cliente1.setCognome("Pili");
        cliente1.setCodiceFiscale("GGHWWT83G32H645G");
        cliente1.setUsername("cli1");
        cliente1.setPassword("pwd1");
        cliente1.setSaldo(5000.0);
        listaClienti.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNome("Gianni");
        cliente2.setCognome("Fenu");
        cliente2.setCodiceFiscale("FNEGNN62A11B354O");
        cliente2.setUsername("cli2");
        cliente2.setPassword("pwd2");
        cliente2.setSaldo(15000.0);
        listaClienti.add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNome("Alberto");
        cliente3.setCognome("Atzori");
        cliente3.setCodiceFiscale("TZRABR77G01T555H");
        cliente3.setUsername("cli3");
        cliente3.setPassword("pwd3");
        cliente3.setSaldo(7500.0);
        listaClienti.add(cliente3);
        */
    }
    public ArrayList<Cliente> getClienteList() {
        ArrayList<Cliente> listaClienti = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select u.* from CLIENTE c, UTENTE u where c.utente_id=u.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("ID"));
                cliente.setCodiceFiscale(set.getString("CODFISC"));
                cliente.setCognome(set.getString("COGNOME"));
                cliente.setNome(set.getString("NOME"));
                cliente.setPassword(set.getString("PASSWORD"));
                cliente.setUsername(set.getString("USERNAME"));
                cliente.setSaldo(set.getDouble("SALDO"));
                listaClienti.add(cliente);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClienti;
    }
    public Cliente getClienteById(Integer id) {
        Cliente cliente = null;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select u.* from CLIENTE c, UTENTE u where u.id=? and c.utente_id=u.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                cliente = new Cliente();
                cliente.setId(set.getInt("ID"));
                cliente.setCodiceFiscale(set.getString("CODFISC"));
                cliente.setCognome(set.getString("COGNOME"));
                cliente.setNome(set.getString("NOME"));
                cliente.setPassword(set.getString("PASSWORD"));
                cliente.setUsername(set.getString("USERNAME"));
                cliente.setSaldo(set.getDouble("SALDO"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}
