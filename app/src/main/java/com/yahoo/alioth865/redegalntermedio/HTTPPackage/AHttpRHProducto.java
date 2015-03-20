package com.yahoo.alioth865.redegalntermedio.HTTPPackage;

import android.util.Log;


import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserProduct;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Producto;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.xml.sax.SAXException;

/**
 * Created by Alioth on 25/02/2015.
 */
public class AHttpRHProducto extends AsyncHttpResponseHandler{
    private Producto producto=new Producto();
    private String language;

    public AHttpRHProducto(String language) {
        this.language = language;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        // called when response HTTP status is "200 OK"
        String xml= new String(response);
        XMLParserProduct parser=new XMLParserProduct(xml, language);
        try {
            producto=parser.parse();
        }catch (SAXException e){
            Log.e("ERROR PARSER", e.getMessage());
        }

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        Log.e("Error AHttpRHProducto", "Status " + statusCode+" "+e.getMessage());
    }

    public Producto getProducto() {
        return producto;
    }
}
