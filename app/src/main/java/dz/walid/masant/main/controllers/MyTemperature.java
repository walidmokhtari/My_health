package dz.walid.masant.main.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dz.walid.masant.R;
import dz.walid.masant.main.model.Temperature;

public class MyTemperature extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_temperature);

        setupTemperature();
    }

    public void setupTemperature() {
        //Création d'un objer de type Temperature
        Temperature temp = new Temperature();

        //Récupération des élements
        EditText et_temperature = findViewById(R.id.et_temperature);
        Spinner spinner = findViewById(R.id.s_wm);
        Button btn_check = findViewById(R.id.btn_check);
        TextView tv_answer = findViewById(R.id.tv_answer);

        //Sauvegarder les dpnnées
        SharedPreferences perfs = getPreferences(MODE_PRIVATE);
        et_temperature.setText(perfs.getString("temp.et_temperature", ""));
        tv_answer.setText(perfs.getString("temp.tv_answer", ""));

        btn_check.setOnClickListener((v) -> {
            try {
                //Récupérer ce qu'il y'a dans l'Edit Text et le sauvegarder dans la variable temp_c
                float temp_c = Float.parseFloat(et_temperature.getText().toString());
                temp.setTemp(temp_c);
                //Gestion du spinner
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    //Dans le cas ou l'utilisateur sélectionne un choix
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            temp.setSexe('w');
                        } else {
                            temp.setSexe('m');
                        }
                    }

                    @Override
                    //Dans le cas ou l'utilisateur ne sélectionne rien
                    public void onNothingSelected(AdapterView<?> parent) {
                        temp.setSexe('w');
                    }
                });

               if (temp.checkTemp() == 1) {
                    tv_answer.setText(R.string.message_yntsad);
                    tv_answer.setTextColor(Color.RED);
                } else {
                    tv_answer.setText(R.string.message_ytio);
                    tv_answer.setTextColor(Color.GREEN);
                }


            } catch (Exception e) {
                tv_answer.setText(R.string.message_ii);
            }

            getPreferences(MODE_PRIVATE)
                    .edit()
                    .putString("temp.et_temperature", et_temperature.getText().toString())
                    .putString("temp.tv_answer", tv_answer.getText().toString())
                    .apply();
        });
    }


}
