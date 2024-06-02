package com.itca.healthapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.itca.healthapplication.ConfigRecycler.Item;
import com.itca.healthapplication.DbHealth.DataManager;

public class Articulos extends AppCompatActivity {

    private DataManager dataManager;
    TextView titulo , parrafo;
    ImageView imagenart;

   ImageView btn_regresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        titulo = findViewById(R.id.titulo);
        parrafo = findViewById(R.id.parrafo);
        imagenart = findViewById(R.id.imagenart);
        btn_regresar = findViewById(R.id.btn_regresar);
        dataManager = new DataManager(this);
        dataManager.open();

        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String Articulo = intent.getStringExtra("Articulo");
        String parrafos = intent.getStringExtra("Consejo");
        String llenadoparrafo = " ";

      //  Toast.makeText(Articulos.this, "ID es"+ID,Toast.LENGTH_LONG).show();
        Cursor cursor = dataManager.getArticle(Integer.parseInt(ID));

        if (cursor != null && cursor.moveToFirst())
        {


            do {


                String title = cursor.getString(cursor.getColumnIndex("titulo"));
                String cons = cursor.getString(cursor.getColumnIndex("consejo"));

               titulo.setText(title);
               parrafo.setText(cons);
               imagenart.setImageResource(R.drawable.perfil);

            }while (cursor.moveToNext());


        }

        if (cursor != null){
            cursor.close();
        }


       btn_regresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Articulos.this, Consejos.class);



               startActivity(intent);
           }
       });

//    }


    }

}