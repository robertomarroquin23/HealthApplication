package com.itca.healthapplication.DbHealth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntrenamientosDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "entrenamientos.db";
    private static final int DATABASE_VERSION = 1;

    public EntrenamientosDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Entrenamientos ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "tipo_ejercicio TEXT, "
                + "duracion INTEGER, "
                + "intensidad TEXT, "
                + "calorias REAL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Entrenamientos");
        onCreate(db);
    }
}
