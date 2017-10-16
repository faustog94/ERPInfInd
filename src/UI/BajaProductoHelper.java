/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.DetalleOrdenProdController;
import Controllers.EstructuraController;
import Controllers.ProductoController;
import Controllers.RutaFabricacionController;
import Models.Producto;

/**
 *
 * @author franco
 */
public class BajaProductoHelper {
    public boolean codigoExiste(String codProducto) {
        return ProductoController.productoExisteByCod(codProducto);
    }
    
    public Producto buscarProducto(String cod){
        return ProductoController.getProductoByCod(cod);
    }
    
    public String obtenerDescProdPadre(int idProductoBase){
        Producto prodPadre = ProductoController.getProductoById(idProductoBase);
        return prodPadre.getCodProducto() + " - " + prodPadre.getDescripcion();
    }
    
    public boolean tieneProductosFinales(int idProducto){
        return ProductoController.productoTieneProductosFinales(idProducto);
    }
    
    public boolean tieneOrdenesPendientes(int idProducto){
        return DetalleOrdenProdController.prodTieneOrdenActiva(idProducto);
    }
    
    public void bajaProducto(int idProducto){ // doy de baja el producto, sus estructuras y sus rutas.
        ProductoController.bajaProductoIndividual(idProducto);
        EstructuraController.bajaEstructurasProducto(idProducto);
        RutaFabricacionController.bajaRutasProducto(idProducto);
    }
}
