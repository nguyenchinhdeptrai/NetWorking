package com.example.myapplication.Demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Demo21MainActivity extends AppCompatActivity implements View.OnClickListener, Demo21Interface {
    Button btnClick;
    TextView textView;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnClick = findViewById(R.id.btnDemo21);
        textView = findViewById(R.id.txtDemo21);
        imgView = findViewById(R.id.imgDemo21);
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //khi click btn thi goi asynctask
        new Demo21AsynTask(this, this).execute("http://tinypic.com/images/goodbye.jpg");
    }

    @Override
    public void onLoadAnh(Bitmap bitmap) {
        imgView.setImageBitmap(bitmap);
    }
    @Override
    public void onLoi() {
        textView.setText("loi doc du lieu");
    }
}