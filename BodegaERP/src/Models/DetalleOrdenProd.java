/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.OrdenProduccionController;
import Controllers.ProductoController;

/**
 *
 * @author franco-lxle
 */
public class DetalleOrdenProd {
    private int idDetalleOrden;
    private int cantidad;
    
    private int idProducto;
    private Producto producto;
    private boolean productoBuscado;
    
    private int idOrdenProduccion;
    private OrdenProduccion orden;
    private boolean ordenBuscado;

    public DetalleOrdenProd() {
        this.productoBuscado = false;
        this.ordenBuscado = false;
    }

    public DetalleOrdenProd(int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion) {
        this.idDetalleOrden = idDetalleOrden;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idOrdenProduccion = idOrdenProduccion;
        this.productoBuscado = false;
        this.ordenBuscado = false;
    }

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        if (this.productoBuscado == false){
            this.producto = ProductoController.getProductoById(this.idProducto);
            this.productoBuscado = true;
        }
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isProductoBuscado() {
        return productoBuscado;
    }

    public void setProductoBuscado(boolean productoBuscado) {
        this.productoBuscado = productoBuscado;
    }

    public int getIdOrdenProduccion() {
        return idOrdenProduccion;
    }

    public void setIdOrdenProduccion(int idOrdenProduccion) {
        this.idOrdenProduccion = idOrdenProduccion;
    }

    public OrdenProduccion getOrden() {
        if (this.ordenBuscado == false){
            this.orden = OrdenProduccionController.getOrdenProduccionById(this.idOrdenProduccion);
            this.ordenBuscado = true;
        }
        return orden;
    }

    public void setOrden(OrdenProduccion orden) {
        this.orden = orden;
    }

    public boolean isOrdenBuscado() {
        return ordenBuscado;
    }

    public void setOrdenBuscado(boolean ordenBuscado) {
        this.ordenBuscado = ordenBuscado;
    }
    
    
}
