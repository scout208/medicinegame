package com.example.healthgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Pill1 {
    int x, y, width, height;
    Bitmap pill;

    Pill1(int screenY, Resources res) {
        pill = BitmapFactory.decodeResource(res, R.drawable.pill1);

        width = pill.getWidth();
        height = pill.getHeight();

        width /= 4;
        height /= 4;

        pill = Bitmap.createScaledBitmap(pill, width, height, false);

        y = screenY / 2;
        x = 64;
    }

    Bitmap getPill () {
        return pill;
    }
}
