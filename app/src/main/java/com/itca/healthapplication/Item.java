package com.itca.healthapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Item{
    String Titulo;
    String Consejo;
    int image;

    public Item(String titulo, String consejo, int image) {
        Titulo = titulo;
        Consejo = consejo;
        this.image = image;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getConsejo() {
        return Consejo;
    }

    public void setConsejo(String consejo) {Consejo = consejo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}