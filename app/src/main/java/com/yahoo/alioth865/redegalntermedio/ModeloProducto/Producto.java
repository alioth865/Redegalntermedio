package com.yahoo.alioth865.redegalntermedio.ModeloProducto;

import java.io.Serializable;

/**
 * Created by Alioth on 24/02/2015.
 */
public class Producto implements Serializable{
    private String id;
    private String name;
    private String description;
    private String price;
    private Object imagen;
    private String reference;

    public Object getImagen() {
        //todo Ver lo relativo a imagenes
        return imagen;
    }

    public void setImagen(Object imagen) {
        //todo Ver lo relativo a imagenes
        this.imagen = imagen;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
