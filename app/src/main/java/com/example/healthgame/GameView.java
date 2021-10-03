package com.example.healthgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying = false;
    private int screenX, screenY = 0;
    private Paint paint;
    private Pill1 pill1;
    private MainActivity activity;
    private Background background;

    public GameView(MainActivity gameActivity, int screenX, int screenY) {
        super(gameActivity);

        this.activity = gameActivity;

        this.screenX = screenX;
        this.screenY = screenY;

        background = new Background(screenX, screenY, getResources());
        background.x = screenX;

        pill1 = new Pill1(screenY, getResources());

        paint = new Paint();
    }

    @Override
    public void run() {

        //while (isPlaying) {
            update ();
            draw ();
            //sleep ();
        //}

    }

    private void update () {

    }

    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background.background, background.x, background.y, paint);

            canvas.drawBitmap(pill1.getPill(), pill1.x, pill1.y, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep () {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume () {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }

    public void pause () {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
