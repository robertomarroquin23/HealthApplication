package com.itca.healthapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.itca.healthapplication.DbHealth.DataManager;
import com.itca.healthapplication.DbHealth.Users_table;

public class Perfil extends AppCompatActivity {

    ImageView flecha;
    Button btGuardar, btEditar;
    EditText etUsuario, etAltura, etPeso, etEdad, etNacionalidad;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        dataManager = new DataManager(this);
        dataManager.open();
        Intent intent = getIntent();
        String user = intent.getStringExtra("usuario");

        flecha = findViewById(R.id.ivFlecha);
        btGuardar = findViewById(R.id.btGuardar);
        btEditar = findViewById(R.id.btEditar);
        etUsuario = findViewById(R.id.etUsuario);
        etAltura = findViewById(R.id.etAltura);
        etPeso = findViewById(R.id.etPeso);
        etEdad = findViewById(R.id.etEdad);
        etNacionalidad = findViewById(R.id.etNacionalidad);

        etUsuario.setEnabled(false);
        etAltura.setEnabled(false);
        etPeso.setEnabled(false);
        etEdad.setEnabled(false);
        etNacionalidad.setEnabled(false);
        btGuardar.setEnabled(false);

        Cursor cursor = dataManager.getUserData(user);

        if (cursor != null && cursor.moveToFirst()) {
            String usuario = cursor.getString(0);
            etUsuario.setText(usuario);
            cursor.close();
        } else {
            Toast.makeText(Perfil.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Perfil.this, MainActivity.class);
                String usr = etUsuario.getText().toString().trim();
                intent.putExtra("usuario", usr);
                startActivity(intent);
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsuario.setEnabled(true);
                etAltura.setEnabled(true);
                etPeso.setEnabled(true);
                etEdad.setEnabled(true);
                etNacionalidad.setEnabled(true);
                btGuardar.setEnabled(true);
                btEditar.setEnabled(false);

                Cursor cursor = dataManager.getUserData(user);

                if (cursor != null && cursor.moveToFirst()) {
                    String altura = cursor.getString(cursor.getColumnIndexOrThrow(Users_table.COLUMN_ALTURA));
                    String peso = cursor.getString(cursor.getColumnIndexOrThrow(Users_table.COLUMN_PESO));
                    String edad = cursor.getString(cursor.getColumnIndexOrThrow(Users_table.COLUMN_EDAD));
                    String nacionalidad = cursor.getString(cursor.getColumnIndexOrThrow(Users_table.COLUMN_NACIONALIDAD));

                    etAltura.setText(altura);
                    etPeso.setText(peso);
                    etEdad.setText(edad);
                    etNacionalidad.setText(nacionalidad);
                    cursor.close();

                } else {

                    Toast.makeText(Perfil.this, "No se encontraron datos para el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevoUsuario = etUsuario.getText().toString().trim();
                String nuevaAltura = etAltura.getText().toString().trim();
                String nuevoPeso = etPeso.getText().toString().trim();
                String nuevaEdad = etEdad.getText().toString().trim();
                String nuevaNacionalidad = etNacionalidad.getText().toString().trim();

                if(dataManager.isUserExists(nuevoUsuario)){

                    Toast.makeText(Perfil.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();

                }else if(nuevoUsuario.isEmpty() || nuevaAltura.isEmpty() || nuevoPeso.isEmpty() || nuevaEdad.isEmpty() || nuevaNacionalidad.isEmpty()){

                    Toast.makeText(Perfil.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();

                }else{
                        dataManager.updateUserData(user, nuevoUsuario, nuevaAltura, nuevoPeso, nuevaEdad, nuevaNacionalidad);

                        Toast.makeText(Perfil.this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
                        etUsuario.setEnabled(false);
                        etAltura.setEnabled(false);
                        etPeso.setEnabled(false);
                        etEdad.setEnabled(false);
                        etNacionalidad.setEnabled(false);
                        btGuardar.setEnabled(false);
                        btEditar.setEnabled(true);
                        String usr = etUsuario.getText().toString().trim();
                        Intent intent = new Intent(Perfil.this, MainActivity.class );
                        intent.putExtra("usuario", usr);
                        dataManager.close();
                        startActivity(intent);
                }
            }
        });
    }
}

