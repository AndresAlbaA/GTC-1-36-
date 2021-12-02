package com.example.autopartscolv10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    LinearLayout linearPadre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        ActionBar var = getSupportActionBar();
        var.setDisplayShowHomeEnabled(true);
        var.setTitle("Carrito");
        var.setSubtitle("Aqui podra pagar sus Productos");
        var.setLogo(R.mipmap.ic_launcher);
        var.setDisplayUseLogoEnabled(true);

        linearPadre = (LinearLayout) findViewById(R.id.linearPadreCarrito);

        Intent intentCarro = getIntent();
        ArrayList<Producto> carritoCompras = (ArrayList<Producto>) intentCarro.getSerializableExtra("carro");

        if (carritoCompras.size() != 0) {

            for (Producto p : carritoCompras) {
                TextView txtNombre = new TextView(this);
                txtNombre.setText(p.getNombreProd());

                linearPadre.addView(txtNombre);
            }
        }else{
            Toast.makeText(this, "Su carrito de compras esta vacio", Toast.LENGTH_LONG).show();
        }
    }

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
        if (id == R.id.carrito) {
            Intent intent4 = new Intent(getApplicationContext(), CarritoActivity.class);
            startActivity(intent4);
        }
        return super.onOptionsItemSelected(item);
    }
}