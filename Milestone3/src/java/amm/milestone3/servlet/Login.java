/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.servlet;

import amm.milestone3.Cliente;
import amm.milestone3.Venditore;
import amm.milestone3.ClienteFactory;
import amm.milestone3.VenditoreFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nando
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(true);

        if (request.getParameter("submit") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            List<Cliente> listaClienti = ClienteFactory.getInstance().getClienteList();
            if (listaClienti != null) {
                for (Cliente cliente : listaClienti) {
                    if (cliente.getUsername().equals(username) && cliente.getPassword().equals(password)) {
                        session.setAttribute("userType", "c");
                        session.setAttribute("userId", cliente.getId().toString());
                        request.setAttribute("cliente", cliente);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        return;
                    }
                }
            }
            List<Venditore> listaVenditori = VenditoreFactory.getInstance().getVenditoreList();
            if (listaVenditori != null) {
                for (Venditore venditore : listaVenditori) {
                    if (venditore.getUsername().equals(username) && venditore.getPassword().equals(password)) {
                        session.setAttribute("userType", "v");
                        session.setAttribute("userId", venditore.getId());
                        request.setAttribute("venditore", venditore);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        return;
                    }
                }
            }
            String msg = "Username o password non corretta";
            request.setAttribute("messaggio", msg);
            request.setAttribute("username", username);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
