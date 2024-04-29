package com.itca.healthapplication.View.MainView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.itca.healthapplication.Class.RegisterAdapter;
import com.itca.healthapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTrainingLog extends AppCompatActivity {
    private EditText etDistance;
    private EditText etCalories;
    private Button btnSave;
    private ListView listView;
    private List<String> registros;
    private RegisterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_training_log);

        etDistance = findViewById(R.id.etDistance);
        etCalories = findViewById(R.id.etCalories);
        btnSave = findViewById(R.id.btnSave);
        listView = findViewById(R.id.listView);
        registros = new ArrayList<>();
        adapter = new RegisterAdapter(this, R.layout.registro_item, registros);
        listView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double distancia = Double.parseDouble(etDistance.getText().toString());
                int calorias = Integer.parseInt(etCalories.getText().toString());
                String registro = "Distancia: " + distancia + " km, Calorías quemadas: " + calorias;
                registros.add(registro);
                adapter.notifyDataSetChanged();
            }
        });

    }
}