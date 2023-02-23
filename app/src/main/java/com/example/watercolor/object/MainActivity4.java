package com.example.watercolor.object;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.watercolor.MainActivity;
import com.example.watercolor.R;

public class MainActivity4 extends AppCompatActivity {
    TextView txvLevel;
    int level=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
        Color();
        setup();
        setClick();
    }
    private void init(){
        level=getIntent().getIntExtra("level", 0);
    }
    private void Color(){
        txvLevel = findViewById(R.id.txvLevel);

    }
    private void setup(){
        txvLevel.setText("" + level);

    }
    private void setClick(){

    }
    public void choilai(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void thoat(View view){
        finish();
    }
}