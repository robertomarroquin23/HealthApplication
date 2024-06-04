package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.itca.healthapplication.DbHealth.DataManager;

public class Registrar extends AppCompatActivity {

    ImageView flecha;
    Button btGuardar;
    private EditText etUsuario, etCorreo, etPassword, etConfirmarPassword;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        dataManager = new DataManager(this);
        dataManager.open();

        flecha = findViewById(R.id.ivFlecha);
        btGuardar = findViewById(R.id.btGuardar);
        etUsuario = findViewById(R.id.etUsuario);
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPasswd);
        etConfirmarPassword = findViewById(R.id.etConfirmarPasswd);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String correo = etCorreo.getText().toString();
                String password = etPassword.getText().toString();
                String confirmarPassword = etConfirmarPassword.getText().toString();

                if(dataManager.isUserExists(usuario)){

                    Toast.makeText(Registrar.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();

                }else if (password.equals(confirmarPassword)) {
                    DataManager dataManager = new DataManager(Registrar.this);
                    dataManager.open();
                    long newRowId = dataManager.insertUser(usuario, correo, password);
                    dataManager.close();

                    if (newRowId != -1) {
                        Toast.makeText(Registrar.this, "Usuario agregado exitosamente", Toast.LENGTH_SHORT).show();
                        etUsuario.setText("");
                        etCorreo.setText("");
                        etPassword.setText("");
                        etConfirmarPassword.setText("");
                    } else {
                        Toast.makeText(Registrar.this, "Error al agregar el usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registrar.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrar.this, Login.class);
                startActivity(intent);
            }
        });
    }
}