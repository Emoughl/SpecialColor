package com.example.watercolor.object;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watercolor.adapter.MauAdapter;
import com.example.watercolor.dialog.Dialog;
import com.example.watercolor.object.Dinhnghia;
import com.example.watercolor.object.Mau;
import com.example.watercolor.object.StarGame;
import com.example.watercolor.R;
import com.example.watercolor.adapter.MauAdapter;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    Dinhnghia dinhnghia = new Dinhnghia();
    ArrayList<Mau> arrMau = new ArrayList<>();

    GridView gdvLisMau;
    MauAdapter adapter;

    TextView txvLevel;
    TextView txvTime;
    CountDownTimer demnguoc;

    ImageView imgAnhNhay;
    int iconNhay = R.drawable.icon1;
    boolean Chonxoay = true;
    TextView txvStar;
    StarGame Star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        Color();
        setup();
        setClick();
    }

    private void init(){
        Star = new StarGame(this);
        Star.getData();
        taoMau();
        while (arrMau.size() < dinhnghia.soO){
            arrMau.add(new Mau( dinhnghia.maumax));
        }
        Random r = new Random();
        arrMau.get(r.nextInt(arrMau.size())).maMau= dinhnghia.maumin;
        adapter = new MauAdapter(this,0,arrMau);
    }
    private void Color(){
        gdvLisMau=findViewById(R.id.gdvLisMau);
        txvLevel = findViewById(R.id.txvLevel);
        txvTime = findViewById(R.id.txvTime);
        imgAnhNhay = findViewById(R.id.imgAnhNhay);
        txvStar = findViewById(R.id.txvStar);
    }

    private void setup (){
        txvStar.setText(""+Star.Startichluy);
        gdvLisMau.setNumColumns(dinhnghia.soCot);
        gdvLisMau.setAdapter(adapter);
        txvLevel.setText(""+dinhnghia.level);
        upDateTime();

        new CountDownTimer( 3000, 200) {

            @Override
            public void onTick(long l) {
                if (Chonxoay == true) {


                    if (iconNhay == R.drawable.icon2) {
                        iconNhay = R.drawable.icon1;
                    } else {
                        iconNhay = R.drawable.icon2;
                    }
                    imgAnhNhay.setImageResource(iconNhay);
                }
            }



            @Override
            public void onFinish() {
                Chonxoay = false;
                if (dinhnghia.endgame == false) {
                    start();
                }
            }
        }.start();

    }
    private void setClick(){
        gdvLisMau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkMau(arrMau.get(i));
            }
        });
    }
    private void checkMau(Mau o){
        if(o.maMau.equals(dinhnghia.maumin)){
            dinhnghia.level++;
            taoMau();
            update();
            dinhnghia.timeChay = dinhnghia.timeChay+dinhnghia.timeCong;
            demnguoc.cancel();
            upDateTime();
            Chonxoay = true;

            Star.Startichluy=Star.Startichluy+10;
            txvStar.setText(""+Star.Startichluy);
            Star.setData();
        }else{
            Toast.makeText(this,"Sai Rồi !!",Toast.LENGTH_SHORT).show();
        }
    }
    private void taoMau(){
        dinhnghia.setLevel();
        dinhnghia.laymauNgauNhien();
        arrMau.clear();
        while (arrMau.size() < dinhnghia.soO){
            arrMau.add(new Mau( dinhnghia.maumax));
        }
        Random r = new Random();
        arrMau.get(r.nextInt(arrMau.size())).maMau= dinhnghia.maumin;
    }
    private void update(){

        adapter.update(arrMau);
        gdvLisMau.setNumColumns(dinhnghia.soCot);
        txvLevel.setText(""+dinhnghia.level);
    }
    private void upDateTime(){
        demnguoc = new CountDownTimer(dinhnghia.timeChay,1){

            @Override
            public void onTick(long l) {
                dinhnghia.timeChay = (int) l;
                if (dinhnghia.timeChay >= 0) {
                    int Giay = dinhnghia.timeChay / 1000;
                    int MiLiGiay = dinhnghia.timeChay % 1000 / 10;
                    String times = Giay + ":" + MiLiGiay;
                    txvTime.setText(times);
                } else {
                    txvTime.setText("00:00");
                }
            }

            @Override
            public void onFinish() {
                TimeOut();
                txvTime.setText("00:00");

            }
        }.start();
    }
    private void TimeOut(){
        dinhnghia.endgame = true;
        gdvLisMau.setOnItemClickListener(null);
        Intent intent = new Intent(this,MainActivity4.class);
        intent.putExtra("level",dinhnghia.level);
        startActivity(intent);
        finish();
        //new Dialog(this,dinhnghia.level).show();
    }

}
