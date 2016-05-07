/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone;

/**
 *
 * @author Nando
 */
public class CategoriaAuto {
    private Integer id;
    private String categoria;
    private String descrizione;
    
    CategoriaAuto(Integer id, String categoria,String descrizione) {
        this.id = id;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
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
}
