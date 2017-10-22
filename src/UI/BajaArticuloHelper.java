/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Controllers.EstructuraController;
import Controllers.TipoArticuloController;
import Models.Articulo;

/**
 *
 * @author franco
 */
public class BajaArticuloHelper {
    public boolean codigoExiste(String codArticulo) {
        return ArticuloController.articuloExisteByCod(codArticulo);
    }
    
    public Articulo buscarArticulo(String cod){
        return ArticuloController.getArticuloByCod(cod);
    }
    
    public String obtenerDescTipo(int idTipoArticulo){
        return TipoArticuloController.getTipoArticuloById(idTipoArticulo).getDescripcion();
    }
    
    public boolean articuloTieneEstructurasActivas(int idArticulo){
        return EstructuraController.existeEstructuraconArticulo(idArticulo);
    }
    
    public void bajaArticulo(int idArticulo){
        ArticuloController.bajaArticulo(idArticulo);
    }
}
