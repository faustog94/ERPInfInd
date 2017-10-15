/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.TipoArticuloController;
import Models.TipoArticulo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author franco-lxle
 */
public class AltaArticuloHelper {
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
    
    
    //métodos miembros de la clase
    public HashMap<Integer, TipoArticulo> getTiposHash() {
        return tiposHash;
    }

    public void setTiposHash(HashMap<Integer, TipoArticulo> tiposHash) {
        this.tiposHash = tiposHash;
    }
    
}
