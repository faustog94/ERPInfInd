/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.CentroTrabajoController;
import Controllers.EstructuraController;
import Controllers.RutaFabricacionController;

/**
 *
 * @author franco-lxle
 */
public class DetalleRuta {
    private int idDetalleRuta;
    private int orden;
    private double tiempoManoObra;
    private double tiempoMaquina;
    private double tiempoReposo;
    
    //Puntero RutaFabricacion
    private int idRuta;
    private RutaFabricacion ruta;
    private boolean rutaBuscada;
    //Puntero CentroTrabajo
    private int idCentro;
    private CentroTrabajo centro;
    private boolean centroBuscado;
    //Puntero Estructura
    private int idEstructura;
    private Estructura estructura;
    private boolean estructuraBuscada;
    
    
    
    public DetalleRuta() {
        this.rutaBuscada = false;
        this.centroBuscado = false;
        this.estructuraBuscada = false;
    }

    public DetalleRuta(int idDetalleRuta, int orden, double tiempoManoObra, double tiempoMaquina, double tiempoReposo, int idRuta, int idCentro, int idEstructura) {
        this.idDetalleRuta = idDetalleRuta;
        this.orden = orden;
        this.tiempoManoObra = tiempoManoObra;
        this.tiempoMaquina = tiempoMaquina;
        this.tiempoReposo = tiempoReposo;
        this.idRuta = idRuta;
        this.idCentro = idCentro;
        this.idEstructura = idEstructura;
        this.rutaBuscada = false;
        this.centroBuscado = false;
        this.estructuraBuscada = false;
    }

    public int getIdDetalleRuta() {
        return idDetalleRuta;
    }

    public void setIdDetalleRuta(int idDetalleRuta) {
        this.idDetalleRuta = idDetalleRuta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public double getTiempoManoObra() {
        return tiempoManoObra;
    }

    public void setTiempoManoObra(double tiempoManoObra) {
        this.tiempoManoObra = tiempoManoObra;
    }

    public double getTiempoMaquina() {
        return tiempoMaquina;
    }

    public void setTiempoMaquina(double tiempoMaquina) {
        this.tiempoMaquina = tiempoMaquina;
    }

    public double getTiempoReposo() {
        return tiempoReposo;
    }

    public void setTiempoReposo(double tiempoReposo) {
        this.tiempoReposo = tiempoReposo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public RutaFabricacion getRuta() {
        if (this.rutaBuscada == false){
            this.ruta = RutaFabricacionController.getRutaFabricacionById(idRuta);
            this.rutaBuscada = true;
        }
        return ruta;
    }

    public void setRuta(RutaFabricacion ruta) {
        this.ruta = ruta;
    }

    public boolean isRutaBuscada() {
        return rutaBuscada;
    }

    public void setRutaBuscada(boolean rutaBuscada) {
        this.rutaBuscada = rutaBuscada;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public CentroTrabajo getCentro() {
        if (this.centroBuscado == false){
            this.centro = CentroTrabajoController.getCentroById(idCentro);
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

    public int getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(int idEstructura) {
        this.idEstructura = idEstructura;
    }

    public Estructura getEstructura() {
        if (this.estructuraBuscada == false){
            this.estructura = EstructuraController.getEstructuraById(idEstructura);
            this.estructuraBuscada = true;
        }
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public boolean isEstructuraBuscada() {
        return estructuraBuscada;
    }

    public void setEstructuraBuscada(boolean estructuraBuscada) {
        this.estructuraBuscada = estructuraBuscada;
    }
    
    
}
