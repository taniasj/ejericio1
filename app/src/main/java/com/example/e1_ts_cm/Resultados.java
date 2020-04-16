package com.example.e1_ts_cm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {

    TextView txt_edad; //objeto tipo textview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txt_edad = (TextView) findViewById(R.id.txt_res_edad); //ligamos la parte logica con la grafica
        Bundle miBundle = this.getIntent().getExtras();

        if (miBundle != null) {
            String dato = miBundle.getString("dato_edad");
            txt_edad.setText("Edad:");
        }
    }

      /* String edad = getIntent().getStringExtra("pasar_edad");
       txt_edad.setText("Edad:1" +edad);

               // ("Edad: " +años+ "años " +meses+ "meses");
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "¡Regresa pronto!", Toast.LENGTH_LONG).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
}
