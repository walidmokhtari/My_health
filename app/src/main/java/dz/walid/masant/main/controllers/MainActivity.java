package dz.walid.masant.main.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import dz.walid.masant.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Récupération et définition des différnents boutons de la page principale
        final Button btn_confinement = findViewById(R.id.btn_confinement);
        final Button btn_bg = findViewById(R.id.btn_bg);
        final Button btn_temperature = findViewById(R.id.btn_temperature);
        final Button btn_weight = findViewById(R.id.btn_weight);
        final Button btn_website = findViewById(R.id.btn_website);

        //Appel a la fonction setOnClickListener() pour chaque bouton
        btn_confinement.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyConfinement.class);
            startActivity(intent);
        });

        btn_bg.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyChildsBg.class);
            startActivity(intent);
        });

        btn_temperature.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyTemperature.class);
            startActivity(intent);
        });

        btn_weight.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MyImc.class);
            startActivity(intent);
        });

        btn_website.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.univ-perp.fr/"));
            startActivity(intent);
        });
    }
}
