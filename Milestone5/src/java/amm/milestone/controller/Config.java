/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

/**
 *
 * @author Nando
 */
public class Config {
    private static String dbConnection;
    
    private Config() {}
    public static void setConnectionString(String dbConnection) {
        Config.dbConnection = dbConnection;
    }
    public static String getConnectionString() {
        return  dbConnection;
    }
}
