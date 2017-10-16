/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import Controllers.TipoArticuloController;
import Models.Articulo;
import Models.TipoArticulo;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franco
 */
public class ModificarArticuloHelper {
    private HashMap<Integer, TipoArticulo> tiposHash = new HashMap<Integer, TipoArticulo>();
    
    public ArrayList<String> getTipos(){
        ArrayList<TipoArticulo> tiposAL = TipoArticuloController.getTipoArticulo();
        ArrayList<String> tiposS = new ArrayList();
        int idTipoArticulo;
        String descripcion;
        for (int i = 0; i < tiposAL.size(); i++) {
            idTipoArticulo = tiposAL.get(i).getIdTipo();
            descripcion = tiposAL.get(i).getDescripcion();
            tiposHash.put(idTipoArticulo, tiposAL.get(i));
            tiposS.add(descripcion);
        }
        return tiposS;
    }
    
    public int getTipoIdFromIndex(int index){ //retorna el id de TipoArticulo basado en el indice seleccionado
        return tiposHash.get(index+1).getIdTipo();
    }
    
    public Articulo buscarArticulo(String codArticulo){
        return ArticuloController.getArticuloByCod(codArticulo);
    }
    
    public boolean codigoExiste(String codigo){
        return ArticuloController.articuloExisteByCod(codigo);
    }
    
    public boolean existenCambios(Articulo art, Articulo artModificado){
        String codArt = art.getCodArticulo();
        String codArtModif = artModificado.getCodArticulo();
        String descripcionArt = art.getDescripcion();
        String descripcionArtModif = artModificado.getDescripcion();
        boolean activoArt = art.isActivo();
        boolean activoArtModif = artModificado.isActivo();
        String umArt = art.getUnidadMedida();
        String umArtModif = artModificado.getUnidadMedida();
        int tipoArt = art.getIdTipoArticulo();
        int tipoArtModificado = artModificado.getIdTipoArticulo();
        
        if (codArt.equals(codArtModif) && descripcionArt.equals(descripcionArtModif) && activoArt == activoArtModif && umArt.equals(umArtModif) && tipoArt == tipoArtModificado){
            return false;
        }
        else {return true;}
    }
    
    public void modificar(Articulo artModificado) {
        int idArticulo = artModificado.getIdArticulo();
        String codArticulo = artModificado.getCodArticulo();
        String descripcion = artModificado.getDescripcion();
        boolean activo = artModificado.isActivo();
        String unidadMedida = artModificado.getUnidadMedida();
        int idTipoArticulo = artModificado.getIdTipoArticulo();
        ArticuloController.modificarArticulo(idArticulo, codArticulo, descripcion, activo, unidadMedida, idTipoArticulo);
    }
    
    
    //métodos miembros de la clase
    public HashMap<Integer, TipoArticulo> getTiposHash() {
        return tiposHash;
    }

    public void setTiposHash(HashMap<Integer, TipoArticulo> tiposHash) {
        this.tiposHash = tiposHash;
    }

    
}
