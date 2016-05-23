/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.servlet;

import amm.milestone.model.Auto;
import amm.milestone.factory.AutoFactory;
import amm.milestone.factory.CarburanteFactory;
import amm.milestone.factory.CategoriaAutoFactory;
import amm.milestone.model.Carburante;
import amm.milestone.model.CategoriaAuto;
import amm.milestone.model.Sessione;
import amm.milestone.model.Venditore;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nando
 */
@WebServlet(name = "FormModifica", urlPatterns = {"/formmodifica.html"})
public class FormModifica extends HttpServlet {

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
        String idAuto = request.getParameter("id");
        if (idAuto != null) {
            Venditore v = Sessione.getVenditore(request);
            if (v != null) {
                Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                request.setAttribute("auto", auto);
                List<CategoriaAuto> listaCatAuto = CategoriaAutoFactory.getInstance().getCategoriaAutoList();
                request.setAttribute("categorieAuto", listaCatAuto);
                List<Carburante> listaCarburanti = CarburanteFactory.getInstance().getCarburanteList();
                request.setAttribute("carburanti", listaCarburanti);
                request.setAttribute("venditore", v);
            }
            else {
                request.setAttribute("messaggio", "Sessione scaduta");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("formmodifica.jsp").forward(request, response);
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
