/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Articulo;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class ArticuloController {

    public static void altaArticulo(String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo) {
        //    CODART, DESC, ACT, UM, IDTIPO
        String sql = Queries.ARTICULO_ALTAARTICULO;
        sql = sql.replaceAll("CODART", codArticulo);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("UM", unidadMedida);
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoArticulo));

        DBConnection.execSQL(sql);
    }

    public static void modificarArticulo(int idArticulo, String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo) {
        String sql = Queries.ARTICULO_MODIFICARARTICULO;
        sql = sql.replaceAll("CODART", codArticulo);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("UM", unidadMedida);
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipoArticulo));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        System.out.println(sql);

        DBConnection.execSQL(sql);
    }

    public static void bajaArticulo(int idArticulo) { //debemos chequear que no pertenece a una estructura de producto (Controlador de Estructura de Producto)

    }

    public static ArrayList<Articulo> getArticulos() {
        ArrayList<Articulo> articulos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ARTICULO_GETARTICULOS);
            while (rs.next()) {
                //int idArticulo, String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo
                int idArticulo = rs.getInt("idArticulo");
                String codArticulo = rs.getString("codArticulo");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                String unidadMedida = rs.getString("unidadMedida");
                int idTipoArticulo = rs.getInt("idTipoArticulo");

                Articulo temp = new Articulo(idArticulo, codArticulo, descripcion, activo, unidadMedida, idTipoArticulo);
                articulos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }

    public static Articulo getArticuloById(int idArticulo) {
        Articulo art = new Articulo();
        String sql = Queries.ARTICULO_GETARTICULOSBYID;
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
            String codArticulo = rs.getString("codArticulo");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");
            String unidadMedida = rs.getString("unidadMedida");
            int idTipoArticulo = rs.getInt("idTipoArticulo");

            art.setIdArticulo(idArticulo);
            art.setCodArticulo(codArticulo);
            art.setDescripcion(descripcion);
            art.setActivo(activo);
            art.setUnidadMedida(unidadMedida);
            art.setIdTipoArticulo(idTipoArticulo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return art;
    }

    public static Articulo getArticuloByCod(String codArticulo){
        Articulo art = new Articulo();
        String sql = Queries.ARTICULO_GETARTICULOSBYCOD;
        sql = sql.replaceAll("CODART", codArticulo);
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
            int idArticulo = rs.getInt("idArticulo");
            String descripcion = rs.getString("descripcion");
            boolean activo = rs.getBoolean("activo");
            String unidadMedida = rs.getString("unidadMedida");
            int idTipoArticulo = rs.getInt("idTipoArticulo");

            art.setIdArticulo(idArticulo);
            art.setCodArticulo(codArticulo);
            art.setDescripcion(descripcion);
            art.setActivo(activo);
            art.setUnidadMedida(unidadMedida);
            art.setIdTipoArticulo(idTipoArticulo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return art;
    }
    
    public static ArrayList<Articulo> getArticuloByTipo(int idTipo){
        ArrayList<Articulo> articulos = new ArrayList();
        String sql = Queries.ARTICULO_GETARTICULOSBYTIPO;
        sql = sql.replaceAll("IDTIPO", String.valueOf(idTipo));
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ARTICULO_GETARTICULOS);
            while (rs.next()) {
                //int idArticulo, String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo
                int idArticulo = rs.getInt("idArticulo");
                String codArticulo = rs.getString("codArticulo");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                String unidadMedida = rs.getString("unidadMedida");

                Articulo temp = new Articulo(idArticulo, codArticulo, descripcion, activo, unidadMedida, idTipo);
                articulos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
    
    public static ArrayList<Articulo> getArticulosActivos(){
    ArrayList<Articulo> articulos = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ARTICULO_GETARTICULOS);
            while (rs.next()) {
                //int idArticulo, String codArticulo, String descripcion, boolean activo, String unidadMedida, int idTipoArticulo
                int idArticulo = rs.getInt("idArticulo");
                String codArticulo = rs.getString("codArticulo");
                String descripcion = rs.getString("descripcion");
                String unidadMedida = rs.getString("unidadMedida");
                int idTipoArticulo = rs.getInt("idTipoArticulo");

                Articulo temp = new Articulo(idArticulo, codArticulo, descripcion, true, unidadMedida, idTipoArticulo);
                articulos.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
}
