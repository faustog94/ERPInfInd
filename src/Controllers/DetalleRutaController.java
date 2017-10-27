/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DetalleRuta;
import Models.RutaFabricacion;
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
    public static void altaDetalleRuta(int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro) {
        String sql = Queries.DETALLERUTA_ALTADETALLERUTA;
        sql = sql.replaceAll("ORD", String.valueOf(orden));
        sql = sql.replaceAll("TMO", String.valueOf(tiempoManoObra));
        sql = sql.replaceAll("TMAQ", String.valueOf(tiempoMaquina));
        sql = sql.replaceAll("TREP", String.valueOf(tiempoReposo));
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));

        DBConnection.execSQL(sql);
    }

    public static void modificarDetalleRuta(int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro) {
        String sql = Queries.DETALLERUTA_MODIFICARDETALLERUTA;
        sql = sql.replaceAll("ORD", String.valueOf(orden));
        sql = sql.replaceAll("TMO", String.valueOf(tiempoManoObra));
        sql = sql.replaceAll("TMAQ", String.valueOf(tiempoMaquina));
        sql = sql.replaceAll("TREP", String.valueOf(tiempoReposo));
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));

        DBConnection.execSQL(sql);
    }

    //public static void bajaDetalleRuta(int idDetalleRuta){} //NO DEBERÍA TENER BAJA.
    
    public static ArrayList<DetalleRuta> getDetalleRuta() {
        ArrayList<DetalleRuta> detalles = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.DETALLERUTA_GETDETALLERUTA);
            while (rs.next()) {
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idCentro = rs.getInt("idCentro");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro);
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
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idCentro = rs.getInt("idCentro");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro);
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
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");

                DetalleRuta temp = new DetalleRuta(idDetalleRuta, orden, tiempoManoObra, tiempoMaquina, tiempoReposo, idRuta, idCentro);
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
                //int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro
                int orden = rs.getInt("orden");
                double tiempoManoObra = rs.getDouble("tiempoManoObra");
                double tiempoMaquina = rs.getDouble("tiempoMaquina");
                double tiempoReposo = rs.getDouble("tiempoReposo");
                int idRuta = rs.getInt("idRuta");
                int idCentro = rs.getInt("idCentro");

                detalle.setIdDetalleRuta(idDetalleRuta);
                detalle.setOrden(orden);
                detalle.setTiempoManoObra(tiempoManoObra);
                detalle.setTiempoMaquina(tiempoMaquina);
                detalle.setTiempoReposo(tiempoReposo);
                detalle.setIdRuta(idRuta);
                detalle.setIdCentro(idCentro);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalle;
    }

    public static boolean centroEstaEnRutaActiva(int idCentro){
        boolean rutaActiva = false;
        ArrayList<DetalleRuta> detalles = getDetalleRutaByCentro(idCentro);
        for (int i = 0 ; i < detalles.size() ; i++){
            int idRuta = detalles.get(i).getIdRuta();
            if(RutaFabricacionController.rutaIsActiva(idCentro)){
                rutaActiva = true;
            }
        }
        return rutaActiva;
    }
    
    public static int getLastInsertedId(){
        String sql = Queries.DETALLERUTA_LASTINSERTEDID;
        int ultid = 0;
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                ultid = rs.getInt("id");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ultid;
    }
}
