package com.example.applicationtest;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

public class Coord{
    private static List<Coord> Touchs = new ArrayList<Coord>();

    public static List<Coord> getTouchs() {
        return new ArrayList<>(Touchs);
    }

    public static void removeLastTouch(){
        int sizeTouch = Touchs.size();
        if(sizeTouch != 0){
            Touchs.remove(sizeTouch - 1);
        }
    }

    public static void clearDrawings(){
        Touchs.clear();
    }

    private Paint paint;
    private int color = Color.BLACK, colorBorder = Color.BLACK;

    private int border = 1;

    private int left, top, right, bottom;

    private  List<Integer> xList = new ArrayList<Integer>();
    private List<Integer> yList = new ArrayList<Integer>();
    private String formeType;

    public Coord(int left, int top, int right, int bottom, int border, int color, int colorBorder, String formeType, Paint paint){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.border = border;
        this.color = color;
        this.colorBorder = colorBorder;
        this.formeType = formeType;
        this.paint = paint;
        Touchs.add(this);
    }

    public Coord(List<Integer> X, List<Integer> Y, int border, int color, Paint paint){
        this.formeType = "Free";
        this.border = border;
        this.color = color;
        this.paint = paint;
        for(int i=0; i< X.size(); i++){
            this.xList.add(X.get(i));
            this.yList.add(Y.get(i));
        }
        Touchs.add(this);
    }

    public void addToFreeLists(int x, int y){
        this.xList.add(x);
        this.yList.add(y);
    };

    public List<Integer> getxList() { return new ArrayList<Integer>(xList);}

    public List<Integer> getyList() { return new ArrayList<Integer>(yList); }

    public String getType() {
        return formeType;
    }

    public int getColor() {
        return color;
    }

    public int getColorBorder() {
        return colorBorder;
    }

    public int getBorder() {
        return border;
    }

    public Paint getPaint() {
        return paint;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }
}
