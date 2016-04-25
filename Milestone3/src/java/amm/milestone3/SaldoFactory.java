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
public class SaldoFactory {
    static List<Saldo> listaSaldi = null;
    private void SaldoFactory() {}

    public List getInstance() {
        if (listaSaldi == null) {
            listaSaldi = new ArrayList<>();
        
            Saldo saldo1 = new Saldo();
            saldo1.setId(1);
            saldo1.setSaldo(10.56);
            listaSaldi.add(saldo1);

            Saldo saldo2 = new Saldo();
            saldo2.setId(2);
            saldo2.setSaldo(120.15);
            listaSaldi.add(saldo2);

            Saldo saldo3 = new Saldo();
            saldo3.setId(3);
            saldo3.setSaldo(345.00);
            listaSaldi.add(saldo3);
        }
        return listaSaldi;
    }
    public List<Saldo> getSaldoList() {
        return listaSaldi;
    }
    public Saldo getSaldoFromId(Integer id) {
        if (listaSaldi != null && id != null) {
            for (Saldo s : listaSaldi) {
                if (s.getId().equals(id))
                    return s;
            }
        }
        return null;
    }
}
