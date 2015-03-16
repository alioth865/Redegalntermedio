package com.yahoo.alioth865.redegalntermedio.ModeloCliente;

import java.io.Serializable;

/**
 * Created by Alioth on 19/02/2015.
 */
public class Group implements Serializable {
    private String id;

    public Group(String id) {
        this.id = id;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                '}';
    }
}
