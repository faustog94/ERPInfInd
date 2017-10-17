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
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class AltaEstructuraHelper {
    HashMap<Integer, Articulo> articulos = new HashMap<Integer, Articulo>();
    public boolean codigoExiste(String codProducto) {
        return ProductoController.productoExisteByCod(codProducto);
    }
    
    public Producto buscarProducto(String cod){
        return ProductoController.getProductoByCod(cod);
    }
    
    public HashMap<String, Integer> obtenerArticulos(){
        HashMap<String, Integer> arts = new HashMap<String, Integer>();
        ArrayList<Articulo> artsAL = ArticuloController.getArticulosActivos();
        int idArticulo;
        String desc;        
        for (int i = 0; i < artsAL.size(); i++) {
            idArticulo = artsAL.get(i).getIdArticulo();
            desc = artsAL.get(i).getCodArticulo() + " - " + artsAL.get(i).getDescripcion();
            articulos.put(idArticulo, artsAL.get(i));
            arts.put(desc, idArticulo);
        }        
        return arts;
    }
    
    public void altaEstructura(int idProducto, boolean activo, String version, HashMap<Integer, Integer> hashArticulos){
        for(Integer idArticulo : hashArticulos.keySet()){
            EstructuraController.altaEstructura(hashArticulos.get(idArticulo), activo, version, idProducto, idArticulo);
        }
    }
}
