package com.yahoo.alioth865.redegalntermedio;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;
import com.yahoo.alioth865.redegalntermedio.HTTPPackage.AHttpRHEmpleadoEspecifico;
import com.yahoo.alioth865.redegalntermedio.HTTPPackage.AHttpRHTodosEmpleados;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.Empleado;
import com.yahoo.alioth865.redegalntermedio.ModeloEmpleado.ListEmpleados;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Registro extends ActionBarActivity  {
    EditText etUsuario;
    EditText etContraseña;
    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializarComponentes();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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

    public void inicializarComponentes(){
        etUsuario=(EditText)findViewById(R.id.editTextUser);
        etContraseña=(EditText)findViewById(R.id.editTextPasswd);
        btnAceptar=(Button)findViewById(R.id.buttonAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlProducto="http://192.168.1.38/redegal/api/employees/";
                String key="88IWBKN2CG5EENND8MTVA4EKD57RN8X6";
                HiloListaEmpleados hiloListaEmpleados =new HiloListaEmpleados();
                //ESTO ES PARA PROBAR NO DEBERIA IR
                String usuario=etUsuario.getText().toString().trim();
                String cookieKey="XCpQPFtLBVB0AASGQG1MOPLP1oKUdr2xTcWbKjSgtnFVDKT8rnFjxRwi";
                String contraseña=etContraseña.getText().toString();
                hiloListaEmpleados.execute(urlProducto, key, usuario, cookieKey+contraseña);
            }
        });

    }

    class HiloListaEmpleados extends AsyncTask<String, Float, Void> {
        ListEmpleados listEmpleados;
        boolean isUsuarioValido=false;
        Empleado empleado;
        @Override
        protected Void doInBackground(String... params) {
            SyncHttpClient client = new SyncHttpClient();
            client.setBasicAuth(params[1],"");
            AsyncHttpResponseHandler rhTodosEmpleados=new AHttpRHTodosEmpleados();
            client.get(params[0],rhTodosEmpleados);
            String usuario=params[2];
            String contraseña=params[3];
            listEmpleados=((AHttpRHTodosEmpleados)(rhTodosEmpleados)).getListEmpleados();
            for(String tmp: listEmpleados.getIdEmpleados()){
                AsyncHttpResponseHandler rhEmpleado=new AHttpRHEmpleadoEspecifico();
                client.get(params[0]+"/"+tmp,rhEmpleado);
                empleado=((AHttpRHEmpleadoEspecifico)(rhEmpleado)).getEmpleado();
                try {
                    MessageDigest digest = MessageDigest.getInstance("MD5");
                    digest.update(contraseña.getBytes());


                    byte[] messageDigest = digest.digest();
                    String contraseñaencryptada = "";
                    for (int i=0; i<messageDigest.length; i++){
                        contraseñaencryptada+=Integer.toHexString((messageDigest[i]>>4) & 0xf );
                        contraseñaencryptada+= Integer.toHexString(messageDigest[i] & 0xf);
                    }

                    Log.i("Contraseña Sin Encriptar",contraseña);
                    Log.i("Contraseña",contraseñaencryptada);
                    if(empleado.getEmail().equals(usuario) && empleado.getContaseña().equals(contraseñaencryptada)){
                        isUsuarioValido=true;
                        break;
                    }
                }catch(Exception e){
                    Log.e("ERROR CON ENCRIPTACION", e.getMessage());
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i("Empleados",listEmpleados.toString());
            if(isUsuarioValido){
                Log.i("Empleado",empleado.toString());
                Toast.makeText(getApplicationContext(), "Autenticacion correcta", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Usuario o contraseña no válidas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
