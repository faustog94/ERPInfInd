/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TipoMateriales;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class TipoMaterialesController {
    //Por ahora no necesitamos alta, baja ni modificación. 

    public static ArrayList<TipoMateriales> getTipoMateriales() {
        ArrayList<TipoMateriales> tipos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.TIPOMATERIALES_GETTIPOMATERIALES);
            while (rs.next()) {
                //int idTipoMateriales, String descripcion
                int idTipoMateriales = rs.getInt("idTipoMateriales");
                String descripcion = rs.getString("descripcion");

                TipoMateriales temp = new TipoMateriales(idTipoMateriales, descripcion);
                tipos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipos;
    }

    public static TipoMateriales getTipoMaterialesById(int idTipoMateriales) {
        TipoMateriales tipo = new TipoMateriales();
        String sql = Queries.TIPOMATERIALES_GETTIPOMATERIALESBYID;
        sql = sql.replaceAll("IDTM", String.valueOf(idTipoMateriales));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idTipoMateriales, String descripcion
                String descripcion = rs.getString("descripcion");

                tipo.setIdTipoMateriales(idTipoMateriales);
                tipo.setDescripcion(descripcion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipo;
    }
}
