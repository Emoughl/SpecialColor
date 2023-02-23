package com.example.watercolor.object;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class Custom extends androidx.appcompat.widget.AppCompatImageView {
    public Custom(Context context) {
        super(context);
    }

    public Custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int a= getMeasuredWidth();
        setMeasuredDimension(a,a);
    }
}