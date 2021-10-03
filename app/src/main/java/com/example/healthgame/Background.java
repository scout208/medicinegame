package com.example.healthgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

public class Background {

    int x = 0, y = 0;
    Bitmap background;

    Background(int screenX, int screenY, Resources res) {
//        background = Color.valueOf(0x000000);
//        x = screenX;
//        y = screenY;
        background = BitmapFactory.decodeResource(res, R.drawable.whitebg);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}
