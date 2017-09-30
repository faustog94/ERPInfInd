/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.EstadoOrdenProduccionController;

/**
 *
 * @author franco-lxle
 */
public class OrdenProduccion {
    private int idOrdenProduccion;
    private String fechaPedido;
    
    private int idEstOP;
    private EstadoOrdenProduccion estado;
    private boolean estadoBuscado;

    public OrdenProduccion() {
    }

    public OrdenProduccion(int idOrdenProduccion, String fechaPedido, int idEstOP) {
        this.idOrdenProduccion = idOrdenProduccion;
        this.fechaPedido = fechaPedido;
        this.idEstOP = idEstOP;
        this.estadoBuscado = false;
    }

    public int getIdOrdenProduccion() {
        return idOrdenProduccion;
    }

    public void setIdOrdenProduccion(int idOrdenProduccion) {
        this.idOrdenProduccion = idOrdenProduccion;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getIdEstOP() {
        return idEstOP;
    }

    public void setIdEstOP(int idEstOP) {
        this.idEstOP = idEstOP;
    }

    public EstadoOrdenProduccion getEstado() {
        if (this.estadoBuscado == false){
            this.estado = EstadoOrdenProduccionController.getEstadoOrdenProduccionById(idEstOP);
            this.estadoBuscado = true;
        }
        return estado;
    }

    public void setEstado(EstadoOrdenProduccion estado) {
        this.estado = estado;
    }

    public boolean isEstadoBuscado() {
        return estadoBuscado;
    }

    public void setEstadoBuscado(boolean estadoBuscado) {
        this.estadoBuscado = estadoBuscado;
    }
    
    
}
