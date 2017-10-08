/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ProductoController;

/**
 *
 * @author franco-lxle
 */
public class RutaFabricacion {
    private int idRuta;
    private boolean activa;
    private String version;
    private String vigenteDesde;
    
    private int idProducto;
    private Producto producto;
    private boolean productoBuscado;

    public RutaFabricacion() {
        this.productoBuscado = false;
    }

    public RutaFabricacion(int idRuta, boolean activa, String version, String vigenteDesde, int idProducto) {
        this.idRuta = idRuta;
        this.activa = activa;
        this.version = version;
        this.vigenteDesde = vigenteDesde;
        this.idProducto = idProducto;
        this.productoBuscado = false;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVigenteDesde() {
        return vigenteDesde;
    }

    public void setVigenteDesde(String vigenteDesde) {
        this.vigenteDesde = vigenteDesde;
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
    
    
}
