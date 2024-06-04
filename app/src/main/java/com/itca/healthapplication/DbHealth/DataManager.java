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
            database = dbHelper.getWritableDatabase();
        }

        public void open() {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

    public long insertUser(String usuario, String correo, String password) {
        ContentValues values = new ContentValues();
        values.put(Users_table.COLUMN_USUARIO, usuario);
        values.put(Users_table.COLUMN_CORREO, correo);
        values.put(Users_table.COLUMN_PASSWORD, password);

        return database.insert(Users_table.TABLE_NAME, null, values);
    }

    public boolean isUserExists(String usuario) {
        String[] columns = { Users_table.COLUMN_ID };
        String selection = Users_table.COLUMN_USUARIO + " = ?";
        String[] selectionArgs = { usuario };
        Cursor cursor = database.query(Users_table.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        return cursorCount > 0;
    }

    public Cursor getUserData(String username) {
        String[] columns = {
                Users_table.COLUMN_USUARIO,
                Users_table.COLUMN_ALTURA,
                Users_table.COLUMN_PESO,
                Users_table.COLUMN_EDAD,
                Users_table.COLUMN_NACIONALIDAD
        };

        String selection = Users_table.COLUMN_USUARIO + " = ?";
        String[] selectionArgs = {username};

        return database.query(
                Users_table.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public int updateUserData(String antiguoUser, String nuevoUsuario, String nuevaAltura, String nuevoPeso, String nuevaEdad, String nuevaNacionalidad) {
        ContentValues values = new ContentValues();
        values.put("usuario", nuevoUsuario);
        values.put("altura", nuevaAltura);
        values.put("peso", nuevoPeso);
        values.put("edad", nuevaEdad);
        values.put("nacionalidad", nuevaNacionalidad);

        return database.update("Users_table", values, "usuario = ?", new String[]{String.valueOf(antiguoUser)});
    }

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

    public boolean authenticateUser(String usuario, String password) {
        String[] columns = { Users_table.COLUMN_ID };
        String selection = Users_table.COLUMN_USUARIO + " = ? AND " + Users_table.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = { usuario, password };
        Cursor cursor = database.query(Users_table.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();

        return cursorCount > 0;
    }


    public void deleteAllData() {
        database.delete(Article_table.TABLE_NAME, null, null);
    }

    public Cursor getAllData(){
        String[] columns = {"_id","titulo","consejo"};

        return  database.query("Article_table",columns,null,null,null,null,null);

    }
}