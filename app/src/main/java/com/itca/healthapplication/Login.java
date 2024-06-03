package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.itca.healthapplication.DbHealth.DataManager;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    Button btConfirmar;
    EditText etUser, etPass;
    TextView registrar;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btConfirmar = findViewById(R.id.btConfirmar);
        etUser = findViewById(R.id.etUsuario);
        etPass = findViewById(R.id.etPasswd);
        registrar = findViewById(R.id.tvRegistrar);

        dataManager = new DataManager(this);
        dataManager.open();

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registrar.class);
                startActivity(intent);
            }
        });

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUser.getText().toString().trim();
                String password = etPass.getText().toString().trim();

                if (dataManager.authenticateUser(usuario, password)) {
                    // User exists and password matches
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // User does not exist or password does not match
                    Toast.makeText(Login.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            dataManager.close();
        }

}