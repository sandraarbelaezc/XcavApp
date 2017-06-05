package com.sandra.xcavapp.Objetos;

public class Operadores {
    private String Id;
    private String Nombre;
    private String Contraseña;
    private String Correo;

    public Operadores(String id, String nombre, String contraseña, String correo) {
        this.Id = id;
        this.Nombre = nombre;
        this.Contraseña = contraseña;
        this.Correo = correo;
    }

    public Operadores() {
        this.Id = "";
        this.Nombre = "";
        this.Contraseña ="";
        this.Correo = "";
    }


    public String getId() { return Id; }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
