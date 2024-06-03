package com.itca.healthapplication.CaloriesDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itca.healthapplication.DbHealth.EntrenamientosDatabaseHelper;

public class TrainingDAO {
    private SQLiteDatabase db;
    private EntrenamientosDatabaseHelper dbHelper;

    public TrainingDAO(Context context) {
        dbHelper = new EntrenamientosDatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long addEntrenamiento(String tipoEjercicio, int duracion, String intensidad, double calorias) {
        ContentValues values = new ContentValues();
        values.put("tipo_ejercicio", tipoEjercicio);
        values.put("duracion", duracion);
        values.put("intensidad", intensidad);
        values.put("calorias", calorias);
        return db.insert("Entrenamientos", null, values);
    }

    public Cursor getAllEntrenamientos() {
        return db.query("Entrenamientos",
                new String[]{"_id", "tipo_ejercicio", "duracion", "intensidad", "calorias"},
                null, null, null, null, null);
    }

    public int updateEntrenamiento(long id, String tipoEjercicio, int duracion, String intensidad, double calorias) {
        ContentValues values = new ContentValues();
        values.put("tipo_ejercicio", tipoEjercicio);
        values.put("duracion", duracion);
        values.put("intensidad", intensidad);
        values.put("calorias", calorias);
        return db.update("Entrenamientos", values, "_id = ?", new String[]{String.valueOf(id)});
    }

    public int deleteEntrenamiento(long id) {
        return db.delete("Entrenamientos", "_id = ?", new String[]{String.valueOf(id)});
    }

    public void close() {
        dbHelper.close();
    }
}
