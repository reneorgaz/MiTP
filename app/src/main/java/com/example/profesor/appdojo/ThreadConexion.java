package com.example.profesor.appdojo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by profesor on 17/09/2015.
 */
public class ThreadConexion implements Runnable {

    private String url;
    private Handler h;

    public ThreadConexion(String url, Handler h)
    {
        this.url = url;
        this.h = h;
    }
    @Override
    public void run() {
        HttpManager http =  new HttpManager(url);

        try {
            String resultado = http.getStrDataByGET();
            List<Persona> personas = Persona.obtenerListaPersona(resultado);

            for (Persona p: personas)
            {
                http =  new HttpManager(p.getUrl());
                byte[] miArray = http.getBytesDataByGET();

                Bitmap bitmapImg = BitmapFactory.decodeByteArray(miArray, 0, miArray.length);
                p.setImg(bitmapImg);
            }

            Message msg= new Message();
            msg.obj = personas;
            h.sendMessage(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
