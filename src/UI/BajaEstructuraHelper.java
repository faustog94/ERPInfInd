/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Controllers.DetalleOrdenProdController;
import Controllers.EstructuraController;
import Controllers.ProductoController;
import Models.Articulo;
import Models.Estructura;
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco-deb
 */
public class BajaEstructuraHelper {

    HashMap<Integer, Articulo> articulos = new HashMap<Integer, Articulo>();

    public boolean codigoExiste(String codProducto) {
        return ProductoController.productoExisteByCod(codProducto);
    }

    public Producto buscarProducto(String cod) {
        return ProductoController.getProductoByCod(cod);
    }

    public ArrayList<Estructura> obtenerVersionesEstructura(int idProducto) {
        return EstructuraController.getEstructuraActivaByProducto(idProducto);
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

    public boolean tieneOrdenesPendientes(int idProducto) {
        return DetalleOrdenProdController.prodTieneOrdenActiva(idProducto);
    }
    
    public void bajaEstructura(int idEstructura){
        EstructuraController.bajaEstructuraIndividual(idEstructura);
    }
}
