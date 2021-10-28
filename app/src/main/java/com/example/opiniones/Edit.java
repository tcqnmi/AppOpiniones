package com.example.opiniones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Edit extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit);

        TextView cabOpi = (TextView) findViewById(R.id.cabEdit);
        EditText edOpi = (EditText) findViewById(R.id.editOpinion);
        TextView cabUser = (TextView) findViewById(R.id.cabUsuario);
        EditText edUser = (EditText) findViewById(R.id.editUsuario);
        Button btGuardar = (Button) findViewById(R.id.guardar);
        Button btVolver = (Button) findViewById(R.id.volver);
        Intent esc = this.getIntent();
        final int pos = esc.getIntExtra("pos",0);

        View.OnClickListener listenerGuardar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent devOk = new Intent(getApplicationContext(),Detalle.class);

                devOk.putExtra("result","Opinión guardada");
                devOk.putExtra("pos",pos);
                devOk.putExtra("opinion",edOpi.getText().toString());
                devOk.putExtra("user",edUser.getText().toString());
                setResult(RESULT_OK, devOk);

                finish();
            }
        };
        btGuardar.setOnClickListener(listenerGuardar);

        View.OnClickListener listnerVolver = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent devNada = new Intent(getApplicationContext(),Detalle.class );
                devNada.putExtra("posic",pos);

                setResult(RESULT_CANCELED, devNada);
                finish();
            }
        };
        btVolver.setOnClickListener(listnerVolver);



    }
}
