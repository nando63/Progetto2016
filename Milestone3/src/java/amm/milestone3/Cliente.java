/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3;

/**
 *
 * @author Nando
 */
public class Cliente extends Utente {
    private Saldo saldo;

    /**
     * @return the saldo
     */
    public Integer getSaldo() {
        return saldo.getSaldo().intValue();
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = new Saldo(saldo);
    }
}
