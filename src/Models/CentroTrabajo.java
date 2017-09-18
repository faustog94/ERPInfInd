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
public class CentroTrabajo {
    private int idCentro;
    private String codCentro;
    private String descripcion;
    private boolean activo;

    public CentroTrabajo(int idCentro, String codCentro, String descripcion, boolean activo) {
        this.idCentro = idCentro;
        this.codCentro = codCentro;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public CentroTrabajo() {
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getCodCentro() {
        return codCentro;
    }

    public void setCodCentro(String codCentro) {
        this.codCentro = codCentro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
