/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CentroTrabajo;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class CentroTrabajoController {

    public static void altaCentro(String codProducto, String descripcion, boolean activo) {
        String sql = Queries.CENTROTRABAJO_ALTACENTRO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));

        DBConnection.execSQL(sql);
    }

    public static void modificarCentro(int idCentro, String codProducto, String descripcion, boolean activo) {
        String sql = Queries.CENTROTRABAJO_MODIFICARCENTRO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("IDCENTRO", String.valueOf(idCentro));

        DBConnection.execSQL(sql);
    }

    public static void bajaCentro() {

    }

    public static ArrayList<CentroTrabajo> getCentros() {
        ArrayList<CentroTrabajo> centros = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.CENTROTRABAJO_GETCENTROS);
            while (rs.next()) {
                int idCentro = rs.getInt("idCentro");
                String codCentro = rs.getString("codCentro");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");

                CentroTrabajo temp = new CentroTrabajo(idCentro, codCentro, descripcion, activo);
                centros.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return centros;
    }

    public static CentroTrabajo getCentroById(int idCentro) {
        CentroTrabajo centro = new CentroTrabajo();
        String sql = Queries.CENTROTRABAJO_GETCENTROBYID;
        sql = sql.replaceAll("IDCENTRO", String.valueOf(idCentro));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            String codCentro = rs.getString("codCentro");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");

            centro.setIdCentro(idCentro);
            centro.setCodCentro(codCentro);
            centro.setDescripcion(descripcion);
            centro.setActivo(activo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return centro;
    }

    public static CentroTrabajo getCentroByCod(String codCentro) {
        CentroTrabajo centro = new CentroTrabajo();
        String sql = Queries.CENTROTRABAJO_GETCENTROBYCOD;
        sql = sql.replaceAll("CODCENTRO", codCentro);
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            int idCentro = rs.getInt("idCentro");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");

            centro.setIdCentro(idCentro);
            centro.setCodCentro(codCentro);
            centro.setDescripcion(descripcion);
            centro.setActivo(activo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return centro;
    }
}
