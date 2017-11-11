package com.example.admin.actividad3a;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.admin.actividad3a.MainActivity.PREFS;

public class SegonFinestra extends AppCompatActivity {

    private TextView tvNom, tvDni, tvData;
    private TextView tvSexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segon_finestra);

        tvNom = (TextView)findViewById(R.id.textMuestraNombre);
        tvDni = (TextView)findViewById(R.id.textMuestraDNI);
        tvData = (TextView)findViewById(R.id.textMuestraFechaNacimiento);
        tvSexe = (TextView) findViewById(R.id.textMuestraSexo);

        SharedPreferences sp = getSharedPreferences(PREFS,MODE_PRIVATE);
        String nom = sp.getString("nom","");
        String dni = sp.getString("dni","");
        String data = sp.getString("data","");
        String sexe = sp.getString("sexe","");

        tvNom.setText(nom);
        tvDni.setText(dni);
        tvData.setText(data);
        tvSexe.setText(sexe);


    }
}
