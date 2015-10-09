package com.example.profesor.appdojo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by profesor on 17/09/2015.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView txtNombre;
    private TextView txtTelefono;
    private ImageView img;

    public MyViewHolder(View view){
        super(view);
        txtNombre = (TextView) view.findViewById(R.id.txtNombre);
        txtTelefono= (TextView) view.findViewById(R.id.txtTelefono);
        img = (ImageView) view.findViewById(R.id.imageView);

    }

    public TextView getTxtNombre() {
        return txtNombre;
    }

    public TextView getTxtTelefono() {
        return txtTelefono;
    }

    public ImageView getImg() {
        return img;
    }
}
