/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone.model;

import amm.milestone.controller.CategoriaAutoFactory;
import amm.milestone.controller.CarburanteFactory;

/**
 *
 * @author Nando
 */
public class Auto {
    private Integer id;
    private Integer idCategoria;
    private String marca;
    private String modello;
    private Integer annoImmatricolazione;
    private String targa;
    private Integer idCarburante;
    private String descrizione;
    private Integer prezzo;
    private String image;
    private Integer idProprietario;
    
    public Auto() {
        this.id = -1; // momentaneamente messo a -1
        this.marca = null;
        this.modello = null;
    }
    public Auto(Integer id, String marca, String modello) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
    }
    public Auto(String marca, String modello) {
        this.id = -1; // momentaneamente messo a -1
        this.marca = marca;
        this.modello = modello;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modello
     */
    public String getModello() {
        return modello;
    }

    /**
     * @param modello the modello to set
     */
    public void setModello(String modello) {
        this.modello = modello;
    }

    /**
     * @return the annoImmatricolazione
     */
    public Integer getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    /**
     * @param annoFabbricazione the annoImmatricolazione to set
     */
    public void setAnnoImmatricolazione(Integer annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    /**
     * @return the targa
     */
    public String getTarga() {
        return targa;
    }

    /**
     * @param targa the targa to set
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    /**
     * @return the idCarburante
     */
    public Integer getIdCarburante() {
        return idCarburante;
    }

    /**
     * @return the Carburante
     */
    public String getCarburante() {
        return CarburanteFactory.getInstance().getCarburanteById(idCarburante);
    }

    /**
     * @param carburante the carburante to set
     */
    public void setIdCarburante(Integer idCarburante) {
        this.idCarburante = idCarburante;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return (idCategoria);
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return CategoriaAutoFactory.getInstance().getCategoriaAutoById(idCategoria);
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the prezzo
     */
    public Integer getPrezzo() {
        return prezzo;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the idProprietario
     */
    public Integer getIdProprietario() {
        return idProprietario;
    }

    /**
     * @param idProprietario the idProprietario to set
     */
    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }
    
    
}
