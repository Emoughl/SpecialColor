package com.example.watercolor.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.watercolor.R;
import com.example.watercolor.object.Custom;
import com.example.watercolor.object.Mau;

import java.util.ArrayList;
import java.util.List;

public class MauAdapter extends ArrayAdapter<Mau> {
    private Context ct;
    private ArrayList<Mau> arrMau;
    public MauAdapter(@NonNull Context context, int resource, @NonNull List<Mau> objects) {
        super(context, resource, objects);
        this.ct =context;
        this.arrMau = new ArrayList<>(objects);
    }
    public void update(ArrayList<Mau>arr){
        this.arrMau.clear();
        this.arrMau.addAll(arr);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrMau.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.itemmau,null);
        }
        if(arrMau.size()>0){
            Mau o = arrMau.get(position);
            Custom Custom = convertView.findViewById(R.id.imgMau);
            Custom.setColorFilter(Color.parseColor(o.maMau));
        }
        return convertView;
    }
}

