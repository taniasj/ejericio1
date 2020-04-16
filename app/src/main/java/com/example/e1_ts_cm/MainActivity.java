package com.example.e1_ts_cm;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText; //libreria para edit text
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar; //libreria que obtiene decha del sistema
import java.util.Date;



public class MainActivity  extends AppCompatActivity implements View.OnClickListener {

    Button fecha;
    Date fecha_act = new Date(); //objeto tipo Date que nos ayudará a obtener la fecha actual
    TextView fecha_nac;
    TextView edad;
    //TextView signo;

    int aa = 0; //año actual
    int ma = 0; //mes actual
    int da = 0; //día actual
    int anio = 0, mes = 0, dia = 0;
    String dato_edad = edad.getText().toString();
   // String horoscopo= "";


    private EditText nombre, ap_pat, ap_mat;
   // private TextView rfc;

   /* private GoogleApiClient client;
    private Object AppIndex;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast.makeText(this, "Onncreate", Toast.LENGTH_LONG.show();

        //guardar datos para que no se borren
        //SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE );
        // nombre,ap_pat, ap_mat.setText(preferences.getString("nombre, ap_pat,ap_mat", ""));

        //Datos nombre
        //View b_signo = findViewById(R.id.btn_signo);
        //b_signo.setOnClickListener(this);



        nombre = (EditText) findViewById(R.id.edit_name); //se guarda dentro de un objeto el casteo y se pide encuentra la vista(componente) por su id
        ap_pat = (EditText) findViewById(R.id.edit_ap_pat); //se guarada en el objeto ap_pat la vista(componente) de la parte grafica
        ap_mat = (EditText) findViewById(R.id.edit_ap_mat);

        //nombre.setText("");  //tomamos lo que se guarda
       // ap_pat.setText("");
        //ap_mat.setText("");

        //Fecha- Asignación de vistas
        fecha = (Button) findViewById(R.id.btn_fechanac);
        fecha.setOnClickListener((View.OnClickListener) this);
        fecha_nac = (TextView) findViewById(R.id.txt_fecha_nac);// a la variable fecha_nac se le asigna la la vista/componente txt_fecha_nac
        edad = (TextView) findViewById(R.id.resultado_edad);

        //RFC
        /*nombre = (EditText) findViewById(R.id.edit_name);
        String[] arre = nombre.split("",2);

        ap_pat = (EditText) findViewById(R.id.edit_ap_pat);
        rfc = (TextView) findViewById(R.id.txt_rfc);
        rfc.setVisibility(View.VISIBLE);*/

        // Set Text Watcher listener
        //nombre.addTextChangedListener(rfcWatcher);
        //ap_pat.addTextChangedListener(rfcWatcher);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


  /*  private final TextWatcher elrfcWatcher = new TextWatcher() {
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after
        ) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            rfc.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {

            rfc.setText(
                    "" + nombre.getText() + ap_pat.getText()
            );
        }
    };

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public Notification.Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Notification.Action.Builder(Notification.Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Notification.Action.STATUS_TYPE_COMPLETED)
                .build();
    } */

    @Override
    protected void onStart() {
        super.onStart();
        //  Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
        /*client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }

    @Override
    protected void onStop() {
        super.onStop();
       // Toast.makeText(this, "¡Regresa pronto!", Toast.LENGTH_LONG).show();
        // La actividad ya no es visible (ahora está "detenida")
        /*AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();*/
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_fechanac) { //unico view que va a ejecutar el metodo onclick es el boton
            Calendar calendar = Calendar.getInstance(); //se crea un objeto tipo Calendar
            anio = calendar.get(Calendar.YEAR); //guardamos en la variable el año actual que obtiene el objeto
            mes = calendar.get(Calendar.MONTH);
            dia = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog guarda_fecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { //se crea el objeto tipo datepickerdialog que tiene un contructor y asu vez este tiene un metodo ONDAteSEt
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth1) { //el metodo tiene 4 parametros
                    final int mesActual = month + 1;
                    String diaFormateado = (dayOfMonth1 < 10) ? "0" + String.valueOf(dayOfMonth1) : String.valueOf(dayOfMonth1);
                    String mesFormateado = (mesActual < 10) ? "0" + String.valueOf(mesActual) :
                            String.valueOf(mesActual);
                    fecha_nac.setText("Fecha nacimiento: " + diaFormateado + "/" + mesFormateado + "/" + year); //se imprime la fecha de nacimiento

                    aa = year;
                    ma = Integer.parseInt(mesFormateado);
                    edad.setText(calcular(anio, (mes + 1), aa, ma));
                    //
                    //da = Integer.parseInt(diaFormateado);


                    /*signo = (TextView) findViewById(R.id.txt_zodiaco);

                    switch(ma){
                        case 1:
                            if (da < 21){
                                horoscopo = "Capricornio";
                            }else{
                                horoscopo = "Acuario";
                            }break;
                        case 2:
                            if (da < 19){
                                horoscopo = "Acuario";
                            }else{
                                horoscopo = "Piscis";
                            }break;
                        case 3:
                            if (da < 21){
                                horoscopo = "Piscis";
                            }else{
                                horoscopo = "Aries";
                            }break;
                        case 4:
                            if (da < 21){
                                horoscopo = "Aries";
                            }else{
                                horoscopo = "Tauro";
                            }break;
                        case 5:
                            if (da < 21){
                                horoscopo = "Tauro";
                            }else{
                                horoscopo = "Geminis";
                            }break;
                        case 6:
                            if (da < 21){
                                horoscopo = "Geminis";
                            }else{
                                horoscopo = "Cancer";
                            }break;
                        case 7:
                            if (da < 21){
                                horoscopo = "Capricornio";
                            }else{
                                horoscopo = "Acuario";
                            }break;
                        case 8:
                            if (da < 25){
                                horoscopo = "Leo";
                            }else{
                                horoscopo = "Virgo";
                            }break;
                        case 9:
                            if (da < 24){
                                horoscopo = "Virgoo";
                            }else{
                                horoscopo = "Libra";
                            }break;
                        case 10:
                            if (da < 24){
                                horoscopo = "Libra";
                            }else{
                                horoscopo = "Escorpio";
                            }break;
                        case 11:
                            if (da < 23){
                                horoscopo = "Escorpio";
                            }else{
                                horoscopo = "Sagitario";
                            }break;
                        case 12:
                            if (da < 22){
                                horoscopo = "Sagitario";
                            }else{
                                horoscopo = "Capricornio";
                            }break;
                        default:
                    }

                    signo.append(nombre+ "tu horoscopo es: "+ horoscopo);*/



                }


            }, anio, mes, dia); //fecha actual
            guarda_fecha.show(); //visualizar el modal del datepicker
        }

    }

    public String calcular(int a, int m, int aa, int ma) {
        int años = 0;
        int meses = 0;
        if (ma <= m) {
            años = a - aa;
            meses = m - ma;
        } else {
            años = a - aa - 1;
            meses = 12 - (ma - m);

        }
        return ("Edad: " + años + "años " + meses + "meses");
    }
}
    //metodo que enviará la edad calculada al activity Resultados
   /* public void Envia_edad (View view){
        Intent envia_edad = new Intent(this,Resultados.class);
        Bundle miBundle = new Bundle();
        miBundle.putString("dato_edad",edad.getText().toString()); /////////

        envia_edad.putExtras(miBundle);

        startActivity(envia_edad);
    }


    public void Calcular (View view){
        Intent calcular = new Intent(this, Resultados.class);
        startActivity(calcular);

    }*/




