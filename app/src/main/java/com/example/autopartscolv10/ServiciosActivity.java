package com.example.autopartscolv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ServiciosActivity extends AppCompatActivity {
    private Button btnSelec;
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
        setContentView(R.layout.activity_servicios);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Servicios");
        getSupportActionBar().setSubtitle("Seleccione una Servicio");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        btnSelec = (Button) findViewById(R.id.btnSelec);

        btnSelec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " Este boton lo llevara al servicio ",Toast.LENGTH_LONG).show();

            }
        });
    }
}