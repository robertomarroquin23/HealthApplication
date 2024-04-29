package com.itca.healthapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btConfirmar = findViewById(R.id.btConfirmar);
        etUser = findViewById(R.id.etUsuario);
        etPass = findViewById(R.id.etPasswd);
        registrar = findViewById(R.id.tvRegistrar);

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUser.getText().toString().equals("Rene") && etPass.getText().toString().equals("1234"))
                {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{

                    Toast.makeText(Login.this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registrar.class);
                startActivity(intent);
            }
        });
    }
}