/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ProductoController;
import Models.Producto;
import Models.TipoArticulo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class AltaProductoHelper {

    private HashMap<Integer, Producto> productosHash = new HashMap<Integer, Producto>();

    public ArrayList<String> getProductosBase() {
        ArrayList<String> prodString = new ArrayList();
        ArrayList<Producto> prodAL = ProductoController.getProductoByTipo(1); //1 es el id de productos base
        int idProducto;
        String descripcion;
        for (int i = 0; i < prodAL.size(); i++) {
            idProducto = prodAL.get(i).getIdProducto();
            descripcion = prodAL.get(i).getDescripcion();
            productosHash.put(idProducto, prodAL.get(i));
            prodString.add(descripcion);
        }
        return prodString;
    }

    public int getIdProductoPadre(String descripcion) {
        for (Producto prod : productosHash.values()) {
            if (prod.getDescripcion().equals(descripcion)) {
                return prod.getIdProducto();
            }
        }
        return 0;
    }
    
    public void darAlta(String codProducto, String descripcion, boolean activo, String unidadMedida, int idTipoProducto, int idProductoBase) {
        ProductoController.altaProducto(codProducto, descripcion, activo, unidadMedida, idTipoProducto, idProductoBase);
    }

    public HashMap<Integer, Producto> getProductosHash() {
        return productosHash;
    }

    public void setProductosHash(HashMap<Integer, Producto> productosHash) {
        this.productosHash = productosHash;
    }

    

}
