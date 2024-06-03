package com.itca.healthapplication.CaloriesDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itca.healthapplication.DbHealth.CaloriasDatabaseHelper;

public class CaloriesDao {
    private SQLiteDatabase db;
    private CaloriasDatabaseHelper dbHelper;

    public CaloriesDao(Context context) {
        dbHelper = new CaloriasDatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long addCalorias(double distancia) {
        double calorias = calcularCalorias(distancia);
        ContentValues values = new ContentValues();
        values.put("distancia", distancia);
        values.put("calorias", calorias);
        return db.insert("Calorias", null, values);
    }

    public Cursor getAllCalorias() {
        return db.query("Calorias",
                new String[]{"_id", "distancia", "calorias"},
                null, null, null, null, null);
    }

    public int updateCalorias(long id, double distancia) {
        double calorias = calcularCalorias(distancia);
        ContentValues values = new ContentValues();
        values.put("distancia", distancia);
        values.put("calorias", calorias);
        return db.update("Calorias", values, "_id = ?", new String[]{String.valueOf(id)});
    }

    public int deleteCalorias(long id) {
        return db.delete("Calorias", "_id = ?", new String[]{String.valueOf(id)});
    }

    private double calcularCalorias(double distancia) {
        return distancia * 0.5;
    }

    public void close() {
        dbHelper.close();
    }
}
