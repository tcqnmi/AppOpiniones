package com.example.opiniones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class ListadoLOpis extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listadoopis);

        ListView lvListado  = (ListView)  findViewById(R.id.listadoOpis);
        Button btVolver = (Button) findViewById(R.id.btVolverOpis);

        Opiniones opinines = new Opiniones();
        String [] arrayopis = (String [])opinines.devolverArrayListOpis().toArray(new String[0]);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayopis);

        lvListado.setAdapter(adapter);

        AdapterView.OnItemClickListener listenerLista = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent llamadaDetalle = new Intent(getApplicationContext(), Detalle.class);

                llamadaDetalle.putExtra("posicion",i);

                startActivity(llamadaDetalle);
            }
        };
        lvListado.setOnItemClickListener(listenerLista);

        View.OnClickListener volver = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        btVolver.setOnClickListener(volver);

    }
}
