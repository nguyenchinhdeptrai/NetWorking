package com.example.myapplication.Demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class DemoMainActivity extends AppCompatActivity implements View.OnClickListener, Demo21Interface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onLoadAnh(Bitmap bitmap) {

    }

    @Override
    public void onLoi() {

    }
}