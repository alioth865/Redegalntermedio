package com.yahoo.alioth865.redegalntermedio.Convertor;

import android.sax.Element;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.TextElementListener;
import android.util.Xml;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Producto;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Created by Alioth on 25/02/2015.
 */
public class XMLParserProduct {
    private String xml;
    private String idlanguage;

    public XMLParserProduct(String xml, String idlanguage) {
        this.xml = xml;
        this.idlanguage = idlanguage;
    }

    public Producto parse() throws SAXException{
        final Producto producto=new Producto();
        RootElement root=new RootElement("prestashop");
        final Element product=root.getChild("product");

        product.getChild("id").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setId(body);
            }
        });

        product.getChild("price").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setPrice(body);
            }
        });

        product.getChild("name").getChild("language").setTextElementListener(new TextElementListener() {
            boolean isLenguajeCorrectoName=false;
            @Override
            public void end(String body) {
                if(isLenguajeCorrectoName){
                    producto.setName(body);
                }
            }

            @Override
            public void start(Attributes attributes) {
                isLenguajeCorrectoName = idlanguage.equals(attributes.getValue("id"));
            }
        });

        product.getChild("name").getChild("description").setTextElementListener(new TextElementListener() {
            boolean isLenguajeCorrectoName=false;
            @Override
            public void end(String body) {
                if(isLenguajeCorrectoName){
                    producto.setDescription(body);
                }
            }

            @Override
            public void start(Attributes attributes) {
                isLenguajeCorrectoName = idlanguage.equals(attributes.getValue("id"));
            }
        });

        product.getChild("reference").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setReference(body);
            }
        });

        //TODO HACER TODO LO RELATIVO A LAS IMAGENES


        Xml.parse(xml, root.getContentHandler());
        return producto;
    }
}
