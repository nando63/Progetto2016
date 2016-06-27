/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.servlet;

import amm.milestone.model.Auto;
import amm.milestone.controller.AutoFactory;
import amm.milestone.model.Cliente;
import amm.milestone.controller.Sessione;
import amm.milestone.controller.Vendita;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nando
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class ClienteServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = Sessione.getCliente(request);
        if (c != null) {
            request.setAttribute("cliente", c);
            String idAuto = request.getParameter("id");
            if (idAuto != null) { // forse la voglio comprare
                Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                request.setAttribute("auto", auto);
                request.getRequestDispatcher("carrello.jsp").forward(request, response);
            }
            else {
                idAuto = request.getParameter("idauto");
                if (idAuto != null) { // la voglio comprare
                    Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                    if (c.getSaldo() >= auto.getPrezzo()) {
                        if (Vendita.vendi(auto,c)) { // c'e' stato un errore nella vendita
                            request.setAttribute("messaggio", "Si e' verificato un errore durante la transazione");
                        }
                        else {
                            // e' stato aggiornato il saldo del cliente
                            request.setAttribute("cliente", c);
                            request.setAttribute("messaggio", "Complimenti, hai appena acquistato una "+auto.getMarca()+" "+auto.getModello());
                        }
                    }
                    else {
                        request.setAttribute("messaggio", "Peccato, non hai abbastanza soldi per comprarti una "+auto.getMarca()+" "+auto.getModello());
                    }
                    // mostro il messaggio
                    request.getRequestDispatcher("confermaacquisto.jsp").forward(request, response);
                }
                else { // lista auto in vendita
                    ArrayList<Auto> listaAuto = AutoFactory.getInstance().getAutoInVendita();
                    request.setAttribute("listAuto", listaAuto);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            }
        }
        else {
            request.getRequestDispatcher("nonautorizzato.jsp?tipo=c").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
