package dz.walid.masant.main.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import dz.walid.masant.R;
import dz.walid.masant.main.model.BloodGroup;

import static dz.walid.masant.R.color.colorBlood;

public class MyChildsBg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_childs_bg);

        setupChildBg();
    }

    public void setupChildBg() {
        //Création d'un objet de type BloodGroup
        BloodGroup bg = new BloodGroup();

        //Récupération et définition des différents élements de l'activité ChildsBg
        Spinner s_fbg = findViewById(R.id.s_fbg);
        Spinner s_mbg = findViewById(R.id.s_mbg);
        Button btn_check = findViewById(R.id.btn_check);
        TextView tv_answer = findViewById(R.id.tv_answer);

        //Création d'un SharedPerferences pour sauvegarder les données même si l'utilisateur arrête le processus
        SharedPreferences perfs = getPreferences(MODE_PRIVATE);
        tv_answer.setText(perfs.getString("temp.tv_answer", ""));

        //Lorsque l'utilisateur clique sur le bouton Check
        btn_check.setOnClickListener(v -> {

            try {
                //Gestion du Spinner
                s_fbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //La variable position contient l'indice de l'élement choisi par l'utilisateur
                        bg.setFatherBg(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        bg.setFatherBg(0);
                    }
                });

                //Gestion du deuxiéme Spinner
                s_mbg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        bg.setMotherBg(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        bg.setMotherBg(0);
                    }
                });

                if(bg.getChildBg() == 0) {
                    tv_answer.setText(R.string.message_mbga);
                    tv_answer.setTextColor(getResources().getColor(colorBlood,null));
                }

                if(bg.getChildBg() == 1) {
                    tv_answer.setText(R.string.message_mbgb);
                    tv_answer.setTextColor(getResources().getColor(colorBlood,null));
                }

                if(bg.getChildBg() == 2) {
                    tv_answer.setText(R.string.message_mbgab);
                    tv_answer.setTextColor(getResources().getColor(colorBlood,null));
                }

                if(bg.getChildBg() == 3) {
                    tv_answer.setText(R.string.message_mbgo);
                    tv_answer.setTextColor(getResources().getColor(colorBlood,null));
                }

            } catch (Exception e) {
                tv_answer.setText(R.string.message_ii);
            }

            //Sauvegarder les données que l'utilisateurs a saisi ou a choisi
            getPreferences(MODE_PRIVATE)
                    .edit()
                    .putString("temp.tv_answer", tv_answer.getText().toString())
                    .apply();

        });


    }
}
