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
public class ClienteFactory {
    private static ClienteFactory cf;
    private static ArrayList<Cliente> listaClienti = null;

    public static ClienteFactory getInstance() {
        if (cf == null) {
            cf = new ClienteFactory();
        }
        return cf;
    }
        
    private ClienteFactory() {
        listaClienti = new ArrayList<>();

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("Mauro");
        cliente1.setCognome("Pili");
        cliente1.setCodiceFiscale("GGHWWT83G32H645G");
        cliente1.setUsername("cli1");
        cliente1.setPassword("pwd1");
        cliente1.setSaldo(5000.0);
        listaClienti.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNome("Gianni");
        cliente2.setCognome("Fenu");
        cliente2.setCodiceFiscale("FNEGNN62A11B354O");
        cliente2.setUsername("cli2");
        cliente2.setPassword("pwd2");
        cliente2.setSaldo(15000.0);
        listaClienti.add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNome("Alberto");
        cliente3.setCognome("Atzori");
        cliente3.setCodiceFiscale("TZRABR77G01T555H");
        cliente3.setUsername("cli3");
        cliente3.setPassword("pwd3");
        cliente3.setSaldo(7500.0);
        listaClienti.add(cliente3);
    }
    public ArrayList<Cliente> getClienteList() {
        return listaClienti;
    }
    public Cliente getClienteById(Integer id) {
        if (listaClienti != null && id != null) {
            for (Cliente c : listaClienti) {
                if (c.getId().equals(id))
                    return c;
            }
        }
        return null;
    }
}
