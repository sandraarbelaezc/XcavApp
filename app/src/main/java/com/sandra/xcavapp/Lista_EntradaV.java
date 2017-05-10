package com.sandra.xcavapp;

/**
 * Created by sandra on 04/05/2017.
 */

public class Lista_EntradaV {
    private String VolqP, NViajes;

    public Lista_EntradaV(String volqP, String NViajes) {
        VolqP = volqP;
        this.NViajes = NViajes;
    }

    public String getVolqP() {
        return VolqP;
    }

    public void setVolqP(String volqP) {
        VolqP = volqP;
    }

    public String getNViajes() {
        return NViajes;
    }

    public void setNViajes(String NViajes) {
        this.NViajes = NViajes;
    }
}
