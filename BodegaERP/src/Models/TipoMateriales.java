/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author franco-lxle
 */
public class TipoMateriales {
    private int idTipoMateriales;
    private String descripcion;

    public TipoMateriales() {
    }

    public TipoMateriales(int idTipoMateriales, String descripcion) {
        this.idTipoMateriales = idTipoMateriales;
        this.descripcion = descripcion;
    }

    public int getIdTipoMateriales() {
        return idTipoMateriales;
    }

    public void setIdTipoMateriales(int idTipoMateriales) {
        this.idTipoMateriales = idTipoMateriales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
