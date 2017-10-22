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
public class EstadoOrdenProduccion {
    private int idEstOP;
    private String descripcion;

    public EstadoOrdenProduccion() {
    }

    public EstadoOrdenProduccion(int idEstOP, String descripcion) {
        this.idEstOP = idEstOP;
        this.descripcion = descripcion;
    }

    public int getIdEstOP() {
        return idEstOP;
    }

    public void setIdEstOP(int idEstOP) {
        this.idEstOP = idEstOP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
