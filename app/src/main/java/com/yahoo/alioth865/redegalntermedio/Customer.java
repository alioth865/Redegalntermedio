package com.yahoo.alioth865.redegalntermedio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yahoo.alioth865.redegalntermedio.ModeloCliente.Cliente;


public class Customer extends ActionBarActivity {
    TextView nombre;
    TextView apellido;
    TextView correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Inicializar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer, menu);
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

    public void Inicializar(){
        nombre=(TextView)findViewById(R.id.textView2);
        apellido=(TextView)findViewById(R.id.textView4);
        correo=(TextView)findViewById(R.id.textView6);
        Cliente c=(Cliente)getIntent().getExtras().getSerializable("Cliente");
        nombre.setText(c.getFirstname());
        apellido.setText(c.getLastname());
        correo.setText(c.getEmail());
    }
}
