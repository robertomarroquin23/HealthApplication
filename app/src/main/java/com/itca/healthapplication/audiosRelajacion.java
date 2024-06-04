package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itca.healthapplication.ConfigRecycler.audioAdapter;

public class audiosRelajacion extends AppCompatActivity {

    String audiolist[]={"Moonlight Echoes","Relaxing","Please calm my mind","Loves Serenade","Relaxing Birds and piano music"};
    int audioimg[]={R.drawable.moonlightechoes,R.drawable.relaxing,R.drawable.pleasecalmmymind,
    R.drawable.lovesserenade,R.drawable.musicpiano
    };
    ImageView Back;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios_relajacion);
        listView = (ListView) findViewById(R.id.audioslv);
        Back = findViewById(R.id.Back);

        audioAdapter audioAdapter = new audioAdapter(getApplicationContext(),audiolist,audioimg);
        listView.setAdapter(audioAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {

                String selectedItem = audiolist[position];
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(audiosRelajacion.this, Audios.class);

                intent.putExtra("Song",selectedItem);

                startActivity(intent);

            }
        });

  Back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Intent intent = new Intent(audiosRelajacion.this, MainActivity.class );
          startActivity(intent);
      }
  });






    }


}