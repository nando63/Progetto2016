/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone;

import java.util.ArrayList;

/**
 *
 * @author Nando
 */
public class CarburanteFactory {
    private static CarburanteFactory cf;
    static ArrayList<Carburante> listaCarburante = null;
    
    public static CarburanteFactory getInstance() {
        if (cf == null)
            cf = new CarburanteFactory();
        return cf;
    }
    private CarburanteFactory() {
        listaCarburante = new ArrayList<>();
        
        listaCarburante.add(new Carburante(1,"Benzina"));
        listaCarburante.add(new Carburante(2,"Diesel"));
        listaCarburante.add(new Carburante(3,"Gpl"));
    }
    public ArrayList<Carburante> getCarburanteList() {
        return listaCarburante;
    }
    public String getCarburanteById(Integer id) {
        if (listaCarburante != null && id != null) {
            for (Carburante c : listaCarburante) {
                if (c.getId().equals(id))
                    return c.getNome();
            }
        }
        return null;
    }
}
