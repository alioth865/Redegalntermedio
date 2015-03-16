package com.yahoo.alioth865.redegalntermedio.Convertor;

import android.sax.Element;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.ListEmpleados;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class XMLParserListEmpleados {
    private String xml;

    public XMLParserListEmpleados(String xml) {
        this.xml = xml;
    }

    public ListEmpleados parse() throws SAXException {
        final ListEmpleados listEmpleados=new ListEmpleados();
        RootElement root=new RootElement("prestashop");
        Element empleados= root.getChild("employees");
        empleados.getChild("employee").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                listEmpleados.addId(attributes.getValue("id"));
            }
        });
        Xml.parse(xml, root.getContentHandler());
        return listEmpleados;

    }
}
