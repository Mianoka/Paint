package com.example.applicationtest;

import android.graphics.Paint;

public class Coord {

    private int xTop, yBottom, xLeft, yRight, color;
    private Paint paint;

    public Coord(int xTop, int yBottom, int xLeft, int yRight, int color, Paint paint) {
        this.xTop = xTop;
        this.yBottom = yBottom;
        this.xLeft = xLeft;
        this.yRight = yRight;
        this.color = color;
        this.paint = paint;
    }


    public int getColor() {
        return color;
    }

    public int getxTop() {
        return xTop;
    }

    public int getyRight() {
        return yRight;
    }

    public Paint getPaint() {
        return paint;
    }

    public int getyBottom() {
        return yBottom;
    }

    public int getxLeft() {
        return xLeft;
    }
}
