package com.example.autopartscolv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtCiudad;
    private Button btnInicio;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

            if (id == R.id.opProductos) {
                Intent intent = new Intent(getApplicationContext(), ProductosActivity.class);
                startActivity(intent);
            }

            if (id == R.id.opServicios) {
                Intent intent2 = new Intent(getApplicationContext(), ServiciosActivity.class);
                startActivity(intent2);
            }

            if (id == R.id.opSucursales) {
                Intent intent3 = new Intent(getApplicationContext(), SucursalesActivity.class);
                startActivity(intent3);
            }
            return super.onOptionsItemSelected(item);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Ingreso a la App");
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtCiudad = (EditText) findViewById(R.id.edtCiudad);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString();
                String ciudad = edtCiudad.getText().toString();

                if (usuario.equals("") && ciudad.equals("")){
                    Toast.makeText(getApplicationContext(), "Por favor ingrese su nombre y ciudad de destino ",Toast.LENGTH_LONG).show();
                }
                else if (ciudad.equals("bogota") || ciudad.equals("cali") || ciudad.equals("medellin") || ciudad.equals("barranquilla")){
                    Toast.makeText(getApplicationContext(), "Bienvenido "+ usuario +" nuestra tienda puede hacer envios a: "+ ciudad,Toast.LENGTH_LONG).show();
                    Intent intent4 = new Intent(getApplicationContext(), ProductosActivity.class);
                    startActivity(intent4);
                }else{
                    Toast.makeText(getApplicationContext(), "Lo sentimos aun no tenemos envios a su ciudad",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}