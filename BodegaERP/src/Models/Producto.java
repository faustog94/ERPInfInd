/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ProductoController;
import Controllers.TipoProductoController;

/**
 *
 * @author franco-lxle
 */
public class Producto {
    private int idProducto;
    private String codProducto;
    private String descripcion;
    private boolean activo;
    private String unidadMedida;
    
    //Relacion con TipoProducto
    private int idTipoProducto;
    private boolean tipoProductoBuscado;
    private TipoProducto tipo;
    
    //Relación con Producto
    private int idProductoBase;
    private boolean productoBaseBuscado;
    private Producto productoBase;

    public Producto(int idProducto, String codProducto, String descripcion, boolean activo, String unidadMedida, int idTipoProducto, int idProductoBase) {
        this.idProducto = idProducto;
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.activo = activo;
        this.unidadMedida = unidadMedida;
        this.idTipoProducto = idTipoProducto;
        this.idProductoBase = idProductoBase;
        this.tipoProductoBuscado = false;
        this.productoBaseBuscado = false;
    }
    
    public Producto(){
        this.tipoProductoBuscado = false;
        this.productoBaseBuscado = false;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
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

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public TipoProducto getTipo() {
        if (this.tipoProductoBuscado == false){
            this.tipo = TipoProductoController.getTipoProductoById(this.idTipoProducto);
            this.tipoProductoBuscado = true;
        }
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public int getIdProductoBase() {
        return idProductoBase;
    }

    public void setIdProductoBase(int idProductoBase) {
        this.idProductoBase = idProductoBase;
    }

    public Producto getProductoBase() {
        if (this.productoBaseBuscado == false){
            this.productoBase = ProductoController.getProductoById(this.idProductoBase);
            this.productoBaseBuscado = true;
        }
        return productoBase;
    }

    public void setProductoBase(Producto productoBase) {
        this.productoBase = productoBase;
    }
    
    
}
