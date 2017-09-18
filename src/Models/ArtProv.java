/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ArticuloController;
import Controllers.ProveedorController;

/**
 *
 * @author franco-lxle
 */
public class ArtProv {
    private int idArtProv;
    private String descripcion;
    
    //Relaciones
    private int idProveedor;
    private boolean proveedorBuscado;
    private Proveedor proveedor;

    private int idArticulo;
    private boolean articuloBuscado;
    private Articulo articulo;
    
    public ArtProv() {
        this.proveedorBuscado = false;
        this.articuloBuscado = false;
    }

    public ArtProv(int idArtProv, String descripcion, int idProveedor, int idArticulo) {
        this.idArtProv = idArtProv;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
        this.idArticulo = idArticulo;
        this.proveedorBuscado = false;
        this.articuloBuscado = false;
    }

    public int getIdArtProv() {
        return idArtProv;
    }

    public void setIdArtProv(int idArtProv) {
        this.idArtProv = idArtProv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor getProveedor() {
        if (proveedorBuscado == false){
            this.proveedor = ProveedorController.getProveedorById(idProveedor);
            this.proveedorBuscado = true;
        }
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo getArticulo() {
        if (articuloBuscado == false){
            articulo = ArticuloController.getArticuloById(idArticulo);
            articuloBuscado = false;
        }
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
    
    
}
