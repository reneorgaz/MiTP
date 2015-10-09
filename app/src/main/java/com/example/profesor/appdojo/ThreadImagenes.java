package com.example.profesor.appdojo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.List;

/**
 * Created by profesor on 17/09/2015.
 */
public class ThreadImagenes implements Runnable
{
    private String url;
    private Handler h;
    private int position;

    public ThreadImagenes(String url, Handler h, int position)
    {
        this.url = url;
        this.h = h;
        this.position = position;
    }
    @Override
    public void run() {
        HttpManager http =  new HttpManager(url);

        http =  new HttpManager(this.url);
        byte[] miArray = new byte[0];
        try {
            miArray = http.getBytesDataByGET();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap bitmapImg = BitmapFactory.decodeByteArray(miArray, 0, miArray.length);

        Message msg= new Message();
        msg.arg1 = 1;
        msg.arg2 = this.position;
        msg.obj = bitmapImg;
        h.sendMessage(msg);


    }
}
