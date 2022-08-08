package com.example.applicationtest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;

//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.larswerkman.holocolorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {
    private DrawingView drawingView;
    private LinearLayout verticalLayout;
    private ImageButton btnBrush, btnNew, btnReturn, btnRect, btnOval, btnLine, btnFree;
    private SeekBar borderBar;
    private ColorPicker borderPicker, fillPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpToolbarEvent();
        this.setUpDefaults();
        this.setUpListeners();
    }

    private void setUpToolbarEvent() {
        this.drawingView = (DrawingView) findViewById(R.id.drawingView);
        this.verticalLayout = (LinearLayout) findViewById(R.id.verticalLayout);
        this.btnBrush = (ImageButton) findViewById(R.id.btnBrush);
        this.btnNew = (ImageButton) findViewById(R.id.btnNew);
        this.btnReturn = (ImageButton) findViewById(R.id.btnReturn);
        this.btnRect = (ImageButton) findViewById(R.id.rectBtn);
        this.btnOval = (ImageButton) findViewById(R.id.ovalBtn);
        this.btnLine = (ImageButton) findViewById(R.id.lineBtn);
        //this.btnFree = (ImageButton) findViewById(R.id.freeBtn);
        this.borderBar = (SeekBar) findViewById(R.id.borderBar);
        this.borderPicker = (ColorPicker) findViewById(R.id.borderPicker);
        this.fillPicker = (ColorPicker) findViewById(R.id.fillPicker);
    };

    private void setUpDefaults(){
        this.verticalLayout.setVisibility(View.INVISIBLE);
        int defaultColor = this.drawingView.color;
        this.borderPicker.setColor(defaultColor);
        this.borderPicker.setOldCenterColor(defaultColor);
        this.fillPicker.setColor(defaultColor);
        this.fillPicker.setOldCenterColor(defaultColor);
    }

    public void changeVerticalLayoutVisibility(){
        int visibility = (verticalLayout.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE;
        verticalLayout.setVisibility(visibility);
    }

    private void setUpListeners(){
        this.btnBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { changeVerticalLayoutVisibility(); }
        });

        this.btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coord.clearDrawings();
                drawingView.invalidate();
            }
        });

        this.btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coord.removeLastTouch();
                drawingView.invalidate();
            }
        });

        this.btnRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.formeType = "Rect";
                fillPicker.setVisibility(View.VISIBLE);
            }
        });

        this.btnOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.formeType = "Oval";
                fillPicker.setVisibility(View.VISIBLE);
            }
        });

        this.btnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.formeType = "Line";
                fillPicker.setVisibility(View.INVISIBLE);
            }
        });

        this.btnFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.formeType = "Free";
                fillPicker.setVisibility(View.INVISIBLE);
            }
        });

        this.borderBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) { drawingView.border = (i + 1) * 10; }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { System.out.println("Start border"); }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { System.out.println("Stop border"); }
        });

        this.borderPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                borderPicker.setOldCenterColor(drawingView.colorBorder);
                drawingView.colorBorder = color;
            }
        });

        this.fillPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                fillPicker.setOldCenterColor(drawingView.color);
                drawingView.color = color;
            }
        });
    };
}
