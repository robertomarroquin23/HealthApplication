package com.itca.healthapplication.View.MainView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.itca.healthapplication.CaloriesDAO.CaloriesDao;
import com.itca.healthapplication.Class.RegisterAdapter;
import com.itca.healthapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTrainingLog extends AppCompatActivity {
    private CaloriesDao caloriesDao;
    private EditText editTextDistancia;
    private ListView listViewCalorias;
    private SimpleCursorAdapter adapter;
    private long selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_training_log);

        caloriesDao = new CaloriesDao(this);

        editTextDistancia = findViewById(R.id.editTextDistancia);
        listViewCalorias = findViewById(R.id.listViewCalorias);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double distancia = Double.parseDouble(editTextDistancia.getText().toString());
                caloriesDao.addCalorias(distancia);
                updateListView();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId != -1) {
                    double distancia = Double.parseDouble(editTextDistancia.getText().toString());
                    caloriesDao.updateCalorias(selectedId, distancia);
                    updateListView();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId != -1) {
                    caloriesDao.deleteCalorias(selectedId);
                    updateListView();
                }
            }
        });

        listViewCalorias.setOnItemClickListener((parent, view, position, id) -> {
            selectedId = id;
            Cursor cursor = (Cursor) adapter.getItem(position);
            double distancia = cursor.getDouble(cursor.getColumnIndexOrThrow("distancia"));
            editTextDistancia.setText(String.valueOf(distancia));
        });

        updateListView();
    }

    private void updateListView() {
        Cursor cursor = caloriesDao.getAllCalorias();
        String[] from = new String[]{"_id", "distancia", "calorias"};
        int[] to = new int[]{R.id.textViewId, R.id.textViewDistancia, R.id.textViewCalorias};
        adapter = new SimpleCursorAdapter(this, R.layout.item_calories, cursor, from, to, 0);
        listViewCalorias.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        caloriesDao.close();
        super.onDestroy();
    }
}