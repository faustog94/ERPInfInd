/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.ArticuloController;
import Controllers.DetalleRutaController;
import Controllers.TipoMaterialesController;

/**
 *
 * @author franco-lxle
 */
public class Materiales {
    private int idMateriales;
    private int cantidad;
    
    //Puntero DetalleRuta
    private int idDetalleRuta;
    private DetalleRuta detruta;
    private boolean detalleBuscado;
    //Puntero Articulo
    private int idArticulo;
    private Articulo articulo;
    private boolean articuloBuscado;
    //Puntero TipoMateriales
    private int idTipoMateriales;
    private TipoMateriales tipo;
    private boolean tipoBuscado;

    public Materiales() {
        this.detalleBuscado = false;
        this.articuloBuscado = false;
        this.tipoBuscado = false;
    }

    public Materiales(int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales) {
        this.idMateriales = idMateriales;
        this.cantidad = cantidad;
        this.idDetalleRuta = idDetalleRuta;
        this.idArticulo = idArticulo;
        this.idTipoMateriales = idTipoMateriales;
        this.detalleBuscado = false;
        this.articuloBuscado = false;
        this.tipoBuscado = false;
    }

    public int getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(int idMateriales) {
        this.idMateriales = idMateriales;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdDetalleRuta() {
        return idDetalleRuta;
    }

    public void setIdDetalleRuta(int idDetalleRuta) {
        this.idDetalleRuta = idDetalleRuta;
    }

    public DetalleRuta getDetruta() {
        if (this.detalleBuscado == false){
            this.detruta = DetalleRutaController.getDetalleRutaById(idDetalleRuta);
            this.detalleBuscado = true;
        }
        return detruta;
    }

    public void setDetruta(DetalleRuta detruta) {
        this.detruta = detruta;
    }

    public boolean isDetalleBuscado() {
        return detalleBuscado;
    }

    public void setDetalleBuscado(boolean detalleBuscado) {
        this.detalleBuscado = detalleBuscado;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo getArticulo() {
        if (this.articuloBuscado == false){
            this.articulo = ArticuloController.getArticuloById(idArticulo);
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

    public int getIdTipoMateriales() {
        return idTipoMateriales;
    }

    public void setIdTipoMateriales(int idTipoMateriales) {
        this.idTipoMateriales = idTipoMateriales;
    }

    public TipoMateriales getTipo() {
        if (this.tipoBuscado == false){
            this.tipo = TipoMaterialesController.getTipoMaterialesById(idTipoMateriales);
            this.tipoBuscado = true;
        }
        return tipo;
    }

    public void setTipo(TipoMateriales tipo) {
        this.tipo = tipo;
    }

    public boolean isTipoBuscado() {
        return tipoBuscado;
    }

    public void setTipoBuscado(boolean tipoBuscado) {
        this.tipoBuscado = tipoBuscado;
    }
    
    
    
}
