package com.itca.healthapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Videos extends AppCompatActivity {
    private VideoView videoView;
    private SeekBar seekBar;
    private Button btnPause, btnreturn;
    private TextView tvElapsedTime1, tvRemainingTime1;
    private TextView txtvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_videos);
        videoView = findViewById(R.id.videoView);
        txtvmain = findViewById(R.id.txtvmain);
        seekBar = findViewById(R.id.seekBar);
        btnPause = findViewById(R.id.btnPause);
        btnreturn = findViewById(R.id.btnreturn);
        tvElapsedTime1 = findViewById(R.id.tvElapsedTime1);
        tvRemainingTime1 = findViewById(R.id.tvRemainingTime1);
        Intent intent = getIntent();
        String videoTitle = intent.getStringExtra("video");

        switch (videoTitle) {
            case "Círculos con las rodillas":
                txtvmain.setText("Círculos con las rodillas");
                String videopath = "android.resource://" + getPackageName() + "/" + R.raw.articulacionrodilla;
                Uri videoUri = Uri.parse(videopath);
                videoView.setVideoURI(videoUri);
                videoView.start();
                break;
            case "Estiramiento de espalda y piernas":
                txtvmain.setText("Estiramiento de espalda y piernas");
                String videopath1 = "android.resource://" + getPackageName() + "/" + R.raw.estiramientoespalda;
                Uri videoUri1 = Uri.parse(videopath1);
                videoView.setVideoURI(videoUri1);
                videoView.start();
                break;
            case "Estiramiento sobre alfombra":
                txtvmain.setText("Estiramiento sobre alfombra");
                String videopath2 = "android.resource://" + getPackageName() + "/" + R.raw.estiramientoalfombra;
                Uri videoUri2 = Uri.parse(videopath2);
                videoView.setVideoURI(videoUri2);
                videoView.start();
                break;
            case "Yoga":
                txtvmain.setText("Ejercicios de Yoga");
                String videopath3 = "android.resource://" + getPackageName() + "/" + R.raw.yoga;
                Uri videoUri3 = Uri.parse(videopath3);
                videoView.setVideoURI(videoUri3);
                videoView.start();
                break;
        }

        btnPause.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                btnPause.setText("Play");
            } else {
                videoView.start();
                btnPause.setText("Pause");
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    videoView.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        videoView.setOnPreparedListener(mp -> {
            int videoDuration = videoView.getDuration();
            seekBar.setMax(videoDuration);

            new Thread(() -> {
                while (videoView != null) {
                    try {
                        int currentPosition = videoView.getCurrentPosition();
                        seekBar.setProgress(currentPosition);

                        runOnUiThread(() -> {
                            tvElapsedTime1.setText(formatTime(currentPosition));
                            tvRemainingTime1.setText(formatTime(videoDuration - currentPosition));
                        });

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        btnreturn.setOnClickListener(v -> {
            Intent intent1 = new Intent(Videos.this, VideosRutinas.class);
            videoView.pause();
            startActivity(intent1);
        });
    }

    private String formatTime(int milliseconds) {
        int minutes = (milliseconds / 1000) / 60;
        int seconds = (milliseconds / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
