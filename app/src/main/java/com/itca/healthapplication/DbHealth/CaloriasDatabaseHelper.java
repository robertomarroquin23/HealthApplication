package com.itca.healthapplication.DbHealth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CaloriasDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "calorias.db";
    private static final int DATABASE_VERSION = 1;

    public CaloriasDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Calorias ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "distancia REAL, "
                + "calorias REAL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Calorias");
        onCreate(db);
    }
}
