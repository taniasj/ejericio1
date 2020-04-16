package com.example.e1_ts_cm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    Button btnToMain;
    TextView inst1, inst2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_LONG).show();

        btnToMain = findViewById(R.id.btnToMain); //se pone el id al cual irá el btn
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //se crea para cuando el usuario le de click al boton se vaya  a otroactivt
                Intent intent = new Intent(Inicio.this, MainActivity.class);  //metodo que invoca a la clase a la que se quiere ir
                startActivity(intent);
            }
        });
    }
}
