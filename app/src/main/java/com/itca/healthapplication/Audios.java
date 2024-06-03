package com.itca.healthapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Audios extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView tvStatus, tvElapsedTime,tvRemainingTime;

    private Button btnPlayPause;
    Button btnback;
    ImageView imageView;

    private SeekBar seekBar;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_audios);


        btnback = findViewById(R.id.btnback);

        tvElapsedTime = findViewById(R.id.tvElapsedTime);
        tvRemainingTime = findViewById(R.id.tvRemainingTime);
        tvStatus = findViewById(R.id.tvStatus);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);

        //Inicializar media player
        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("Song");
        String artistName = intent.getStringExtra("Artist");




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



        Runnable updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(currentPosition);

                    // Obtener la duración total del video/audio en milisegundos
                    int totalDuration = mediaPlayer.getDuration();

                    // Calcular el tiempo transcurrido y restante en minutos:segundos
                    int elapsedMinutes = currentPosition / (1000 * 60);
                    int elapsedSeconds = (currentPosition / 1000) % 60;
                    int remainingMinutes = (totalDuration - currentPosition) / (1000 * 60);
                    int remainingSeconds = ((totalDuration - currentPosition) / 1000) % 60;

                    // Actualizar los TextViews con el tiempo transcurrido y restante
                    tvElapsedTime.setText(String.format("%02d:%02d", elapsedMinutes, elapsedSeconds));
                    tvRemainingTime.setText(String.format("%02d:%02d", remainingMinutes, remainingSeconds));
                }
                // Actualizar la SeekBar cada 100 milisegundos (o cualquier intervalo deseado)
                handler.postDelayed(this, 100);
            }
        };


        handler.postDelayed(updateSeekBar, 100);




        switch (songTitle) {
            case "Moonlight Echoes":
                imageView.setImageResource(R.drawable.moonlightechoes);
                mediaPlayer = MediaPlayer.create(this, R.raw.moonlightechoes);
                seekBar.setMax(mediaPlayer.getDuration());


                handler.postDelayed(updateSeekBar, 100);
                break;
            case "Relaxing":
                imageView.setImageResource(R.drawable.relaxing);
                mediaPlayer = MediaPlayer.create(this, R.raw.relaxing);

                seekBar.setMax(mediaPlayer.getDuration());

                // Actualizar continuamente el progreso de la SeekBar
                handler.postDelayed(updateSeekBar, 100);
                break;
            case "Please calm my mind":
                imageView.setImageResource(R.drawable.pleasecalmmymind);
                mediaPlayer = MediaPlayer.create(this, R.raw.pleasecalmmymind);

                seekBar.setMax(mediaPlayer.getDuration());

                // Actualizar continuamente el progreso de la SeekBar
                handler.postDelayed(updateSeekBar, 100);
                break;
            case "Loves Serenade":
                imageView.setImageResource(R.drawable.lovesserenade);
                mediaPlayer = MediaPlayer.create(this, R.raw.lovesserenade);

                seekBar.setMax(mediaPlayer.getDuration());

                // Actualizar continuamente el progreso de la SeekBar
                handler.postDelayed(updateSeekBar, 100);
                break;
            case "Relaxing Birds and piano music":
                imageView.setImageResource(R.drawable.musicpiano);
                mediaPlayer = MediaPlayer.create(this, R.raw.pianomusic);

                seekBar.setMax(mediaPlayer.getDuration());

                // Actualizar continuamente el progreso de la SeekBar
                handler.postDelayed(updateSeekBar, 100);
                break;

            case "Círculos con las rodillas":
                Intent intento = new Intent(this, Videos.class);

                intento.putExtra("video", "Círculos con las rodillas");


                startActivity(intento);
                break;
            case "Estiramiento de espalda y piernas":
                Intent intento2 = new Intent(this, Videos.class);

                intento2.putExtra("video", "Estiramiento de espalda y piernas");


                startActivity(intento2);
                break;
            case "Estiramiento sobre alfombra":
                Intent intento3 = new Intent(this, Videos.class);

                intento3.putExtra("video", "Estiramiento sobre alfombra");


                startActivity(intento3);
                break;
            case "Yoga":

                Intent intento4 = new Intent(this, Videos.class);

                intento4.putExtra("video", "Yoga");


                startActivity(intento4);
                break;

        }





        // boton reproducir y pausar
        btnPlayPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btnPlayPause.setText("Play");
                tvStatus.setText("Paused");

            } else {
                mediaPlayer.start();
                btnPlayPause.setText("Pause");
                tvStatus.setText("Playing");
            }


        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Audios.this, audiosRelajacion.class);

                onPause();
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null)
        {
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;

        }
    }
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }

        }
    }










}