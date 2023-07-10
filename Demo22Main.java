package com.example.myapplication.Demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo22Main extends AppCompatActivity {
    TextView tv2;
    Button btn2;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo22_main);
        tv2 = findViewById(R.id.txtDemo22);
        btn2 = findViewById(R.id.btnDemo22);
        img2 = findViewById(R.id.imgDemo22);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Demo22Asyn().execute("http://tinypic.com/images/goodbye.jpg");
            }
        });
    }
    class Demo22Asyn extends AsyncTask<String, Void, Bitmap>{
        //function read data from server
        @Override
        protected Bitmap doInBackground(String... strings) {
            try{
                return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //function return the result to the client

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap!= null){
                img2.setImageBitmap(bitmap);
            }
            else{
                tv2.setText("Tải ảnh lỗi");
            }
        }
    }

}