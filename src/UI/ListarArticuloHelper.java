/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Models.Articulo;
import java.util.ArrayList;

/**
 *
 * @author franco
 */
public class ListarArticuloHelper {
    public ArrayList<Articulo> obtenerArticulos(){
        return ArticuloController.getArticulos();
    }
    
    public String obtenerDescTipo(int idTipoArticulo){
        switch(idTipoArticulo){
            case 1: return "Materia Prima";
            case 2: return "Producto componente";
            case 3: return "Producto en proceso de fabricación";
            default: return "Error en la búsqueda del tipo";
        }
    }
}
