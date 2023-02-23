package com.example.watercolor.object;

import java.util.Random;

public class Dinhnghia {
    public int soCot = 14;
    public int soO = 14;
    public String maumax = "#FF0000";
    public String maumin = "#FE2E2E";
    private String arrMauMax[] = new String[]{
            "#FF0000",
            "#FFFF00",
            "#3ADF00",
            "#0174DF",
            "#A901DB",
            "#AAAAAA",
            "#FF9900",
            "#339999",
            "#9966CC",
            "#FF99CC",

    };
    private String arrMauMin[] = new String[]{
            "#FA5858",
            "#F3F781",
            "#ACFA58",
            "#2ECCFA",
            "#D0A9F5",
            "#FFFFFF",
            "#FF9966",
            "#669999",
            "#9966FF",
            "#FF99FF",
    };
    public int level = 1;
    public int timeTong  = 100;
    public int timeChay  = timeTong*1000;
    public int timeCong = 300;
    public boolean endgame = false;

    public void laymauNgauNhien() {
        Random r = new Random();
        int vt = r.nextInt(arrMauMax.length);
        maumax = arrMauMax[vt];
        maumin = arrMauMin[vt];
    }

    public void setLevel() {
        if (level >= 3){
            soCot = 3;
        }else {
            soCot = 3;
        }if(level >5){
            soCot = 4;
        }if (level > 10){
            soCot = 5;
        }if(level > 20){
            soCot = 6;
        }if(level >30){
            soCot =7;
        }if (level >40){
            soCot = 8;
        }if (level > 50){
            soCot = 9;
        }if (level > 60){
            soCot = 10;
        }if (level > 70){
            soCot =11;
        }if (level > 80){
            soCot =12;
        }if(level >90){
            soCot =13;
        }if(level >100){
            soCot = 14;
        }if(level >110){
            soCot = 15;
        }

        soO = soCot * soCot;
    }
}

