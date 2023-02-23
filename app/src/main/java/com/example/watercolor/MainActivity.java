package com.example.watercolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.watercolor.object.MainActivity3;

public class MainActivity extends AppCompatActivity {
    TextView dangnhap,choingay,thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dangnhap(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
        finish();
    }
    public void choingay(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        finish();
    }
    public void thoat(View view){
        finish();
    }
}
