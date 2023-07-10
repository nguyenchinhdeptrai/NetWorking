package com.example.myapplication.Demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo23Main extends AppCompatActivity {
    TextView tv3;
    Button btn3;
    ImageView img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo23);
        tv3 = findViewById(R.id.txtDemo23);
        btn3 = findViewById(R.id.btnDemo23);
        img3 = findViewById(R.id.imgDemo23);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread myThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bitmap = loadAnh("http://tinypic.com/images/goodbye.jpg");
                        img3.post(new Runnable() {
                            @Override
                            public void run() {
                                img3.setImageBitmap(bitmap);
                                tv3.setText("Thành Công");
                            }
                        });
                    }
                });
                myThread.start();
            }
        });
    }
    //function load img
    private Bitmap loadAnh(String str){
        URL url;
        Bitmap bitmap = null;
        try{
            url = new URL(str);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}