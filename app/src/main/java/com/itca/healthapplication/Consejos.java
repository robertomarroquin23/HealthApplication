package com.itca.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Consejos extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    ImageView btn_regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        btn_regresar =findViewById(R.id.btn_regresar);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<Item> items = new ArrayList<Item>();

        items.add(new Item("Beneficios del ejercicio físico","El ejercicio físico regular puede mejorar la salud mental, incluyendo la reducción del estrés... ",R.drawable.ejercicio));
        items.add(new Item("La alimentación en la salud cardiovascular","Investiga cómo una dieta saludable puede reducir el riesgo de enfermedades cardiovasculares",R.drawable.dieta));
        items.add(new Item("Técnicas de manejo de estrés y ansiedad:","Examina estrategias y técnicas, como la meditación, la respiración profunda y la atención plena",R.drawable.manejoestres));
        items.add(new Item("Importancia del sueño para la salud general"," Investiga cómo el sueño adecuado afecta la salud física y mental, incluyendo la función cognitiva",R.drawable.dormir));
        items.add(new Item("Prevención de enfermedades infecciosas","La importancia de la vacunación en la prevención de enfermedades infecciosas",R.drawable.vacunacion));
        items.add(new Item("Actividad física en la tercera edad","Explora cómo el ejercicio regular puede mejorar la calidad de vida de las personas mayores",R.drawable.ejercicioanciano));
        items.add(new Item("La Salud bucal en la salud general","Cómo la salud bucal adecuada puede influir en la salud general del cuerpo",R.drawable.dental));
        items.add(new Item("Importancia del descanso adecuado"," Explora la importancia de incluir períodos de descanso y recuperación en un programa de entrenamiento físico",R.drawable.descanso));

        MyAdapter adapter = new MyAdapter(this, items);
        adapter.setOnItemClickListener(this); // Configuración del listener

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter); // Usar la instancia del adaptador ya creada

   btn_regresar.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(Consejos.this, MainActivity.class);

           startActivity(intent);
       }
   });

    }

    @Override
    public void onItemClick(Item item) {

        Intent intent = new Intent(this, Articulos.class);

        intent.putExtra("Articulo", item.getTitulo());
        intent.putExtra("Consejo", item.getConsejo());

        startActivity(intent);
    }



}