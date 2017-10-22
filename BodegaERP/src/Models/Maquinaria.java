package Models;

import Controllers.CentroTrabajoController;

public class Maquinaria {
    private int idMaquinaria;
    private String codMaquinaria;
    private String descripcion;
    private boolean activa;

    //Relación con CentroTrabajo
    private int idCentro;
    private CentroTrabajo centro;
    private boolean centroBuscado;

    public Maquinaria() {
        this.centroBuscado = false;
    }

    public Maquinaria(int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa) {
        this.idMaquinaria = idMaquinaria;
        this.codMaquinaria = codMaquinaria;
        this.descripcion = descripcion;
        this.idCentro = idCentro;
        this.activa = activa;
        this.centroBuscado = false;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public String getCodMaquinaria() {
        return codMaquinaria;
    }

    public void setCodMaquinaria(String codMaquinaria) {
        this.codMaquinaria = codMaquinaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public CentroTrabajo getCentro() {
        if (this.centroBuscado == false){
                this.centro = CentroTrabajoController.getCentroById(this.idCentro);
                this.centroBuscado = true;
        }
        return centro;
    }

    public void setCentro(CentroTrabajo centro) {
        this.centro = centro;
    }

    public boolean isCentroBuscado() {
        return centroBuscado;
    }

    public void setCentroBuscado(boolean centroBuscado) {
        this.centroBuscado = centroBuscado;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
