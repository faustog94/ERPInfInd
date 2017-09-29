/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EstadoOrdenProduccion;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class EstadoOrdenProduccionController {

    public static ArrayList<EstadoOrdenProduccion> getEstadoOrdenProduccion() {
        ArrayList<EstadoOrdenProduccion> estados = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ESTADOORDENPRODUCCION_GETESTADOORDENPRODUCCION);
            while (rs.next()) {
                //int idEstOP, String descripcion
                int idEstOP = rs.getInt("idEstOP");
                String descripcion = rs.getString("descripcion");

                EstadoOrdenProduccion temp = new EstadoOrdenProduccion(idEstOP, descripcion);
                estados.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estados;
    }

    public static EstadoOrdenProduccion getEstadoOrdenProduccionById(int idEstOP) {
        EstadoOrdenProduccion estado = new EstadoOrdenProduccion();
        String sql = Queries.ESTADOORDENPRODUCCION_GETESTADOORDENPRODUCCIONBYID;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idEstOP, String descripcion
                String descripcion = rs.getString("descripcion");
                
                estado.setIdEstOP(idEstOP);
                estado.setDescripcion(descripcion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }
}
