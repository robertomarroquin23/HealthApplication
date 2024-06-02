package com.itca.healthapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class audiosRelajacion extends AppCompatActivity {

    String audiolist[]={"Moonlight Echoes","Relaxing","Please calm my mind","Loves Serenade","Relaxing Birds and piano music"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios_relajacion);

    }
}