package com.yahoo.alioth865.redegalntermedio.HTTPPackage;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserCustomer;
import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserListEmpleados;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.ListEmpleados;

import org.apache.http.Header;
import org.xml.sax.SAXException;

/**
 * Created by AliothAntonio on 15/03/2015.
 */
public class AHttpRHTodosEmpleados extends AsyncHttpResponseHandler{
    private ListEmpleados listEmpleados=new ListEmpleados();

    @Override
    public void onSuccess(int i, Header[] headers, byte[] response) {
        String xml= new String(response);
        XMLParserListEmpleados parser=new XMLParserListEmpleados(xml);
        try {
            listEmpleados=parser.parse();
        }catch (SAXException e){
            Log.e("ERROR PARSER", e.getMessage());
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        Log.e("Error", "Status "+statusCode);
    }


    public ListEmpleados getListEmpleados() {
        return listEmpleados;
    }
}
