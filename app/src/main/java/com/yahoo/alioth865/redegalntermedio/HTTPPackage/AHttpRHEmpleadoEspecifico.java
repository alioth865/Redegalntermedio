package com.yahoo.alioth865.redegalntermedio.HTTPPackage;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserEmpleadoEspecifico;
import com.yahoo.alioth865.redegalntermedio.Convertor.XMLParserListEmpleados;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.Empleado;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.ListEmpleados;

import org.apache.http.Header;
import org.xml.sax.SAXException;

/**
 * Created by AliothAntonio on 15/03/2015.
 */
public class AHttpRHEmpleadoEspecifico extends AsyncHttpResponseHandler{
    private Empleado empleado;

    @Override
    public void onSuccess(int i, Header[] headers, byte[] response) {
        String xml= new String(response);
        XMLParserEmpleadoEspecifico parser=new XMLParserEmpleadoEspecifico(xml);
        try {
            empleado=parser.parse();
        }catch (SAXException e){
            Log.e("ERROR PARSER", e.getMessage());
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        Log.e("Error AHttpRHEmpleadoEspecifico", "Status " + statusCode+" "+e.getMessage());
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
