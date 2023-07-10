package com.example.myapplication.Demo2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo21AsynTask extends AsyncTask<String,Void, Bitmap> {

    private Demo21Interface anInterface;// lắng nghe và trả kết quả
    private Context context;
    public Demo21AsynTask(Demo21Interface anInterface, Context context) {
        this.anInterface = anInterface;
        this.context = context;
    }
    //hàm đọc data từ server
    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
            return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    //
    //trả về clent
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null){
            anInterface.onLoadAnh(bitmap);
        }else{
            anInterface.onLoi();
        }
    }
}

