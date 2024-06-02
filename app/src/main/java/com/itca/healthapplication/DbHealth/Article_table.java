package com.itca.healthapplication.DbHealth;

public class Article_table {

    public static final String TABLE_NAME = "Article_table";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_CONSEJO = "consejo";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITULO + " TEXT, " +
                    COLUMN_CONSEJO + " TEXT)";

    public static final String SQL_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
