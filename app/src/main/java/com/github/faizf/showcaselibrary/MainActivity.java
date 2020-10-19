package com.github.faizf.showcaselibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        /*
         *Sometimes If you need to show after onCreate
         *Use this function to make sure the view component weight and height full ready rendered
         */
        button1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //Showcase now
                button1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == button1) {
            ShowCaseUtil.showCase(button1, this, R.layout.onboard_sample, button1.getWidth(), button1.getHeight(), true, true, null);
        } else if (view == button2) {
            ShowCaseUtil.showCase(button2, this, R.layout.onboard_sample, button2.getWidth(), button2.getHeight(), true, true, null);
        } else if (view == button3) {
            ShowCaseUtil.showCase(button3, this, R.layout.onboard_sample, button3.getWidth(), button3.getHeight(), true, true, null);
        } else if (view == button4) {
            ShowCaseUtil.showCase(button4, this, R.layout.onboard_sample, button4.getWidth(), button4.getHeight(), true, true, null);
        } else if (view == button5) {
            ShowCaseUtil.showCase(button5, this, R.layout.onboard_sample, button5.getWidth(), button5.getHeight(), true, true, null);
        } else if (view == button6) {
            ShowCaseUtil.showCase(button6, this, R.layout.onboard_sample, button6.getWidth(), button6.getHeight(), true, true, null);
        } else if (view == button7) {
//            ShowCaseUtil.showCase(button7, this, R.layout.onboard_sample, button7.getWidth(), button7.getHeight(), true, true);
            DialogFragmentSample dialogFragmentSample = new DialogFragmentSample();
            dialogFragmentSample.show(getSupportFragmentManager(), "Dialog Sample");
        }

    }
}
