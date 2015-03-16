package com.yahoo.alioth865.redegalntermedio.ModeloCliente;

import java.io.Serializable;

/**
 * Created by Alioth on 18/02/2015.
 */
public class Associations implements Serializable {
    Groups groups;

    public Associations(Groups groups) {
        this.groups = groups;
    }

    public Associations() {
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Associations{" +
                "groups=" + groups +
                '}';
    }
}
