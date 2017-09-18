/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TipoArticulo;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class TipoArticuloController {
    
    

    public static ArrayList<TipoArticulo> getTipoArticulo(){
        ArrayList<TipoArticulo> tipos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.TIPOARTICULO_GETTIPOARTICULO);
            while (rs.next()){
                int idTipoArticulo = rs.getInt("idTipoArticulo");
                String descripcion = rs.getString("descripcion");
                TipoArticulo temp = new TipoArticulo(idTipoArticulo, descripcion);
                tipos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipos;
    }
    
    public static TipoArticulo getTipoArticuloById(int idTipoArt){
        TipoArticulo tipoart = new TipoArticulo();
        String sql = Queries.TIPOARTICULO_GETTIPOARTICULOBYID;
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoArt));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
                int idTipoArticulo = rs.getInt("idTipoArticulo");
                String descripcion = rs.getString("descripcion");
                tipoart.setIdTipo(idTipoArt);
                tipoart.setDescripcion(descripcion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipoart;
    }
}
