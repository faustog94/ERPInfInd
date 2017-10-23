/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.EstructuraController;
import Controllers.ProductoController;
import Controllers.RutaFabricacionController;
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class ListarProductoHelper {

    HashMap<Integer, Boolean> tieneRuta = new HashMap<Integer, Boolean>();
    HashMap<Integer, Boolean> tieneEstructura = new HashMap<Integer, Boolean>();
    HashMap<Integer, Producto> productos = new HashMap<Integer, Producto>();

    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> prodAL = ProductoController.getProductos();
        for (Producto prod : prodAL) {
            productos.put(prod.getIdProducto(), prod);
        }
        return prodAL;
    }

    public boolean tieneRuta(int idProducto) {
        if (tieneRuta.containsKey(idProducto)) {
            return tieneRuta.get(idProducto);
        } else {
            boolean tiene = RutaFabricacionController.productoTieneRuta(idProducto);
            tieneRuta.put(idProducto, tiene);
            return tiene;
        }
    }

    public boolean tieneEstructura(int idProducto) {
        if (tieneEstructura.containsKey(idProducto)) {
            return tieneEstructura.get(idProducto);
        } else {
            boolean tiene = EstructuraController.productoTieneEstructura(idProducto);
            tieneEstructura.put(idProducto, tiene);
            return tiene;
        }
    }

    public String obtenerDescTipo(int idTipoProducto) {
        switch (idTipoProducto) {
            case 1:
                return "Producto base";
            case 2:
                return "Producto final";
            default:
                return "Error en la búsqueda del tipo";
        }
    }

    public String obtenerPadre(int idProductoBase) {
        Producto prodPadre;
        String padre;
        if (productos.containsKey(idProductoBase)) {
            prodPadre = productos.get(idProductoBase);
        } else {
            prodPadre = ProductoController.getProductoById(idProductoBase);
            productos.put(idProductoBase, prodPadre);
        }
        padre = prodPadre.getCodProducto() + " - " + prodPadre.getDescripcion();
        return padre;
    }
}
