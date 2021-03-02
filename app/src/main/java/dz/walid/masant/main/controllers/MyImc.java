package dz.walid.masant.main.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import dz.walid.masant.R;
import dz.walid.masant.main.model.Imc;

import static dz.walid.masant.R.color.colorBlood;
import static dz.walid.masant.R.color.colorOrange;

public class MyImc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weight);

        setupImc();
    }

    public void setupImc() {
        //Création d'un objer de type Imc
        Imc imc = new Imc();
        //Récupération des élements
        EditText et_weight = findViewById(R.id.et_weight);
        EditText et_size = findViewById(R.id.et_size);
        Button btn_check_imc = findViewById(R.id.btn_check_imc);
        TextView tv_answer = findViewById(R.id.tv_answer);

        //Sauvegarder les dpnnées
        SharedPreferences perfs = getPreferences(MODE_PRIVATE);
        et_weight.setText(perfs.getString("temp.et_weight", ""));
        et_size.setText(perfs.getString("temp.et_size", ""));
        tv_answer.setText(perfs.getString("temp.tv_answer", ""));

        btn_check_imc.setOnClickListener((v) -> {
            try {
                //Récupérer ce qu'il y'a dans l'Edit Text et le sauvegarder dans la variable weight et size
                float weight = Float.parseFloat(et_weight.getText().toString());
                float size = Float.parseFloat(et_size.getText().toString());
                //Calculer l'imc
                float imc_c = weight / (size * size);
                imc.setImc(imc_c);

                if (imc.getResult() == 0) {
                    tv_answer.setText(R.string.message_yas);
                    tv_answer.setTextColor(Color.BLUE);
                }

                if (imc.getResult() == 1) {
                    tv_answer.setText(R.string.message_ywin);
                    tv_answer.setTextColor(Color.GREEN);
                }

                if (imc.getResult() == 2) {
                    tv_answer.setText(R.string.message_yacto);
                    tv_answer.setTextColor(getResources().getColor(colorOrange,null));
                }

                if (imc.getResult() == 3) {
                    tv_answer.setText(R.string.message_yao);
                    tv_answer.setTextColor(Color.RED);
                }


            } catch (Exception e) {
                tv_answer.setText(R.string.message_ii);
            }

            getPreferences(MODE_PRIVATE)
                    .edit()
                    .putString("temp.et_weight", et_weight.getText().toString())
                    .putString("temp.et_size", et_size.getText().toString())
                    .putString("temp.tv_answer", tv_answer.getText().toString())
                    .apply();
        });
    }
}
