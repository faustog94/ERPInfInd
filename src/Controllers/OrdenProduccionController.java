/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.OrdenProduccion;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class OrdenProduccionController {
    
    public static void altaOrdenProduccion(String fechaPedido, int idEstOP) {
        String sql = Queries.ORDENPRODUCCION_ALTAORDENPRODUCCION;
        sql = sql.replaceAll("FECHA", fechaPedido);
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        
        DBConnection.execSQL(sql);
    }
    
    public static void modificarOrdenProduccion(int idOrdenProduccion, String fechaPedido, int idEstOP) {
        String sql = Queries.ORDENPRODUCCION_MODIFICARORDENPRODUCCION;
        sql = sql.replaceAll("FECHA", fechaPedido);
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        
        DBConnection.execSQL(sql);
    }
    
    public static void bajaOrdenProduccion(int idOrdenProduccion) {
        String sql = Queries.ORDENPRODUCCION_BAJAORDENPRODUCCION;
        //El id para Cancelado es 4
        int idEstOP = 4;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        
        DBConnection.execSQL(sql);
    }
    
    public static ArrayList<OrdenProduccion> getOrdenProduccion() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ORDENPRODUCCION_GETORDENPRODUCCION);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                int idEstOP = rs.getInt("idEstOP");
                
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }

    public static ArrayList<OrdenProduccion> getOrdenProduccionActiva() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        //El id para un estado activo es pendiente o en curso (1, 2)
        int idEstA = 1;
        int idEstB = 2;
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONACTIVA;
        sql = sql.replaceAll("IDESTA", String.valueOf(idEstA));
        sql = sql.replaceAll("IDESTB", String.valueOf(idEstB));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                int idEstOP = rs.getInt("idEstOP");
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
    
    public static ArrayList<OrdenProduccion> getOrdenProduccionPendiente() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        //El id para el estado pendiente es 1
        int idEstOP = 1;
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONBYESTADO;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
    
    public static ArrayList<OrdenProduccion> getOrdenProduccionEnCurso() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        //El id para el estado en curso es 2
        int idEstOP = 2;
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONBYESTADO;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
    
    public static ArrayList<OrdenProduccion> getOrdenProduccionFinalizada() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        //El id para el estado finalizada es 3
        int idEstOP = 3;
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONBYESTADO;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
    
    public static ArrayList<OrdenProduccion> getOrdenProduccionCancelada() {
        ArrayList<OrdenProduccion> ordenes = new ArrayList();
        //El id para el estado cancelada es 4
        int idEstOP = 4;
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONBYESTADO;
        sql = sql.replaceAll("IDEST", String.valueOf(idEstOP));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");
                String fechaPedido = rs.getString("fechaPedido");
                OrdenProduccion temp = new OrdenProduccion(idOrdenProduccion, fechaPedido, idEstOP);
                ordenes.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }
    
    public static OrdenProduccion getOrdenProduccionById(int idOrdenProduccion) {
        OrdenProduccion orden = new OrdenProduccion();
        String sql = Queries.ORDENPRODUCCION_GETORDENPRODUCCIONBYID;
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idOrdenProduccion, String fechaPedido, int idEstOP
                String fechaPedido = rs.getString("fechaPedido");
                int idEstOP = rs.getInt("idEstOP");
                
                orden.setIdOrdenProduccion(idOrdenProduccion);
                orden.setFechaPedido(fechaPedido);
                orden.setIdEstOP(idEstOP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orden;
    }

    public static boolean ordenIsActiva(int idOrdenProduccion){
        boolean activa = false;
        //El id para un estado activo es pendiente o en curso (1, 2)
        int idEstA = 1;
        int idEstB = 2;
        String sql = Queries.ORDENPRODUCCION_ORDENISACTIVA;
        sql = sql.replaceAll("IDESTA", String.valueOf(idEstA));
        sql = sql.replaceAll("IDESTB", String.valueOf(idEstB));
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                if (cantidad > 0){
                    activa = true;
                }
                else {activa = false;}
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return activa;
    }
    
}
