/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DetalleRuta;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class DetalleRutaController {

    //IDDET, ORD, TMO, TMAQ, TREP, IDRUT, IDCEN, IDESTR
    public static void altaDetalleRuta(int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura) {
        String sql = Queries.DETALLERUTA_ALTADETALLERUTA;
        sql = sql.replaceAll("ORD", String.valueOf(orden));
        sql = sql.replaceAll("TMO", String.valueOf(tiempoManoObra));
        sql = sql.replaceAll("TMAQ", String.valueOf(tiempoMaquina));
        sql = sql.replaceAll("TREP", String.valueOf(tiempoReposo));
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        sql = sql.replaceAll("IDESTR", String.valueOf(idEstructura));

        DBConnection.execSQL(sql);
    }

    public static void modificarDetalleRuta(int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura) {
        String sql = Queries.DETALLERUTA_MODIFICARDETALLERUTA;
        sql = sql.replaceAll("ORD", String.valueOf(orden));
        sql = sql.replaceAll("TMO", String.valueOf(tiempoManoObra));
        sql = sql.replaceAll("TMAQ", String.valueOf(tiempoMaquina));
        sql = sql.replaceAll("TREP", String.valueOf(tiempoReposo));
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        sql = sql.replaceAll("IDESTR", String.valueOf(idEstructura));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));

        DBConnection.execSQL(sql);
    }

    //public static void bajaDetalleRuta(int idDetalleRuta){}
    
    public static ArrayList<DetalleRuta> getDetalleRuta() {
        ArrayList<DetalleRuta> detalles = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.DETALLERUTA_GETDETALLERUTA);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idCentro = rs.getInt("idCentro");
                int idEstructura = rs.getInt("idEstructura");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro, idEstructura);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static ArrayList<DetalleRuta> getDetalleRutaByRuta(int idRuta) {
        ArrayList<DetalleRuta> detalles = new ArrayList();
        String sql = Queries.DETALLERUTA_GETDETALLERUTABYRUTA;
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idCentro = rs.getInt("idCentro");
                int idEstructura = rs.getInt("idEstructura");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro, idEstructura);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static ArrayList<DetalleRuta> getDetalleRutaByCentro(int idCentro) {
        ArrayList<DetalleRuta> detalles = new ArrayList();
        String sql = Queries.DETALLERUTA_GETDETALLERUTABYCENTRO;
        sql = sql.replaceAll("IDRUT", String.valueOf(idCentro));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idEstructura = rs.getInt("idEstructura");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro, idEstructura);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static ArrayList<DetalleRuta> getDetalleRutaByEstructura(int idEstructura) {
        ArrayList<DetalleRuta> detalles = new ArrayList();
        String sql = Queries.DETALLERUTA_GETDETALLERUTABYESTRUCTURA;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstructura));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idCentro = rs.getInt("idCentro");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro, idEstructura);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static DetalleRuta getDetalleRutaById(int idDetalleRuta){
        DetalleRuta detalle = new DetalleRuta();
        String sql = Queries.DETALLERUTA_GETDETALLERUTABYID;
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idCentro = rs.getInt("idCentro");
                int idEstructura = rs.getInt("idEstructura");

                detalle.setIdDetalleRuta(idDetalleRuta);
                detalle.setOrden(orden);
                detalle.setTiempoManoObra(tiempoManoObra);
                detalle.setTiempoMaquina(tiempoMaquina);
                detalle.setTiempoReposo(tiempoReposo);
                detalle.setIdRuta(idRuta);
                detalle.setIdCentro(idCentro);
                detalle.setIdEstructura(idEstructura);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalle;
    }
}
