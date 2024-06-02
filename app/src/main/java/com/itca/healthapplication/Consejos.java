package com.itca.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.itca.healthapplication.ConfigRecycler.Item;
import com.itca.healthapplication.ConfigRecycler.MyAdapter;
import com.itca.healthapplication.DbHealth.DataManager;

import java.util.ArrayList;
import java.util.List;

public class Consejos extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private DataManager dataManager;
    ImageView btn_regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        btn_regresar =findViewById(R.id.btn_regresar);
        dataManager = new DataManager(this);
        dataManager.open();
        //metodo para limpiar la base
 //       dataManager.deleteAllData();
        cargarDatos();


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

        intent.putExtra("ID",item.getID());
        intent.putExtra("Articulo", item.getTitulo());
        intent.putExtra("Consejo", item.getConsejo());

        startActivity(intent);
    }





    public  void  cargarDatos(){

        List<Item> items = new ArrayList<Item>();
        Cursor cursor = dataManager.getAllData();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        MyAdapter adapter = new MyAdapter(this, items);
        adapter.setOnItemClickListener(this); // Configuración del listener

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter); // Usar la instancia del adaptador ya creada


        if (cursor != null && cursor.moveToFirst())
        {


                do {
                    Integer id = cursor.getInt(cursor.getColumnIndex("_id"));

                    String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                    String consejo = cursor.getString(cursor.getColumnIndex("consejo"));

                    if (consejo.length() > 90) {
                        consejo = consejo.substring(0, 90);
                    }


                   items.add(new Item(id.toString(),titulo,consejo , R.drawable.perfil));


            }while (cursor.moveToNext());


        }

        if (cursor != null){
            cursor.close();
        }

    }
































}