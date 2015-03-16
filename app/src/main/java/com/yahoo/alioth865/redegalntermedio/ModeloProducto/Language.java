package com.yahoo.alioth865.redegalntermedio.ModeloProducto;

import java.io.Serializable;

/**
 * Created by Alioth on 26/02/2015.
 */
public class Language implements Serializable{
    String id;
    String descripcion;

    public Language(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
