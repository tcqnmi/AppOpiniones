package com.example.opiniones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detalle);

        TextView tvLibro = (TextView) findViewById(R.id.libro);
        TextView tvAutor = (TextView) findViewById(R.id.autor);
        TextView tvOpiniones = (TextView) findViewById(R.id.opinion);
        TextView tvUsuario = (TextView)  findViewById(R.id.usuario);
        Button btVolver = (Button) findViewById(R.id.btVolver);
        Button btEscribir = (Button) findViewById(R.id.btescribirOpinion);

        Intent det = this.getIntent();

        final int pos = det.getIntExtra("posicion", 0);

        Libros lib = new Libros();
        Opiniones op = new Opiniones();

        tvLibro.setText(lib.getLibro(pos));
        tvAutor.setText(lib.getAutor(pos));
        tvOpiniones.setText(op.getOpinion(pos));
        tvUsuario.setText(op.getUser(pos));

        View.OnClickListener listenerVolver = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        btVolver.setOnClickListener(listenerVolver);

        View.OnClickListener listenerEscribir = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent esc = new Intent(getApplicationContext(), Edit.class);

                esc.putExtra("pos",pos);

                startActivityForResult(esc, 0);
            }
        };
        btEscribir.setOnClickListener(listenerEscribir);



    }

    public void onActivityResult(int requestCode, int resultCode, Intent i){

        TextView tvOpiniones = (TextView) findViewById(R.id.opinion);
        TextView tvUsuario = (TextView)  findViewById(R.id.usuario);
        Opiniones opi = new Opiniones();

        if(resultCode == -1){

            final int pos = i.getIntExtra("pos",0);

            opi.reescribirOpi(pos,i.getStringExtra("opinion").toString());
            opi.reescribirUser(pos,i.getStringExtra("user").toString());
            tvOpiniones.setText(opi.getOpinion(pos));
            tvUsuario.setText(opi.getUser(pos));
            Toast.makeText(getApplicationContext(),i.getStringExtra("result"),Toast.LENGTH_LONG).show();

        }

    }
}
