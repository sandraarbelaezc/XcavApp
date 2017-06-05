package com.sandra.xcavapp.Objetos;

/**
 * Created by sandra on 31/05/2017.
 */

public class HorasMantenimiento {

    private String Id;
    private String Fecha;
    private String Hinicial;
    private String HFinal;
    private String THoras;
    private String TPagar;

    public HorasMantenimiento(String id, String fecha, String hinicial, String HFinal, String THoras, String TPagar) {
        this.Id = id;
        this.Fecha = fecha;
        this.Hinicial = hinicial;
        this.HFinal = HFinal;
        this.THoras = THoras;
        this.TPagar = TPagar;
    }

    public HorasMantenimiento() {
        this.Id = "";
        this.Fecha = "";
        this.Hinicial = "";
        this.HFinal = "";
        this.THoras = "";
        this.TPagar = "";
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHinicial() {
        return Hinicial;
    }

    public void setHinicial(String hinicial) {
        Hinicial = hinicial;
    }

    public String getHFinal() {
        return HFinal;
    }

    public void setHFinal(String HFinal) {
        this.HFinal = HFinal;
    }

    public String getTHoras() {
        return THoras;
    }

    public void setTHoras(String THoras) {
        this.THoras = THoras;
    }

    public String getTPagar() {
        return TPagar;
    }

    public void setTPagar(String TPagar) {
        this.TPagar = TPagar;
    }
}
