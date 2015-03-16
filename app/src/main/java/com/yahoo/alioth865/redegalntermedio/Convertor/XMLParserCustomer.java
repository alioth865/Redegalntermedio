package com.yahoo.alioth865.redegalntermedio.Convertor;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Associations;
import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Cliente;
import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Group;
import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Groups;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Created by Alioth on 19/02/2015.
 */
public class XMLParserCustomer {
    private Associations assoc;
    private Groups grupos;
    private String xml;

    public XMLParserCustomer(String xml) {
        this.xml = xml;
    }

    public Cliente parse() throws SAXException {
        final Cliente cliente=new Cliente();
        RootElement root=new RootElement("prestashop");
        Element customer=root.getChild("customer");
        Element associations=customer.getChild("associations");
        customer.getChild("id").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId(body);
            }
        });
        customer.getChild("id_default_group").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_default_group(body);
            }
        });
        customer.getChild("id_lang").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_lang(body);
            }
        });
        customer.getChild("newsletter_date_add").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setNewsletter_date_date_add(body);
            }
        });
        customer.getChild("ip_registration_newsletter").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setIp_registration_newsletter(body);
            }
        });
        customer.getChild("last_passwd_gen").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setLast_passwd_gen(body);
            }
        });
        customer.getChild("secure_key").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setSecure_key(body);
            }
        });
        customer.getChild("deleted").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setDeleted(body);
            }
        });
        customer.getChild("passwd").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setPasswd(body);
            }
        });
        customer.getChild("lastname").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setLastname(body);
            }
        });
        customer.getChild("firstname").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setFirstname(body);
            }
        });
        customer.getChild("email").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setEmail(body);
            }
        });
        customer.getChild("id_gender").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_gender(body);
            }
        });
        customer.getChild("birthday").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setBirthday(body);
            }
        });
        customer.getChild("newsletter").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setNewsletter(body);
            }
        });
        customer.getChild("optin").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setOptin(body);
            }
        });
        customer.getChild("website").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setWebsite(body);
            }
        });
        customer.getChild("company").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setCompany(body);
            }
        });
        customer.getChild("siret").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setSiret(body);
            }
        });
        customer.getChild("ape").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setApe(body);
            }
        });
        customer.getChild("outstanding_allow_amount").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setOutstanding_allow_amount(body);
            }
        });
        customer.getChild("show_public_prices").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setShow_public_prices(body);
            }
        });
        customer.getChild("id_risk").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_risk(body);
            }
        });
        customer.getChild("max_payment_days").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setMax_payment_days(body);
            }
        });
        customer.getChild("active").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setActive(body);
            }
        });
        customer.getChild("note").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setNote(body);
            }
        });
        customer.getChild("is_guest").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setIs_guest(body);
            }
        });
        customer.getChild("id_shop").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_shop(body);
            }
        });
        customer.getChild("id_shop_group").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setId_shop_group(body);
            }
        });
        customer.getChild("date_add").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setDate_add(body);
            }
        });
        customer.getChild("date_upd").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                cliente.setDate_upd(body);
            }
        });
        associations.setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                assoc=new Associations();
            }
        });

        associations.setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                cliente.setAssociations(assoc);
            }
        });
        associations.getChild("groups").setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                grupos = new Groups();
            }
        });

        associations.getChild("groups").setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                assoc.setGroups(grupos);
            }
        });

        associations.getChild("groups").getChild("group").getChild("id").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                grupos.addGroup(new Group(body));
            }
        });

        Xml.parse(xml, root.getContentHandler());

        return cliente;


    }

}
