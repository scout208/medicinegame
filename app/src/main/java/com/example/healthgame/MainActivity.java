package com.example.healthgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView pill1_0ImageView;
    ImageView pill1_1ImageView;
    ImageView pill1_2ImageView;
    ImageView pill1_3ImageView;
    ImageView pill1_4ImageView;
    ImageView pill1_5ImageView;
    ImageView pill1_6ImageView;

    ImageView pill2_0ImageView;
    ImageView pill2_1ImageView;
    ImageView pill2_2ImageView;
    ImageView pill2_3ImageView;
    ImageView pill2_4ImageView;
    ImageView pill2_5ImageView;
    ImageView pill2_6ImageView;

    ConstraintLayout sun, mon, tue, wed, thu, fri, sat;

    ImageView[] pill1Arr;
    ImageView[] pill2Arr;

    ConstraintLayout[] bins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        setContentView(R.layout.activity_main);

        pill1_0ImageView = findViewById(R.id.pill1_0);
        pill1_1ImageView = findViewById(R.id.pill1_1);
        pill1_2ImageView = findViewById(R.id.pill1_2);
        pill1_3ImageView = findViewById(R.id.pill1_3);
        pill1_4ImageView = findViewById(R.id.pill1_4);
        pill1_5ImageView = findViewById(R.id.pill1_5);
        pill1_6ImageView = findViewById(R.id.pill1_6);

        pill2_0ImageView = findViewById(R.id.pill2_0);
        pill2_1ImageView = findViewById(R.id.pill2_1);
        pill2_2ImageView = findViewById(R.id.pill2_2);
        pill2_3ImageView = findViewById(R.id.pill2_3);
        pill2_4ImageView = findViewById(R.id.pill2_4);
        pill2_5ImageView = findViewById(R.id.pill2_5);
        pill2_6ImageView = findViewById(R.id.pill2_6);

        pill1Arr = new ImageView[] { pill1_0ImageView, pill1_1ImageView, pill1_2ImageView, pill1_3ImageView, pill1_4ImageView, pill1_5ImageView, pill1_6ImageView };

        View.OnDragListener dragListener = new myDragEventListener();

        findViewById(R.id.pills).setOnDragListener(dragListener);

        sun = findViewById(R.id.sun);
        mon = findViewById(R.id.mon);
        tue = findViewById(R.id.tue);
        wed = findViewById(R.id.wed);
        thu = findViewById(R.id.thu);
        fri = findViewById(R.id.fri);
        sat = findViewById(R.id.sat);

        bins = new ConstraintLayout[] { sun, mon, tue, wed, thu, fri, sat };

        sun.setOnDragListener(dragListener);
        mon.setOnDragListener(dragListener);
        tue.setOnDragListener(dragListener);
        wed.setOnDragListener(dragListener);
        thu.setOnDragListener(dragListener);
        fri.setOnDragListener(dragListener);
        sat.setOnDragListener(dragListener);

        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the ImageView object's tag
                ClipData.Item item = new ClipData.Item(v.getTag().toString());

                // Create a new ClipData using the tag as a label, the plain text MIME type, and
                // the already-created item. This will create a new ClipDescription object within the
                // ClipData, and set its MIME type entry to "text/plain"
                ClipData dragData = new ClipData(
                        v.getTag().toString(),
                        new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                        item);

                // Instantiates the drag shadow builder.
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

                // Starts the drag
                v.startDragAndDrop(dragData, myShadow, null, 0);

                v.setVisibility(View.INVISIBLE);
                return true;
                //return false;
            }
        };

//        View.OnLongClickListener touchListener = new View.OnLongClickListener() {
//            // Defines the one method for the interface, which is called when the View is long-clicked
//            @Override
//            public boolean onLongClick(View v) {
//                // Create a new ClipData.
//                // This is done in two steps to provide clarity. The convenience method
//                // ClipData.newPlainText() can create a plain text ClipData in one step.
//
//                // Create a new ClipData.Item from the ImageView object's tag
//                ClipData.Item item = new ClipData.Item(v.getTag().toString());
//
//                // Create a new ClipData using the tag as a label, the plain text MIME type, and
//                // the already-created item. This will create a new ClipDescription object within the
//                // ClipData, and set its MIME type entry to "text/plain"
//                ClipData dragData = new ClipData(
//                        v.getTag().toString(),
//                        new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
//                        item);
//
//                // Instantiates the drag shadow builder.
//                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);
//
//                // Starts the drag
//                v.startDragAndDrop(dragData, myShadow, v, 0);
//
//                v.setVisibility(View.INVISIBLE);
//                return true;
//                //return false;
//            }
//        };

        pill1_0ImageView.setOnTouchListener(onTouchListener);
        pill1_1ImageView.setOnTouchListener(onTouchListener);
        pill1_2ImageView.setOnTouchListener(onTouchListener);
        pill1_3ImageView.setOnTouchListener(onTouchListener);
        pill1_4ImageView.setOnTouchListener(onTouchListener);
        pill1_5ImageView.setOnTouchListener(onTouchListener);
        pill1_6ImageView.setOnTouchListener(onTouchListener);

        pill2_0ImageView.setOnTouchListener(onTouchListener);
        pill2_1ImageView.setOnTouchListener(onTouchListener);
        pill2_2ImageView.setOnTouchListener(onTouchListener);
        pill2_3ImageView.setOnTouchListener(onTouchListener);
        pill2_4ImageView.setOnTouchListener(onTouchListener);
        pill2_5ImageView.setOnTouchListener(onTouchListener);
        pill2_6ImageView.setOnTouchListener(onTouchListener);
    }

    protected class myDragEventListener implements View.OnDragListener {

        // This is the method that the system calls when it dispatches a drag event to the
        // listener.
        @Override
        public boolean onDrag(View v, DragEvent event) {
            // Defines a variable to store the action type for the incoming event
            final int action = event.getAction();
            View view;

            // Handles each of the expected events
            switch(action) {
                case DragEvent.ACTION_DRAG_STARTED:

                    // Determines if this View can accept the dragged data
                    return event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);

                case DragEvent.ACTION_DRAG_ENTERED:

                    // Return true; the return value is ignored.

                    // Invalidate thew view to force a redraw
                    v.invalidate();

                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:

                    // Ignore the event
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    // Invalidate the view to force a redraw
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:

                    // Gets the item containing the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);

                    // Gets the text data from the item.
                    CharSequence dragData = item.getText();

                    v.invalidate();

                    // Displays a message containing the dragged data
                    //Toast.makeText(this, "Dragged data is " + dragData.toString(), Toast.LENGTH_LONG).show();
                    String id = dragData.toString();
                    int resID = getResources().getIdentifier(id, "id", getPackageName());
                    Log.d("Dragging", "This is the id " + id + "(" + resID + ")");

                    //if (view != null) {
                    view = (View) findViewById(resID);
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);

                    ViewGroup destination = (ViewGroup) v;
                    destination.addView(view);
                    view.setVisibility(View.VISIBLE);
                    //}

                    // Count pills that are left and check the results.
                    int pills = ((RelativeLayout) findViewById(R.id.pills)).getChildCount();
                    Log.d("Info", pills + " pills");
                    if (pills == 0)
                    {
                        Log.d("Info", "No more pills");

                        // Check which pills are in each bin
                        for (int i = 0; i < bins.length; i++) {
                            ViewGroup bin = bins[i];
                            int childCount = bin.getChildCount();
                            if (childCount != 3) {
                                Toast.makeText(MainActivity.this, "Some pill is placed wrong.", Toast.LENGTH_LONG).show();
                                return true;
                            } else {

                                String item11 = bin.getChildAt(0).toString();
                                Boolean isFirstPillPill1 = bin.getChildAt(1).toString().contains("pill1");
                                Boolean isSecondPillPill1 = bin.getChildAt(2).toString().contains("pill1");

                                if (isFirstPillPill1 && isSecondPillPill1) {
                                    // Something is wrong
                                    Toast.makeText(MainActivity.this, "Some pill is placed wrong.", Toast.LENGTH_LONG).show();
                                    return true;
                                }

                                //break;
                            }
                        }

                        // Success!!!
                        Toast.makeText(MainActivity.this, "You did it!", Toast.LENGTH_LONG).show();
                        Log.d("Info", "Showed toast");
                    }

                    // Invalidates the view to force a redraw
                    //v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:

                    // Invalidates the view to force a redraw
                    v.invalidate();

                    if (event.getResult()) {
                        //Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG).show();
                    } else {

                    }

                    // Returns true; the value is ignored.
                    return true;

                // An unknown action type was received.
                default:
                    Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                    break;
            }

            return false;
        }
    };
}