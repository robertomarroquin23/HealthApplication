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

import com.itca.healthapplication.CaloriesDAO.TrainingDAO;
import com.itca.healthapplication.R;

public class PhysicalActivityLog extends AppCompatActivity {
    private TrainingDAO entrenamientosDAO;
    private EditText editTextTipoEjercicio, editTextDuracion, editTextIntensidad, editTextCalorias;
    private ListView listViewEntrenamientos;
    private SimpleCursorAdapter adapter;
    private long selectedId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_log);

        entrenamientosDAO = new TrainingDAO(this);
        editTextTipoEjercicio = findViewById(R.id.editTextTipoEjercicio);
        editTextDuracion = findViewById(R.id.editTextDuracion);
        editTextIntensidad = findViewById(R.id.editTextIntensidad);
        editTextCalorias = findViewById(R.id.editTextCalorias);
        listViewEntrenamientos = findViewById(R.id.listViewEntrenamientos);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipoEjercicio = editTextTipoEjercicio.getText().toString();
                int duracion = Integer.parseInt(editTextDuracion.getText().toString());
                String intensidad = editTextIntensidad.getText().toString();
                double calorias = Double.parseDouble(editTextCalorias.getText().toString());
                entrenamientosDAO.addEntrenamiento(tipoEjercicio, duracion, intensidad, calorias);
                updateListView();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId != -1) {
                    String tipoEjercicio = editTextTipoEjercicio.getText().toString();
                    int duracion = Integer.parseInt(editTextDuracion.getText().toString());
                    String intensidad = editTextIntensidad.getText().toString();
                    double calorias = Double.parseDouble(editTextCalorias.getText().toString());
                    entrenamientosDAO.updateEntrenamiento(selectedId, tipoEjercicio, duracion, intensidad, calorias);
                    updateListView();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedId != -1) {
                    entrenamientosDAO.deleteEntrenamiento(selectedId);
                    updateListView();
                }
            }
        });

        listViewEntrenamientos.setOnItemClickListener((parent, view, position, id) -> {
            selectedId = id;
            Cursor cursor = (Cursor) adapter.getItem(position);
            String tipoEjercicio = cursor.getString(cursor.getColumnIndexOrThrow("tipo_ejercicio"));
            int duracion = cursor.getInt(cursor.getColumnIndexOrThrow("duracion"));
            String intensidad = cursor.getString(cursor.getColumnIndexOrThrow("intensidad"));
            double calorias = cursor.getDouble(cursor.getColumnIndexOrThrow("calorias"));

            editTextTipoEjercicio.setText(tipoEjercicio);
            editTextDuracion.setText(String.valueOf(duracion));
            editTextIntensidad.setText(intensidad);
            editTextCalorias.setText(String.valueOf(calorias));
        });

        updateListView();
    }

    private void updateListView() {
        Cursor cursor = entrenamientosDAO.getAllEntrenamientos();
        String[] from = new String[]{"_id", "tipo_ejercicio", "duracion", "intensidad", "calorias"};
        int[] to = new int[]{R.id.textViewId, R.id.textViewTipoEjercicio, R.id.textViewDuracion, R.id.textViewIntensidad, R.id.textViewCalorias};
        adapter = new SimpleCursorAdapter(this, R.layout.item_training, cursor, from, to, 0);
        listViewEntrenamientos.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        entrenamientosDAO.close();
        super.onDestroy();
    }
}