package com.example.autopartscolv10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ProductosActivity extends AppCompatActivity {

    private Button btnComprar;
    private Switch Select1;
    private Switch Select2;
    private Switch Select3;
    private Switch Select4;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
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
        setContentView(R.layout.activity_productos);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Productos");
        getSupportActionBar().setSubtitle("Seleccione un Producto");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        btnComprar = (Button) findViewById(R.id.btnComprar);
        Select1 = (Switch) findViewById(R.id.Select1);
        Select2 = (Switch) findViewById(R.id.Select2);
        Select3 = (Switch) findViewById(R.id.Select3);
        Select4 = (Switch) findViewById(R.id.Select4);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Select1.isChecked() || Select2.isChecked() || Select3.isChecked() || Select4.isChecked()){
                    Toast.makeText(getApplicationContext(), " Este boton lo llevara al carrito de compras con los articulos seleccionados",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Debe seleccionar un articulo para ir al carrito ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onclick(View view){
        if (view.getId() == R.id.Select1){
            if (Select1.isChecked()){
                Toast.makeText(getApplicationContext(), " El producto seleccionado (Rines de Lujo 15 in) sera añadido al carrito",Toast.LENGTH_LONG).show();
            }
        }
        if (view.getId() == R.id.Select2){
            if (Select2.isChecked()){
                Toast.makeText(getApplicationContext(), " El producto seleccionado (Turbo Compresor) sera añadido al carrito",Toast.LENGTH_LONG).show();
            }
        }
        if (view.getId() == R.id.Select3){
            if (Select3.isChecked()){
                Toast.makeText(getApplicationContext(), " El producto seleccionado (Asiento de Carrera) sera añadido al carrito",Toast.LENGTH_LONG).show();
            }
        }
        if (view.getId() == R.id.Select4){
            if (Select4.isChecked()){
                Toast.makeText(getApplicationContext(), " El producto seleccionado (Frenos de Disco) sera añadido al carrito",Toast.LENGTH_LONG).show();
            }
        }
    }
}
