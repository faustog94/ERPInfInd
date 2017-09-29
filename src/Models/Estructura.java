/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ArticuloController;
import Controllers.ProductoController;

/**
 *
 * @author franco-lxle
 */
public class Estructura {

    private int idEstructura;
    private int cantidad;
    private boolean activo;

    private int idProducto;
    private Producto producto;
    private boolean productoBuscado;

    private int idArticulo;
    private Articulo articulo;
    private boolean articuloBuscado;

    public Estructura() {
        this.productoBuscado = false;
        this.articuloBuscado = false;
    }

    public Estructura(int idEstructura, int cantidad, boolean activo, int idProducto, int idArticulo) {
        this.idEstructura = idEstructura;
        this.cantidad = cantidad;
        this.activo = activo;
        this.idProducto = idProducto;
        this.idArticulo = idArticulo;
        this.productoBuscado = false;
        this.articuloBuscado = false;
    }

    public int getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(int idEstructura) {
        this.idEstructura = idEstructura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        if (this.productoBuscado == false) {
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

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo getArticulo() {
        if (this.articuloBuscado == false) {
            this.articulo = ArticuloController.getArticuloById(this.idArticulo);
            this.articuloBuscado = true;
        }
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public boolean isArticuloBuscado() {
        return articuloBuscado;
    }

    public void setArticuloBuscado(boolean articuloBuscado) {
        this.articuloBuscado = articuloBuscado;
    }

}