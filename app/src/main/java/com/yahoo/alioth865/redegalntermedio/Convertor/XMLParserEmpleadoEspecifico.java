package com.yahoo.alioth865.redegalntermedio.Convertor;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.Empleado;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.ListEmpleados;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class XMLParserEmpleadoEspecifico {
    private String xml;

    public XMLParserEmpleadoEspecifico(String xml) {
        this.xml = xml;
    }

    public Empleado parse() throws SAXException {
        final Empleado empleado=new Empleado();
        RootElement root=new RootElement("prestashop");
        Element elementEmpleado= root.getChild("employee");
        elementEmpleado.getChild("firstname").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                empleado.setNombre(body);
            }
        });
        elementEmpleado.getChild("lastname").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                empleado.setApellido(body);
            }
        });
        elementEmpleado.getChild("email").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                empleado.setEmail(body);
            }
        });
        elementEmpleado.getChild("passwd").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                empleado.setContaseña(body);
            }
        });
         Xml.parse(xml, root.getContentHandler());
        return empleado;

    }
}
