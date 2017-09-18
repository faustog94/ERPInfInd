/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.TipoArticuloController;

/**
 *
 * @author franco-lxle
 */


public class Articulo {

    private int idArticulo;
    private String codArticulo;
    private String descripcion;
    private boolean activo;
    private String unidadMedida;
    private int idTipoArticulo;
    private boolean tipoArticuloBuscado;
    private TipoArticulo tipo;

    public Articulo(int idArticulo, String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo) {
        this.idArticulo = idArticulo;
        this.codArticulo = codArticulo;
        this.descripcion = descripcion;
        this.activo = activo;
        this.unidadMedida = unidadMedida;
        this.idTipoArticulo = idTipoArticulo;
        this.tipoArticuloBuscado = false;
    }

    public Articulo() {
        this.tipoArticuloBuscado = false;
    }
    
    public void setTipoArticulo(TipoArticulo tipo){
        this.tipo = tipo;
    }
    
    public TipoArticulo getTipoArticulo(){
        if (this.tipoArticuloBuscado == false){
            this.tipo = TipoArticuloController.getTipoArticuloById(this.idTipoArticulo);
            this.tipoArticuloBuscado = true;
        }
        return tipo;
    }
    
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public TipoArticulo getTipo() {
        return tipo;
    }

    public void setTipo(TipoArticulo tipo) {
        this.tipo = tipo;
    }

    public int getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(int idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }
    
}
