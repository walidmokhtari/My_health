package dz.walid.masant.main.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dz.walid.masant.R;
import dz.walid.masant.main.model.Confinement;

public class MyConfinement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_confinement);

        setupConfinement();
    }

    public void setupConfinement() {
        //Création d'un objer de type Confinement
        Confinement c = new Confinement();

        //Récupération des élements
        EditText et_days = findViewById(R.id.et_days);
        Button btn_check = findViewById(R.id.btn_ckeck);
        TextView tv_answer = findViewById(R.id.tv_answer);

        //Sauvegarder les dpnnées
        SharedPreferences perfs = getPreferences(MODE_PRIVATE);
        et_days.setText(perfs.getString("temp.et_days", ""));
        tv_answer.setText(perfs.getString("temp.tv_answer", ""));


        btn_check.setOnClickListener((v) -> {
            try {
                //Récupérer ce qu'il y'a dans l'Edit Text et le sauvegarder dans la variable days
                int days = Integer.parseInt(et_days.getText().toString());
                c.setNbDays(days);
                if (c.confinementOrNo() == 1) {
                    /*Attribuer un text pour le TextView (Rq : ici j'ai essayer de concaténer une chaine de caractére que j'ai définie
                     dans le fichier Strings mais dans l'app ca afficher une adresse non pas la chaine de caractére*/
                    tv_answer.setText("You must stay confined, you have left :  "+ String.format("%d Days",c.daysLeft() ));
                    //Attribuer une couleur pour le text
                    tv_answer.setTextColor(Color.RED);
                } else {
                    tv_answer.setText(R.string.message_ad);
                    tv_answer.setTextColor(Color.GREEN);
                }
            } catch (Exception e) {
                //En cas d'erreur
                tv_answer.setText(R.string.message_ii);
            }

            //Sauvegarder les données
            getPreferences(MODE_PRIVATE)
                    .edit()
                    .putString("temp.et_days", et_days.getText().toString())
                    .putString("temp.tv_answer", tv_answer.getText().toString())
                    .apply();

        });

    }


}
