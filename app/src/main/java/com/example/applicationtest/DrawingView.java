package com.example.applicationtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DrawingView extends View {

    int touchX = -1, touchY = -1, firstTouchX = -1, firstTouchY = -1;
    int color;
    public List<Coord> liste = new ArrayList();
    private Paint paint;
    ArrayList<Integer> currentX = new ArrayList();
    ArrayList<Integer> currentY = new ArrayList();
    ArrayList<Integer> currentColor = new ArrayList();


    public DrawingView(Context context){
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        for(int i=0; i<liste.size(); i++){
            paint.setColor(liste.get(i).getColor());
            canvas.drawRect(liste.get(i).getxTop() - 250, liste.get(i).getyBottom() - 250, liste.get(i).getxLeft() + 250, liste.get(i).getyRight() + 250, liste.get(i).getPaint());
        }


        paint = new Paint();
        paint.setColor(color);

        if(touchX != -1 && touchY != -1 ) {
            canvas.drawRect(firstTouchX - 250, firstTouchY - 250, touchX + 250, touchY + 250, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(touchX == -1){
            firstTouchX = (int) event.getX();
            firstTouchY = (int) event.getY();
        }

        touchX = (int) event.getX();
        touchY = (int) event.getY();

        Random rnd = new Random();
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        if(event.getAction() == MotionEvent.ACTION_UP){

            Coord coord = new Coord(firstTouchX, firstTouchY, touchX, touchY, color, paint);
            liste.add(coord);
            touchX = -1;
            touchY = -1;
        }

        invalidate();

        return true;
    }


}
