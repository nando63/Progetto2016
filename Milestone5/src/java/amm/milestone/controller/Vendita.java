/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

import amm.milestone.model.Auto;
import amm.milestone.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nando
 */
public class Vendita {
    static public boolean vendi(Auto auto, Cliente cliente) {
        Connection conn = null;
        Boolean error = false;
        try {
            conn = DriverManager.getConnection(Config.getConnectionString(), "pippo", "pippo");
            conn.setAutoCommit(false);
            String sql = null;
            PreparedStatement stmt=null;

            // aumenta il saldo del venditore
            sql = "Update UTENTE set saldo=saldo+? where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, auto.getPrezzo());
            stmt.setInt(2, auto.getIdProprietario());
            error = (stmt.executeUpdate() != 1);
            stmt.close();

            Logger.getLogger(AutoFactory.class.getName()).log(Level.INFO, sql+"-"+auto.getPrezzo()+"-"+auto.getIdProprietario()+"-"+error);
            
            if (!error) {
                // diminuisce il saldo del cliente
                sql = "Update UTENTE set saldo=saldo-? where id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, auto.getPrezzo());
                stmt.setInt(2, cliente.getId());
                error = (stmt.executeUpdate() != 1);
                stmt.close();
                Logger.getLogger(AutoFactory.class.getName()).log(Level.INFO, sql+"-"+auto.getPrezzo()+"-"+cliente.getId()+"-"+error);
            }

            if (!error) {
                // imposta l'auto al nuovo proprietario
                sql = "Update AUTO set proprietario_id=? where id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, cliente.getId());
                stmt.setInt(2, auto.getId());
                error = (stmt.executeUpdate() != 1);
                stmt.close();
                Logger.getLogger(AutoFactory.class.getName()).log(Level.INFO, sql+"-"+cliente.getId()+"-"+auto.getId()+"-"+error);
            }
            if (!error) {
                cliente.setSaldo(cliente.getSaldo()-auto.getPrezzo());
            }
        } catch (SQLException ex) {
            error = true;
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (conn != null) {
                try {
                    if (error)
                        conn.rollback();
                    else
                        conn.commit();
                    conn.setAutoCommit(true);
                    conn.close();
                }
                catch(SQLException ex) {
                    Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return error;
    }
}
