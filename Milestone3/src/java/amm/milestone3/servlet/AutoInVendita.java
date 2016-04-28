/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.servlet;

import amm.milestone3.Auto;
import amm.milestone3.Carburante;
import amm.milestone3.CarburanteFactory;
import amm.milestone3.CategoriaAuto;
import amm.milestone3.CategoriaAutoFactory;
import amm.milestone3.Sessione;
import amm.milestone3.Venditore;
import amm.milestone3.VenditoreFactory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AutoInVendita", urlPatterns = {"/autoinvendita.html"})
public class AutoInVendita extends HttpServlet {

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
        Venditore v = Sessione.getVenditore(request);
        if (v != null) {
            String marca = request.getParameter("marca");
            String modello = request.getParameter("modello");
            Auto auto = new Auto(marca,modello);
            auto.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
            auto.setIdCarburante(Integer.parseInt(request.getParameter("carburante")));
            auto.setDescrizione(request.getParameter("descrizione"));
            auto.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
            
            request.setAttribute("venditore", v);
            request.setAttribute("auto", auto);
            request.getRequestDispatcher("confermaauto.jsp").forward(request, response);
        }
        request.getRequestDispatcher("non_autorizzato.jsp?page=venditore").forward(request, response);
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
