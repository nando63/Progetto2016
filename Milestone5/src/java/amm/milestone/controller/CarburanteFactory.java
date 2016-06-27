/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

import amm.milestone.model.Carburante;
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
public class CarburanteFactory {
    private static CarburanteFactory cf;
    //static ArrayList<Carburante> listaCarburante = null;
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    public String getConnectionString() {
        return this.connectionString;
    }
    public static CarburanteFactory getInstance() {
        if (cf == null)
            cf = new CarburanteFactory();
        return cf;
    }
    private CarburanteFactory() {
        /*
        listaCarburante = new ArrayList<>();
        
        listaCarburante.add(new Carburante(1,"Benzina"));
        listaCarburante.add(new Carburante(2,"Diesel"));
        listaCarburante.add(new Carburante(3,"Gpl"));
        */
    }
    public ArrayList<Carburante> getCarburanteList() {
        ArrayList<Carburante> listaCarburante = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from CARBURANTE";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Integer id = set.getInt("id");
                String nome = set.getString("nome");
                Carburante carburante = new Carburante(id,nome);
                listaCarburante.add(carburante);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCarburante;
    }
    public String getCarburanteById(Integer id) {
        String nome = null;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from CARBURANTE where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                nome = set.getString("nome");
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }
}
