package com.yahoo.alioth865.redegalntermedio.ModeloCliente;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alioth on 18/02/2015.
 */
public class Groups implements Serializable {
    List<Group> groups;

    public Groups(List<Group> groups) {
        this.groups = groups;
    }

    public Groups() {
        this.groups =new LinkedList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groups=" + groups +
                '}';
    }
}
