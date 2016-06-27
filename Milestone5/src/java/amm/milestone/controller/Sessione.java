/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.controller;

import amm.milestone.model.Cliente;
import amm.milestone.model.Venditore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nando
 */
public class Sessione {
    public static Cliente getCliente(HttpServletRequest request) {
        Cliente c = null;
        Integer id = getId(request,"c");
        if (id != null) {
            c = ClienteFactory.getInstance().getClienteById(id);
        }
        return c;
    }
    public static Venditore getVenditore(HttpServletRequest request) {
        Venditore v = null;
        Integer id = getId(request,"v");
        if (id != null) {
            v = VenditoreFactory.getInstance().getVenditoreById(id);
        }
        return v;
    }
    private static Integer getId(HttpServletRequest request,String userTypte) {
        Integer id = null;
        HttpSession session = request.getSession(false);
        if (session != null) {
            String strUserType = (String)session.getAttribute("userType");
            if (strUserType != null && strUserType.equals(userTypte)) {
                id = Integer.parseInt(session.getAttribute("userId").toString());
            }
        }
        return id;
    }
    private Sessione() {}
}
