/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Materiales;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class MaterialesController {
    //IDMAT, CANT, IDDET, IDART, IDTM
    public static void altaMateriales(int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales){
        String sql = Queries.MATERIALES_ALTAMATERIALES;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        sql = sql.replaceAll("IDTM", String.valueOf(idTipoMateriales));
        

        DBConnection.execSQL(sql);
    }
    public static void modificarMateriales(int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales){
        String sql = Queries.MATERIALES_MODIFICARMATERIALES;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        sql = sql.replaceAll("IDTM", String.valueOf(idTipoMateriales));
        sql = sql.replaceAll("IDMAT", String.valueOf(idMateriales));

        DBConnection.execSQL(sql);
    }
    public static void bajaMateriales(int idMateriales){
        String sql = Queries.MATERIALES_BAJAMATERIALES;
        sql = sql.replaceAll("IDMAT", String.valueOf(idMateriales));

        DBConnection.execSQL(sql);
    }
    
    public static ArrayList<Materiales> getMateriales() {
        ArrayList<Materiales> materiales = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.MATERIALES_GETMATERIALES);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int idMateriales = rs.getInt("idMateriales");
                int cantidad = rs.getInt("cantidad");
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int idArticulo = rs.getInt("idArticulo");
                int idTipoMateriales = rs.getInt("idTipoMateriales");

                Materiales temp = new Materiales(idMateriales, cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
                materiales.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materiales;
    }
    public static ArrayList<Materiales> getMaterialesByDetalle(int idDetalleRuta){
        ArrayList<Materiales> materiales = new ArrayList();
        String sql = Queries.MATERIALES_GETMATERIALESBYDETALLE;
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int idMateriales = rs.getInt("idMateriales");
                int cantidad = rs.getInt("cantidad");
                int idArticulo = rs.getInt("idArticulo");
                int idTipoMateriales = rs.getInt("idTipoMateriales");

                Materiales temp = new Materiales(idMateriales, cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
                materiales.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materiales;
    }
    public static ArrayList<Materiales> getMaterialesByArticulo(int idArticulo){
        ArrayList<Materiales> materiales = new ArrayList();
        String sql = Queries.MATERIALES_GETMATERIALESBYARTICULO;
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int idMateriales = rs.getInt("idMateriales");
                int cantidad = rs.getInt("cantidad");
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int idTipoMateriales = rs.getInt("idTipoMateriales");

                Materiales temp = new Materiales(idMateriales, cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
                materiales.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materiales;
    }
    public static ArrayList<Materiales> getMaterialesByTipo(int idTipoMateriales){
        ArrayList<Materiales> materiales = new ArrayList();
        String sql = Queries.MATERIALES_GETMATERIALESBYTIPO;
        sql = sql.replaceAll("IDTM", String.valueOf(idTipoMateriales));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int idMateriales = rs.getInt("idMateriales");
                int cantidad = rs.getInt("cantidad");
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int idArticulo = rs.getInt("idArticulo");

                Materiales temp = new Materiales(idMateriales, cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
                materiales.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materiales;
    }
    public static ArrayList<Materiales> getMaterialesByTipoByDetalle(int idTipoMateriales, int idDetalleRuta){
        ArrayList<Materiales> materiales = new ArrayList();
        String sql = Queries.MATERIALES_GETMATERIALESBYTIPOBYDETALLE;
        sql = sql.replaceAll("IDTM", String.valueOf(idTipoMateriales));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleRuta));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int idMateriales = rs.getInt("idMateriales");
                int cantidad = rs.getInt("cantidad");
                int idArticulo = rs.getInt("idArticulo");

                Materiales temp = new Materiales(idMateriales, cantidad, idDetalleRuta, idArticulo, idTipoMateriales);
                materiales.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materiales;
    }
    
    public static Materiales getMaterialesById(int idMateriales){
        Materiales material = new Materiales();
        String sql = Queries.MATERIALES_GETMATERIALESBYID;
        sql = sql.replaceAll("IDMAT", String.valueOf(idMateriales));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMateriales, int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                int cantidad = rs.getInt("cantidad");
                int idDetalleRuta = rs.getInt("idDetalleRuta");
                int idArticulo = rs.getInt("idArticulo");
                int idTipoMateriales = rs.getInt("idTipoMateriales");

                material.setIdMateriales(idMateriales);
                material.setCantidad(cantidad);
                material.setIdDetalleRuta(idDetalleRuta);
                material.setIdArticulo(idArticulo);
                material.setIdTipoMateriales(idTipoMateriales);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return material;
    }
}
