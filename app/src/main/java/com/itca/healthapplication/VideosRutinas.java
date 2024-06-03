package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.itca.healthapplication.ConfigRecycler.audioAdapter;

public class VideosRutinas extends AppCompatActivity {

    String videolist[]={"Círculos con las rodillas","Estiramiento de espalda y piernas","Estiramiento sobre alfombra","Yoga"};
    int videoimg[]={R.drawable.articulacion,R.drawable.estiramiento,R.drawable.alfombraestiramiento,
           R.drawable.yogaestiramiento
    };
    ImageView Back;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_videos_rutinas);


        listView = (ListView) findViewById(R.id.videolv);
        Back = findViewById(R.id.Back);

        audioAdapter audioAdapter = new audioAdapter(getApplicationContext(),videolist,videoimg);
        listView.setAdapter(audioAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {

                String selectedItem = videolist[position];
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(VideosRutinas.this, Audios.class);

                intent.putExtra("Song",selectedItem);

                startActivity(intent);

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideosRutinas.this, MainActivity.class );
                startActivity(intent);
            }
        });

    }
}