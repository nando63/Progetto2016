/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nando
 */
public class AutoFactory {
    private static AutoFactory af;
    static ArrayList<Auto> listaAuto = null;
    
    public static AutoFactory getInstance() {
        if (af == null)
            af = new AutoFactory();
        return af;
    }
    private AutoFactory() {
        listaAuto = new ArrayList<>();
        Auto auto = null;

        auto = new Auto(1,"FIAT","Panda");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoFabbricazione(1995);
        auto.setTarga("GF635FD");
        auto.setDescrizione("Modello semi nuovo");
        listaAuto.add(auto);

        auto = new Auto(2,"Renault","Twingo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoFabbricazione(2001);
        auto.setTarga("TT636HH");
        auto.setDescrizione("Incidentata");
        listaAuto.add(auto);

        auto = new Auto(3,"Opel","Aygo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(1);
        auto.setAnnoFabbricazione(2011);
        auto.setTarga("GT453DD");
        auto.setDescrizione("Nuova");
        listaAuto.add(auto);

        auto = new Auto(4,"Fiat","Panda");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoFabbricazione(1999);
        auto.setTarga("AA998GB");
        auto.setDescrizione("Molto vecchia");
        listaAuto.add(auto);

        auto = new Auto(5,"Renault","Twingo");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoFabbricazione(2003);
        auto.setTarga("AF884HH");
        auto.setDescrizione("Occasione");
        listaAuto.add(auto);

        auto = new Auto(6,"Renault","Clio");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoFabbricazione(2004);
        auto.setTarga("BA998LL");
        auto.setDescrizione("Di terza mano");
        listaAuto.add(auto);

        auto = new Auto(7,"Opel","Adam");
        auto.setIdCategoria(1);
        auto.setIdCarburante(2);
        auto.setAnnoFabbricazione(2011);
        auto.setTarga("EA888JU");
        auto.setDescrizione("Chilometri zero");
        listaAuto.add(auto);

        auto = new Auto(8,"Chevrolet","Matiz");
        auto.setIdCategoria(1);
        auto.setIdCarburante(3);
        auto.setAnnoFabbricazione(2006);
        auto.setTarga("CZ897HL");
        auto.setDescrizione("Con fendinebbia");
        listaAuto.add(auto);

        auto = new Auto(9,"Peugeot","106");
        auto.setIdCategoria(1);
        auto.setIdCarburante(3);
        auto.setAnnoFabbricazione(2000);
        auto.setTarga("BN804EG");
        auto.setDescrizione("Cambio automatico");
        listaAuto.add(auto);

        auto = new Auto(10,"Fiat","500");
        auto.setIdCategoria(2);
        auto.setIdCarburante(1);
        auto.setAnnoFabbricazione(2012);
        auto.setTarga("EE777FR");
        auto.setDescrizione("Piccola");
        listaAuto.add(auto);

        auto = new Auto(11,"Renault","Clio");
        auto.setIdCategoria(2);
        auto.setIdCarburante(1);
        auto.setAnnoFabbricazione(2010);
        auto.setTarga("DE536GG");
        auto.setDescrizione("Tetto apribile");
        listaAuto.add(auto);

        auto = new Auto(12,"Volkswagen","Polo");
        auto.setIdCategoria(2);
        auto.setIdCarburante(2);
        auto.setAnnoFabbricazione(2014);
        auto.setTarga("ER432TK");
        auto.setDescrizione("Bicolore");
        listaAuto.add(auto);

        auto = new Auto(13,"Peugeot","407");
        auto.setIdCategoria(2);
        auto.setIdCarburante(3);
        auto.setAnnoFabbricazione(2015);
        auto.setTarga("FA378JJ");
        auto.setDescrizione("Da rottamare");
        listaAuto.add(auto);

        auto = new Auto(14,"Citroen","C2");
        auto.setIdCategoria(2);
        auto.setIdCarburante(3);
        auto.setAnnoFabbricazione(2011);
        auto.setTarga("CD436HH");
        auto.setDescrizione("Cerchi in lega");
        listaAuto.add(auto);
    }
    public ArrayList<Auto> getAutoList() {
        return listaAuto;
    }
    public Auto getAutoById(Integer id) {
        if (listaAuto != null && id != null) {
            for (Auto a : listaAuto) {
                if (a.getId().equals(id))
                    return a;
            }
        }
        return null;
    }
    public ArrayList<Auto> getAutoListByCategoria(Integer idCategoria) {
        ArrayList<Auto> al = new ArrayList<>();
        for (Auto a : listaAuto) {
            if (a.getIdCategoria().equals(idCategoria))
                al.add(a);
        }
        return al;
    }
    public ArrayList<Auto> getAutoListByCarburante(Integer idCarburante) {
        ArrayList<Auto> al = new ArrayList<>();
        for (Auto a : listaAuto) {
            if (a.getIdCarburante().equals(idCarburante))
                al.add(a);
        }
        return al;
    }
}
