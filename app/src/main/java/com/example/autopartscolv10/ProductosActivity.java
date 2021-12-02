package com.example.autopartscolv10;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    LinearLayout linearPadre;
    LinearLayout linearvertical;
    LinearLayout linearFila;
    LinearLayout linearColumna;
    ArrayList<Producto> carro;
    ArrayList<Producto> listaProductos;
    Spinner numeroprod;
    ScrollView Scroll;

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
            Intent intent4 = new Intent(this, CarritoActivity.class);
            Bundle bundel = new Bundle();
            bundel.putParcelableArrayList("carro", carro);
            intent4.putExtras(bundel);
            startActivity(intent4);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        ActionBar var = getSupportActionBar();
        var.setDisplayShowHomeEnabled(true);
        var.setTitle("Productos");
        var.setSubtitle("Seleccione un Producto");
        var.setLogo(R.mipmap.ic_launcher);
        var.setDisplayUseLogoEnabled(true);

        carro = new ArrayList<>();
        listaProductos = new ArrayList<>();

        listaProductos.add(new Producto(1, "Rin de Lujo 15 in", 150000, R.drawable.rin));
        listaProductos.add(new Producto(2, "Turbo Compresor", 1500000, R.drawable.turbo));
        listaProductos.add(new Producto(3, "Asientos de Carreras", 500000, R.drawable.asiento));
        listaProductos.add(new Producto(4, "Frenos de Disco", 400000, R.drawable.frenos));


        linearPadre = (LinearLayout) findViewById(R.id.linearPadre);

        int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;
        int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

        for(Producto p: listaProductos){

            Scroll = new ScrollView(this);
            Scroll.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));

            linearvertical = new LinearLayout(this);
            linearvertical.setOrientation(LinearLayout.VERTICAL);
            linearvertical.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            linearvertical.setBackgroundColor(getResources().getColor(R.color.Azul_Petroleo));

            linearFila = new LinearLayout(this);
            linearFila.setOrientation(LinearLayout.HORIZONTAL);
            linearFila.setLayoutParams(new LinearLayout.LayoutParams(matchParent,600, 1));

            ImageView imagen = new ImageView(this);
            imagen.setImageResource(p.getImagen());
            imagen.setLayoutParams(new LinearLayout.LayoutParams(1200,wrapContent,1));
            imagen.setScaleType(ImageView.ScaleType.FIT_XY);

            linearColumna = new LinearLayout(this);
            linearColumna.setOrientation(LinearLayout.VERTICAL);
            linearColumna.setLayoutParams(new LinearLayout.LayoutParams(matchParent,matchParent,1));
            linearColumna.setBackgroundColor(getResources().getColor(R.color.Gris_Claro));

            TextView txtNombreProd = new TextView(this);
            txtNombreProd.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            txtNombreProd.setGravity(Gravity.CENTER);
            txtNombreProd.setText(R.string.txtNombProd);
            txtNombreProd.setTextColor(getResources().getColor(R.color.white));

            TextView txtProd = new TextView(this);
            txtProd.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            txtProd.setGravity(Gravity.CENTER);
            txtProd.setText(p.getNombreProd());
            txtProd.setTextColor(getResources().getColor(R.color.white));

            TextView txtPrecioProd = new TextView(this);
            txtPrecioProd.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            txtPrecioProd.setGravity(Gravity.CENTER);
            txtPrecioProd.setText(R.string.txtPrecProd);
            txtPrecioProd.setTextColor(getResources().getColor(R.color.white));

            TextView txtPrecio = new TextView(this);
            txtPrecio.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            txtPrecio.setGravity(Gravity.CENTER_VERTICAL);
            txtPrecio.setText("COP $ "+ p.getPrecio());
            txtPrecio.setTextColor(getResources().getColor(R.color.white));

            TextView txtCantidad = new TextView(this);
            txtCantidad.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            txtCantidad.setGravity(Gravity.CENTER_VERTICAL);
            txtCantidad.setText(R.string.txtcantidad);
            txtCantidad.setTextColor(getResources().getColor(R.color.white));

            Spinner numeroProd = new Spinner(this);
            numeroProd.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            numeroProd.setGravity(Gravity.CENTER);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lista,android.R.layout.simple_list_item_1);
            numeroProd.setAdapter(adapter);

            Switch Seleccionar = new Switch(this);
            Seleccionar.setLayoutParams(new LinearLayout.LayoutParams(wrapContent,wrapContent));
            Seleccionar.setGravity(Gravity.CENTER_HORIZONTAL);
            Seleccionar.setText(R.string.txtcomprar);
            Seleccionar.setTextColor(getResources().getColor(R.color.white));

            Seleccionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Seleccionar.isChecked()) {
                        carro.add(p);
                        Toast.makeText(getApplicationContext(), " El producto seleccionado " + p.getNombreProd() + " sera añadido al carrito", Toast.LENGTH_LONG).show();
                    }
                }
            });
            linearColumna.addView(txtNombreProd);
            linearColumna.addView(txtProd);
            linearColumna.addView(txtPrecioProd);
            linearColumna.addView(txtPrecio);
            linearColumna.addView(txtCantidad);
            linearColumna.addView(numeroProd);
            linearColumna.addView(Seleccionar);

            Button carrito = new Button(this);
            carrito.setLayoutParams(new LinearLayout.LayoutParams(matchParent,wrapContent));
            carrito.setText("Comprar");
            carrito.setBackgroundColor(getResources().getColor(R.color.Amarillo));
            carrito.setTextColor(getResources().getColor(R.color.black));

            carrito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Seleccionar.isChecked()) {

                        Intent intent4 = new Intent(getApplicationContext(), CarritoActivity.class);
                        Bundle bundel = new Bundle();
                        bundel.putParcelableArrayList("carro", carro);
                        intent4.putExtras(bundel);
                        startActivity(intent4);

                    }else {
                        Toast.makeText(getApplicationContext(), "Debe seleccionar un articulo para ir al carrito ", Toast.LENGTH_LONG).show();
                    }
                }
            });

            linearFila.addView(imagen);
            linearFila.addView(linearColumna);

            linearvertical.addView(linearFila);
            linearvertical.addView(carrito);

            Scroll.addView(linearvertical);

            linearPadre.addView(Scroll);
        }

    }

}
