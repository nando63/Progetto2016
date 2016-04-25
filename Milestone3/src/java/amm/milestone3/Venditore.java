/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

import java.util.List;

/**
 *
 * @author Nando
 */
public class Venditore extends Utente {
    private List<Integer> idAutoInVendita;
    /**
     * @return the idAutoInVendita
     */
    public List<Integer> getIdAutoInVendita() {
        return idAutoInVendita;
    }

    /**
     * @param idAutoInVendita the idAutoInVendita to set
     */
    public void setIdAutoInVendita(List<Integer> idAutoInVendita) {
        this.idAutoInVendita = idAutoInVendita;
    }

}
