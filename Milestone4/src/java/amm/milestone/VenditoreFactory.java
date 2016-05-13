/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nando
 */
public class VenditoreFactory {
    private static VenditoreFactory vf;
    static List<Venditore> listaVenditori = null;
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
    }
    public List<Venditore> getVenditoreList() {
        return listaVenditori;
    }
    public Venditore getVenditoreById(Integer id) {
        if (listaVenditori != null && id != null) {
            for (Venditore v : listaVenditori) {
                if (v.getId().equals(id))
                    return v;
            }
        }
        return null;
    }
}
