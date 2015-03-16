package com.yahoo.alioth865.redegalntermedio.ModeloEmpleado;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AliothAntonio on 15/03/2015.
 */
public class ListEmpleados {
    List<String> idEmpleados;

    public ListEmpleados() {
        this.idEmpleados = new LinkedList<>();
    }

    public void addId(String id){
        idEmpleados.add(id);
    }

    @Override
    public String toString() {
        String retorno="";
        for(String tmp:idEmpleados){
            retorno+=tmp+"\n";
        }
        return retorno;
    }

    public List<String> getIdEmpleados() {
        return idEmpleados;
    }
}
