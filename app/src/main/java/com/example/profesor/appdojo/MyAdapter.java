package com.example.profesor.appdojo;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by profesor on 17/09/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Persona> myList;
    private Handler h;

    public MyAdapter(List<Persona> myList, Handler h)
    {
        this.myList = myList;
        this.h = h;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View v = li.inflate(R.layout.layoutitem, null);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Persona persona = myList.get(i);
        myViewHolder.getTxtNombre().setText(persona.getNombre()+ " " + persona.getApellido());
        myViewHolder.getTxtTelefono().setText(persona.getTelefono());
        //otra opcion: lanzo thread por esta etapa
        if ( persona.getImg() == null ) {
            ThreadImagenes thI = new ThreadImagenes(persona.getUrl(), h, i);
            Thread t = new Thread(thI);
            t.start();
        }
        else
        {
            myViewHolder.getImg().setImageBitmap(persona.getImg());
        }

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
