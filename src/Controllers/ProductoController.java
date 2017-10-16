/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Producto;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class ProductoController {

    public static void altaProducto(String codProducto, String descripcion, boolean activo, String unidadMedida, int idTipoProducto, int idProductoBase) {
        //'CODART', 'DESC', ACT, 'UM', IDTIPO, IDPRODBASE
        String sql = Queries.PRODUCTO_ALTAPRODUCTO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("UM", unidadMedida);
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoProducto));
        sql = sql.replaceAll("IDPRODBASE", String.valueOf(idProductoBase));

        DBConnection.execSQL(sql);
    }

    public static void modificarProducto(int idProducto, String codProducto, String descripcion, boolean activo, String unidadMedida, int idTipoProducto, int idProductoBase) {
        String sql = Queries.PRODUCTO_MODIFICARPRODUCTO;
        sql = sql.replaceAll("CODPROD", codProducto);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("UM", unidadMedida);
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoProducto));
        sql = sql.replaceAll("IDPRODBASE", String.valueOf(idProductoBase));
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));

        DBConnection.execSQL(sql);
    }

    public static void bajaProducto(int idProducto) {
        //Tengo que chequear si existe alguna Orden de Produccion pendiente o en curso.
        boolean existeOrden = DetalleOrdenProdController.prodTieneOrdenActiva(idProducto);
        if (existeOrden == false){
            bajaProductoIndividual(idProducto);
            //doy de baja todas las estructuras y rutas
            EstructuraController.bajaEstructurasProducto(idProducto);
            RutaFabricacionController.bajaRutasProducto(idProducto);
        }
        else {
            //Existe una orden activa, mostrar mensaje de error
        }
    }

    public static void bajaProductoIndividual(int idProducto){
        String sql = Queries.PRODUCTO_BAJAPRODUCTOINDIVIDUAL;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));

        DBConnection.execSQL(sql);
    }

    public static ArrayList<Producto> getProductos() {
        ArrayList<Producto> productos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.PRODUCTO_GETPRODUCTOS);
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String codProducto = rs.getString("codProducto");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                String unidadMedida = rs.getString("unidadMedida");
                int idTipoProducto = rs.getInt("idTipoProducto");
                int idProductoBase = rs.getInt("idProductoBase");

                Producto temp = new Producto(idProducto, codProducto, descripcion, activo, unidadMedida, idTipoProducto, idProductoBase);
                productos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }

    public static ArrayList<Producto> getProductosActivos(){
        ArrayList<Producto> productos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.PRODUCTO_GETPRODUCTOSACTIVOS);
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String codProducto = rs.getString("codProducto");
                String descripcion = rs.getString("descripcion");
                String unidadMedida = rs.getString("unidadMedida");
                int idTipoProducto = rs.getInt("idTipoProducto");
                int idProductoBase = rs.getInt("idProductoBase");

                Producto temp = new Producto(idProducto, codProducto, descripcion, true, unidadMedida, idTipoProducto, idProductoBase);
                productos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }
    
    public static ArrayList<Producto> getProductoByTipo(int idTipoProducto){
        ArrayList<Producto> productos = new ArrayList();
        String sql = Queries.PRODUCTO_GETPRODUCTOSBYTIPO;
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoProducto));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String codProducto = rs.getString("codProducto");
                String descripcion = rs.getString("descripcion");
                String unidadMedida = rs.getString("unidadMedida");
                int idProductoBase = rs.getInt("idProductoBase");

                Producto temp = new Producto(idProducto, codProducto, descripcion, true, unidadMedida, idTipoProducto, idProductoBase);
                productos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }
    
    public static Producto getProductoById(int idProducto){
        Producto prod = new Producto();
        String sql = Queries.PRODUCTO_GETPRODUCTOBYID;
        sql = sql.replaceAll("IDPROD", String.valueOf(idProducto));

        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
            String codProducto = rs.getString("codProducto");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");
            String unidadMedida = rs.getString("unidadMedida");
            int idTipoProducto = rs.getInt("idTipoProducto");
            int idProductoBase = rs.getInt("idProductoBase");
            
            prod.setIdProducto(idProducto);
            prod.setCodProducto(codProducto);
            prod.setDescripcion(descripcion);
            prod.setActivo(activo);
            prod.setUnidadMedida(unidadMedida);
            prod.setIdTipoProducto(idTipoProducto);
            prod.setIdProductoBase(idProductoBase);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return prod;
    }
    
    public static Producto getProductoByCod(String codProducto){
        Producto prod = new Producto();
        String sql = Queries.PRODUCTO_GETPRODUCTOBYCOD;
        sql = sql.replaceAll("CODPROD", codProducto);

        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
            int idProducto = rs.getInt("idProducto");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");
            String unidadMedida = rs.getString("unidadMedida");
            int idTipoProducto = rs.getInt("idTipoProducto");
            int idProductoBase = rs.getInt("idProductoBase");
            
            prod.setIdProducto(idProducto);
            prod.setCodProducto(codProducto);
            prod.setDescripcion(descripcion);
            prod.setActivo(activo);
            prod.setUnidadMedida(unidadMedida);
            prod.setIdTipoProducto(idTipoProducto);
            prod.setIdProductoBase(idProductoBase);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return prod;
    }

    public static boolean productoExisteByCod(String codProducto){
        boolean existe = false;
        String sql = Queries.PRODUCTO_PRODUCTOEXISTEBYCOD;
        sql = sql.replaceAll("CODPROD", codProducto);
        
        try {
        ResultSet rs = DBConnection.execSelectSQL(sql);
        while (rs.next()){
            int cantidad = rs.getInt("cantidad");
            if (cantidad > 0){
                existe = true;
            }
            else {existe = false;}
        }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return existe;
    }
}
