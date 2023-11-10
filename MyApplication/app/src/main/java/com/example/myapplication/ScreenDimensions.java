package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenDimensions {
    public static int width;
    public static int height;

    public ScreenDimensions(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }
}
