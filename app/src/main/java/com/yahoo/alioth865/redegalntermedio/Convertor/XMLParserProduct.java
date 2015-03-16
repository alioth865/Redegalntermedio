package com.yahoo.alioth865.redegalntermedio.Convertor;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Log;
import android.util.Xml;

import com.yahoo.alioth865.redegalntermedio.ModeloProducto.AvailableNow;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Description;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.DescriptionShort;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Language;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Name;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Producto;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Created by Alioth on 25/02/2015.
 */
public class XMLParserProduct {
    private String xml;
    private Language lang;
    private Name name;
    private Description description;
    private DescriptionShort descriptionShort;
    private AvailableNow availableNow;



    public XMLParserProduct(String xml) {
        this.xml = xml;
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
        product.getChild("id_manufacturer").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setId_manufacturer(body);
            }
        });
        product.getChild("id_supplier").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setId_supplier(body);
            }
        });
        product.getChild("id_category_default").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setId_category_default(body);
            }
        });
        product.getChild("cache_default_attribute").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setCache_default_attribute(body);
            }
        });
        product.getChild("is_virtual").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setIs_virtual(body);
            }
        });
        product.getChild("on_sale").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setOn_sale(body);
            }
        });
        product.getChild("online_only").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setOnline_only(body);
            }
        });
        product.getChild("minimal_quanity").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setMinimal_quantity(body);
            }
        });
        product.getChild("price").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setPrice(body);
            }
        });
        product.getChild("condition").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                producto.setCondition(body);
            }
        });

        product.getChild("name").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                name = new Name();
            }
        });

        product.getChild("name").getChild("language").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                lang=new Language(attributes.getValue("id"));
            }
        });
        product.getChild("name").getChild("language").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                lang.setDescripcion(body);
                name.insertar(Integer.parseInt(lang.getId()),lang);
            }
        });

        product.getChild("name").setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                producto.setName(name);
                Log.i("ANALIZAR: ->:", producto.getName().retornar(1).getDescripcion());
            }
        });




        product.getChild("description").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                description = new Description();
            }
        });

        product.getChild("description").getChild("language").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                lang=new Language(attributes.getValue("id"));
            }
        });
        product.getChild("description").getChild("language").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                lang.setDescripcion(body);
                description.insertar(Integer.parseInt(lang.getId()),lang);
            }
        });

        product.getChild("description").setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                producto.setDescription(description);
            }
        });


        product.getChild("description_short").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                descriptionShort = new DescriptionShort();
            }
        });

        product.getChild("description_short").getChild("language").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                lang=new Language(attributes.getValue("id"));
            }
        });
        product.getChild("description_short").getChild("language").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                lang.setDescripcion(body);
                descriptionShort.insertar(Integer.parseInt(lang.getId()),lang);
            }
        });

        product.getChild("description_short").setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                producto.setDescription_short(descriptionShort);
            }
        });

        product.getChild("available_now").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                availableNow = new AvailableNow();
            }
        });

        product.getChild("available_now").getChild("language").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                lang=new Language(attributes.getValue("id"));
            }
        });
        product.getChild("available_now").getChild("language").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                lang.setDescripcion(body);
                availableNow.insertar(Integer.parseInt(lang.getId()),lang);
            }
        });

        product.getChild("available_now").setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                producto.setAvailable_now(availableNow);
            }
        });


        Xml.parse(xml, root.getContentHandler());
        return producto;
    }
}
