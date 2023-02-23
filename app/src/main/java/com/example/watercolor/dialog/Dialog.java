package com.example.watercolor.dialog;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.watercolor.R;

public class Dialog extends android.app.Dialog {
    public Dialog(@NonNull Context context, int level) {
        super(context);
        setContentView(R.layout.dialog);
        TextView txvLevel = findViewById(R.id.txvLevel);
        txvLevel.setText("" + level);
    }
}
