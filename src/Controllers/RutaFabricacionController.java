/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
public class RutaFabricacionController {

    public static void altaRutaFabricacion(boolean activa, String version, String vigenteDesde, int idProducto) {
        //ACT, VER, VIG, IDPROD
        String sql = Queries.RUTAFABRICACION_ALTARUTAFABRICACION;
        sql = sql.replaceAll("ACT", String.valueOf(activa));
        sql = sql.replaceAll("VER", version);
        sql = sql.replaceAll("VIG", vigenteDesde);
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        
        DBConnection.execSQL(sql);

    }
    public static void modificarRutaFabricacion(int idRuta, boolean activa, String version, String vigenteDesde, int idProducto){
        String sql = Queries.RUTAFABRICACION_MODIFICARRUTAFABRICACION;
        sql = sql.replaceAll("ACT", String.valueOf(activa));
        sql = sql.replaceAll("VER", version);
        sql = sql.replaceAll("VIG", vigenteDesde);
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        
        DBConnection.execSQL(sql);
    }
    //public static void bajaRutaFabricacion(){}

    public static ArrayList<RutaFabricacion> getRutaFabricacion(){
    ArrayList<RutaFabricacion> rutas = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.RUTAFABRICACION_GETRUTAFABRICACION);
            while (rs.next()) {
                //int idRuta, boolean activa, String version, String vigenteDesde, int idProducto
                int idRuta = rs.getInt("idRuta");
                boolean activa = rs.getBoolean("activa");
                String version = rs.getString("version");
                String vigenteDesde = rs.getString("vigenteDesde");
                int idProducto = rs.getInt("idProducto");

                RutaFabricacion temp = new RutaFabricacion(idRuta, activa, version, vigenteDesde, idProducto);
                rutas.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rutas;
    }
    public static ArrayList<RutaFabricacion> getRutaFabricacionByProducto(int idProducto){
        ArrayList<RutaFabricacion> rutas = new ArrayList();
        String sql = Queries.RUTAFABRICACION_GETRUTAFABRICACIONBYPRODUCTO;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idRuta, boolean activa, String version, String vigenteDesde, int idProducto
                int idRuta = rs.getInt("idRuta");
                boolean activa = rs.getBoolean("activa");
                String version = rs.getString("version");
                String vigenteDesde = rs.getString("vigenteDesde");

                RutaFabricacion temp = new RutaFabricacion(idRuta, activa, version, vigenteDesde, idProducto);
                rutas.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rutas;
    }
    public static ArrayList<RutaFabricacion> getRutaFabricacionByProductoActiva(int idProducto){
        ArrayList<RutaFabricacion> rutas = new ArrayList();
        String sql = Queries.RUTAFABRICACION_GETRUTAFABRICACIONBYPRODUCTOACTIVA;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idRuta, boolean activa, String version, String vigenteDesde, int idProducto
                int idRuta = rs.getInt("idRuta");
                boolean activa = true;
                String version = rs.getString("version");
                String vigenteDesde = rs.getString("vigenteDesde");

                RutaFabricacion temp = new RutaFabricacion(idRuta, activa, version, vigenteDesde, idProducto);
                rutas.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rutas;
    }
    public static RutaFabricacion getRutaFabricacionById(int idRuta){
        RutaFabricacion ruta = new RutaFabricacion();
        String sql = Queries.RUTAFABRICACION_GETRUTAFABRICACIONBYID;
        sql = sql.replaceAll("IDRUT", String.valueOf(idRuta));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idRuta, boolean activa, String version, String vigenteDesde, int idProducto
                boolean activa = rs.getBoolean("activa");
                String version = rs.getString("version");
                String vigenteDesde = rs.getString("vigenteDesde");
                int idProducto = rs.getInt("idProducto");

                ruta.setIdRuta(idRuta);
                ruta.setActiva(activa);
                ruta.setVersion(version);
                ruta.setVigenteDesde(vigenteDesde);
                ruta.setIdProducto(idProducto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ruta;
    }
}
