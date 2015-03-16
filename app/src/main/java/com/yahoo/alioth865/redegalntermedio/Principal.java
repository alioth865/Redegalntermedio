package com.yahoo.alioth865.redegalntermedio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.yahoo.alioth865.redegalntermedio.HTTPPackage.AHttpRHCliente;
import com.yahoo.alioth865.redegalntermedio.HTTPPackage.AHttpRHProducto;
import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Cliente;
import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Producto;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;


public class Principal extends ActionBarActivity {
    Button cliente;
    Button producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inicializarComponentes();


    }

    private void inicializarComponentes() {
        cliente=(Button)findViewById(R.id.buttonAceptar);
        producto=(Button)findViewById(R.id.button2);
        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlCliente="http://10.0.0.184/prestashop/api/customers/1";
                String key="88IWBKN2CG5EENND8MTVA4EKD57RN8X6";
                HiloCliente hiloCliente =new HiloCliente();
                hiloCliente.execute(urlCliente, key);
            }
        });

        producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlProducto="http://10.0.0.184/prestashop/api/products/1";
                String key="88IWBKN2CG5EENND8MTVA4EKD57RN8X6";
                HiloProducto hiloCliente =new HiloProducto();
                hiloCliente.execute(urlProducto, key);
            }
        });










    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class HiloCliente extends AsyncTask<String, Float, Void> {
        Cliente c;
        @Override
        protected Void doInBackground(String... params) {
            SyncHttpClient client = new SyncHttpClient();
            client.setBasicAuth(params[1],"");
            AsyncHttpResponseHandler rhCliente=new AHttpRHCliente();
            client.get(params[0],rhCliente);
            c=((AHttpRHCliente)(rhCliente)).getC();
            //Log.i("Cliente",c.toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent i=new Intent(Principal.this, Customer.class);
            //Log.i("Cliente",c.toString());
            i.putExtra("Cliente", c);
            startActivity(i);
        }
    }

    class HiloProducto extends AsyncTask<String, Float, Void> {
        Producto producto;
        @Override
        protected Void doInBackground(String... params) {
            SyncHttpClient client = new SyncHttpClient();
            client.setBasicAuth(params[1],"");
            AsyncHttpResponseHandler rhProducto=new AHttpRHProducto();
            client.get(params[0],rhProducto);
            producto=((AHttpRHProducto)(rhProducto)).getProducto();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent i=new Intent(Principal.this, Product.class);
            //Log.i("Cliente",c.toString());
            i.putExtra("Producto", producto);
            startActivity(i);
        }
    }

}