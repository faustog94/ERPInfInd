/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author franco-lxle
 */
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private boolean activo;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombre, boolean activo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
