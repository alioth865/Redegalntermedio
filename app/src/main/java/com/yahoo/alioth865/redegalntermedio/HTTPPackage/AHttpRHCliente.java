package com.yahoo.alioth865.redegalntermedio.HTTPPackage;

import android.util.Log;

import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserCustomer;
import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Cliente;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.xml.sax.SAXException;

/**
 * Created by Alioth on 24/02/2015.
 */
public class AHttpRHCliente extends AsyncHttpResponseHandler {
    private Cliente c=new Cliente();
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        // called when response HTTP status is "200 OK"
        String xml= new String(response);
        XMLParserCustomer parser=new XMLParserCustomer(xml);
        try {
            c=parser.parse();
        }catch (SAXException e){
            Log.e("ERROR PARSER", e.getMessage());
        }

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        Log.e("Error", "Status "+statusCode);
    }

    public Cliente getC() {
        return c;
    }
}
