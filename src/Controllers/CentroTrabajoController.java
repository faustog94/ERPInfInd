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

    public static void altaCentro(String codProducto, String descripcion, boolean activo, double costoHoraMaquinaria, double costoHoraManoObra) {
        String sql = Queries.CENTROTRABAJO_ALTACENTRO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("CMAQ", String.valueOf(costoHoraMaquinaria));
        sql = sql.replaceAll("CMO", String.valueOf(costoHoraManoObra));

        DBConnection.execSQL(sql);
    }

    public static void modificarCentro(int idCentro, String codProducto, String descripcion, boolean activo, double costoHoraMaquinaria, double costoHoraManoObra) {
        String sql = Queries.CENTROTRABAJO_MODIFICARCENTRO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("IDCENTRO", String.valueOf(idCentro));
        sql = sql.replaceAll("CMAQ", String.valueOf(costoHoraMaquinaria));
        sql = sql.replaceAll("CMO", String.valueOf(costoHoraManoObra));

        DBConnection.execSQL(sql);
    }

    public static void bajaCentro(int idCentro) {
        //Debo verificar que no esté en una ruta activa
        boolean enRutaActiva = DetalleRutaController.centroEstaEnRutaActiva(idCentro);
        if (enRutaActiva == false){
            bajaCentroIndividual(idCentro);
        }
        else {
            //Tiene una ruta activa, mostrar error
        }
    }

    public static void bajaCentroIndividual(int idCentro){
        String sql = Queries.CENTROTRABAJO_BAJACENTROINDIVIDUAL;
        sql = sql.replaceAll("IDCENTRO", String.valueOf(idCentro));

        DBConnection.execSQL(sql);
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
                double costoHoraMaquinaria = rs.getDouble("costoHoraMaquinaria");
                double costoHoraManoObra = rs.getDouble("costoHoraManoObra");

                CentroTrabajo temp = new CentroTrabajo(idCentro, codCentro, descripcion, activo, costoHoraMaquinaria, costoHoraManoObra);
                centros.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return centros;
    }

    public static ArrayList<CentroTrabajo> getCentrosActivos(){
        ArrayList<CentroTrabajo> centros = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.CENTROTRABAJO_GETCENTROSACTIVOS);
            while (rs.next()) {
                int idCentro = rs.getInt("idCentro");
                String codCentro = rs.getString("codCentro");
                String descripcion = rs.getString("descripcion");
                double costoHoraMaquinaria = rs.getDouble("costoHoraMaquinaria");
                double costoHoraManoObra = rs.getDouble("costoHoraManoObra");

                CentroTrabajo temp = new CentroTrabajo(idCentro, codCentro, descripcion, true, costoHoraMaquinaria, costoHoraManoObra);
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
            while (rs.next()) {
                String codCentro = rs.getString("codCentro");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                double costoHoraMaquinaria = rs.getDouble("costoHoraMaquinaria");
                double costoHoraManoObra = rs.getDouble("costoHoraManoObra");

                centro.setIdCentro(idCentro);
                centro.setCodCentro(codCentro);
                centro.setDescripcion(descripcion);
                centro.setActivo(activo);
                centro.setCostoHoraMaquinaria(costoHoraMaquinaria);
                centro.setCostoHoraManoObra(costoHoraManoObra);
            }
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
            while (rs.next()) {
                int idCentro = rs.getInt("idCentro");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                double costoHoraMaquinaria = rs.getDouble("costoHoraMaquinaria");
                double costoHoraManoObra = rs.getDouble("costoHoraManoObra");

                centro.setIdCentro(idCentro);
                centro.setCodCentro(codCentro);
                centro.setDescripcion(descripcion);
                centro.setActivo(activo);
                centro.setCostoHoraMaquinaria(costoHoraMaquinaria);
                centro.setCostoHoraManoObra(costoHoraManoObra);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return centro;
    }
}
