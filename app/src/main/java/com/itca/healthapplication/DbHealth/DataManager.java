package com.itca.healthapplication.DbHealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class DataManager {


        private DatabaseHelper dbHelper;
        private SQLiteDatabase database;

        public DataManager(Context context) {
            dbHelper = new DatabaseHelper(context);
        }

        public void open() {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        // Métodos la tabla de usuarios


        public Cursor getArticle(long id) {
            String[] columns = {
                    Article_table.COLUMN_ID,
                    Article_table.COLUMN_TITULO,
                    Article_table.COLUMN_CONSEJO
            };
            String selection = Article_table.COLUMN_ID + " = ?";
            String[] selectionArgs = { String.valueOf(id) };
            return database.query(Article_table.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        }


    public void deleteAllData() {
        database.delete(Article_table.TABLE_NAME, null, null);
    }

    public Cursor getAllData(){
        String[] columns = {"_id","titulo","consejo"};

        return  database.query("Article_table",columns,null,null,null,null,null);

    }












    }




