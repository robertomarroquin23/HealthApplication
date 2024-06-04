package com.itca.healthapplication.DbHealth;

public class Datos_table {
    public static final String TABLE_NAME = "Datos_table";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USUARIO = "usuario";
    public static final String COLUMN_ALTURA = "altura";
    public static final String COLUMN_PESO = "peso";
    public static final String COLUMN_EDAD = "edad";
    public static final String COLUMN_NACIONALIDAD = "nacionalidad";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USUARIO + " TEXT, " +
                    COLUMN_ALTURA + " TEXT, " +
                    COLUMN_PESO + " TEXT, " +
                    COLUMN_EDAD + " TEXT, " +
                    COLUMN_NACIONALIDAD + " TEXT) ";

    public static final String SQL_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
