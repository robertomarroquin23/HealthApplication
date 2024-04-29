package com.itca.healthapplication.Class;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itca.healthapplication.R;

import java.util.List;

public class RegisterAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> registros;



    public RegisterAdapter(Context context, int resource, List<String> registros) {
        super(context, resource, registros);
        this.context = context;
        this.registros = registros;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.registro_item, parent, false);

        TextView tvItem = view.findViewById(R.id.tvItem); // Assuming the TextView ID in registro_item.xml
        tvItem.setText(registros.get(position));

        return view;
    }
}
