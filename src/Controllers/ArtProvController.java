/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ArtProv;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class ArtProvController {

    public static void altaArtProv(String descripcion, int idProveedor, int idArticulo, double precio) {
        String sql = Queries.ARTPROV_ALTAARTPROV;
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        sql = sql.replaceAll("PREC", String.valueOf(precio));

        DBConnection.execSQL(sql);
    }

    public static void modificarArtProv(int idArtProv, String descripcion, int idProveedor, int idArticulo, double precio) {
        String sql = Queries.ARTPROV_MODIFICARARTPROV;
        sql = sql.replaceAll("IDARTPROV", String.valueOf(idArtProv));
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));
        sql = sql.replaceAll("IDART", String.valueOf(idArticulo));
        sql = sql.replaceAll("PREC", String.valueOf(precio));

        DBConnection.execSQL(sql);
    }

    public static void bajaArtProv(int idArtProv) {
        String sql = Queries.ARTPROV_BAJAARTPROV;
        sql = sql.replaceAll("IDARTPROV", String.valueOf(idArtProv));

        DBConnection.execSQL(sql);
    }

    public static void bajaArtProvByProveedor(int idProveedor) {
        String sql = Queries.ARTPROV_BAJAARTPROVBYPROVEEDOR;
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));

        DBConnection.execSQL(sql);
    }

    public static void bajaArtProvByArticulo(int idArticulo) {
        String sql = Queries.ARTPROV_BAJAARTPROVBYARTICULO;
        sql = sql.replaceAll("IDPROV", String.valueOf(idArticulo));

        DBConnection.execSQL(sql);
    }

    public static ArrayList<ArtProv> getArtProv() {
        ArrayList<ArtProv> artprovs = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.ARTPROV_GETARTPROV);
            while (rs.next()) {
                int idArtProv = rs.getInt("idArtProv");
                String descripcion = rs.getString("descripcion");
                int idProveedor = rs.getInt("idProveedor");
                int idArticulo = rs.getInt("idArticulo");
                double precio = rs.getDouble("precio");

                ArtProv temp = new ArtProv(idArtProv, descripcion, idProveedor, idArticulo, precio);
                artprovs.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artprovs;
    }

    public static ArrayList<ArtProv> getArtProvByProveedor(int idProveedor) {
        ArrayList<ArtProv> artprovs = new ArrayList();
        String sql = Queries.ARTPROV_GETARTPROVBYPROVEEDOR;
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                int idArtProv = rs.getInt("idArtProv");
                String descripcion = rs.getString("descripcion");
                int idArticulo = rs.getInt("idArticulo");
                double precio = rs.getDouble("precio");

                ArtProv temp = new ArtProv(idArtProv, descripcion, idProveedor, idArticulo, precio);
                artprovs.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artprovs;
    }

    public static ArrayList<ArtProv> getArtProvByArticulo(int idArticulo) {
        ArrayList<ArtProv> artprovs = new ArrayList();
        String sql = Queries.ARTPROV_GETARTPROVBYARTICULO;
        sql = sql.replaceAll("IDPROV", String.valueOf(idArticulo));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                int idArtProv = rs.getInt("idArtProv");
                String descripcion = rs.getString("descripcion");
                int idProveedor = rs.getInt("idProveedor");
                double precio = rs.getDouble("precio");

                ArtProv temp = new ArtProv(idArtProv, descripcion, idProveedor, idArticulo, precio);
                artprovs.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artprovs;
    }

    public static ArtProv getArtProvById(int idArtProv) {
        ArtProv artprov = new ArtProv();
        String sql = Queries.ARTPROV_GETARTPROVBYID;
        sql = sql.replaceAll("IDARTPROV", String.valueOf(idArtProv));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            rs.next();
            String descripcion = rs.getString("descripcion");
            int idProveedor = rs.getInt("idProveedor");
            int idArticulo = rs.getInt("idArticulo");
            double precio = rs.getDouble("precio");

            artprov.setIdArtProv(idArtProv);
            artprov.setDescripcion(descripcion);
            artprov.setIdProveedor(idProveedor);
            artprov.setIdArticulo(idArticulo);
            artprov.setPrecio(precio);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artprov;
    }
}
