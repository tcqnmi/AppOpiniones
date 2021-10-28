package com.example.opiniones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        TextView tv = (TextView) findViewById(R.id.cabecera);
        ListView lv = (ListView) findViewById(R.id.opciones);

        Libros libros = new Libros();

        String titulos[] = libros.getTitulos();

        ArrayAdapter adapterTitulos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titulos);

        lv.setAdapter(adapterTitulos);

        AdapterView.OnItemClickListener listenerLista = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent detallado = new Intent(getApplicationContext(), Detalle.class);

                detallado.putExtra("posicion",i);

                startActivity(detallado);

            }
        };
        lv.setOnItemClickListener(listenerLista);


    }


}
