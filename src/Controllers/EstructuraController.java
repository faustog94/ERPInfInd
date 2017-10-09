/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Articulo;
import Models.Estructura;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class EstructuraController {

    public static void altaEstructura(int cantidad, boolean activo, String version, int idProducto, int idArticulo) {
        //CANT, ACT, 'VER', IDPROD, IDART
        String sql = Queries.ESTRUCTURA_ALTAESTRUCTURA;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("VER", version);
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));

        DBConnection.execSQL(sql);
    }

    public static void modificarEstructura(int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo) {
        //CANT, ACT, 'VER', IDPROD, IDART
        String sql = Queries.ESTRUCTURA_MODIFICARESTRUCTURA;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("VER", version);
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        sql = sql.replaceAll("IDEST", String.valueOf(idEstructura));

        DBConnection.execSQL(sql);
    }

    public static void bajaEstructura() {
    } //No se permite si existe orden de produccion activa

    public static ArrayList<Estructura> getEstructuras() {
        ArrayList<Estructura> estructuras = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ESTRUCTURA_GETESTRUCTURAS);
            while (rs.next()) {
                //int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo
                int idEstructura = rs.getInt("idEstructura");
                int cantidad = rs.getInt("cantidad");
                boolean activo = rs.getBoolean("activo");
                String version = rs.getString("version");
                int idProducto = rs.getInt("idProducto");
                int idArticulo = rs.getInt("idArticulo");

                Estructura temp = new Estructura(idEstructura, cantidad, activo, version, idProducto, idArticulo);
                estructuras.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estructuras;
    }

    public static ArrayList<Estructura> getEstructurasByArticulo(int idArticulo) {
        ArrayList<Estructura> estructuras = new ArrayList();
        String sql = Queries.ESTRUCTURA_GETESTRUCTURASBYARTICULO;
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo
                int idEstructura = rs.getInt("idEstructura");
                int cantidad = rs.getInt("cantidad");
                boolean activo = rs.getBoolean("activo");
                String version = rs.getString("version");
                int idProducto = rs.getInt("idProducto");

                Estructura temp = new Estructura(idEstructura, cantidad, activo, version, idProducto, idArticulo);
                estructuras.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estructuras;
    }

    public static ArrayList<Estructura> getEstructurasByProducto(int idProducto) {
        ArrayList<Estructura> estructuras = new ArrayList();
        String sql = Queries.ESTRUCTURA_GETESTRUCTURASBYPRODUCTO;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo
                int idEstructura = rs.getInt("idEstructura");
                int cantidad = rs.getInt("cantidad");
                boolean activo = rs.getBoolean("activo");
                String version = rs.getString("version");
                int idArticulo = rs.getInt("idArticulo");

                Estructura temp = new Estructura(idEstructura, cantidad, activo, version, idProducto, idArticulo);
                estructuras.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estructuras;
    }

    public static ArrayList<Estructura> getEstructuraActivaByProducto(int idProducto) {
        ArrayList<Estructura> estructuras = new ArrayList();
        String sql = Queries.ESTRUCTURA_GETESTRUCTURAACTIVABYPRODUCTO;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo
                int idEstructura = rs.getInt("idEstructura");
                int cantidad = rs.getInt("cantidad");
                boolean activo = rs.getBoolean("activo");
                String version = rs.getString("version");
                int idArticulo = rs.getInt("idArticulo");

                Estructura temp = new Estructura(idEstructura, cantidad, activo, version, idProducto, idArticulo);
                estructuras.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estructuras;
    }
    public static Estructura getEstructuraById(int idEstructura){
        Estructura estructura = new Estructura();
        String sql = Queries.ESTRUCTURA_GETESTRUCTURABYID;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstructura));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idEstructura, int cantidad, boolean activo, String version, int idProducto, int idArticulo
                int cantidad = rs.getInt("cantidad");
                boolean activo = rs.getBoolean("activo");
                String version = rs.getString("version");
                int idProducto = rs.getInt("idProducto");
                int idArticulo = rs.getInt("idArticulo");
                
                estructura.setIdEstructura(idEstructura);
                estructura.setCantidad(cantidad);
                estructura.setActivo(activo);
                estructura.setVersion(version);
                estructura.setIdProducto(idProducto);
                estructura.setIdArticulo(idArticulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estructura;
    }
}
