package com.yahoo.alioth865.redegalntermedio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yahoo.alioth865.redegalntermedio.ModeloProducto.Producto;


public class Product extends ActionBarActivity {
    TextView idCategoryDefault;
    TextView condicion;
    TextView name;
    TextView descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        inicializarComponente();
    }

    private void inicializarComponente() {
        Producto p=(Producto)getIntent().getExtras().getSerializable("Producto");
        idCategoryDefault=(TextView)findViewById(R.id.textView8);
        idCategoryDefault.setText(p.getId_category_default());
        condicion=(TextView)findViewById(R.id.textView10);
        condicion.setText(p.getCondition());
        name=(TextView)findViewById(R.id.textView12);
        name.setText(p.getName().retornar(1).getDescripcion());
        descripcion=(TextView)findViewById(R.id.textView14);
        descripcion.setText(p.getDescription().retornar(1).getDescripcion());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product, menu);
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
}
