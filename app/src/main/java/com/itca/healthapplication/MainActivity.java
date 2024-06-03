package com.itca.healthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.itca.healthapplication.View.MainView.ExerciseTrainingLog;
import com.itca.healthapplication.View.MainView.PhysicalActivityLog;

public class MainActivity extends AppCompatActivity {

    ImageView perfil, consejos, rgEntremiento, rgFisica ,Audio,Video;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perfil = findViewById(R.id.ivPerfil);
        consejos = findViewById(R.id.ivConsejos);
        rgEntremiento = findViewById(R.id.ivEjercicio);
        rgFisica = findViewById(R.id.ivFisica);
        Audio = findViewById(R.id.Audio);
        Video = findViewById(R.id.Video);

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Perfil.class );
                startActivity(intent);
            }
        });

        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Consejos.class );
                startActivity(intent);
            }
        });

        rgEntremiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExerciseTrainingLog.class );
                startActivity(intent);
            }
        });

        rgFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhysicalActivityLog.class );
                startActivity(intent);
            }
        });

        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideosRutinas.class );
                startActivity(intent);
            }
        });

        Audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, audiosRelajacion.class );
                startActivity(intent);
            }
        });

    }
}

