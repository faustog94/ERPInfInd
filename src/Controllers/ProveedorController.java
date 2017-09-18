/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Proveedor;
import erpinfind.DBConnection;
import erpinfind.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author franco-lxle
 */
public class ProveedorController {
    
    public static void altaProveedor(String nombre, boolean activo) {
        //'NOM', ACT
        String sql = Queries.PROVEEDOR_ALTAPROVEEDOR;
        sql = sql.replaceAll("NOM", nombre);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        
        DBConnection.execSQL(sql);
    }

    public static void modificarProveedor(int idProveedor, String nombre, boolean activo) {
        String sql = Queries.PROVEEDOR_MODIFICARPROVEEDOR;
        sql = sql.replaceAll("NOM", nombre);
        sql = sql.replaceAll("ACT", String.valueOf(activo));
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));
        
        DBConnection.execSQL(sql);
    }

    public static void bajaProveedor(int idProveedor) {
        String sql = Queries.PROVEEDOR_BAJAPROVEEDOR;
        sql = sql.replaceAll("IDPROV", String.valueOf(idProveedor));
        
        DBConnection.execSQL(sql);
    }
    
    public static ArrayList<Proveedor> getProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.PROVEEDOR_GETPROVEEDORES);
            while (rs.next()) {
                int idProveedor = rs.getInt("idProveedor");
                String nombre = rs.getString("nombre");
                boolean activo = rs.getBoolean("activo");
                
                Proveedor temp = new Proveedor(idProveedor, nombre, activo);
                proveedores.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    public static ArrayList<Proveedor> getProveedoresActivos() {
        ArrayList<Proveedor> proveedores = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.PROVEEDOR_GETPROVEEDORESACTIVOS);
            while (rs.next()) {
                int idProveedor = rs.getInt("idProveedor");
                String nombre = rs.getString("nombre");
                
                Proveedor temp = new Proveedor(idProveedor, nombre, true);
                proveedores.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    public static Proveedor getProveedorById(int idProveedor) {
        Proveedor prov = new Proveedor();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.PROVEEDOR_GETPROVEEDORBYID);
            rs.next();
            
            String nombre = rs.getString("nombre");
            boolean activo = rs.getBoolean("activo");
            prov.setIdProveedor(idProveedor);
            prov.setNombre(nombre);
            prov.setActivo(activo);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return prov;
    }
}
