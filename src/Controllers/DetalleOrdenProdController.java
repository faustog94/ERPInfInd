/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DetalleOrdenProd;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class DetalleOrdenProdController {

    public static void altaDetalleOrdenProd(int cantidad, int idProducto, int idOrdenProduccion) {
        //CANT, IDPROD, IDOP
        String sql = Queries.DETALLENORDENPROD_ALTADETALLEORDENPROD;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));

        DBConnection.execSQL(sql);
    }

    public static void modificarDetalleOrdenProd(int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion) {
        //CANT, IDPROD, IDOP
        String sql = Queries.DETALLENORDENPROD_MODIFICARDETALLEORDENPROD;
        sql = sql.replaceAll("CANT", String.valueOf(cantidad));
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleOrden));

        DBConnection.execSQL(sql);
    }
    //public static void bajaDetalleOrdenProd(){}

    public static ArrayList<DetalleOrdenProd> getDetalleOrdenProd() {
        ArrayList<DetalleOrdenProd> detalles = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.DETALLENORDENPROD_GETDETALLEORDENPROD);
            while (rs.next()) {
                //int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion
                int idDetalleOrden = rs.getInt("idDetalleOrden");
                int cantidad = rs.getInt("cantidad");
                int idProducto = rs.getInt("idProducto");
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");

                DetalleOrdenProd temp = new DetalleOrdenProd(idDetalleOrden, cantidad, idProducto, idOrdenProduccion);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static ArrayList<DetalleOrdenProd> getDetalleOrdenProdByOrdenProduccion(int idOrdenProduccion) {
        ArrayList<DetalleOrdenProd> detalles = new ArrayList();
        String sql = Queries.DETALLENORDENPROD_GETDETALLEORDENPRODBYORDENPRODUCCION;
        sql = sql.replaceAll("IDOP", String.valueOf(idOrdenProduccion));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion
                int idDetalleOrden = rs.getInt("idDetalleOrden");
                int cantidad = rs.getInt("cantidad");
                int idProducto = rs.getInt("idProducto");

                DetalleOrdenProd temp = new DetalleOrdenProd(idDetalleOrden, cantidad, idProducto, idOrdenProduccion);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static ArrayList<DetalleOrdenProd> getDetalleOrdenProdbyProducto(int idProducto) {
        ArrayList<DetalleOrdenProd> detalles = new ArrayList();
        String sql = Queries.DETALLENORDENPROD_GETDETALLEORDENPRODBYPRODUCTO;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion
                int idDetalleOrden = rs.getInt("idDetalleOrden");
                int cantidad = rs.getInt("cantidad");
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");

                DetalleOrdenProd temp = new DetalleOrdenProd(idDetalleOrden, cantidad, idProducto, idOrdenProduccion);
                detalles.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalles;
    }

    public static DetalleOrdenProd getDetalleOrdenProdById(int idDetalleOrden) {
        DetalleOrdenProd detalle = new DetalleOrdenProd();
        String sql = Queries.DETALLENORDENPROD_GETDETALLEORDENPRODBYID;
        sql = sql.replaceAll("IDDET", String.valueOf(idDetalleOrden));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idDetalleOrden, int cantidad, int idProducto, int idOrdenProduccion
                int cantidad = rs.getInt("cantidad");
                int idProducto = rs.getInt("idProducto");
                int idOrdenProduccion = rs.getInt("idOrdenProduccion");

                detalle.setIdDetalleOrden(idDetalleOrden);
                detalle.setCantidad(cantidad);
                detalle.setIdProducto(idProducto);
                detalle.setIdOrdenProduccion(idOrdenProduccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return detalle;
    }
}
