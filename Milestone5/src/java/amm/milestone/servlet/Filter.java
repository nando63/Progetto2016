/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.servlet;

import amm.milestone.factory.AutoFactory;
import amm.milestone.model.Auto;
import amm.milestone.model.Cliente;
import amm.milestone.model.Sessione;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nando
 */
@WebServlet(name = "Filter", urlPatterns = {"/filter.json"})
public class Filter extends HttpServlet {

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
        response.setContentType("application/json");
        response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        Cliente c = Sessione.getCliente(request);
        if (c != null) {
            String q = request.getParameter("q");
            ArrayList<Auto> listaAuto = AutoFactory.getInstance().filtraAutoInVendita(q);
            request.setAttribute("listaAuto", listaAuto);
            request.getRequestDispatcher("listaautojson.jsp").forward(request, response);
            /*
            try (PrintWriter out = response.getWriter()) {
                String q = request.getParameter("q");
                ArrayList<Auto> listaAuto = AutoFactory.getInstance().filtraAutoInVendita(q);
                Logger.getLogger(Filter.class.getName()).log(Level.INFO, listaAuto.toString());

                JsonArrayBuilder jsonArray = Json.createArrayBuilder();
                for (Auto auto : listaAuto) {
                    JsonObjectBuilder jsonObj = Json.createObjectBuilder();
                    jsonObj.add("id",auto.getId());
                    jsonObj.add("marca",auto.getMarca());
                    jsonObj.add("modello",auto.getModello());
                    jsonObj.add("carburante_id",auto.getIdCarburante());
                    jsonObj.add("categoria_id",auto.getIdCategoria());
                    jsonObj.add("proprietario_id",auto.getIdProprietario());
                    jsonObj.add("descrizione",auto.getDescrizione());
                    jsonObj.add("targa",auto.getTarga());
                    String image = auto.getImage();
                    if (image != null)
                        jsonObj.add("image",image);
                    jsonObj.add("prezzo",auto.getPrezzo());
                    jsonObj.add("anno_immatricolazione",auto.getAnnoImmatricolazione());
                    jsonArray.add(jsonObj);
                }
                JsonArray value = jsonArray.build();
                out.write(value.toString());
            }
            */
        }
        else {
            // non fa nulla
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
