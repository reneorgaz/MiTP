package com.example.profesor.appdojo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback{

    private Handler handler = null;
    private RecyclerView rv = null;
    private List<Persona> listaPersonas;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.rv = (RecyclerView)findViewById(R.id.list);

        handler = new Handler(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rv.setLayoutManager(linearLayoutManager);

        ThreadConexion hiloConexion = new ThreadConexion("http://www.lslutnfra.com/alumnos/practicas/personas.csv", handler);

        Thread hilo = new Thread(hiloConexion);

        hilo.start();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean handleMessage(Message msg) {

        listaPersonas = (List<Persona>) msg.obj;

        if ( msg.arg1 == 0 ) {
            this.adapter = new MyAdapter((List<Persona>) msg.obj, handler);
            rv.setAdapter(this.adapter);
        }
        else
        {
            /*si viene bitmap*/
            Persona p = this.listaPersonas.get(msg.arg2);
            p.setImg((Bitmap)msg.obj);
            /*Cambio mi ImageView*/
            adapter.notifyDataSetChanged();
        }

        return false;
    }
}
