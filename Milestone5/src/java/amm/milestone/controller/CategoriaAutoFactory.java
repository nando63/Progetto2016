/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

import amm.milestone.model.CategoriaAuto;
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
public class CategoriaAutoFactory {
    private static CategoriaAutoFactory caf;
    //static ArrayList<CategoriaAuto> listaCategoriaAuto = null;
    private String connectionString;
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }
    public String getConnectionString() {
        return this.connectionString;
    }
    public static CategoriaAutoFactory getInstance() {
        if (caf == null)
            caf = new CategoriaAutoFactory();
        return caf;
    }
    private CategoriaAutoFactory() {
        /*
        listaCategoriaAuto = new ArrayList<>();
        
        listaCategoriaAuto.add(new CategoriaAuto(1,"Citycar","Un tempo una specialità del tutto italiana e una tipologia di vettura prevalentemente diffusa in Italia, le superutilitarie iniziano a diffondersi globalmente verso gli anni ottanta e novanta fino a essere presenti in quasi tutto il mondo e nei listini di quasi tutte le maggiori case automobilistiche. La vettura racchiude concetti strettamente legati alle esigenze delle città, ovvero ridotte dimensioni e praticità, nonché grande manovrabilità. In Europa le vetture di questo tipo vengono spesso classificate come appartenenti al segmento A, mentre nel mercato nord americano sono quasi del tutto assenti, anche nelle grandi città, salvo esperimenti recenti come la FIAT 500, Smart Fortwo e Mini."));
        listaCategoriaAuto.add(new CategoriaAuto(2,"Berlina","Per berlina si intende la carrozzeria d'autovettura con tetto fisso, generalmente dotata di 4 o 5 porte e principalmente realizzata nelle configurazioni a due, tre o due volumi e mezzo. Il termine berlina indicava, in origine, un particolare tipo di carrozza."));
        listaCategoriaAuto.add(new CategoriaAuto(3,"Coupé","Viene definita coupé la tipologia di auto con carrozzeria chiusa a 2 porte e tetto non rimovibile."));
        */
    }
    public ArrayList<CategoriaAuto> getCategoriaAutoList() {
        ArrayList<CategoriaAuto> listaCategoriaAuto = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from CATEGORIA";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Integer id = set.getInt("id");
                String categoria = set.getString("categoria");
                String descrizione = set.getString("descrizione");
                CategoriaAuto categoriaAuto = new CategoriaAuto(id,categoria,descrizione);
                listaCategoriaAuto.add(categoriaAuto);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategoriaAuto;
    }
    public String getCategoriaAutoById(Integer id) {
        String nome = null;
        try {
            Connection conn = DriverManager.getConnection(connectionString, "pippo", "pippo");
            String sql = "select * from CATEGORIA where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                nome = set.getString("categoria");
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nome;
    }
}
