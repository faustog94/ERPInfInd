/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ProductoController;
import Models.Producto;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class ModificarProductoHelper {
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
    
    public boolean codigoExiste(String codProducto) {
        return ProductoController.productoExisteByCod(codProducto);
    }
    
    public Producto buscarProducto(String cod){
        return ProductoController.getProductoByCod(cod);
    }
    
    public String obtenerDescProdPadre(int idProductoBase){
        return productosHash.get(idProductoBase).getDescripcion();
    }
    
    public boolean existenCambios(Producto prod, Producto prodModificado){
        String codArt = prod.getCodProducto();
        String codArtModif = prodModificado.getCodProducto();
        String descripcionArt = prod.getDescripcion();
        String descripcionArtModif = prodModificado.getDescripcion();
        boolean activoArt = prod.isActivo();
        boolean activoArtModif = prodModificado.isActivo();
        String umArt = prod.getUnidadMedida();
        String umArtModif = prodModificado.getUnidadMedida();
        int tipoProd = prod.getIdTipoProducto();
        int tipoProdModificado = prodModificado.getIdTipoProducto();
        int idProductoBaseProd = prod.getIdProductoBase();
        int idProductoBaseProdModificado = prodModificado.getIdProductoBase();
        
        if (codArt.equals(codArtModif) && descripcionArt.equals(descripcionArtModif) && activoArt == activoArtModif && umArt.equals(umArtModif) && tipoProd == tipoProdModificado && idProductoBaseProd == idProductoBaseProdModificado){
            return false;
        }
        else {return true;}
    }
    
    public void modificar(Producto prodModificado) {
        int idProducto = prodModificado.getIdProducto();
        String codProducto = prodModificado.getCodProducto();
        String descripcion = prodModificado.getDescripcion();
        boolean activo = prodModificado.isActivo();
        String unidadMedida = prodModificado.getUnidadMedida();
        int idTipoProducto = prodModificado.getIdTipoProducto();
        int idProductoBase = prodModificado.getIdProductoBase();
        ProductoController.modificarProducto(idProducto, codProducto, descripcion, activo, unidadMedida, idTipoProducto, idProductoBase);
    }

    public HashMap<Integer, Producto> getProductosHash() {
        return productosHash;
    }

    public void setProductosHash(HashMap<Integer, Producto> productosHash) {
        this.productosHash = productosHash;
    }

    
}
