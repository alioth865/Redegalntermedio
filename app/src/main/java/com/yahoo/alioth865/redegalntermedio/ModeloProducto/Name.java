package com.yahoo.alioth865.redegalntermedio.ModeloProducto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alioth on 26/02/2015.
 */
public class Name implements Serializable {
    private Map<Integer,Language> elementos;

    public Name() {
        this.elementos = new HashMap<>();
    }

    public void insertar(int k, Language v){
        this.elementos.put(k,v);
    }

    public Language retornar(int k){
        return this.elementos.get(k);
    }

}
