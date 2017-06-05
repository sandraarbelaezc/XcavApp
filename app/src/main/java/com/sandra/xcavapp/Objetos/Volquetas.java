package com.sandra.xcavapp.Objetos;

/**
 * Created by sandra on 31/05/2017.
 */

public class Volquetas {
    private String Placa;
    private String Capacidad;
    private String Distancia;
    private String NViajes;
    private String TPagar;

    public Volquetas(String placa, String capacidad, String distancia, String NViajes, String TPagar) {
        this.Placa = placa;
        this.Capacidad = capacidad;
        this.Distancia = distancia;
        this.NViajes = NViajes;
        this.TPagar = TPagar;
    }

    public Volquetas() {
        this.Placa = "";
        this.Capacidad = "";
        this.Distancia = "";
        this.NViajes = "";
        this.TPagar = "";
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }

    public String getNViajes() {
        return NViajes;
    }

    public void setNViajes(String NViajes) {
        this.NViajes = NViajes;
    }

    public String getTPagar() {
        return TPagar;
    }

    public void setTPagar(String TPagar) {
        this.TPagar = TPagar;
    }
}
