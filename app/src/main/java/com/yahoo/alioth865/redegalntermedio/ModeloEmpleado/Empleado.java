package com.yahoo.alioth865.redegalntermedio.ModeloEmpleado;

/**
 * Created by AliothAntonio on 15/03/2015.
 */
public class Empleado {
    String nombre;
    String apellido;
    String contaseña;
    String email;

    public Empleado(String nombre, String apellido, String contaseña, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contaseña = contaseña;
        this.email = email;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContaseña() {
        return contaseña;
    }

    public void setContaseña(String contaseña) {
        this.contaseña = contaseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contaseña='" + contaseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


