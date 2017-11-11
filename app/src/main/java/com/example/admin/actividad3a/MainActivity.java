package com.example.admin.actividad3a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    public static final String PREFS="Mis preferencias";
    private Button b;
    private EditText nom, dni, data;
    private RadioButton sexeHome, sexeDona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.boto);

        nom = (EditText)findViewById(R.id.editNombre);
        dni = (EditText)findViewById(R.id.editDNI);
        data = (EditText)findViewById(R.id.editFechaNacimiento);
        sexeHome = (RadioButton)findViewById(R.id.sexeHome);
        sexeDona = (RadioButton)findViewById(R.id.sexeDona);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Creamos o recuperamos el objeto de preferencias compartidas
                SharedPreferences sp = getSharedPreferences(PREFS,MainActivity.MODE_PRIVATE);

                //Obtenemos un editor para modificar las preferencias
                SharedPreferences.Editor editor = sp.edit();

                //Guardamos nuevos valores
                editor.putString("nom",nom.getText().toString());
                editor.putString("dni",dni.getText().toString());
                editor.putString("data",data.getText().toString());

                if (sexeHome.isChecked()) {
                    editor.putString("sexe", "Hombre");
                } else if (sexeDona.isChecked()){
                    editor.putString("sexe","Mujer");
                }

                editor.commit();

                Intent i = new Intent(MainActivity.this,SegonFinestra.class);
                startActivity(i);
            }
        });
    }
}
