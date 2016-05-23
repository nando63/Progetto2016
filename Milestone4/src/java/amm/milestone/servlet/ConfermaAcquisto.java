/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.servlet;

import amm.milestone.model.Auto;
import amm.milestone.factory.AutoFactory;
import amm.milestone.model.Cliente;
import amm.milestone.model.Sessione;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ConfermaAcquisto", urlPatterns = {"/confermaacquisto.html"})
public class ConfermaAcquisto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idAuto = request.getParameter("idauto");
        if (idAuto != null) {
            Cliente c = Sessione.getCliente(request);
            if (c != null) {
                Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                request.setAttribute("auto", auto);
                request.setAttribute("cliente", c);
                if (c.getSaldo() >= auto.getPrezzo()) {
                    if (!AutoFactory.getInstance().vendiAuto(auto,c)) {
                        Logger.getLogger(AutoFactory.class.getName()).log(Level.SEVERE, c.getNome());
                        request.getRequestDispatcher("cliente.html").forward(request, response);
                        return;
                    }
                }
            }
        }
        request.getRequestDispatcher("confermaacquisto.jsp").forward(request, response);
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
