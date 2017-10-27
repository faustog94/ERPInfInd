/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Controllers.CentroTrabajoController;
import Controllers.DetalleRutaController;
import Controllers.EstructuraController;
import Controllers.MaterialesController;
import Controllers.ProductoController;
import Controllers.RutaFabricacionController;
import Models.Articulo;
import Models.CentroTrabajo;
import Models.Estructura;
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class AltaRutaFabHelper {

    HashMap<Integer, Estructura> estructuras = new HashMap<Integer, Estructura>();
    HashMap<Integer, Articulo> articulos = new HashMap<Integer, Articulo>();

    public boolean codigoExiste(String codProducto) {
        return ProductoController.productoExisteByCod(codProducto);
    }

    public Producto buscarProducto(String cod) {
        return ProductoController.getProductoByCod(cod);
    }

    public ArrayList<Estructura> obtenerVersionesEstructura(int idProducto) {
        return EstructuraController.getEstructurasByProducto(idProducto);
    }

    public ArrayList<String> buscarVersiones(int idProducto) {
        ArrayList<Estructura> estrAL = EstructuraController.getEstructuraActivaByProducto(idProducto);
        ArrayList<String> versiones = new ArrayList();
        for (Estructura estr : estrAL) {
            estructuras.put(estr.getIdEstructura(), estr);
            if (!versiones.contains(estr.getVersion())) {
                versiones.add(estr.getVersion());
            }
        }
        return versiones;
    }

    public ArrayList<Estructura> obtenerEstructurasVersion(int idProducto, String version) {
        ArrayList<Estructura> estr = EstructuraController.getEstructuraByProductoByVersion(idProducto, version);
        for (Estructura est : estr) {
            estructuras.put(est.getIdEstructura(), est);
        }
        return estr;
    }

    public ArrayList<Estructura> obtenerEstructurasActivas(int idProducto) {
        ArrayList<Estructura> estr = EstructuraController.getEstructuraActivaByProducto(idProducto);
        for (Estructura est : estr) {
            estructuras.put(est.getIdEstructura(), est);
        }
        return estr;
    }

    public ArrayList<CentroTrabajo> obtenerCentrosTrabajo() {
        return CentroTrabajoController.getCentrosActivos();
    }

    public String obtenerArt(int idArticulo) {
        Articulo art;
        if (articulos.containsKey(idArticulo)) {
            art = articulos.get(idArticulo);
        } else {
            art = ArticuloController.getArticuloById(idArticulo);
            articulos.put(art.getIdArticulo(), art);
        }
        return art.getCodArticulo() + " - " + art.getDescripcion();
    }
    
    public String obtenerDescCentro(int idCentro){
        CentroTrabajo centro = CentroTrabajoController.getCentroById(idCentro);
        return centro.getCodCentro() + " - " + centro.getDescripcion();
    }
    
    public void altaRutaFab(boolean activa, String version, String vigenteDesde, int idProducto){
        RutaFabricacionController.altaRutaFabricacion(activa, version, vigenteDesde, idProducto);
    }

    public int obtenerUltimoIdRuta() {
        return RutaFabricacionController.getLastInsertedId();
    }
    
    public void altaDetalleRuta(int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro){
        DetalleRutaController.altaDetalleRuta(orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro);
    }
    
    public int obtenerUltimoIdDetalleRuta(){
        return DetalleRutaController.getLastInsertedId();
    }
    
    public void altaMateriales(int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales){
        MaterialesController.altaMateriales(cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
    }
}
