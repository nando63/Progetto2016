/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.servlet;

import amm.milestone.controller.AutoFactory;
import amm.milestone.model.Carburante;
import amm.milestone.controller.CarburanteFactory;
import amm.milestone.model.CategoriaAuto;
import amm.milestone.controller.CategoriaAutoFactory;
import amm.milestone.controller.Sessione;
import amm.milestone.model.Auto;
import amm.milestone.model.Venditore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class VenditoreServlet extends HttpServlet {

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
            request.setAttribute("venditore", v);
            if (request.getParameter("azione") != null) {
                String azione = request.getParameter("azione");
                if (azione.equals("Modifica")) {
                    String msg = "";
                    String marca = request.getParameter("marca");
                    String modello = request.getParameter("modello");
                    String categoria = request.getParameter("categoria");
                    String carburante = request.getParameter("carburante");
                    String prezzo = request.getParameter("prezzo");
                    String anno = request.getParameter("anno");
                    String targa = request.getParameter("targa");

                    Auto auto = new Auto(marca,modello);
                    auto.setId(Integer.parseInt(request.getParameter("id")));
                    auto.setIdProprietario(v.getId());
                    auto.setDescrizione(request.getParameter("descrizione"));
                    auto.setImage(request.getParameter("image"));
                    if (prezzo != null && prezzo.length() > 0)
                        auto.setPrezzo(Integer.parseInt(prezzo));
                    if (anno != null && anno.length() > 0)
                        auto.setAnnoImmatricolazione(Integer.parseInt(anno));
                    if (marca != null && marca.length() == 0)
                        msg = "Devi inserire la marca";
                    if (modello == null || modello.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi inserire il modello";
                    }
                    if (categoria == null || categoria.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare la categoria dell'auto";
                    }
                    else
                        auto.setIdCategoria(Integer.parseInt(categoria));
                    if (carburante == null || carburante.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare il carburante utilizzato";
                    }
                    else
                        auto.setIdCarburante(Integer.parseInt(carburante));
                    if (targa == null || targa.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare la targa";
                    }
                    else
                        auto.setTarga(targa);
                    request.setAttribute("auto", auto);
                    if (msg.equals("")){
                        AutoFactory.getInstance().updateAuto(auto);
                        listaAutoVenditore(v,request,response);
                    }
                    else {
                        request.setAttribute("messaggio", msg);
                        List<CategoriaAuto> listaCatAuto = CategoriaAutoFactory.getInstance().getCategoriaAutoList();
                        request.setAttribute("categorieAuto", listaCatAuto);
                        List<Carburante> listaCarburanti = CarburanteFactory.getInstance().getCarburanteList();
                        request.setAttribute("carburanti", listaCarburanti);
                        request.getRequestDispatcher("formmodifica.jsp").forward(request, response);
                    }
                }
                else if (azione.equals("Elimina")) {
                    String idAuto = request.getParameter("idauto");
                    if (idAuto != null) {
                        AutoFactory.getInstance().deleteAuto(Integer.parseInt(idAuto));
                    }
                    listaAutoVenditore(v,request,response);
                }
                else if (azione.equals("Inserisci")) {
                    String msg = "";
                    String marca = request.getParameter("marca");
                    String modello = request.getParameter("modello");
                    String categoria = request.getParameter("categoria");
                    String carburante = request.getParameter("carburante");
                    String prezzo = request.getParameter("prezzo");
                    String anno = request.getParameter("anno");
                    String targa = request.getParameter("targa");

                    Auto auto = new Auto(marca,modello);
                    auto.setIdProprietario(v.getId());
                    auto.setDescrizione(request.getParameter("descrizione"));
                    auto.setImage(request.getParameter("image"));
                    if (prezzo != null && prezzo.length() > 0)
                        auto.setPrezzo(Integer.parseInt(prezzo));
                    if (anno != null && anno.length() > 0)
                        auto.setAnnoImmatricolazione(Integer.parseInt(anno));
                    if (marca != null && marca.length() == 0)
                        msg = "Devi inserire la marca";
                    if (modello == null || modello.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi inserire il modello";
                    }
                    if (categoria == null || categoria.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare la categoria dell'auto";
                    }
                    else
                        auto.setIdCategoria(Integer.parseInt(categoria));
                    if (carburante == null || carburante.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare il carburante utilizzato";
                    }
                    else
                        auto.setIdCarburante(Integer.parseInt(carburante));
                    if (targa == null || targa.length() == 0) {
                        if (!msg.equals("")) msg += "<br/>";
                        msg += "Devi indicare la targa";
                    }
                    else
                        auto.setTarga(targa);
                    request.setAttribute("venditore", v);
                    request.setAttribute("auto", auto);
                    if (msg.equals("")) {
                        AutoFactory.getInstance().insertAuto(auto);
                        request.getRequestDispatcher("confermavendita.jsp").forward(request, response);
                    }
                    else {
                        request.setAttribute("messaggio", msg);
                        List<CategoriaAuto> listaCatAuto = CategoriaAutoFactory.getInstance().getCategoriaAutoList();
                        request.setAttribute("categorieAuto", listaCatAuto);
                        List<Carburante> listaCarburanti = CarburanteFactory.getInstance().getCarburanteList();
                        request.setAttribute("carburanti", listaCarburanti);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                }
                else {
                    listaAutoVenditore(v,request,response);
                }
            }
            else if (request.getParameter("mod") != null) {
                // form modifica auto
                String idAuto = request.getParameter("mod");
                Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                request.setAttribute("auto", auto);
                List<CategoriaAuto> listaCatAuto = CategoriaAutoFactory.getInstance().getCategoriaAutoList();
                request.setAttribute("categorieAuto", listaCatAuto);
                List<Carburante> listaCarburanti = CarburanteFactory.getInstance().getCarburanteList();
                request.setAttribute("carburanti", listaCarburanti);
                request.getRequestDispatcher("formmodifica.jsp").forward(request, response);
            }
            else if (request.getParameter("del") != null) {
                // form per cancellazione auto
                String idAuto = request.getParameter("del");
                Auto auto = AutoFactory.getInstance().getAutoById(Integer.parseInt(idAuto));
                request.setAttribute("auto", auto);
                request.getRequestDispatcher("formcancellazione.jsp").forward(request, response);
            }
            else if (request.getParameter("new") != null) {
                // form per inserimento nuova auto
                ArrayList<CategoriaAuto> listCategorieAuto = CategoriaAutoFactory.getInstance().getCategoriaAutoList();
                ArrayList<Carburante> listCarburanti = CarburanteFactory.getInstance().getCarburanteList();

                request.setAttribute("categorieAuto", listCategorieAuto);
                request.setAttribute("carburanti", listCarburanti);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            else {
                listaAutoVenditore(v,request,response);
            }
        }
        else {
            request.getRequestDispatcher("nonautorizzato.jsp?tipo=v").forward(request, response);
        }
    }
    void listaAutoVenditore(Venditore v, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Auto> listaAuto = AutoFactory.getInstance().getAutoProprietario(v.getId());
        request.setAttribute("listAuto", listaAuto);
        request.getRequestDispatcher("listaautovenditore.jsp").forward(request, response);
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
