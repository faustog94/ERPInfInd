/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TipoProducto;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class TipoProductoController {
    
    public static ArrayList<TipoProducto> getTipoProducto(){
        ArrayList<TipoProducto> tipos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.TIPOPRODUCTO_GETTIPOPRODUCTO);
            while (rs.next()){
                int idTipoProducto = rs.getInt("idTipoProducto");
                String descripcion = rs.getString("descripcion");
                TipoProducto temp = new TipoProducto(idTipoProducto, descripcion);
                tipos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipos;
    }
    
    public static TipoProducto getTipoProductoById(int idTipoProd){
        TipoProducto tipoprod = new TipoProducto();
        String sql = Queries.TIPOPRODUCTO_GETTIPOPRODUCTOBYID;
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoProd));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
                int idTipoProducto = rs.getInt("idTipoProducto");
                String descripcion = rs.getString("descripcion");
                tipoprod.setIdTipo(idTipoProducto);
                tipoprod.setDescripcion(descripcion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipoprod;
    }
    
}
