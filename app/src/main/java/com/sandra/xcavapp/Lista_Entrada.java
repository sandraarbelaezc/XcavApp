package com.sandra.xcavapp;

/**
 * Created by sandra on 03/05/2017.
 */

public class Lista_Entrada {
    private String Fech, THoras, TPago;

    public Lista_Entrada(String fech, String THoras, String TPago) {
        this.Fech = fech;
        this.THoras = THoras;
        this.TPago = TPago;
    }

    public String getFech() {
        return Fech;
    }

    public void setFech(String fech) {
        Fech = fech;
    }

    public String getTHoras() {
        return THoras;
    }

    public void setTHoras(String THoras) {
        this.THoras = THoras;
    }

    public String getTPago() {
        return TPago;
    }

    public void setTPago(String TPago) {
        this.TPago = TPago;
    }
}
