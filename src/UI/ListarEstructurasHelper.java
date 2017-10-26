/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Controllers.EstructuraController;
import Controllers.ProductoController;
import Models.Articulo;
import Models.Estructura;
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class ListarEstructurasHelper {
    HashMap<Integer, Articulo> articulos = new HashMap<Integer, Articulo>();
    
    public ArrayList<Producto> obtenerProductos(){
        return ProductoController.getProductos();
    }
    
    public ArrayList<Estructura> obtenerVersionesEstructura(int idProducto) {
        return EstructuraController.getEstructurasByProducto(idProducto);
    }
    
    public ArrayList<Estructura> obtenerEstructurasVersion(int idProducto, String version) {
        return EstructuraController.getEstructuraByProductoByVersion(idProducto, version);
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
    
    public ArrayList<Estructura> obtenerEstructurasPadre(int idProducto){
        return EstructuraController.getEstructuraActivaByProducto(idProducto);
    }
}
